
package Scheduler;

import static Beans.Bloqueio.EXCLUSIVE;
import static Beans.Bloqueio.SHARED;
import static Beans.Bloqueio.UNLOCKED;
import Beans.Dado;
import Beans.ListaDado;
import Beans.ListaTransacao;
import Beans.Transacao;
import Main.Arquivo;
import java.io.IOException;
import static javafx.application.Platform.exit;



public class Escalonador {
    
    Arquivo arquivo;
    String conteudo;
    ListaDado readers;
    ListaDado writers;
    
    public Escalonador(){
        arquivo = new Arquivo();
        readers = new ListaDado();
        writers = new ListaDado();
    }
   
    public void escalonador(ListaTransacao listaTransacao, ListaTransacao listaEscalonada, ListaTransacao listaEspera) throws IOException{
        
        Transacao transacao;
        Dado dado;
        
        for(int i=0; i<listaTransacao.getSize(); i++){
            
            transacao = new Transacao();
            
            if (listaTransacao.getTransacao(i).getAction().charAt(0) == 'B'){
                transacao = listaTransacao.getTransacao(i);
                listaEscalonada.setTransacao(transacao);
                arquivo.writer(transacao.getAction() + transacao.getIndice());
            }
            
            else if (listaTransacao.getTransacao(i).getAction().charAt(0) == 'R'){
                
                Dado aux = listaTransacao.getTransacao(i).getDado();
                int j=0;
                while(aux.getDescricao() != readers.getDado(j).getDescricao()){
                    j++;
                }
                if (j>=readers.getSize()){
                    j=0;
                    while(aux.getDescricao() != writers.getDado(j).getDescricao()){
                        j++;
                    }
                    if(j<writers.getSize()){
                        if(writers.getDado(j).getIndice() == aux.getIndice()){
                            transacao = listaTransacao.getTransacao(i);
                            listaEscalonada.setTransacao(transacao);
                            arquivo.writer(transacao.getAction()+transacao.getIndice()+transacao.getDado().getDescricao());
                        }
                    }
                }
                
                
            }
            
            else if (listaTransacao.getTransacao(i).getAction().charAt(0) == 'W'){
                
                
                
            }
        }
    }

    
}
        

