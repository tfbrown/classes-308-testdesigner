package edu.calpoly.csc.wiki.ratz.testdesigner;

import javax.swing.UIManager;

import edu.calpoly.csc.wiki.ratz.testdesigner.gui.document.TestDocumentPanel;

/**
 * The program entry class.
 * 
 * @author jdisanti
 */
public class Application {
   public static void main(String[] args) {
      try {
         UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
      }
      catch (Exception ex) {
         // failed to set native look and feel, carry on
      }
      
      new TestDocumentPanel().setVisible(true);
   }
}
