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
public class Transacao {
    
    public Integer indice;
    public String action;
    public Dado dado;
    
    public Transacao(){
        dado = new Dado();
    }

    public Integer getIndice() {
        return indice;
    }

    public void setIndice(Integer indice) {
        this.indice = indice;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public Dado getDado() {
        return dado;
    }

    public void setDado(Dado dado) {
        this.dado = dado;
    }
    
    public void printTransacao(){
        
        System.out.print(this.getIndice());
        System.out.print(", " + this.getAction());
        System.out.print(", " + this.getDado().getDescricao());
        System.out.println(", " + this.getDado().getIndice());
        
    }
    
    
    
}
