package edu.calpoly.csc.wiki.ratz.testdesigner.items;

import java.io.Serializable;

/**
 * An Item is anything that can show up on a test. For example, instructions and
 * multiple choice questions.
 * 
 * @author jdisanti
 */
public abstract class Item implements Serializable, Cloneable {
   private static final long serialVersionUID = -4922048756622256782L;
   
   private String uuid;
   
   public void setUUID(String uuid) {
      this.uuid = uuid;
   }
   
   public String getUUID() {
      return uuid;
   }
   
   /**
    * Returns the type of the item. This is necessary for the RendererFactory to
    * know which kind of Renderer to make.
    * 
    * @return Enumeration of the item type.
    */
   public abstract ItemType getType();
   
   @Override
   public boolean equals(Object obj) {
      if (obj instanceof Item) {
         String objUuid = ((Item) obj).getUUID();
         return objUuid != null && objUuid.equals(uuid);
      }
      return false;
   }
   
   @Override
   public Object clone() throws CloneNotSupportedException {
      return super.clone();
   }
}
