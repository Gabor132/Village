package File;

import Console.Console;
import Structures.DisplayPack;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Dragos-Alexandru
 */
public class FileHandler {
    private static FileHandler instance;
    private final String senderName = "FileHandler";
    private FileHandler(){
        
    }
    public static FileHandler getInstance(){
        if(instance == null){
            instance = new FileHandler();
        }
        return instance;
    }
    
    public DisplayPack getDisplayPack(){
        
        File configFile = new File("config.txt");
        
        try {
            
            FileReader reader = new FileReader(configFile);
            BufferedReader buffReader = new BufferedReader(reader);
            
            try{
                
                String line = buffReader.readLine();
                while(line != null){
                    if(line.contains("DisplayPack")){
                        line = line.split(":")[1];
                        int width = Integer.parseInt(line.split(",")[0]);
                        int height = Integer.parseInt(line.split(",")[1]);
                        DisplayPack displayPack = new DisplayPack(width, height);
                        return displayPack;
                    }
                }
                
            }catch(IOException e){
                Logger.getLogger(FileHandler.class.getName()).log(Level.SEVERE, null, e);
            }
            
        } catch (FileNotFoundException ex) {
            Console.getInstance().print(senderName, "Could not find file (config.txt)");
        }
        
        int width = 800;
        int height = 600;
        DisplayPack displayPack = new DisplayPack(width, height);
        return displayPack;
    }
}
