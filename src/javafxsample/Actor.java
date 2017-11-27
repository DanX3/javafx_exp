/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxsample;

import javafx.scene.Node;
import javafx.scene.image.ImageView;

/**
 *
 * @author optimans
 */
public abstract class Actor {
    ImageView image;
    
    
    
    public abstract Node getNode();
    public abstract ImageView getImageView();
    public abstract void onKeyPressed(String keyCode);
    public void setImage(ImageView i) {
        image = i;
    }
}
