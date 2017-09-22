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
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.util.Duration;

/**
 *
 * @author optimans
 */
public class Plane {

    Image planeBody;
    ImageView planeBodyView;
    
    public Plane(Scene scene) {
        String path = "file:" + System.getProperty("user.dir") + "/src/javafxsample/plane.png";
        System.out.println(path);
        planeBody = new Image(path, false);
        planeBodyView = new ImageView(planeBody);
        planeBodyView.setX(100);
        planeBodyView.setY(100);
        planeBodyView.requestFocus();
        
//        setAnimators();
        
        planeBodyView.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent e) {
                System.out.println("Plane:" + e.getText());
//                e.consume();
            }            
        });
        
//        planeBodyView.setEventDispatcher(scene.getEventDispatcher());
//        EventHandler<KeyEvent> movementHandler = new javafx.event.EventHandler<KeyEvent>() {
//            @Override
//            public void handle(final KeyEvent t) {
//                System.out.println("Input received");
//                System.out.println(t.getCharacter());
//                t.consume();
//            }
//        };
//        
//        planeBodyView.setOnKeyPressed(movementHandler);
        
    }
    
    private void setAnimators() {
        Path animationPath = new Path();
        animationPath.getElements().add(new MoveTo(100+planeBodyView.getFitWidth()/2, 100+planeBodyView.getFitHeight()/2));
        animationPath.getElements().add(new LineTo(500, 500));
        PathTransition pt = new PathTransition();
        pt.setDuration(Duration.millis(1000));
        pt.setPath(animationPath);
//        pt.setOrientation(PathTransition.OrientationType.ORTHOGONAL_TO_TANGENT);
        pt.setInterpolator(Interpolator.EASE_BOTH);
        pt.setNode(planeBodyView);
        
        Path returnAnimationPath = new Path();
        animationPath.getElements().add(new MoveTo(500, 500));
        animationPath.getElements().add(new LineTo(100+planeBodyView.getFitWidth()/2, 100+planeBodyView.getFitHeight()/2));
        PathTransition returnPt = new PathTransition();
        returnPt.setDuration(Duration.millis(1000));
        returnPt.setPath(animationPath);
        returnPt.setInterpolator(Interpolator.EASE_BOTH);
        returnPt.setNode(planeBodyView);
        
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
    
    
    
    ImageView getImageView() { return planeBodyView; }
    
}
