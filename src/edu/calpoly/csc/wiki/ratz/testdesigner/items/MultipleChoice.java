package edu.calpoly.csc.wiki.ratz.testdesigner.items;
import java.util.ArrayList;

/**
 * The multiple choice question type.
 *
 * @author jrabaino
 * @todo add correct answer set/get capability.
 */
public class MultipleChoice extends Question{
   /**
    * A container for answers.
    */
   private class Answer(){
   }

   /** ArrayList of all possible answers. */
   private ArrayList<String> answers;
   /** Index location of correct answer. */
   private int correctAnswer;

   /**
    * Gets all of the answers.
    * @return The ArrayList of answers.
    */
   public ArrayList<String> getAnswers(){
      return answers;
   }
   /**
    * Gets all of the answers.
    * @var newAnswers The ArrayList of answers to assign.
    */
   public void setAnswers(ArrayList<String> newAnswers){
      answers = newAnswers;
   }
   /**
    * Gets a single answer.
    * @var index The location to get the answer from.
    * @return The answer at the given location.
    */
   public String getPossible(int index){
     return answers.get(index);
   }
   /**
    * Sets a single answer.
    * @var newAnswer The answer to set.
    * @var index The location to set the answer.
    */
   public void setPossible(String newAnswer, int index){
      answer.set(index, answer);
   }
   /**
    * Removes a single answer.
    * @var index The location to set the answer.
    */
   public void removePossible(int index){
      answer.remove(index);
   }
}
