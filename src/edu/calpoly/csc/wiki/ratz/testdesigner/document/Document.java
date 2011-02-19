package edu.calpoly.csc.wiki.ratz.testdesigner.document;

import edu.calpoly.csc.wiki.ratz.testdesigner.items.Item;

/**
 * Document interface.
 * 
 * @author tfbrown
 */
public interface Document {
   public void getRenderedItems(Item ItemList);
   public void getMargins(boolean header, boolean footer);
}
