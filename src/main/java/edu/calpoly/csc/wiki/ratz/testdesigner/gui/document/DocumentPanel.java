package edu.calpoly.csc.wiki.ratz.testdesigner.gui.document;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

import edu.calpoly.csc.wiki.ratz.testdesigner.gui.document.items.ItemComponent;
import edu.calpoly.csc.wiki.ratz.testdesigner.items.Item;

/**
 * The Swing test preview component.
 * 
 * @author jdisanti
 */
public class DocumentPanel extends JScrollPane {
   private static final long serialVersionUID = -2317384265778812663L;

   private List<DocumentPage> pages = new ArrayList<DocumentPage>();
   private JPanel pagePanel;

   private PageSettings pageSettings = new PageSettings();

   public DocumentPanel() {
      super();

      setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
      setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
      
      recreatePagePanel();
   }
   
   private void recreatePagePanel() {
      if (pagePanel != null) {
         viewport.remove(pagePanel);
      }
      
      pagePanel = new JPanel();
      pagePanel.setBackground(Color.DARK_GRAY);
      pagePanel.setLayout(new BoxLayout(pagePanel, BoxLayout.Y_AXIS));
      viewport.add(pagePanel);
   }

   /**
    * Refreshes the page display with the given items.
    * 
    * @param items
    *           The items to draw.
    */
   public void refresh(List<Item> items) {
      pages.clear();
      recreatePagePanel();

      DocumentPage page = new DocumentPage(pagePanel, pageSettings);
      pages.add(page);

      for (Item item : items) {
         ItemComponent component = new ItemComponent(pageSettings, item);
         if (!page.canFit(component)) {
            page = new DocumentPage(pagePanel, pageSettings);
            pages.add(page);
         }

         page.addItem(component);
      }
   }
}
