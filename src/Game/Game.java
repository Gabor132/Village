package Game;

import Console.Console;
import Constants.Constants;
import PlayerInput.InputHandler;
import World.Entity;
import World.WorldGenerator;

/**
 *
 * @author Dragos-Alexandru
 */
public class Game implements Runnable{
    Console theConsole = Console.getInstance();
    GameWindow theWindow = GameWindow.getInstance();
    Constants constants = Constants.getInstance();
    WorldGenerator god = WorldGenerator.getInstance();
    InputHandler input = InputHandler.getInstance();
    private static Game instance;
    private Game(){
        
    }
    public static Game getInstance(){
        if(instance == null){
            instance = new Game();
        }
        return instance;
    }
    public void startGame() throws Exception{
        
        theWindow.run();
    }
    
    public void sendCommand(String command){
        if(command.equals("/exit")){
            GameWindow.getInstance().setExit(true);
            Console.getInstance().dispose();
        }else if(command.startsWith("/show_presence")){
            boolean value = Boolean.parseBoolean(command.split(" ")[1]);
            Entity.showPresence = value;
        }
    }

    @Override
    public void run() {
        try{
            startGame();
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            System.out.println("I hope you have a fun time!");
        }
    }
    
}
