/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 *
 * @author jeffersonmantovani
 */
public class ListaOperacao {
    
    private LinkedList<Operacao> list;
    
    public ListaOperacao(){
        this.list = new LinkedList<>();
    }
    
    public void setOperacao(Operacao operacao){
        this.list.add(operacao);
    }
    
    public Operacao getOperacao(int i){
        return this.list.get(i);
    }
    
    public int getSize(){
        return this.list.size();
    }
    
    public void printList(){
        for (Operacao operacao : this.list) {
            operacao.printOperacao();
        }
    }
    
    
}
