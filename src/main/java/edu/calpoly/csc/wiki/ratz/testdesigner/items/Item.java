package edu.calpoly.csc.wiki.ratz.testdesigner.items;

import java.io.Serializable;

/**
 * An Item is anything that can show up on a test. For example, instructions and
 * multiple choice questions.
 * 
 * @author jdisanti
 */
public interface Item extends Serializable {
   /**
    * Returns the type of the item. This is necessary for the RendererFactory to
    * know which kind of Renderer to make.
    * 
    * @return Enumeration of the item type.
    */
   ItemType getType();
}
