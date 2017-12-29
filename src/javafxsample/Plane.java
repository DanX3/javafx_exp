/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxsample;

import java.util.ArrayList;
import javafx.animation.Interpolator;
import javafx.animation.PathTransition;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Point2D;
import javafx.geometry.Rectangle2D;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.util.Duration;

public class Plane extends Actor {

    String name;
    PathTransition pt;
    
    public Plane(String name) {
        super();
        this.name = name;
        setAnimators();
    }

    @Override
    protected String getImageName() {
        return "plane.png";
    }
    
    public String getName() { return name; }
    
    private void setAnimators() {
        Path animationPath = new Path();
        animationPath.getElements().add(new MoveTo(100+image.getFitWidth()/2, 100+image.getFitHeight()/2));
        animationPath.getElements().add(new LineTo(700, 100));
        pt = new PathTransition();
        pt.setDuration(Duration.millis(5000));
        pt.setPath(animationPath);
//        pt.setOrientation(PathTransition.OrientationType.ORTHOGONAL_TO_TANGENT);
        pt.setInterpolator(Interpolator.LINEAR);
        pt.setNode(image);
        
        animationPath.getElements().add(new MoveTo(700, 100));
        animationPath.getElements().add(new LineTo(100+image.getFitWidth()/2, 100+image.getFitHeight()/2));
        PathTransition returnPt = new PathTransition();
        returnPt.setDuration(Duration.millis(5000));
        returnPt.setPath(animationPath);
        returnPt.setInterpolator(Interpolator.LINEAR);
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
            }

    public void onKeyPressed(String keyCode) {
        if ((name.equals("Alpha")) && (keyCode.equals("A"))) {
            pt.play();
        }
        
        if ((name.equals("Bravo")) && (keyCode.equals("B"))) {
            pt.play();
        }
        
        if ((name.equals("Alpha")) && (keyCode.equals("S"))) {
            image.setScaleY(-1 * image.getScaleY());
        }
        
        if ((name.equals("Bravo")) && (keyCode.equals("N"))) {
            image.setScaleY(-1 * image.getScaleY());
        }
    }

    @Override
    protected boolean wantsToCollide() {
        return true;
    }

    @Override
    public ArrayList<Rectangle2D> getCollisionShapes() {
        ArrayList<Rectangle2D> shapes = new ArrayList<Rectangle2D>(2);
        shapes.add(new Rectangle2D(48, 0, 50, 116));
        shapes.add(new Rectangle2D(0, 30, 140, 30));
        return shapes;
    }
    
    @Override
    public String getCollisionStringId() {
        return "plane";
    }

    @Override
    protected Point2D getLocation() {
        return new Point2D(100, 100);
    }
    
}
