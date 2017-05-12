/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;

import Beans.ListaDado;
import Beans.Operacao;
import java.util.LinkedList;

/**
 *
 * @author jeffersonmantovani
 */
public class ListaEspera {
    
    LinkedList<Operacao> listaEspera;
    
    public ListaEspera(){
        listaEspera = new LinkedList<>();
    }
    
    public void setEspera(Operacao transacao){
        listaEspera.add(transacao);
    }
    
    public Operacao getEspera(ListaDado listaDado){
        return null;
    }
    
    
}
