package edu.calpoly.csc.wiki.ratz.testdesigner.document;

import java.io.Serializable;

/**
 * Container class for the document margins.
 * 
 * @author tfbrown
 */
public class Margins implements Serializable {
   private static final long serialVersionUID = -8961127814097150607L;

   private static final float DEFAULT_MARGIN_SIZE = 1.f;

   /** Bottom margin in inches. */
   float bottom;
   /** Top margin in inches. */
   float top;
   /** Left margin in inches. */
   float left;
   /** Right margin in inches. */
   float right;

   /**
    * Default Constructor class.
    */
   public Margins() {
      bottom = top = left = right = DEFAULT_MARGIN_SIZE;
   }

   /**
    * Constructor that sets all margins for the document.
    * 
    * @param bottom
    * @param top
    * @param left
    * @param right
    */
   public Margins(float bottom, float top, float left, float right) {
      this.bottom = bottom;
      this.top = top;
      this.left = left;
      this.right = right;
   }

   /**
    * Sets just the right margin value.
    * 
    * @param right
    */
   public void setRight(float right) {
   }

   /**
    * Sets just the left margin value.
    * 
    * @param left
    */
   public void setLeft(float left) {
   }

   /**
    * Sets the top margin, takes into account possible presence of header.
    * 
    * @param top
    * @param header
    */
   public void setTop(float top, boolean header) {
   }

   /**
    * Sets the bottom margin, takes into account possible presence of footer.
    * 
    * @param bottom
    * @param header
    */
   public void setBottom(float bottom, boolean header) {
   }

   /**
    * Gets the right margin.
    * 
    * @return The right margin value.
    */
   public float getRight() {
      return right;
   }

   /**
    * Gets the left margin.
    * 
    * @return The left margin value.
    */
   public float getLeft() {
      return left;
   }

   /**
    * Gets the top margin.
    * 
    * @return The top margin value.
    */
   public float getTop() {
      return top;
   }

   /**
    * Gets the bottom margin.
    * 
    * @return The bottom margin value.
    */
   public float getBottom() {
      return bottom;
   }
}
