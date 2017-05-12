/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Scheduler;


import static Beans.Bloqueio.EXCLUSIVE;
import static Beans.Bloqueio.SHARED;
import static Beans.Bloqueio.UNLOCKED;
import Beans.Dado;
import Beans.ListaDado;
import Beans.ListaOperacao;
import Beans.Operacao;
import static java.lang.Boolean.FALSE;
import java.util.Iterator;
import java.util.LinkedList;
import static javafx.application.Platform.exit;


/**
 *
 * @author jeffersonmantovani
 */
public class Escalonador {
    
    ListaDado listaEscalonada;
    ListaDado listaEspera;
    ListaDado listaShared;
    ListaDado listaExclusive;
    
    public Escalonador(){
        listaEscalonada = new ListaDado();
        listaEspera = new ListaDado();
        listaShared = new ListaDado();
        listaExclusive = new ListaDado();
    }

    public void Escalonador(ListaOperacao listaOperacao){
        
        Dado dado;
        
        for(int i=0; i<listaOperacao.getSize(); i++){
            
            if (listaOperacao.getOperacao(i).getStatus() == FALSE){
                
                if (listaOperacao.getOperacao(i).getOperacao().charAt(0) == 'B'){
                    dado = new Dado(listaOperacao.getOperacao(i).getOperacao());
                    listaEscalonada.setDado(dado);
                }
                
                else if (listaOperacao.getOperacao(i).getOperacao().charAt(0) == 'R'){
                    dado = new Dado(listaOperacao.getOperacao(i).getOperacao());
                    dado.setBloqueio(SHARED);
                    for(int j=0; j<listaExclusive.getSize(); j++){
                        if(listaExclusive.getDado(j).getBloqueio() == EXCLUSIVE){
                            listaEspera.setDado(dado);
                            exit();
                        }
                    }
                    listaEscalonada.setDado(dado);
                    listaShared.setDado(dado);
                }
                
                else if (listaOperacao.getOperacao(i).getOperacao().charAt(0) == 'W'){
                    dado = new Dado(listaOperacao.getOperacao(i).getOperacao());
                    dado.setBloqueio(EXCLUSIVE);
                    for(int f=0; f<listaEscalonada.getSize(); f++){
                        if(listaEscalonada.getDado(f).getBloqueio() == EXCLUSIVE ||
                            listaEscalonada.getDado(f).getBloqueio() == SHARED){
                            listaEspera.setDado(dado);
                            exit();
                        }
                    }
                    for (int k=0; k<listaEspera.getSize(); k++){
                        
                    }
                    
                }
            }
        
            
        }
        
    }
}
        

