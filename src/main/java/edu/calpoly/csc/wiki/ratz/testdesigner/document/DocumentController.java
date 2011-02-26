package edu.calpoly.csc.wiki.ratz.testdesigner.document;

import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.codehaus.jackson.JsonParser.Feature;
import org.codehaus.jackson.map.ObjectMapper;

import edu.calpoly.csc.wiki.ratz.testdesigner.items.Item;
import edu.calpoly.csc.wiki.ratz.testdesigner.items.MultipleChoiceItem;
import edu.calpoly.csc.wiki.ratz.testdesigner.items.MultipleChoiceItem.Answer;
import edu.calpoly.csc.wiki.ratz.testdesigner.items.Question;

/**
 * DocumentController is used to manipulate a Document.
 * 
 * @author jdisanti
 */
public class DocumentController {
   private Document document;

   /**
    * Creates a new document to manipulate.
    */
   public DocumentController() {
      document = new Document();
   }

   /**
    * Uses an already created document for manipulation.
    * 
    * @param document
    *           The document to use.
    */
   public DocumentController(Document document) {
      this.document = document;
   }

   /**
    * Adds an item to the document.
    * 
    * @param item
    *           The item to add.
    * @return The UUID of the item.
    */
   public String addItem(Item item) {
      final String uuid = UUID.randomUUID().toString();
      item.setUUID(uuid);
      document.getItems().add(item);
      renumberItems();
      return uuid;
   }

   /**
    * Updates an item in the document.
    * 
    * @param uuid
    *           The UUID of the item to update.
    * @param item
    *           The item to update with.
    */
   public void updateItem(String uuid, Item item) {
      Integer index = findIndexOfItem(uuid);
      if (index != null) {
         item.setUUID(uuid);
         document.getItems().set(index, item);
      }
      renumberItems();
   }

   /**
    * Removes an item from the document.
    * 
    * @param uuid
    *           The UUID of the item to remove.
    */
   public void removeItem(String uuid) {
      Iterator<Item> itr = document.getItems().iterator();
      while (itr.hasNext()) {
         Item itm = itr.next();
         if (itm.getUUID().equals(uuid)) {
            itr.remove();
            return;
         }
      }
      renumberItems();
   }

   /**
    * Returns a cloned list of all of the items in the Document.
    * 
    * @return A cloned list of items.
    */
   public List<Item> getItems() {
      List<Item> items = new LinkedList<Item>();
      try {
         for (Item itm : document.getItems()) {
            items.add((Item) itm.clone());
         }
      }
      catch (CloneNotSupportedException ex) {
      }
      return items;
   }

   /**
    * Finds an item by UUID and returns it.
    * 
    * @param uuid
    *           The UUID of the item to look up.
    * @return The Item, or null if it wasn't found.
    */
   public Item findItem(String uuid) {
      for (Item itm : document.getItems())
         if (itm.getUUID().equals(uuid))
            return itm;
      return null;
   }

   /**
    * Moves an item up.
    * 
    * @param uuid
    *           The UUID of the item to move up.
    */
   public void moveItemUp(String uuid) {
      Integer index = findIndexOfItem(uuid);
      if (index != null && index > 0) {
         List<Item> items = document.getItems();
         Item swp = items.get(index);
         items.set(index, items.get(index - 1));
         items.set(index - 1, swp);
      }
      renumberItems();
   }

   /**
    * Moves an item down.
    * 
    * @param uuid
    *           The UUID of the item to move down.
    */
   public void moveItemDown(String uuid) {
      Integer index = findIndexOfItem(uuid);
      List<Item> items = document.getItems();
      if (index != null && index < items.size() - 1) {
         Item swp = items.get(index);
         items.set(index, items.get(index + 1));
         items.set(index + 1, swp);
      }
      renumberItems();
   }

   /**
    * Saves the document to a file.
    * 
    * @param fileName
    *           The name of the file to save to.
    */
   public void save(String fileName) throws IOException {
      DocumentSerializer.save(document, fileName);
   }

   /**
    * Loads the document from file.
    * 
    * @param fileName
    *           The name of the file to load the document from.
    */
   public void load(String fileName) throws IOException {
      document = DocumentSerializer.load(fileName);
   }

   /**
    * Loads the document from a JSON demo file. This method is temporary and
    * should be removed from the final product.
    * 
    * @param fileName
    *           The file name to load from.
    */
   @SuppressWarnings("unchecked")
   public void loadFromJSON(String fileName) throws IOException {
      document = new Document();
      ObjectMapper mapper = new ObjectMapper();
      mapper.configure(Feature.ALLOW_COMMENTS, true);
      mapper.configure(Feature.ALLOW_SINGLE_QUOTES, true);
      Map<String, Object> data = (Map<String, Object>) mapper
            .readValue(new File(fileName), Map.class);

      Map<String, Object> margins = (Map<String, Object>) data.get("margins");
      if (margins != null) {
         document.getMargins().setTop((Double) margins.get("top"));
         document.getMargins().setLeft((Double) margins.get("left"));
         document.getMargins().setRight((Double) margins.get("right"));
         document.getMargins().setBottom((Double) margins.get("bottom"));
      }

      List<Map<String, Object>> questions = (List<Map<String, Object>>) data
            .get("questions");
      if (questions != null) {
         for (Map<String, Object> question : questions) {
            MultipleChoiceItem item = new MultipleChoiceItem();
            item.setQuestion((String) question.get("question"));
            item.setWeight((Integer) question.get("weight"));

            List<Map<String, Object>> answers = (List<Map<String, Object>>) question
                  .get("answers");
            if (answers != null) {
               for (Map<String, Object> answerMap : answers) {
                  item.getAnswers().add(
                        new Answer((String) answerMap.get("text"),
                              (Boolean) answerMap.get("correct")));
               }
            }
            
            addItem(item);
         }
      }
   }

   /**
    * Randomizes the order of questions in the sections.
    * 
    * @param randomizeAnswers
    *           Whether or not to randomize the answers as well.
    */
   public void randomizeQuestionOrder(boolean randomizeAnswers) {
      // XXX
      renumberItems();
   }

   /**
    * Randomizes the order of the sections.
    * 
    * @param randomizeAnswers
    *           Whether or not to randomize the answers as well.
    */
   public void randomizeSections(boolean randomizeAnswers) {
      // XXX
      renumberItems();
   }

   /**
    * Prints the document. Throws a PrinterException on failure.
    */
   public void print() throws PrinterException {
      PrinterJob job = PrinterJob.getPrinterJob();
      job.setPageable(new DocumentPageable(document));
      if (job.printDialog()) {
         job.print();
      }
   }

   private Integer findIndexOfItem(String uuid) {
      for (int idx = 0; idx < document.getItems().size(); idx++)
         if (document.getItems().get(idx).getUUID().equals(uuid))
            return idx;
      return null;
   }

   private void renumberItems() {
      int num = 1;
      for (Item item : document.getItems()) {
         if (item instanceof Question) {
            ((Question) item).setProblemNumber(num++);
         }
      }
   }
}
