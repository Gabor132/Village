package World;

import java.awt.Graphics2D;
import java.util.ArrayList;

/**
 *
 * @author Dragos-Alexandru
 */
public class Map {
    
    private ArrayList<Tile> tiles = new ArrayList<Tile>();
    private ArrayList<Item> itemsDropped = new ArrayList<Item>();
    private ArrayList<Creature> creatures = new ArrayList<Creature>();
    private ArrayList<Tree> trees = new ArrayList<Tree>();
    private ArrayList<Vegetation> vegetation = new ArrayList<Vegetation>();
    private int x;
    private int y;
    private int width;
    private int height;
    private int lastDirection = 0;
    
    public Map(int x,int y, ArrayList<Tile> tiles){
        this.x = x;
        this.y = y;
        this.tiles = tiles;
    }
    
    public void draw(Graphics2D g){
        for(Tile item : tiles){
            item.draw(g);
        }
        for(Vegetation item:vegetation){
            item.draw(g);
        }
        for(Tree item:trees){
            item.draw(g);
        }
        Player player = WorldGenerator.getInstance().getPlayer();
        
        for (Tile item : tiles) {
            if(item.getTree() != null){
                item.getTree().draw(g);
            }
            if(item.isOcupied()){
                if(player != null){
                    player.draw(g);
                    //player.drawPresence(g);
                    g.drawString(player.getX()+" "+player.getY(), player.getX(), player.getY());
                }
            }
        }
    }
    
    
    public void setX(int xDifference) {
        this.x = x + xDifference;
        for(Tile item : tiles){
            item.setX(item.getX()+xDifference);
        }
        for(Entity item : itemsDropped){
            item.setX(item.getX()+xDifference);
        }
    }

    public void setY(int yDifference) {
        this.y = y + yDifference;
        for(Tile item : tiles){
            item.setY(item.getY()+yDifference);
        }
        for(Entity item : itemsDropped){
            item.setY(item.getY()+yDifference);
        }
    }

    public ArrayList<Tile> getTiles() {
        return tiles;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setItemsDropped(ArrayList<Item> itemsDropped) {
        this.itemsDropped = itemsDropped;
    }

    public ArrayList<Item> getItemsDropped() {
        return itemsDropped;
    }

    public ArrayList<Vegetation> getVegetation() {
        return vegetation;
    }

    public void setVegetation(ArrayList<Vegetation> vegetation) {
        this.vegetation = vegetation;
    }

    public ArrayList<Creature> getCreatures() {
        return creatures;
    }

    public void setCreatures(ArrayList<Creature> creature) {
        this.creatures = creature;
    }

    public ArrayList<Tree> getTrees() {
        return trees;
    }

    public void setTrees(ArrayList<Tree> trees) {
        this.trees = trees;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getLastDirection() {
        return lastDirection;
    }

    public void setLastDirection(int lastDirection) {
        this.lastDirection = lastDirection;
    }
    
    
}
