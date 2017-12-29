/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxsample;

import java.util.ArrayList;
import javafx.geometry.Rectangle2D;
import javafx.scene.Node;

/**
 *
 * @author optimans
 */
public class Cannon extends Actor {

    @Override
    public Node getNode() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void onKeyPressed(String keyCode) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected String getImageName() {
        return "cannon.png";
    }

    @Override
    protected boolean wantsToCollide() {
        return false;
    }

    @Override
    public ArrayList<Rectangle2D> getCollisionShapes() {
        return null;
    }
    
    @Override
    public String getCollisionStringId() {
        return "cannon";
    }
}
