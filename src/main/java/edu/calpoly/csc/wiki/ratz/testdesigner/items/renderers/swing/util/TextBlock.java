package edu.calpoly.csc.wiki.ratz.testdesigner.items.renderers.swing.util;

import java.awt.Graphics2D;
import java.awt.font.FontRenderContext;
import java.awt.font.LineBreakMeasurer;
import java.awt.font.TextLayout;
import java.text.AttributedString;

import edu.calpoly.csc.wiki.ratz.testdesigner.gui.document.PageSettings;

public class TextBlock extends Block {
   private PageSettings pageSettings;
   private Graphics2D graphics;
   private String text;
   private double maxWidth;

   public TextBlock(PageSettings pageSettings, Graphics2D graphics,
         String text, double width) {
      this.pageSettings = pageSettings;
      this.graphics = graphics;
      this.text = text;
      this.maxWidth = width;
   }

   @Override
   public Vec2d calculateSize() {
      Vec2d sizeOfChildren = super.calculateSize();

      FontRenderContext fontRenderContext = graphics.getFontRenderContext();
      LineBreakMeasurer lineBreaker = new LineBreakMeasurer(
            new AttributedString(text).getIterator(), fontRenderContext);

      final double dpi = pageSettings.getDpi();
      double width = Math.max(maxWidth, sizeOfChildren.x * dpi);
      double height = 0;

      while (lineBreaker.getPosition() < text.length()) {
         TextLayout layout = lineBreaker.nextLayout((int) (maxWidth * dpi));
         height += layout.getAscent() + layout.getDescent() + layout.getLeading();
      }

      height = Math.max(sizeOfChildren.y, height / dpi);
      return new Vec2d(width, height);
   }

   @Override
   public void render(Graphics2D gr, Vec2d startPos) {
      FontRenderContext fontRenderContext = graphics.getFontRenderContext();
      LineBreakMeasurer lineBreaker = new LineBreakMeasurer(
            new AttributedString(text).getIterator(), fontRenderContext);

      final int dpi = pageSettings.getDpi();

      int y = (int) (dpi * startPos.y);
      while (lineBreaker.getPosition() < text.length()) {
         TextLayout layout = lineBreaker.nextLayout((int) (maxWidth * dpi));

         y += layout.getAscent();
         layout.draw(graphics, (int) (startPos.x * dpi), y);
         y += layout.getDescent() + layout.getLeading();
      }

      super.render(gr, startPos);
   }
}
