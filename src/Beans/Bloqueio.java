/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;

/**
 *
 * @author jeffersonmantovani
 */
public enum Bloqueio {
    UNLOCKED("U"),
    SHARED("S"),
    EXCLUSIVE("X");
    String texto;
    
    private Bloqueio(String texto){
        this.texto = texto;
    }
    
    @Override
    public String toString(){
        return texto;
    }
    
}
