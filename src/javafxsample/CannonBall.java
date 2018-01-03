/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxsample;

import javafx.animation.Interpolator;
import javafx.animation.PathTransition;
import java.util.ArrayList;
import javafx.geometry.Point2D;
import javafx.geometry.Rectangle2D;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 *
 * @author elgab
 */
public class CannonBall extends Actor {

   @Override
   public void setImage() {
      super.setImage(); //To change body of generated methods, choose Tools | Templates.
   }

   @Override
   public ArrayList<ImageView> getImageViewList() {
      return super.getImageViewList(); //To change body of generated methods, choose Tools | Templates.
   }
   @Override
    public void onKeyPressed(String keyCode) {
        return;
    }

    @Override
    protected String getImageName() {
        return "cannonball.png";
    }
    
    @Override
    protected boolean wantsToCollide() {
        return false;
    }
   
}
