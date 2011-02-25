package edu.calpoly.csc.wiki.ratz.testdesigner.gui.document.items;

import java.awt.Color;

import javax.swing.JPanel;

import edu.calpoly.csc.wiki.ratz.testdesigner.gui.document.PageSettings;

public abstract class ItemComponent<ItemClass> extends JPanel {
   private static final long serialVersionUID = -2415607492418432151L;
   
   protected PageSettings pageSettings;
   protected ItemClass item;
   private int number;
   
   public ItemComponent(PageSettings pageSettings, ItemClass item, int number) {
      this.pageSettings = pageSettings;
      this.item = item;
      this.number = number;
      
      setBackground(Color.WHITE);
      initComponents();
   }
   
   protected abstract void initComponents();
   
   protected String getNumber() {
      return String.format("%d.", number);
   }
}
