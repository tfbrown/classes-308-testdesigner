package edu.calpoly.csc.wiki.ratz.testdesigner.document;

import java.util.ArrayList;
import java.util.List;

import junit.framework.Assert;

import org.junit.Test;

import edu.calpoly.csc.wiki.ratz.testdesigner.items.MultipleChoiceItem;
import edu.calpoly.csc.wiki.ratz.testdesigner.items.MultipleChoiceItem.Answer;

public class DocumentControllerTest {
   @Test
   public void testAddRemove() {
      final Document doc = new Document();
      final DocumentController controller = new DocumentController(doc);

      Assert.assertTrue(doc.getItems().isEmpty());

      String uuid0 = controller.addItem(new MultipleChoiceItem());
      Assert.assertNotNull(uuid0);
      Assert.assertFalse(doc.getItems().isEmpty());
      Assert.assertEquals(1, doc.getItems().size());
      Assert.assertEquals(uuid0, doc.getItems().get(0).getUUID());

      String uuid1 = controller.addItem(new MultipleChoiceItem());
      Assert.assertNotNull(uuid1);
      Assert.assertFalse(doc.getItems().isEmpty());
      Assert.assertEquals(2, doc.getItems().size());
      Assert.assertEquals(uuid1, doc.getItems().get(1).getUUID());

      controller.removeItem(uuid0);
      Assert.assertEquals(1, doc.getItems().size());
      Assert.assertEquals(uuid1, doc.getItems().get(0).getUUID());

      controller.removeItem(uuid1);
      Assert.assertTrue(doc.getItems().isEmpty());
   }

   @Test
   public void testUpdate() {
      final int expectedWeight = 3;
      final String expectedLevel = "easy";
      final String expectedCategory = null;
      final String expectedQuestion = "Which of the three numbers am I thinking of?";
      final List<Answer> expectedAnswers = new ArrayList<Answer>();

      final Document doc = new Document();
      final DocumentController controller = new DocumentController(doc);

      MultipleChoiceItem mcItem = new MultipleChoiceItem();
      mcItem.setWeight(23523);
      mcItem.setLevel("asdf");
      mcItem.setCategory("fdads");
      mcItem.setQuestion("asdfag");
      mcItem.setAnswers(null);

      String uuid = controller.addItem(mcItem);

      mcItem = new MultipleChoiceItem();
      mcItem.setWeight(expectedWeight);
      mcItem.setLevel(expectedLevel);
      mcItem.setCategory(expectedCategory);
      mcItem.setQuestion(expectedQuestion);
      mcItem.setAnswers(expectedAnswers);

      controller.updateItem(uuid, mcItem);

      MultipleChoiceItem actualMcItem = (MultipleChoiceItem) controller
            .findItem(uuid);
      Assert.assertEquals(uuid, actualMcItem.getUUID());
      Assert.assertEquals(expectedWeight, actualMcItem.getWeight());
      Assert.assertEquals(expectedLevel, actualMcItem.getLevel());
      Assert.assertEquals(expectedCategory, actualMcItem.getCategory());
      Assert.assertEquals(expectedQuestion, actualMcItem.getQuestion());
   }
   
   @Test
   public void testMoveUp() {
      final Document doc = new Document();
      final DocumentController controller = new DocumentController(doc);
      
      String uuid0 = controller.addItem(new MultipleChoiceItem());
      String uuid1 = controller.addItem(new MultipleChoiceItem());
      
      Assert.assertEquals(uuid0, doc.getItems().get(0).getUUID());
      Assert.assertEquals(uuid1, doc.getItems().get(1).getUUID());
      
      controller.moveItemUp(uuid0);
      
      Assert.assertEquals(uuid0, doc.getItems().get(0).getUUID());
      Assert.assertEquals(uuid1, doc.getItems().get(1).getUUID());
      
      controller.moveItemUp(uuid1);
      
      Assert.assertEquals(uuid1, doc.getItems().get(0).getUUID());
      Assert.assertEquals(uuid0, doc.getItems().get(1).getUUID());
   }
   
   @Test
   public void testMoveDown() {
      final Document doc = new Document();
      final DocumentController controller = new DocumentController(doc);
      
      String uuid0 = controller.addItem(new MultipleChoiceItem());
      String uuid1 = controller.addItem(new MultipleChoiceItem());
      
      Assert.assertEquals(uuid0, doc.getItems().get(0).getUUID());
      Assert.assertEquals(uuid1, doc.getItems().get(1).getUUID());
      
      controller.moveItemDown(uuid1);
      
      Assert.assertEquals(uuid0, doc.getItems().get(0).getUUID());
      Assert.assertEquals(uuid1, doc.getItems().get(1).getUUID());
      
      controller.moveItemDown(uuid0);
      
      Assert.assertEquals(uuid1, doc.getItems().get(0).getUUID());
      Assert.assertEquals(uuid0, doc.getItems().get(1).getUUID());
   }
}
