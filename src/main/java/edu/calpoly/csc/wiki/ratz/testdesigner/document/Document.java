package edu.calpoly.csc.wiki.ratz.testdesigner.document;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import edu.calpoly.csc.wiki.ratz.testdesigner.items.Item;

/**
 * The Document class holds all of the serializable information about the test.
 * 
 * @author tfbrown
 */
public class Document implements Serializable {
   private static final long serialVersionUID = -8726596310681248306L;

   /** All of the items on the test. */
   private List<Item> items = new ArrayList<Item>();

   /** The margins of test page. */
   private Margins margins = new Margins();

   /** Width of the paper in inches. */
   private double pageWidth = 8.5;

   /** Height of the paper in inches. */
   private double pageHeight = 11.0;

   /** Returns the items on the document. */
   public List<Item> getItems() {
      return items;
   }

   /** Returns the margins of the document in inches. */
   public Margins getMargins() {
      return margins;
   }

   /** Returns the page width in inches. */
   public double getPageWidth() {
      return pageWidth;
   }

   /** Returns the page height in inches. */
   public double getPageHeight() {
      return pageHeight;
   }
}
