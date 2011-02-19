package edu.calpoly.csc.wiki.ratz.testdesigner.items.renderers;

import edu.calpoly.csc.wiki.ratz.testdesigner.items.ItemType;

/**
 * A singleton class that creates Renderers for Items. Set the factory to the
 * type of rendering that needs to be done. For instance, if rendering the test
 * to the GUI, set the factory to the SwingRendererFactory. If printing, set the
 * factory to the PrintRendererFactory. Then create Renderers to draw the test.
 * 
 * @author jdisanti
 */
public class RendererFactory {
   /**
    * The factory to use for creating Renderers.
    */
   private static AbstractRendererFactory factory;
   
   /**
    * Returns a Renderer that can draw the Item for the Document Sheet.
    * 
    * @param type The type of Item the Renderer needs to be able to draw.
    * @param showAnswers Whether or not the Renderer should draw answers.
    * @return A Renderer that can draw the given ItemType.
    */
   public static Renderer getDocumentRenderer(ItemType type, boolean showAnswers) {
      return factory.getDocumentRenderer(type, showAnswers);
   }
   
   /**
    * Returns a Renderer that can draw the Item for the Answer Sheet.
    * 
    * @param type The type of Item the Renderer needs to be able to draw.
    * @param showAnswers Whether or not the Renderer should draw answers.
    * @return A Renderer that can draw the given ItemType.
    */
   public static Renderer getAnswerSheetRenderer(ItemType type, boolean showAnswers) {
      return factory.getAnswerSheetRenderer(type, showAnswers);
   }
   
   /**
    * Sets the factory used to create Renderers.
    * @param factory The factory.
    */
   public static void setFactory(AbstractRendererFactory factory) {
      RendererFactory.factory = factory;
   }
}
