package edu.calpoly.csc.wiki.ratz.testdesigner.items.renderers;

import edu.calpoly.csc.wiki.ratz.testdesigner.items.Item;

/**
 * Interface that can render an item.
 * 
 * @author jdisanti
 */
public interface Renderer {
   /**
    * Renders an item.
    * 
    * @param item
    *           The item to be rendered. Must not be null.
    */
   void render(Item item);
}
