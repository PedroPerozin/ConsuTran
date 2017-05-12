/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;

import java.util.LinkedList;

/**
 *
 * @author jeffersonmantovani
 */
public class ListaDado {
    
    private LinkedList<Dado> list;
    
    public ListaDado(){
        this.list = new LinkedList<>();
    }
    
    public void setDado(Dado dado){
        this.list.add(dado);
    }
    
    public Dado getDado(int indice){
        return this.list.get(indice);
    }
    
    public void removeDado(Dado dado){
        this.list.remove(dado);
    }
    
    public int getSize(){
        return this.list.size();
    }
    
    
    
    
}
