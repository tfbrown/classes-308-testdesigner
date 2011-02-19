package edu.calpoly.csc.wiki.ratz.testdesigner.items;

/**
 * Enumeration of every type of Item.
 * 
 * @author jdisanti
 */
public enum ItemType {
   /**
    * Static text can be used for instructions, section headings, and any other
    * kind of text on the test that is not a question.
    */
   STATIC_TEXT,

   /**
    * A multiple choice question.
    */
   MULTIPLE_CHOICE,

   /**
    * A true or false question.
    */
   TRUE_FALSE,

   /**
    * A freeform (or essay) question. In other words, a question with space
    * provided below for the test taker to write an answer.
    */
   FREEFORM,

   /**
    * A fill in the blank question.
    */
   FILL_IN_THE_BLANK,

   /**
    * A list question.
    */
   LIST,

   /**
    * An ordering question.
    */
   ORDER,

   /**
    * A matching question.
    */
   MATCHING
}
