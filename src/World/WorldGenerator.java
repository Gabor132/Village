package World;

import Console.Console;
import Constants.Constants;
import Structures.StatusPacket;
import UI.Inventory;
import java.awt.Color;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Dragos-Alexandru
 */
public final class WorldGenerator {
    private static WorldGenerator instance = null;
    private Map terrain;
    public final HashMap<String,Item> itemBlueprints;
    public final HashMap<String,Vegetation> vegetationBlueprints;
    public final HashMap<String,Creature> creatureBlueprints;
    private final static String senderName = "WorldGenerator";
    private final Player player;
    private WorldGenerator(){
        
        itemBlueprints = new HashMap<String,Item>();
        vegetationBlueprints = new HashMap<String, Vegetation>();
        creatureBlueprints = new HashMap<String, Creature>();
        
        player = new Player(0,0,"Player.png",new StatusPacket(100, 0, 0, new Inventory(new ArrayList<Entity>(), 4)),"Azorel");
        creatureBlueprints.put("tree",new Tree(0, 0, "tree_1.png", new StatusPacket(10, 0, 0, null), "tree"));
        vegetationBlueprints.put("gd1",new Vegetation(0, 0, "grass_detail_1.png"));
        vegetationBlueprints.put("gd2",new Vegetation(0, 0, "grass_detail_2.png"));
        vegetationBlueprints.put("gd3",new Vegetation(0, 0, "grass_detail_3.png"));
        vegetationBlueprints.put("gd4",new Vegetation(0, 0, "grass_detail_4.png"));
        vegetationBlueprints.put("gd5",new Vegetation(0, 0, "grass_detail_5.png"));
        vegetationBlueprints.put("gdf1",new Vegetation(0, 0, "grass_detail_flower_1.png"));
        vegetationBlueprints.put("gdf2",new Vegetation(0, 0, "grass_detail_floser_2.png"));
        itemBlueprints.put("apple", new Item(0,0,"apple.png"));
        itemBlueprints.put("sword_1", new Item(0,0,"sword_1.png"));
        itemBlueprints.put("sword_2", new Item(0,0,"sword_2.png"));
        itemBlueprints.put("dagger_1", new Item(0,0,"dagger_1.png"));
        itemBlueprints.put("dagger_2", new Item(0,0,"dagger_2.png"));
        itemBlueprints.put("bow_1", new Item(0,0,"bow_1.png"));
        itemBlueprints.put("bow_2", new Item(0,0,"bow_2.png"));
        itemBlueprints.put("hammer", new Item(0,0,"hammer.png"));
        itemBlueprints.put("axe", new Item(0,0,"axe.png"));
        
    }
    
    public static WorldGenerator getInstance(){
        if(instance == null){
            Console.getInstance().print(senderName, "new instance");
            WorldGenerator.instance = new WorldGenerator();
        }
        return WorldGenerator.instance;
    }
    
    public Entity getEntity(String s){
        return itemBlueprints.get(s);
    }
    
    public void generateTerrain(){
        Random r = new Random();
        
        int tileWidth = Constants.getInstance().TILE_WIDTH;
        int tileHeight = Constants.getInstance().TILE_HEIGHT;
        int nrTileWidth = 100;
        int nrTileHeight = 20;
        Console.getInstance().print(senderName,nrTileWidth+"");
        Console.getInstance().print(senderName,nrTileHeight+"");
        ArrayList<Tile> map = new ArrayList<Tile>();
        for(int i = 0;i<nrTileHeight;i++){
            for(int j =0; j<nrTileWidth;j++){
                int tipTile = r.nextInt(2);
                boolean hasTree = false;
                if(r.nextInt(3) == 2){
                    hasTree = true;
                }
                if(tipTile==0){
                    map.add(new Tile(j*tileWidth-Constants.getInstance().TERRAIN_START_X,i*tileHeight+Constants.getInstance().TERRAIN_START_Y,"tile-grass1.png",true,hasTree));
                }else if(tipTile==1){
                    map.add(new Tile(j*tileWidth-Constants.getInstance().TERRAIN_START_X,i*tileHeight+Constants.getInstance().TERRAIN_START_Y,"tile-grass2.png",true,hasTree));
                }else{
                    map.add(new Tile(j*tileWidth-Constants.getInstance().TERRAIN_START_X,i*tileHeight+Constants.getInstance().TERRAIN_START_Y,"tile-water.png",false,hasTree));
                }
            }
        }
        ArrayList<Tree> trees = new ArrayList<Tree>();
        for(Tile item : map){
            if(item.getTree() != null){
                trees.add(item.getTree());
            }
        }
        
        terrain = new Map(Constants.getInstance().TERRAIN_START_X,Constants.getInstance().TERRAIN_START_Y,map);
        terrain.setHeight(nrTileHeight*tileHeight);
        terrain.setWidth(nrTileWidth*tileWidth);
        terrain.setTrees((ArrayList<Tree>)trees.clone());
        generateItems();
    }
    
    private void generateItems(){
        Random r = new Random();
        ArrayList<Item> availebleItems = new ArrayList<Item>();
        terrain.setItemsDropped(availebleItems);
    }

    public Map getTerrain() {
        return terrain;
    }

    public Player getPlayer() {
        return player;
    }
    
    
    
}
