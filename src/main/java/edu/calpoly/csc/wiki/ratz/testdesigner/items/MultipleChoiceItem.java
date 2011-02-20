package edu.calpoly.csc.wiki.ratz.testdesigner.items;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * The multiple choice question type.
 * 
 * @author jrabaino
 */
public class MultipleChoiceItem extends Question {
   /**
    * A container for answers.
    */
   public static class Answer implements Serializable {
      private static final long serialVersionUID = 8001218243930856094L;

      /** A single answer. */
      public String answer;
      /** True if the answer is correct. */
      public boolean correct;

      /**
       * Creates a new multiple choice answer.
       * 
       * @var answer The text of the answer.
       * @var correct True if answer is correct.
       */
      public Answer(String answer, boolean correct) {
         this.answer = answer;
         this.correct = correct;
      }

      /** Gets the answer. */
      public String getAnswer() {
         return answer;
      }

      /** Sets the answer. */
      public void setAnswer(String answer) {
         this.answer = answer;
      }

      /** Returns whether or not the answer is the correct answer. */
      public boolean isCorrect() {
         return correct;
      }

      /** Sets whether or not the answer is the correct answer. */
      public void setCorrect(boolean correct) {
         this.correct = correct;
      }
   }

   private static final long serialVersionUID = -9010910595039658025L;

   /** List of all possible answers. */
   private List<Answer> answers = new ArrayList<Answer>();

   /**
    * Gets all of the answers.
    * 
    * @return The list of answers.
    */
   public List<Answer> getAnswers() {
      return answers;
   }

   /**
    * Gets all of the answers.
    * 
    * @var newAnswers The List of answers to assign.
    */
   public void setAnswers(List<Answer> newAnswers) {
      answers = newAnswers;
   }

   /**
    * {@inheritDoc}
    */
   public ItemType getType() {
      return ItemType.MULTIPLE_CHOICE;
   }
}
