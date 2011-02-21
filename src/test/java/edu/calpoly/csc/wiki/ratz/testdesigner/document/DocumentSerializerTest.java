package edu.calpoly.csc.wiki.ratz.testdesigner.document;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import junit.framework.Assert;

import org.junit.Test;

import edu.calpoly.csc.wiki.ratz.testdesigner.items.MultipleChoiceItem;
import edu.calpoly.csc.wiki.ratz.testdesigner.items.MultipleChoiceItem.Answer;

/**
 * A unit test for the DocumentSerializer.
 * 
 * @author jdisanti
 */
public class DocumentSerializerTest {
   @Test
   public void testSaveLoad() throws IOException {
      final int expectedWeight = 3;
      final String expectedLevel = "easy";
      final String expectedCategory = null;
      final String expectedQuestion = "Which of the three numbers am I thinking of?";
      final List<Answer> expectedAnswers = new ArrayList<Answer>();
      
      expectedAnswers.add(new Answer("one", false));
      expectedAnswers.add(new Answer("two", true));
      expectedAnswers.add(new Answer("three", false));
      
      Document doc = new Document();
      MultipleChoiceItem mcItem = new MultipleChoiceItem();
      mcItem.setWeight(expectedWeight);
      mcItem.setLevel(expectedLevel);
      mcItem.setCategory(expectedCategory);
      mcItem.setQuestion(expectedQuestion);
      mcItem.setAnswers(expectedAnswers);
      doc.getItems().put("asdf", mcItem);
      
      ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
      DocumentSerializer.save(doc, outputStream);

      ByteArrayInputStream inputStream = new ByteArrayInputStream(
            outputStream.toByteArray());
      Document actual = DocumentSerializer.load(inputStream);
      
      Assert.assertEquals(doc.getItems().size(), actual.getItems().size());
      
      MultipleChoiceItem actualMcItem = (MultipleChoiceItem) actual.getItems().get("asdf");
      Assert.assertEquals(expectedWeight, actualMcItem.getWeight());
      Assert.assertEquals(expectedLevel, actualMcItem.getLevel());
      Assert.assertEquals(expectedCategory, actualMcItem.getCategory());
      Assert.assertEquals(expectedQuestion, actualMcItem.getQuestion());
      
      Assert.assertEquals(expectedAnswers.size(), actualMcItem.getAnswers().size());
   }
}
