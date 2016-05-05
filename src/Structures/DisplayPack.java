package Structures;

/**
 *
 * @author Dragos-Alexandru
 */
public class DisplayPack {
    private final int WINDOW_WIDTH;
    private final int WINDOW_HEIGHT;
    
    public int getWINDOW_WIDTH() {
        return WINDOW_WIDTH;
    }

    public int getWINDOW_HEIGHT() {
        return WINDOW_HEIGHT;
    }
    
    public DisplayPack(int width,int height){
        WINDOW_HEIGHT = height;
        WINDOW_WIDTH = width;
    }
}
