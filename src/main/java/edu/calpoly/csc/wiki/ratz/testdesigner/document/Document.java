package edu.calpoly.csc.wiki.ratz.testdesigner.document;

import java.io.Serializable;
import java.util.LinkedList;
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
   private List<Item> items = new LinkedList<Item>();

   /** The margins of test page. */
   private Margins margins = new Margins();

   /** Returns the items on the document. */
   public List<Item> getItems() {
      return items;
   }

   /**
    * Returns the items on the document.
    * 
    * @param header
    *           Whether or not to include the header in the margin calculation.
    * @param footer
    *           Whether or not to include the footer in the margin calculation.
    * @return The margins.
    */
   public Margins getMargins(boolean header, boolean footer) {
      // XXX consider the header/footer
      return margins;
   }
}
