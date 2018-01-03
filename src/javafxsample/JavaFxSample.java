/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxsample;

import com.sun.javafx.event.EventDispatchChainImpl;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;
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
import javafx.geometry.Rectangle2D;
import static javafx.application.Application.launch;
import static javafx.application.Application.launch;

/**
 *
 * @author optimans
 */
public class JavaFxSample extends Application {
    /**
     * @param args the command line arguments
     */
    
    ArrayList<Actor> actors;
    ArrayList<Actor> collidingActors;
    Timer tickTimer;
    
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
        actors = new ArrayList<>();
        collidingActors = new ArrayList<>();
        addActor(new Plane("Alpha"));
        addActor(new PlaneJet());
//        actors.add(new Plane(scene, "Bravo"));
        scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
            public void handle(KeyEvent e) {
                String code = e.getCode().toString();
                for (Actor actor: actors) {
                    actor.onKeyPressed(code);
                }
            }
        });
        
        tickTimer = new Timer();
        tickTimer.schedule(new TimerTask() {
                @Override
                public void run() {
                    for (int i=0; i<collidingActors.size(); i++) {
                        for (int j=i+1; j<collidingActors.size(); j++) {
                            Actor first = collidingActors.get(i);
                            Actor second = collidingActors.get(j);
                            for (Rectangle2D shape1: first.getCollisionShapes()) {
                                boolean collided = false;
                                for (Rectangle2D shape2: second.getCollisionShapes()) {
                                    if (shape1.intersects(shape2)) {
                                        first.collidedWith(second.getCollisionStringId());
                                        second.collidedWith(first.getCollisionStringId());
                                        collided = true;
                                        break;
                                    }
                                }
                                if (collided) {
                                    break;
                                }
                            }
                        }
                    }
                }
            }, 0, 33);
        // Increase delay for performance
        
        for (Actor current: actors) {
            for (ImageView iv: current.getImageViewList()) {
                g.getChildren().add(iv);
            }
        }
        
        stage.show();
    }

    @Override
    public void stop() throws Exception {
        super.stop();
        tickTimer.cancel();
    }
    
    
    
    
    
    private void addActor(Actor actor) {
        actors.add(actor);
        if (actor.wantsToCollide()) {
            collidingActors.add(actor);
        }
    }
    
    public static void main(String[] args) {
        launch(args);
    }
    
}

