package edu.calpoly.csc.wiki.ratz.testdesigner.items.renderers;

import edu.calpoly.csc.wiki.ratz.testdesigner.items.Item;

/**
 * Interface that enables the use of a singleton to create all of the different
 * kinds of Renderers for different rendering contexts.
 * 
 * @see edu.calpoly.csc.wiki.ratz.testdesigner.items.renderers.RendererFactory
 * 
 * @author jdisanti
 */
public interface AbstractRendererFactory {
   /**
    * Returns a Renderer that can draw the Item for the Document Sheet.
    * 
    * @param item
    *           The item that the Renderer needs to be able to draw.
    * @param number
    *           The number the item should show if it is numbered.
    * @param showAnswers
    *           Whether or not the Renderer should draw answers.
    * @return A Renderer that can draw the given ItemType.
    */
   Renderer getDocumentRenderer(Item type, int number, boolean showAnswers);

   /**
    * Returns a Renderer that can draw the Item for the Answer Sheet.
    * 
    * @param item
    *           The item that the Renderer needs to be able to draw.
    * @param number
    *           The number the item should show if it is numbered.
    * @param showAnswers
    *           Whether or not the Renderer should draw answers.
    * @return A Renderer that can draw the given ItemType.
    */
   Renderer getAnswerSheetRenderer(Item type, int number, boolean showAnswers);
}
