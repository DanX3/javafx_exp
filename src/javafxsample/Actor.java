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
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;



public abstract class Actor {
    
    protected ImageView image;
    Point2D location;
    
    public Actor() {
        setImage();
        location = getLocation();
        image.setX(location.getX());
        image.setY(location.getY());
    }
    
    public ArrayList<ImageView> getImageViewList() {
        ArrayList<ImageView> result = new ArrayList<ImageView>(1);
        result.add(image);
        return result;
    }
    public abstract void onKeyPressed(String keyCode);
    
    public static String getResPath() {
        return "file:" + System.getProperty("user.dir") + "/res/img/";
    }
    
    private void setImage() {
        String path = getResPath() + getImageName();
        image = new ImageView(new Image(path, true));
    }
    
    public final Rectangle2D getBoundingBox() {
        return image.getViewport();
    }
    
    protected abstract String getImageName();
    
    protected abstract boolean wantsToCollide();
    
    public abstract ArrayList<Rectangle2D> getCollisionShapes();
    
    public abstract String getCollisionStringId();
    
    protected abstract Point2D getLocation();
}
