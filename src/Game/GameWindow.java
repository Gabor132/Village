package Game;

import Constants.Constants;
import Graphics.Display;
import PlayerInput.InputHandler;
import Structures.DisplayPack;
import World.Map;
import World.WorldGenerator;
import World.Player;
import java.awt.BorderLayout;
import java.awt.Graphics2D;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;

/**
 *
 * @author Dragos-Alexandru
 */
public class GameWindow extends JFrame{
    private static GameWindow instance = null;
    private static Display display;
    private boolean exit = false;
    public boolean running = false;
    public Player player;
    private static int frames = 0;
    private final String senderName = "GameWindow";
    private static int nrInstance = 0;
    private static DisplayPack displayPack;
    public final WorldGenerator god;
    public final Map map;
    public void setExit(boolean exit) {
        this.exit = exit;
    }
    
    public static int getNrFrames(){
        return frames;
    }
    
    private GameWindow(){
        super("Village - 0.01 Alpha");
        displayPack = Constants.getInstance().getDisplayPack();
        this.setSize(displayPack.getWINDOW_WIDTH(),displayPack.getWINDOW_HEIGHT());
        //this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setLayout(new BorderLayout());
        god = WorldGenerator.getInstance();
        god.generateTerrain();
        display = Display.getInstance();
        this.add(display,BorderLayout.CENTER);
        nrInstance++;
        
        this.addMouseListener(InputHandler.getInstance());
        this.addMouseMotionListener(InputHandler.getInstance());
        this.addKeyListener(InputHandler.getInstance());
        
        this.setVisible(true);
        
        map = god.getTerrain();
    }
    public static GameWindow getInstance(){
        if(instance == null && nrInstance<1){
            instance = new GameWindow();
        }
        return instance;
    }
    
    public void run(){
        if(running)
            return;
        running = true;
        long time;
        long timeNow;
        
        time = Calendar.getInstance().getTimeInMillis();
        int tempFrames = 0;
        
        player = god.getPlayer();
        while(!exit){
            timeNow = Calendar.getInstance().getTimeInMillis();
            tempFrames++;
            if(timeNow - time > 1000){
                time = timeNow;
                display.paintFrames((Graphics2D)display.getGraphics());
                GameWindow.frames = tempFrames;
                tempFrames = 0;
            }
            update(timeNow - time);
        }
        running = false;
        
        this.dispose();
    }
    
    public void update(long time){
        
        god.getPlayer().update(time);
        //display.paint((Graphics2D)this.getGraphics());
        display.repaint();
        //p.setY(p.getY()+10);
        try {
            Thread.sleep(25);
        } catch (InterruptedException ex) {
            Logger.getLogger(GameWindow.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
