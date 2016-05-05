package World;

import Structures.Drawable;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;

/**
 *
 * @author Dragos-Alexandru
 */
public class Entity implements Drawable, Cloneable{
    protected int x;
    protected int y;
    protected int width;
    protected int height;
    protected Rectangle positionPresence;
    protected Color presenceColor;
    protected int speed;
    protected int dir;
    protected static int nrThings = 0;
    protected final Image image;
    protected boolean visible = false;
    public static boolean showPresence = true;
    protected boolean clicked = false;

    public Entity(int x,int y,String pathToImage){
        
        this.x = x;
        this.y = y;
        Entity.nrThings++;
        ImageIcon imageIcon = new ImageIcon(pathToImage);
        image = imageIcon.getImage();
        width = imageIcon.getIconWidth()/3;
        height = imageIcon.getIconHeight()/3;
        positionPresence = new Rectangle(x, y, width, height);
        
    }
    
    //GETTERS & SETTERS
    public void setX(int x){
        this.x = x;
        positionPresence.setLocation(x, y);
    }
    
    public void setY(int y){
        this.y = y;
        positionPresence.setLocation(x, y);
    }
    
    public int getX(){
        return this.x;
    }
    
    public int getY(){
        return this.y;
    }
    
    public static int getNrThings() {
        return nrThings;
    }
    
    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
        positionPresence.setSize(width, height);
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
        positionPresence.setSize(width, height);
    }

    public boolean isVisible() {
        return visible;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }

    public Color getPresenceColor() {
        return presenceColor;
    }

    public void setPresenceColor(Color presenceColor) {
        this.presenceColor = presenceColor;
    }

    public Rectangle getPositionPresence() {
        return positionPresence;
    }

    public void setPositionPresence(Rectangle presence) {
        this.positionPresence = presence;
    }

    public boolean isClicked() {
        return clicked;
    }

    public void setClicked(boolean clicked) {
        this.clicked = clicked;
    }
    
    public void update(long time){
    }
    
    @Override
    public void draw(Graphics2D artist) {
        artist.drawImage(image, x, y,width, height, null);
        
        if(isClicked()){
            if(presenceColor != null){
                artist.setColor(presenceColor);
            }else{
                artist.setColor(Color.white);
            }
            artist.fill(positionPresence);
            
        }
    }
    
    @Override
    public Object clone() throws CloneNotSupportedException{
        Entity clone;
        try {
            clone = (Entity)super.clone();
            clone.positionPresence = new Rectangle(clone.x, clone.y, clone.width, clone.height);
            return clone;
        } catch (CloneNotSupportedException ex) {
            Logger.getLogger(Entity.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    @Override
    public String toString(){
        return "Entity";
    }
    
}
