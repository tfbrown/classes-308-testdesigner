package edu.calpoly.csc.wiki.ratz.testdesigner.document;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.awt.print.PageFormat;
import java.awt.print.Pageable;
import java.awt.print.Paper;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.util.ArrayList;
import java.util.List;

import edu.calpoly.csc.wiki.ratz.testdesigner.gui.document.PageSettings;
import edu.calpoly.csc.wiki.ratz.testdesigner.items.Item;
import edu.calpoly.csc.wiki.ratz.testdesigner.items.renderers.Renderer;
import edu.calpoly.csc.wiki.ratz.testdesigner.items.renderers.swing.SwingRendererFactory;

/**
 * Class that chunks and prints a document.
 * 
 * @author jdisanti
 */
public class DocumentPageable implements Pageable, Printable {
   private static class Page {
      public List<Item> items = new ArrayList<Item>();
   }

   // Paper class requires measurements in 72 DPI
   private static final double PAPER_DIMENSIONS = 72;

   private PageSettings pageSettings = new PageSettings();
   private PageFormat pageFormat = new PageFormat();
   private List<Page> pages = new ArrayList<Page>();

   public DocumentPageable(Document document) {
      calculatePageFormat(document);
      calculatePages(document);
   }

   private void calculatePageFormat(Document document) {
      final Margins margins = document.getMargins();

      Paper paper = new Paper();
      paper.setSize(document.getPageWidth() * PAPER_DIMENSIONS,
            document.getPageHeight() * PAPER_DIMENSIONS);
      paper.setImageableArea(
            margins.getLeft() * PAPER_DIMENSIONS,
            margins.getTop() * PAPER_DIMENSIONS,
            (document.getPageWidth() - (margins.getLeft() + margins.getRight()))
                  * PAPER_DIMENSIONS,
            (document.getPageHeight() - (margins.getTop() + margins.getBottom()))
                  * PAPER_DIMENSIONS);
      pageFormat.setPaper(paper);
      pageFormat.setOrientation(PageFormat.PORTRAIT);

      pageSettings.setMargins(margins);
      pageSettings.setPageWidth(document.getPageWidth());
      pageSettings.setPageHeight(document.getPageHeight());
   }

   private void calculatePages(Document document) {
      // If you know of a better way to get a Graphics2D, please use it below
      BufferedImage img = new BufferedImage(1, 1, BufferedImage.TYPE_INT_RGB);
      SwingRendererFactory factory = new SwingRendererFactory(pageSettings,
            (Graphics2D) img.getGraphics());

      Page page = new Page();
      pages.add(page);

      double usedHeight = 0;
      for (Item item : document.getItems()) {
         Renderer renderer = factory.getDocumentRenderer(item, false);
         usedHeight += renderer.calculateHeight();

         if (usedHeight > pageFormat.getImageableHeight() / PAPER_DIMENSIONS) {
            page = new Page();
            pages.add(page);
            usedHeight = 0;
         }

         page.items.add(item);
      }
   }

   public int getNumberOfPages() {
      return pages.size();
   }

   public PageFormat getPageFormat(int pageIndex) {
      return pageFormat;
   }

   public Printable getPrintable(int pageIndex) {
      return this;
   }

   public int print(Graphics gr, PageFormat pageFormat, int pageIndex)
         throws PrinterException {
      if (pageIndex >= pages.size())
         return NO_SUCH_PAGE;

      final Page page = pages.get(pageIndex);
      final Graphics2D graphics = (Graphics2D) gr;
      final SwingRendererFactory factory = new SwingRendererFactory(
            pageSettings, graphics);

      graphics
            .translate(pageFormat.getImageableX(), pageFormat.getImageableY());
      for (Item item : page.items) {
         Renderer renderer = factory.getDocumentRenderer(item, false);
         renderer.render();

         graphics.translate(0, renderer.calculateHeight() * PAPER_DIMENSIONS);
      }

      return PAGE_EXISTS;
   }
}
