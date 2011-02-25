package edu.calpoly.csc.wiki.ratz.testdesigner.gui.document.items;

import edu.calpoly.csc.wiki.ratz.testdesigner.gui.document.PageSettings;
import edu.calpoly.csc.wiki.ratz.testdesigner.items.Item;
import edu.calpoly.csc.wiki.ratz.testdesigner.items.MultipleChoiceItem;

/**
 * Factory for Swing components to draw various item types.
 * 
 * @author jdisanti
 */
public class ItemComponentFactory {
   /**
    * Returns a component based on the item type of the passed item.
    * 
    * @param pageSettings
    *           The PageSettings for the item component to use.
    * @param item
    *           The Item the component is for.
    * @param number
    *           The number of the component (if applicable).
    * @return An item component.
    */
   public static ItemComponent<? extends Item> getComponent(
         PageSettings pageSettings, Item item, int number) {
      switch (item.getType()) {
      case MULTIPLE_CHOICE:
         return new MultipleChoiceComponent(pageSettings,
               (MultipleChoiceItem) item, number);
      default:
         assert false;
      }
      return null;
   }
}
