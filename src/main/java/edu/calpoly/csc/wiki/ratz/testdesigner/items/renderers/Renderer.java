package edu.calpoly.csc.wiki.ratz.testdesigner.items.renderers;


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
   void render();

   /**
    * Calculates and returns the height of the given item in inches.
    * 
    * @param item
    *           The item for the calculation to be performed on.
    */
   double calculateHeight();
}
