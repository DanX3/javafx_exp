/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxsample;

import java.util.ArrayList;
import javafx.geometry.Point2D;
import javafx.geometry.Rectangle2D;
import javafx.scene.Node;
import javafx.scene.image.ImageView;

/**
 *
 * @author elgab
 */
public class AirForce extends Actor {
   
   @Override
   public void onKeyPressed(String keyCode) {
      return;
   }
   
   @Override
   protected String getImageName(){
      return "airForce.png";
   }
   
   @Override
   protected boolean wantsToCollide() {
      return false;
   }
   
   @Override
   public ArrayList<Rectangle2D> getCollisionShapes() {
      ArrayList<Rectangle2D> shapes = new ArrayList<>(3);
      shapes.add(new Rectangle2D(0, 25, 325, 50));
      shapes.add(new Rectangle2D(245, 0, 100, 50));
      return shapes;
   }
   
   @Override
   public String getCollisionStringId() {
      return "airForce";
   }
   
   @Override
   protected Point2D getLocation() {
      return new Point2D(0, 200);
   }
   
   
}
