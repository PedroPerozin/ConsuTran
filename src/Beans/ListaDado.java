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
    
    LinkedList<Dado> listaDado;
    
    public ListaDado(){
        listaDado = new LinkedList<>();
    }
    
    public int getSize(){
        return this.listaDado.size();
    }
    
    public Dado getDado(int i){
        return this.listaDado.get(i);
    }
    
    public void setDado(Dado dado){
        this.listaDado.add(dado);
    }
    
    public void removeDado(int i){
        this.listaDado.remove(i);
    }
    
    public void printListaDado(){
        for (Dado dado : listaDado) {
            System.out.print(dado.getDescricao());
            System.out.println(" - " + dado.getIndice());
        }
    }
    
    public boolean containsDado(Dado dado){
        for (Dado dado1 : listaDado) {
            if(dado1.equalsIndex(dado))
                return true;
        }
    return false;    
    }
    
    public void removeDado(Dado dado){
        for (Dado dado1 : this.listaDado) {
            if(dado1.equalsIndex(dado))
                this.listaDado.remove(dado);
        }
    }
    
}
