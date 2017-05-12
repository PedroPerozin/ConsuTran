/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;

import static Beans.Bloqueio.UNLOCKED;
import java.util.LinkedList;

/**
 *
 * @author jeffersonmantovani
 */
public class Dado {
    
    
    private Bloqueio bloqueio;
    private String itemDado;
    
    public Dado(String itemDado){
        this.itemDado = itemDado;
        this.bloqueio = UNLOCKED;
    }
    
    public void setBloqueio(Bloqueio bloqueio){
        this.bloqueio = bloqueio;
    }
    
    public Bloqueio getBloqueio(){
        return this.bloqueio;
    }
    
    public String getItemDado(){
        return this.itemDado;
    }
    
    
}
