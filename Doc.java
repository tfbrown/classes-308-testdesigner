package edu.calpoly.csc.wiki.ratz.testdesigner.document.Doc;


import edu.calpoly.csc.wiki.ratz.testdesigner.items.Item;
/**
 * Document interface.
 * @author tfbrown
 */

public interface Doc {
public void getRemderedItems(Item ItemList);



public void getMargins(boolean header, boolean footer);

}
