package World;
import Structures.Killable;
import Structures.StatusPacket;

/**
 *
 * @author Dragos-Alexandru
 */
public class Creature extends Entity implements Killable{

    protected final String name;
    protected final StatusPacket status;
    
    public Creature(int x, int y, String pathToImage,StatusPacket status, String name) {
        super(x, y, pathToImage);
        this.name = name;
        this.status = status;
    }

    public String getName() {
        return name;
    }

    public StatusPacket getStatus() {
        return status;
    }
    
    
    @Override
    public boolean takeDamage(int damage) {
        status.setHp(status.getHp()-damage);
        if(status.getHp()<=0){
            return true;
        }
        return false;
    }
    
    /**
     *  Spit out random objects in world
     */
    @Override
    public void dropLoot() {
        
    }
    
    @Override
    public String toString(){
        return "Creature";
    }
    
}
