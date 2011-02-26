package edu.calpoly.csc.wiki.ratz.testdesigner.items;

/**
 * Class for Question types.
 * 
 * @author jrabaino
 */
public abstract class Question extends Item {
   private static final long serialVersionUID = -8646128822584368461L;

   /** The introductory text to a question. */
   private String question;
   /** The point value of a question. */
   private int weight;
   /** The user defined level for a question. */
   private String level;
   /** The user defined category for a question. */
   private String category;
   /** The problem number. */
   private int problemNumber;

   /**
    * Gets the question text for the question.
    * 
    * @return The question text.
    */
   public String getQuestion() {
      return question;
   }

   /**
    * Sets the question text for a question.
    * 
    * @var newQuestion The new text to assign.
    */
   public void setQuestion(String newQuestion) {
      question = newQuestion;
   }

   /**
    * Gets the weight for a question.
    * 
    * @return The weight.
    */
   public int getWeight() {
      return weight;
   }

   /**
    * Sets the weight for a question.
    * 
    * @var newWeight The weight to assign.
    */
   public void setWeight(int newWeight) {
      weight = newWeight;
   }

   /**
    * Gets the level for a question.
    * 
    * @return The level.
    */
   public String getLevel() {
      return level;
   }

   /**
    * Sets the level for a question.
    * 
    * @var newLevel The level to assign.
    */
   public void setLevel(String newLevel) {
      level = newLevel;
   }

   /**
    * Gets the category for a question.
    * 
    * @return The category.
    */
   public String getCategory() {
      return category;
   }

   /**
    * Sets the category for a question.
    * 
    * @var newCategory The new category to assign.
    */
   public void setCategory(String newCategory) {
      category = newCategory;
   }
   
   /** Returns the problem number. */
   public int getProblemNumber() {
      return problemNumber;
   }
   
   /** Sets the problem number. */
   public void setProblemNumber(int problemNumber) {
      this.problemNumber = problemNumber;
   }
}
