package edu.calpoly.csc.wiki.ratz.testdesigner.gui.document;

import java.awt.Color;
import java.awt.Dimension;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.SpringLayout;
import javax.swing.border.LineBorder;

import net.miginfocom.swing.MigLayout;
import edu.calpoly.csc.wiki.ratz.testdesigner.document.Margins;
import edu.calpoly.csc.wiki.ratz.testdesigner.gui.document.items.ItemComponent;
import edu.calpoly.csc.wiki.ratz.testdesigner.items.Item;

/**
 * A Swing component that displays a piece of paper with ItemComponents rendered
 * on it.
 * 
 * @author jdisanti
 */
public class DocumentPage extends JPanel {
   private static final long serialVersionUID = -2347923520957683006L;

   private PageSettings pageSettings;
   private List<ItemComponent<? extends Item>> components = new ArrayList<ItemComponent<? extends Item>>();
   private JPanel viewArea;

   public DocumentPage(JComponent parent, PageSettings pageSettings) {
      super();
      this.pageSettings = pageSettings;
      initComponents();
      parent.add(this);
   }

   /**
    * Returns whether or not another item will fit on the document page.
    * 
    * @param component
    *           The item component to test.
    * @return True if it will fit.
    */
   public boolean canFit(ItemComponent<? extends Item> component) {
      int usedHeight = 0;
      for (ItemComponent<? extends Item> comp : components) {
         usedHeight += comp.getHeight();
      }
      Margins margins = pageSettings.getMargins();
      int maxHeight = (int) (pageSettings.getPageHeightPixels() - pageSettings
            .getDpi() * (margins.getTop() + margins.getBottom()));
      // XXX: The getHeight method below is always returning 0... 
      return usedHeight + component.getHeight() < maxHeight;
   }

   /**
    * Adds an item to the document page.
    * 
    * @param component
    *           The item to add.
    */
   public void addItem(ItemComponent<? extends Item> component) {
      components.add(component);
      viewArea.add(component, "wrap");
   }

   private void initComponents() {
      setBackground(Color.WHITE);
      setBorder(new LineBorder(Color.BLACK, 1));

      Dimension size = new Dimension(pageSettings.getPageWidthPixels(),
            pageSettings.getPageHeightPixels());
      setMinimumSize(size);
      setPreferredSize(size);
      setMaximumSize(size);

      Margins margins = pageSettings.getMargins();

      viewArea = new JPanel();
      viewArea.setBackground(Color.WHITE);
      viewArea.setLayout(new MigLayout());
      add(viewArea);

      SpringLayout layout = new SpringLayout();
      layout.putConstraint(SpringLayout.NORTH, viewArea,
            (int) (margins.getTop() * pageSettings.getDpi()),
            SpringLayout.NORTH, this);
      layout.putConstraint(SpringLayout.WEST, viewArea,
            (int) (margins.getLeft() * pageSettings.getDpi()),
            SpringLayout.WEST, this);
      layout.putConstraint(SpringLayout.EAST, viewArea,
            (int) (-margins.getRight() * pageSettings.getDpi()),
            SpringLayout.EAST, this);
      layout.putConstraint(SpringLayout.SOUTH, viewArea,
            (int) (-margins.getBottom() * pageSettings.getDpi()),
            SpringLayout.SOUTH, this);
      setLayout(layout);
   }
}
