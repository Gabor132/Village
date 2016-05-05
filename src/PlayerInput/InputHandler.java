package PlayerInput;

import Console.Console;
import World.Map;
import World.Player;
import World.Tile;
import World.Vegetation;
import World.WorldGenerator;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

/**
 *
 * @author Dragos-Alexandru
 */
public class InputHandler implements ActionListener, MouseListener,MouseMotionListener, KeyListener{
    
    private static InputHandler instance;
    private static final String senderName = "InputHandler";
    public int mouseX = 0;
    public int mouseY = 0;
    private InputHandler(){
        super();
    }
    
    public static InputHandler getInstance(){
        if(instance == null){
            Console.getInstance().print(senderName, "new instance");
            instance = new InputHandler();
        }
        return instance;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if(e.getButton() == MouseEvent.BUTTON1){
            mouseX = e.getX()-8;
            mouseY = e.getY()-32;
            Map map = WorldGenerator.getInstance().getTerrain();
            for(Tile tile : map.getTiles()){
                if(tile.getPositionPresence().contains(mouseX, mouseY)){
                    tile.setClicked(true);
                }else if(tile.isClicked()){
                    tile.setClicked(false);
                }
            }
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
        if(e.getButton() == MouseEvent.BUTTON3){
            System.out.println("MOUSE 3!");
            Map map = WorldGenerator.getInstance().getTerrain();
            Player player = WorldGenerator.getInstance().getPlayer();
            player.setWidth(player.getWidth()*2);
            player.setHeight(player.getHeight()*2);
            player.setX(400-(player.getWidth()/2));
            player.setY(300-(player.getHeight()/2));
            for(Tile item : map.getTiles()){
                item.setWidth(item.getWidth()*2);
                item.setHeight(item.getHeight()*2);
            }
            for(Vegetation item : map.getVegetation()){
                item.setWidth(item.getWidth()*2);
                item.setHeight(item.getHeight()*2);
            }
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        if(e.getButton() == MouseEvent.BUTTON3){
            System.out.println("MOUSE 3!");
            Map map = WorldGenerator.getInstance().getTerrain();
            Player player = WorldGenerator.getInstance().getPlayer();
            player.setWidth(player.getWidth()/2);
            player.setHeight(player.getHeight()/2);
            player.setX(400-(player.getWidth()/2));
            player.setY(300-(player.getHeight()/2));
            for(Tile item : map.getTiles()){
                item.setWidth(item.getWidth()/2);
                item.setHeight(item.getHeight()/2);
            }
        }
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        
    }

    @Override
    public void mouseExited(MouseEvent e) {
        
    }

    @Override
    public void keyTyped(KeyEvent e) {
        
    }

    @Override
    public void keyPressed(KeyEvent e) {
        
        //Console.getInstance().print(senderName, "Pressed key "+ KeyEvent.getKeyText(e.getKeyCode()));
        
        if(e.getKeyCode() == KeyEvent.VK_UP){
            Map map = WorldGenerator.getInstance().getTerrain();
            Player p = WorldGenerator.getInstance().getPlayer();
            //p.setSpeedX(1);
            
            if(map.getY() + 10 < (p.getY()+p.getHeight())){
                WorldGenerator.getInstance().getTerrain().setLastDirection(1);
                WorldGenerator.getInstance().getTerrain().setY(10);
                
            }
            
        }else if(e.getKeyCode() == KeyEvent.VK_DOWN){
            Map map = WorldGenerator.getInstance().getTerrain();
            Player p = WorldGenerator.getInstance().getPlayer();
            
            if(map.getY()+map.getHeight() - 10 > (p.getY()+p.getHeight())){
                WorldGenerator.getInstance().getTerrain().setLastDirection(-1);
                WorldGenerator.getInstance().getTerrain().setY(-10);
                
            }
            
        }else if(e.getKeyCode() == KeyEvent.VK_LEFT){
            Map map = WorldGenerator.getInstance().getTerrain();
            Player p = WorldGenerator.getInstance().getPlayer();
            
            if(map.getX() + 10 < p.getX()){
                WorldGenerator.getInstance().getTerrain().setLastDirection(-2);
                WorldGenerator.getInstance().getTerrain().setX(10);
                
            }
            
        }else if(e.getKeyCode() == KeyEvent.VK_RIGHT){
            Map map = WorldGenerator.getInstance().getTerrain();
            Player p = WorldGenerator.getInstance().getPlayer();
            //p.setSpeedX(1);
            if(map.getX()+map.getWidth() - 10 > p.getX() + p.getWidth()){
                WorldGenerator.getInstance().getTerrain().setLastDirection(2);
                WorldGenerator.getInstance().getTerrain().setX(-10);
                
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_UP){
            Map map = WorldGenerator.getInstance().getTerrain();
            Player p = WorldGenerator.getInstance().getPlayer();
            WorldGenerator.getInstance().getTerrain().setLastDirection(0);
        }else if(e.getKeyCode() == KeyEvent.VK_DOWN){
            Map map = WorldGenerator.getInstance().getTerrain();
            Player p = WorldGenerator.getInstance().getPlayer();
            WorldGenerator.getInstance().getTerrain().setLastDirection(0);
        }else if(e.getKeyCode() == KeyEvent.VK_LEFT){
            Map map = WorldGenerator.getInstance().getTerrain();
            Player p = WorldGenerator.getInstance().getPlayer();
            WorldGenerator.getInstance().getTerrain().setLastDirection(0);
        }else if(e.getKeyCode() == KeyEvent.VK_RIGHT){
            Map map = WorldGenerator.getInstance().getTerrain();
            Player p = WorldGenerator.getInstance().getPlayer();
            WorldGenerator.getInstance().getTerrain().setLastDirection(0);
        }
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        mouseX = e.getX()-8;
        mouseY = e.getY()-32;
    }
    
}
