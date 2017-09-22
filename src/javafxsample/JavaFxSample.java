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
        scene.setFill(Color.WHITESMOKE);
        ArrayList<Actor> actors = new ArrayList<>();
        actors.add(new Plane(scene, "Alpha"));
        actors.add(new Plane(scene, "Bravo"));
        
        
        EventDispatchChainImpl chain = new EventDispatchChainImpl();
        chain.append(scene.getEventDispatcher());
        chain.append(actors.get(0).getImageView().getEventDispatcher());
        chain.append(actors.get(1).getImageView().getEventDispatcher());
        scene.buildEventDispatchChain(chain);
        
        scene.addEventFilter(KeyEvent.KEY_PRESSED, new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent e) {
                System.out.println("Scene:" + e.getText());
                chain.dispatchEvent(e);
//                for (Actor actor: actors) {
//                    actor.getNode().requestFocus(); 
//                    System.out.println("Notified " + ((Plane)actor).getName());
//                }
                // Non so perche' dovrei consumarlo qua...ma se non lo faccio 
                // vengono propagati piu' eventi del dovuto
//                e.consume();
            }
        });
        
        g.getChildren().add(actors.get(0).getImageView());
        stage.setScene(scene);
        stage.show();
    }
    
    public static void main(String[] args) {
        launch(args);
    }
    
}

