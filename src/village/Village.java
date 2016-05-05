package village;

import Game.Game;

/**
 *
 * @author Dragos-Alexandru
 */
public class Village {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Game theGame = Game.getInstance();
        Thread mainThread = new Thread(theGame);
        mainThread.start();
    }
    
}
