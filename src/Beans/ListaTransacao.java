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
public class ListaTransacao {
    
    LinkedList<Transacao> listaTransacao;
    
    public ListaTransacao(){
        listaTransacao = new LinkedList<>();
    }

    public Transacao getTransacao(int i){
        return listaTransacao.get(i);
    }
    
    public void setTransacao(Transacao transacao){
        listaTransacao.add(transacao);
    }
    
    public int getSize(){
        return listaTransacao.size();
    }
    
    public void abort(int indice){
        for (Transacao transacao : listaTransacao) {
            if(transacao.getIndice() == indice){
                this.listaTransacao.remove(indice);
            }
        }
    }
    
    public void remove(int indice){
        this.listaTransacao.remove(indice);
    }
    
    
    
    public void printListaTransacao(){
        for (Transacao transacao : listaTransacao) {
            System.out.print(transacao.action);
            System.out.print(" " + transacao.indice);
            System.out.println(" " + transacao.dado.getDescricao());
        }
    }
    
    public boolean containsTransacao(Transacao transacao){
        for (Transacao transacao1 : this.listaTransacao) {
            if(transacao1.getDado().getIndice() == transacao.getIndice())
                return true;
        }
    return false;
    }
    
    public void removeTransacao(Transacao transacao){
        for (Transacao transacao1 : this.listaTransacao) {
            
        }
    }
    
    
}
