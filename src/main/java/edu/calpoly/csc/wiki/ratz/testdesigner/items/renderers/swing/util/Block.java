package edu.calpoly.csc.wiki.ratz.testdesigner.items.renderers.swing.util;

import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.List;

public class Block {
   protected List<Block> children = new ArrayList<Block>();
   protected Vec2d position = new Vec2d(0, 0);

   public void setPosition(double x, double y) {
      position = new Vec2d(x, y);
   }

   public void setPosition(Vec2d pos) {
      position = pos;
   }

   public Vec2d getPosition() {
      return new Vec2d(position);
   }

   public Vec2d calculateSize() {
      double width = 0, height = 0;
      for (Block child : children) {
         Vec2d childSize = child.calculateSize();
         width = Math.max(width, child.getX() + childSize.x);
         height = Math.max(height, child.getY() + childSize.y);
      }
      return new Vec2d(width, height);
   }

   public void render(Graphics2D gr) {
      render(gr, position);
   }

   public void render(Graphics2D gr, Vec2d startPos) {
      for (Block child : children) {
         child.render(gr, startPos.add(child.getPosition()));
      }
   }

   public double getX() {
      return position.x;
   }

   public double getY() {
      return position.y;
   }

   public void addChild(Block child) {
      children.add(child);
   }
}
