/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package World;

import Structures.StatusPacket;
import java.awt.Color;
import java.awt.Graphics2D;

/**
 *
 * @author Dragos-Alexandru
 */
public class Tree extends Creature{

    public Tree(int x, int y, String pathToImage, StatusPacket status, String name) {
        super(x, y, pathToImage, status, name);
        
    }
    
    
    @Override
    public String toString(){
        return "Tree";
    }
    
    @Override
    public void draw(Graphics2D g){
        g.drawImage(image, x, y, width,height,null);
        g.setColor(presenceColor);
        //g.draw(positionPresence);
        g.setColor(Color.black);
    }
    
    //GETTERS & SETTERS
    @Override
    public void setX(int x){
        this.x = x;
        positionPresence.setLocation(x+width/3, y+height - 20);
    }
    
    @Override
    public void setY(int y){
        this.y = y;
        positionPresence.setLocation(x, y);
        positionPresence.setLocation(x+width/3, y+height - 20);
    }

    @Override
    public boolean takeDamage(int damage) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void dropLoot() {
        
    }
    
}
