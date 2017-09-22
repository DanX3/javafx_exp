/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxsample;

import java.util.ArrayList;
import javafx.animation.FadeTransition;
import static javafx.application.Application.launch;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Shape;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;

/**
 *
 * @author optimans
 */
public class JavaFxSample extends Application {
    /**
     * @param args the command line arguments
     */
    
    FadeTransition show, hide;
    Plane plane;
    
    FadeTransition hideShapeTransition(Shape s, int millis_duration) {
        FadeTransition result = new FadeTransition(Duration.millis(millis_duration), s);
        result.setFromValue(255);
        result.setToValue(0);
        return result;
    }
    
    
    
    public void start(Stage stage) {
        Group g = new Group();
        Scene scene = new Scene(g, 800, 600);
        scene.setFill(Color.WHITESMOKE);
        ArrayList<ImageView> actorsToBeNotified = new ArrayList<>();
        plane = new Plane(scene);
        Plane plane2 = new Plane(scene);
        actorsToBeNotified.add(plane.getImageView());
        actorsToBeNotified.add(plane2.getImageView());
        
        scene.addEventFilter(KeyEvent.KEY_PRESSED, new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent e) {
                System.out.println("Scene:" + e.getText());
                for (ImageView actor: actorsToBeNotified) {
                    actor.requestFocus(); 
               }
//                plane.getImageView().requestFocus();
//                plane.getImageView().fireEvent(e);
            }
        });
        
//        Circle c = new Circle(50, 50, 50, Color.BLUEVIOLET);
//        hide = hideShapeTransition(c, 1000);
        
//        g.getChildren().add(c);
        g.getChildren().add(plane.getImageView());
        stage.setScene(scene);
        stage.show();
//        hide.play();
    }
    
    public static void main(String[] args) {
        launch(args);
    }
    
}

