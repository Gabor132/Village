package World;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.util.ArrayList;

/**
 *
 * @author Dragos-Alexandru
 */
public class Tile extends Entity{
    protected boolean walkable;
    protected Tree tree;
    protected boolean ocupied = false;
    protected boolean reached = false;
    public Tile(int x, int y, String pathToImage, boolean walkable, boolean hasTree) {
        super(x, y, pathToImage);
        this.walkable = walkable;
        if(hasTree){
            tree = (Tree)WorldGenerator.getInstance().creatureBlueprints.get("tree");
            tree.setX(getX()+getWidth()/2-tree.getWidth()/2);
            tree.setY(getY()+getHeight()/2-tree.getHeight()/2);
        }
    }

    public boolean isWalkable() {
        return walkable;
    }

    public Tree getTree() {
        return tree;
    }

    public boolean isReached() {
        return reached;
    }

    public void setReached(boolean reached) {
        this.reached = reached;
    }

    public boolean isOcupied() {
        return ocupied;
    }

    public void setOcupied(boolean ocupied) {
        this.ocupied = ocupied;
    }
    
    @Override
    public void setPresenceColor(Color presenceColor){
        super.setPresenceColor(presenceColor);
        if(tree!=null){
            tree.setPresenceColor(presenceColor);
        }
    }
    
    @Override
    public void draw(Graphics2D artist) {
        artist.drawImage(image, x, y,width, height, null);
        
        if(isOcupied() && tree != null){
            artist.setColor(presenceColor);
            //artist.fill(positionPresence);
            artist.setColor(Color.BLACK);
        }
        if(isClicked()){
            if(presenceColor != null){
                artist.setColor(presenceColor);
            }else{
                artist.setColor(Color.white);
            }
            artist.fill(positionPresence);
        }
        if(tree != null){
            if(isReached()){
                artist.setColor(presenceColor);
                artist.fill(positionPresence);
            }
        }
        artist.setColor(Color.black);
    }
    
}
