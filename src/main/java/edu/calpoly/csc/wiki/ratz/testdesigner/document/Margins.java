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
   double bottom;
   /** Top margin in inches. */
   double top;
   /** Left margin in inches. */
   double left;
   /** Right margin in inches. */
   double right;

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
   public Margins(double bottom, double top, double left, double right) {
      this.bottom = bottom;
      this.top = top;
      this.left = left;
      this.right = right;
   }

   /** Sets the right margin value in inches. */
   public void setRight(double right) {
      this.right = right;
   }

   /** Sets the left margin value in inches. */
   public void setLeft(double left) {
      this.left = left;
   }

   /** Sets the top margin in inches. */
   public void setTop(double top) {
      this.top = top;
   }

   /** Sets the bottom margin in inches. */
   public void setBottom(double bottom) {
      this.bottom = bottom;
   }

   /** Gets the right margin in inches. */
   public double getRight() {
      return right;
   }

   /** Gets the left margin in inches. */
   public double getLeft() {
      return left;
   }

   /** Gets the top margin in inches. */
   public double getTop() {
      return top;
   }

   /** Gets the bottom margin in inches. */
   public double getBottom() {
      return bottom;
   }
}
