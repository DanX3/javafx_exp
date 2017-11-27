/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxsample;

import com.sun.javafx.event.EventDispatchChainImpl;
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
import static javafx.application.Application.launch;

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
        stage.setScene(scene);
        scene.setFill(Color.WHITESMOKE);
        ArrayList<Actor> actors = new ArrayList<>();
        actors.add(new Plane(scene, "Alpha"));
        actors.add(new Plane(scene, "Bravo"));
        scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
            public void handle(KeyEvent e) {
                String code = e.getCode().toString();
                for (Actor actor: actors) {
                    actor.onKeyPressed(code);
                }
            }
        });
        
        g.getChildren().add(actors.get(0).getImageView());
        
        stage.show();
    }
    
    public static void main(String[] args) {
        launch(args);
    }
    
}

