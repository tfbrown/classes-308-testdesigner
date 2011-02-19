package edu.calpoly.csc.wiki.ratz.testdesigner.document.AutoSave;


import edu.calpoly.csc.wiki.ratz.testdesigner.document.Doc;


/**
 * Functions regarding the Auto-Save feature.
 * @author tfbrown
 */
public class AutoSave{
/**
 * Default Constructor class.
 */
public AutoSave(){

}
/**
 * Boolean to check if changes have been made.
 */
boolean change;

/**
 * Function that checks if a question or formatting item has been added or removed.
 * @return 1 if change has been made, 0 otherwise
 */
public boolean changeMade(){

    return change;
}

}
