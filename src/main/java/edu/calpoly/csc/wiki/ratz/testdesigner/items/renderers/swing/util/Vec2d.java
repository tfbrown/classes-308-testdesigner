package edu.calpoly.csc.wiki.ratz.testdesigner.items.renderers.swing.util;

public class Vec2d {
   public final double x, y;

   public Vec2d(double x, double y) {
      this.x = x;
      this.y = y;
   }

   public Vec2d(Vec2d rhs) {
      this.x = rhs.x;
      this.y = rhs.y;
   }

   public Vec2d add(Vec2d rhs) {
      return new Vec2d(x + rhs.x, y + rhs.y);
   }

   public Vec2d mul(Vec2d rhs) {
      return new Vec2d(x * rhs.x, y * rhs.y);
   }

   public Vec2d mul(double scalar) {
      return new Vec2d(x * scalar, y * scalar);
   }
}
