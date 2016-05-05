/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Structures;

import UI.Inventory;

/**
 *
 * @author Dragos-Alexandru
 */
public class StatusPacket {
    private int hp;
    private int level;
    private int exp;
    private final Inventory inventory;
    
    public StatusPacket(int hp,int level, int exp, Inventory inventory){
        this.hp = hp;
        this.level = level;
        this.exp = exp;
        this.inventory = inventory;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getExp() {
        return exp;
    }

    public void setExp(int exp) {
        this.exp = exp;
    }

    public Inventory getInventory() {
        return inventory;
    }
    
    
    
}
