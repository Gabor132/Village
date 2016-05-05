package Constants;

import Console.Console;
import File.FileHandler;
import Structures.DisplayPack;
import javax.swing.ImageIcon;

/**
 *
 * @author Dragos-Alexandru
 */
public class Constants {
    private static Constants instance;
    private final DisplayPack displayPack;
    public final int TILE_WIDTH;
    public final int TILE_HEIGHT;
    public final int APPLE_WIDTH;
    public final int APPLE_HEIGHT;
    public final int PLAYER_WIDTH;
    public final int PLAYER_HEIGHT;
    private final int PERFECT_WINDOW_WIDTH = 1366;
    private final int PERFECT_WINDOW_HEIGHT = 768;
    public final int nrItemsDropped = 330;
    public final int NR_TILE_WIDTH = 100;
    public final int NR_TILE_HEIGHT = 20;
    public final int TERRAIN_START_X;
    public final int TERRAIN_START_Y;
    private final String senderName = "Constants";
    
    private Constants(DisplayPack displayPack){
        
        this.displayPack = displayPack;
        
        ImageIcon imageIcon = new ImageIcon("Player.png");
        PLAYER_WIDTH = imageIcon.getIconWidth()/3;
        PLAYER_HEIGHT = imageIcon.getIconHeight()/3;
        Console.getInstance().print(senderName, "PlayerWidth:"+PLAYER_WIDTH);
        Console.getInstance().print(senderName, "PlayerHeight:"+PLAYER_HEIGHT);
        
        imageIcon = new ImageIcon("tile-grass1.png");
        TILE_WIDTH = imageIcon.getIconWidth()/3;
        TILE_HEIGHT = imageIcon.getIconHeight()/3;
        Console.getInstance().print(senderName, "TileWidth:"+TILE_WIDTH);
        Console.getInstance().print(senderName, "TileHeight:"+TILE_HEIGHT);
        
        imageIcon = new ImageIcon("apple.png");
        APPLE_WIDTH = imageIcon.getIconWidth()/3;
        APPLE_HEIGHT = imageIcon.getIconHeight()/3;
        Console.getInstance().print(senderName, "appleWidth:"+APPLE_WIDTH);
        Console.getInstance().print(senderName, "appleHeight:"+APPLE_HEIGHT);
        
        TERRAIN_START_Y = displayPack.getWINDOW_HEIGHT()/2;
        TERRAIN_START_X = 0;
        
    }
    public static Constants getInstance(){
        if(instance == null){
            instance = new Constants(FileHandler.getInstance().getDisplayPack());
        }
        return instance;
    }

    public DisplayPack getDisplayPack() {
        return displayPack;
    }

    public int getTileSize() {
        return TILE_WIDTH;
    }

    public int getPlayerWidth() {
        return PLAYER_WIDTH;
    }

    public int getPlayerHeight() {
        return PLAYER_HEIGHT;
    }
    
    
}
