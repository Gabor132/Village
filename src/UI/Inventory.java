package UI;

import World.Entity;
import java.util.ArrayList;

/**
 *
 * @author Dragos-Alexandru
 */
public class Inventory {
    
    private final ArrayList<Entity> items = new ArrayList<Entity>();
    private int nrItems = 0;
    private int limitItems;
    
    public Inventory(ArrayList<Entity> items, int limitItems){
        
        for(int i=0;i<items.size() && i<limitItems;i++){
            this.items.add(items.get(i));
            nrItems++;
        }
        
    }
    
    public Entity getItem(int index){
        if(index < this.limitItems && index < this.items.size()){
            return this.items.get(index);
        } else {
            return null;
        }
    }
    
    public boolean pushItem(Entity e){
        if(items.size()<limitItems){
            items.add(e);
            nrItems++;
            return true;
        }
        return false;
    }
    
    public Entity popItem(){
        if(items.isEmpty()){
            return null;
        }
        nrItems--;
        return items.remove(items.size()-1);
    }

    public int getNrItems() {
        return nrItems;
    }

    public int getLimitItems() {
        return limitItems;
    }
    public void setLimitItems(int limitItems){
        if(limitItems>=0){
            this.limitItems = limitItems;
        }
    }
    
    public boolean isFull(){
        return nrItems == limitItems;
    }
    
}
