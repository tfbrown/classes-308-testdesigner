package edu.calpoly.csc.wiki.ratz.testdesigner.items;

import java.util.ArrayList;

/**
 * The multiple choice question type.
 * 
 * @author jrabaino
 */
public class MultipleChoice extends Question {
   /**
    * A container for answers.
    */
   public static class Answer {
      /** A single answer. */
      public String answer;
      /** True if the answer is correct. */
      public boolean isCorrect;

      /**
       * Creates a new muiltiple choice answer.
       * 
       * @var answer The text of the answer.
       * @var correct True if answer is correct.
       */
      public Answer(String answer, boolean correct) {
         this.answer = answer;
         isCorrect = correct;
      }

   }

   /** ArrayList of all possible answers. */
   private ArrayList<Answer> answers;

   /**
    * Gets all of the answers.
    * 
    * @return The ArrayList of answers.
    */
   public ArrayList<Answer> getAnswers() {
      return answers;
   }

   /**
    * Gets all of the answers.
    * 
    * @var newAnswers The ArrayList of answers to assign.
    */
   public void setAnswers(ArrayList<Answer> newAnswers) {
      answers = newAnswers;
   }

   /**
    * Gets a single answer.
    * 
    * @var index The location to get the answer from.
    * @return The answer at the given location.
    */
   public Answer getPossible(int index) {
      return answers.get(index);
   }

   /**
    * Sets a single answer.
    * 
    * @var answer The text of the answer to set.
    * @var correct True if given answer is a correct answer.
    * @var index The location to set the answer.
    */
   public void setPossible(String answer, boolean correct, int index) {
      answers.set(index, new Answer(answer, correct));
   }

   /**
    * Sets a single answer.
    * 
    * @var answer The answer to set.
    * @var index The location to set the answer.
    */
   public void setPossible(Answer answer, int index) {
      answers.set(index, answer);
   }

   /**
    * Removes a single answer.
    * 
    * @var index The location to set the answer.
    */
   public void removePossible(int index) {
      answers.remove(index);
   }

   public ItemType getType() {
      return ItemType.MULTIPLE_CHOICE;
   }
}
