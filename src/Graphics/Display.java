package Graphics;

import Console.Console;
import Constants.Constants;
import Game.GameWindow;
import PlayerInput.InputHandler;
import World.Map;
import World.WorldGenerator;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import javax.swing.JPanel;

/**
 *
 * @author Dragos-Alexandru
 */
public class Display extends JPanel{
    private static Display instance;
    private final int windowWidth;
    private final int windowHeight;
    private final WorldGenerator god;
    private static final String senderName = "Display";
    
    private Display(){
        super();
        windowWidth = Constants.getInstance().getDisplayPack().getWINDOW_WIDTH();
        windowHeight = Constants.getInstance().getDisplayPack().getWINDOW_HEIGHT();
        setDoubleBuffered(true);
        god = WorldGenerator.getInstance();
    }
    public static Display getInstance(){
        if(instance == null){
            Console.getInstance().print(senderName, "new instance");
            instance = new Display();
        }
        return instance;
    }
    
    public void paintFrames(Graphics2D graphics){
        graphics.setColor(Color.red);
        graphics.drawString(GameWindow.getNrFrames()+"", windowWidth-40, windowHeight-40);
    }
    
    public void paintTerrain(Graphics2D graphics){
        
        Map map = god.getTerrain();
        map.draw(graphics);
        graphics.drawString(map.getX()+" "+map.getY(), 10, 10);
        graphics.drawString(InputHandler.getInstance().mouseX + " " + InputHandler.getInstance().mouseY, InputHandler.getInstance().mouseX,InputHandler.getInstance().mouseY);
        graphics.draw(new Rectangle(InputHandler.getInstance().mouseX,InputHandler.getInstance().mouseY,1,1));
    }
    
    @Override
    public void paintComponent(Graphics g) {
        
        super.paintComponent(g);
        Graphics2D graphics = (Graphics2D)g;
        g.setColor(new Color(129,196,242));
        g.fillRect(0, 0, Constants.getInstance().getDisplayPack().getWINDOW_WIDTH(),
                WorldGenerator.getInstance().getTerrain().getY());
        g.setColor(new Color(144,192,62));
        g.fillRect(0, WorldGenerator.getInstance().getTerrain().getY(), Constants.getInstance().getDisplayPack().getWINDOW_WIDTH(), WorldGenerator.getInstance().getTerrain().getHeight()+250);
        paintTerrain(graphics);
        paintFrames(graphics);
    }
}
