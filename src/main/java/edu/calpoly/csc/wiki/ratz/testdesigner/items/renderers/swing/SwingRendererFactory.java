package edu.calpoly.csc.wiki.ratz.testdesigner.items.renderers.swing;

import java.awt.Graphics2D;

import edu.calpoly.csc.wiki.ratz.testdesigner.gui.document.PageSettings;
import edu.calpoly.csc.wiki.ratz.testdesigner.items.Item;
import edu.calpoly.csc.wiki.ratz.testdesigner.items.MultipleChoiceItem;
import edu.calpoly.csc.wiki.ratz.testdesigner.items.renderers.AbstractRendererFactory;
import edu.calpoly.csc.wiki.ratz.testdesigner.items.renderers.Renderer;

/**
 * Creates Renderers for drawing to a Swing form.
 * 
 * @see edu.calpoly.csc.wiki.ratz.testdesigner.items.renderers.RendererFactory
 * 
 * @author jdisanti
 */
public class SwingRendererFactory implements AbstractRendererFactory {
   private PageSettings pageSettings;
   private Graphics2D graphics;

   public SwingRendererFactory(PageSettings pageSettings, Graphics2D graphics) {
      this.pageSettings = pageSettings;
      this.graphics = graphics;
   }

   /**
    * {@inheritDoc}
    */
   public Renderer getDocumentRenderer(Item item, boolean showAnswers) {
      switch (item.getType()) {
      case MULTIPLE_CHOICE:
         return new SwingMultipleChoiceRenderer((MultipleChoiceItem) item,
               pageSettings, graphics, showAnswers);
      default:
         assert false;
      }
      return null;
   }

   /**
    * {@inheritDoc}
    */
   public Renderer getAnswerSheetRenderer(Item item, boolean showAnswers) {
      // TODO Auto-generated method stub
      return null;
   }
}
