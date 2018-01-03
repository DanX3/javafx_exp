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

/**
 *
 * @author optimans
 */
public class Cannon extends Actor {

   Point2D projectileSpawnPoint;
   float tiltAngle;
   
   public Cannon() {
      tiltAngle = 0;
   }

   @Override
    public void onKeyPressed(String keyCode) {
        return;
    }
    
    private void increaseTiltAngle(float difference){
       tiltAngle += difference;
       tiltAngle = Actor.clamp(0,90, tiltAngle);
       
       
    }

    @Override
    protected String getImageName() {
        return "cannon.png";
    }

    @Override
    protected boolean wantsToCollide() {
        return false;
    }

    @Override
    public ArrayList<Rectangle2D> getCollisionShapes() {
        return null;
    }
    
    @Override
    public String getCollisionStringId() {
        return "cannon";
    }

    @Override
    protected Point2D getInitialLocation() {
        return new Point2D(100, 200);
    }

}
