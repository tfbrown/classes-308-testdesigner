package edu.calpoly.csc.wiki.ratz.testdesigner.gui.document.items;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;

import edu.calpoly.csc.wiki.ratz.testdesigner.gui.document.PageSettings;
import edu.calpoly.csc.wiki.ratz.testdesigner.items.Item;
import edu.calpoly.csc.wiki.ratz.testdesigner.items.renderers.Renderer;
import edu.calpoly.csc.wiki.ratz.testdesigner.items.renderers.swing.SwingRendererFactory;

/**
 * Class that renders a test item to the Swing preview component. It
 * accomplishes this by rendering the item to a buffered image, and then copying
 * that image to the final component.
 * 
 * @author jdisanti
 */
public class ItemComponent extends JPanel {
   private static final long serialVersionUID = 7172145259989034168L;

   private Renderer renderer;
   private BufferedImage bufferedImage;
   private Dimension size;

   public ItemComponent(PageSettings pageSettings, Item item) {
      bufferedImage = new BufferedImage(pageSettings.getItemAreaWidthPixels(),
            pageSettings.getItemAreaHeightPixels(), BufferedImage.TYPE_INT_RGB);
      Graphics2D graphics = (Graphics2D) bufferedImage.getGraphics();
      graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
            RenderingHints.VALUE_ANTIALIAS_ON);
      graphics.setColor(Color.WHITE);
      graphics.fillRect(0, 0, bufferedImage.getWidth(),
            bufferedImage.getHeight());

      renderer = new SwingRendererFactory(pageSettings, graphics)
            .getDocumentRenderer(item, false);
      renderer.render();

      size = new Dimension(pageSettings.getItemAreaWidthPixels(),
            (int) (pageSettings.getDpi() * renderer.calculateHeight()));
      setPreferredSize(size);
      setMinimumSize(size);
      setMaximumSize(size);
   }

   public int calculateHeight() {
      return (int) size.getHeight();
   }

   @Override
   protected void paintComponent(Graphics g) {
      super.paintComponent(g);

      ((Graphics2D) g).drawImage(bufferedImage, new AffineTransformOp(
            new AffineTransform(), AffineTransformOp.TYPE_NEAREST_NEIGHBOR), 0,
            0);
   }
   
   public BufferedImage getImage() {
      return bufferedImage;
   }
}
