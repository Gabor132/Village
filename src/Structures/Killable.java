/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Structures;

/**
 *
 * @author Dragos-Alexandru
 */
public interface Killable {
    
    public boolean takeDamage(int damage);
    
    public void dropLoot();
}
