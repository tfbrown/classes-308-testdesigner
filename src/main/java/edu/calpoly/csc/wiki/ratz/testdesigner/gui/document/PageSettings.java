package edu.calpoly.csc.wiki.ratz.testdesigner.gui.document;

import java.awt.Font;

import edu.calpoly.csc.wiki.ratz.testdesigner.document.Margins;

/**
 * Bean that is used by the Swing test preview components for rendering.
 * 
 * @author jdisanti
 */
public class PageSettings {
   private Font font;
   private Margins margins;

   /** Page width in inches */
   private float pageWidth;

   /** Page height in inches */
   private float pageHeight;

   private String header;
   private String footer;

   /** Display dots-per-inch */
   private int dpi;

   public PageSettings() {
      font = new Font("Serif", Font.PLAIN, 12);
      margins = new Margins();
      header = "";
      footer = "";
      pageWidth = 8.5f;
      pageHeight = 11.f;
      dpi = 72;
   }

   public Font getFont() {
      return font;
   }

   public void setFont(Font font) {
      this.font = font;
   }

   public Margins getMargins() {
      return margins;
   }

   public void setMargins(Margins margins) {
      this.margins = margins;
   }

   public void setPageWidth(float pageWidth) {
      this.pageWidth = pageWidth;
   }

   public float getPageWidth() {
      return pageWidth;
   }

   public int getPageWidthPixels() {
      return (int) (dpi * pageWidth);
   }

   public void setPageHeight(float pageHeight) {
      this.pageHeight = pageHeight;
   }

   public float getPageHeight() {
      return pageHeight;
   }

   public int getPageHeightPixels() {
      return (int) (dpi * pageHeight);
   }

   public int getItemAreaWidthPixels() {
      return getPageWidthPixels()
            - (int) (dpi * margins.getLeft() + dpi * margins.getRight());
   }

   public int getItemAreaHeightPixels() {
      return getPageHeightPixels()
            - (int) (dpi * margins.getTop() + dpi * margins.getBottom());
   }

   public String getHeader() {
      return header;
   }

   public void setHeader(String header) {
      this.header = header;
   }

   public String getFooter() {
      return footer;
   }

   public void setFooter(String footer) {
      this.footer = footer;
   }

   public float getQuestionWidth() {
      return pageWidth - (margins.getLeft() + margins.getRight());
   }

   public int getQuestionWidthPixels() {
      return (int) (dpi * getQuestionWidth());
   }

   public int getDpi() {
      return dpi;
   }

   public void setDpi(int dpi) {
      this.dpi = dpi;
   }
}
