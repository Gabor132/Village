/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package World;

/**
 *
 * @author Dragos-Alexandru
 */
public class Item extends Entity{

    public Item(int x, int y, String pathToImage) {
        super(x, y, pathToImage);
    }
    
    @Override
    public String toString(){
        return "Item";
    }
    
}
