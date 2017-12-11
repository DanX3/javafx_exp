/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxsample;

import java.util.ArrayList;
import javafx.geometry.Rectangle2D;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 *
 * @author optimans
 */
public abstract class Actor {
    protected ImageView image;
    
    public Actor() {
        setImage();
    }
    
    public abstract Node getNode();
    public final ImageView getImageView() { return image; }
    public abstract void onKeyPressed(String keyCode);
    
    public void setImage() {
        String path = "file:" + System.getProperty("user.dir") + "/res/img/" + getImageName();
        image = new ImageView(new Image(path, true));
    }
    
    public final Rectangle2D getBoundingBox() {
        return image.getViewport();
    }
    
    protected abstract String getImageName();
    
    protected abstract boolean wantsToCollide();
    
    public abstract ArrayList<Rectangle2D> getCollisionShapes();
}
