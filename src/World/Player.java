/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package World;

import Structures.StatusPacket;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;

/**
 *
 * @author Dragos-Alexandru
 */
public class Player extends Creature{
    
    private final Rectangle neighborPresenceLeft;
    private final Rectangle neighborPresenceRight;
    private final Rectangle neighborPresenceDown;
    
    public Player(int x,int y,String pathToImage,StatusPacket status, String name){
        super(x,y,pathToImage, status, name);
        setX(400-(super.getWidth()/2));
        setY(300-(super.getHeight()/2));
        positionPresence = new Rectangle(this.x+width/2, this.y+height-5, 1, 1);
        neighborPresenceLeft = new Rectangle(this.x-5,this.y+height/2+7,5,height/2-10);
        neighborPresenceRight = new Rectangle(this.x+width,this.y+height/2+7,5,height/2-10);
        neighborPresenceDown = new Rectangle(this.x+5,this.y+height,width-10,10);
        presenceColor = new java.awt.Color(123, 123, 123);
    }

    @Override
    public String getName() {
        return name;
    }
    
    @Override
    public void update(long time){
        //System.out.println("update: "+time/100);
        this.x = (int)(this.x + this.speed*time);
        this.y = (int)(this.y + this.speed*time);
        //System.out.println(this.x+" "+this.y);
        checkIntersection();
    }
    
    public void checkIntersection(){
        Map map;
        map = WorldGenerator.getInstance().getTerrain();
        for(Creature item : map.getCreatures()){
            if(getPositionPresence().intersects(item.getPositionPresence())){
                int lastDirection = WorldGenerator.getInstance().getTerrain().getLastDirection();
                    if(lastDirection == 1){
                        map.setY(-10);
                    }else if(lastDirection == -1){
                        map.setY(10);
                    }else if(lastDirection == 2){
                        map.setX(10);
                    }else{
                        map.setX(-10);
                    }
            }
        }
        for(Tree item : map.getTrees()){
            if(getPositionPresence().intersects(item.getPositionPresence())){
                int lastDirection = WorldGenerator.getInstance().getTerrain().getLastDirection();
                    if(lastDirection == 1){
                        map.setY(-10);
                    }else if(lastDirection == -1){
                        map.setY(10);
                    }else if(lastDirection == 2){
                        map.setX(10);
                    }else{
                        map.setX(-10);
                    }
            }
        }
        for(Tile item : map.getTiles()){
            if(getPositionPresence().intersects(item.getPositionPresence()) && !item.isOcupied()){
                item.setOcupied(true);
            }else if(!getPositionPresence().intersects(item.getPositionPresence()) && item.isOcupied()){
                item.setOcupied(false);
            }else if(!item.isReached() && checkNeighbor(item)){
                item.setReached(true);
                if(item.getPresenceColor() == Color.white)
                    item.setPresenceColor(Color.gray);
                
            }else if(item.isReached() && !checkNeighbor(item)){
                item.setReached(false);
                if(item.getPresenceColor() == Color.gray)
                    item.setPresenceColor(Color.white);
            }
            
        }
    }
    
    private boolean checkNeighbor(Tile tile){
        if(neighborPresenceDown.intersects(tile.positionPresence) || neighborPresenceLeft.intersects(tile.positionPresence) || neighborPresenceRight.intersects(tile.positionPresence)){
            return true;
        }
        return false;
    }
    
    @Override
    public String toString(){
        return "Creature";
    }

    public Rectangle getNeighborPresenceLeft() {
        return neighborPresenceLeft;
    }

    public Rectangle getNeighborPresenceRight() {
        return neighborPresenceRight;
    }

    public Rectangle getNeighborPresenceDown() {
        return neighborPresenceDown;
    }
    
    public void drawPresence(Graphics2D g){
        g.draw(positionPresence);
        g.draw(neighborPresenceDown);
        g.draw(neighborPresenceLeft);
        g.draw(neighborPresenceRight);
    }
    
}
