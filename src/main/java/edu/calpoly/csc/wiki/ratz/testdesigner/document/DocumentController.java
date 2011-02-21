package edu.calpoly.csc.wiki.ratz.testdesigner.document;

import java.io.IOException;
import java.util.LinkedHashMap;

import edu.calpoly.csc.wiki.ratz.testdesigner.items.Item;

/**
 * DocumentController is used to manipulate a Document.
 * 
 * @author jdisanti
 */
public class DocumentController {
   private Document document = new Document();
   
   /**
    * Adds an item to the document.
    * 
    * @param item
    *           The item to add.
    * @return The UUID of the item.
    */
   public String addItem(Item item) {
      // XXX
      return null;
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
      // XXX
   }

   /**
    * Removes an item from the document.
    * 
    * @param uuid
    *           The UUID of the item to remove.
    */
   public void removeItem(String uuid) {
      // XXX
   }

   /**
    * Returns a cloned list of all of the items in the Document.
    * 
    * @return A cloned list of items.
    */
   public LinkedHashMap<String, Item> getItems() {
      // XXX: Make sure you deep clone the items.
      return null;
   }

   /**
    * Finds an item by UUID and returns it.
    * 
    * @param uuid
    *           The UUID of the item to look up.
    * @return The Item, or null if it wasn't found.
    */
   public Item findItem(String uuid) {
      // XXX
      return null;
   }

   /**
    * Moves an item up.
    * 
    * @param uuid
    *           The UUID of the item to move up.
    */
   public void moveItemUp(String uuid) {
      // XXX
   }

   /**
    * Moves an item down.
    * 
    * @param uuid
    *           The UUID of the item to move down.
    */
   public void moveItemDown(String uuid) {
      // XXX
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
    * Randomizes the order of questions in the sections.
    * 
    * @param randomizeAnswers
    *           Whether or not to randomize the answers as well.
    */
   public void randomizeQuestionOrder(boolean randomizeAnswers) {
      // XXX
   }

   /**
    * Randomizes the order of the sections.
    * 
    * @param randomizeAnswers
    *           Whether or not to randomize the answers as well.
    */
   public void randomizeSections(boolean randomizeAnswers) {
      // XXX
   }

   /**
    * Prints the document.
    */
   public void print() {
      // XXX
   }
}
