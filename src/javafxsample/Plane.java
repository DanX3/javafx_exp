/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxsample;

import javafx.animation.Interpolator;
import javafx.animation.PathTransition;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.util.Duration;

public class Plane extends Actor {

    String name;
    Image planeBody;
    
    public Plane(Scene scene, String name) {
        String path = "file:" + System.getProperty("user.dir") + "/src/javafxsample/plane.png";
        this.name = name;
        setImage(new ImageView(new Image(path, true)));
        image.setX(100);
        image.setY(100);
        image.requestFocus();
    }
    
    public String getName() { return name; }
    
    private void setAnimators() {
        Path animationPath = new Path();
        animationPath.getElements().add(new MoveTo(100+image.getFitWidth()/2, 100+image.getFitHeight()/2));
        animationPath.getElements().add(new LineTo(500, 500));
        PathTransition pt = new PathTransition();
        pt.setDuration(Duration.millis(1000));
        pt.setPath(animationPath);
//        pt.setOrientation(PathTransition.OrientationType.ORTHOGONAL_TO_TANGENT);
        pt.setInterpolator(Interpolator.EASE_BOTH);
        pt.setNode(image);
        
        Path returnAnimationPath = new Path();
        animationPath.getElements().add(new MoveTo(500, 500));
        animationPath.getElements().add(new LineTo(100+image.getFitWidth()/2, 100+image.getFitHeight()/2));
        PathTransition returnPt = new PathTransition();
        returnPt.setDuration(Duration.millis(1000));
        returnPt.setPath(animationPath);
        returnPt.setInterpolator(Interpolator.EASE_BOTH);
        returnPt.setNode(image);
        
        pt.setOnFinished(new EventHandler() {
            public void handle(Event t) {
                returnPt.play();
            }
        });
        
        
        returnPt.setOnFinished(new EventHandler() {
            public void handle(Event t) {
                pt.play();
            }
        });
        
        pt.play();
    }

    @Override
    public Node getNode() {
        return image;
    }
    
    public ImageView getImageView() { return image; }
    
    public void onKeyPressed(String keyCode) {
        System.out.println(name + " " + keyCode);
    }
    
}
