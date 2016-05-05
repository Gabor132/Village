package Structures;

import World.Entity;

/**
 *
 * @author Dragos-Alexandru
 */
public interface Collidable {
    
    public boolean collide(Entity foreignObject);
    
}
