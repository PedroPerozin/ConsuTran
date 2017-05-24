package Scheduler;

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

    public Escalonador() {
        arquivo = new Arquivo();
        readers = new ListaDado();
        writers = new ListaDado();
    }
    
    public void escalonador(ListaTransacao listaTransacao, ListaTransacao listaEscalonada, ListaTransacao listaEspera) throws IOException {

        Transacao transacao;
        Dado dado;
        

        FOR:
        for (int i = 0; i < listaTransacao.getSize(); i++) {

            transacao = new Transacao();
            transacao = listaTransacao.getTransacao(i);
            dado = new Dado();
            dado = transacao.getDado();
            String conteudo = transacao.getAction() + transacao.getIndice() + transacao.getDado().getDescricao();

            if (listaTransacao.getTransacao(i).getAction().charAt(0) == 'B') {
                listaEscalonada.setTransacao(transacao);
                arquivo.writer(transacao.getAction() + transacao.getIndice());
            } 
            
            else if(listaTransacao.getTransacao(i).getAction().charAt(0) == 'E'){
                
                if(!listaEspera.containsTransacao(transacao)){
                   
                }
                
                else{
                    
                }
                
                
                
            }
            
            else if (listaTransacao.getTransacao(i).getAction().charAt(0) == 'R') {

                if (readers.getSize() <= 0 && writers.getSize() <= 0) {
                    listaEscalonada.setTransacao(transacao);
                    arquivo.writer(conteudo);
                    readers.setDado(dado);
                } 
                
                else if (readers.getSize() > 0 && writers.getSize() <= 0) {
                    int j = 0;
                    while (j < readers.getSize()) {
                        if (readers.getDado(j).equalsDesc(dado)){
                            if(readers.getDado(j).equalsIndex(dado)){
                                listaEscalonada.setTransacao(transacao);
                                arquivo.writer(conteudo);
                                continue FOR;
                            }
                        }
                        j++;
                    }
                    listaEscalonada.setTransacao(transacao);
                    arquivo.writer(conteudo);
                    readers.setDado(dado);
                } 
                
                else if (readers.getSize() <= 0 && writers.getSize() > 0) {
                    int j = 0;
                    while (j < writers.getSize()) {
                        if (writers.getDado(j).equalsDesc(dado)){
                            if(writers.getDado(j).equalsIndex(dado)){
                                listaEscalonada.setTransacao(transacao);
                                arquivo.writer(conteudo);
                                readers.setDado(dado);
                                continue FOR;
                            }
                        }
                    j++;
                    }
                    listaEspera.setTransacao(transacao);
                }
                 
                
                else if (readers.getSize() > 0 && writers.getSize() > 0) {
                    int j = 0;
                    while (j < readers.getSize()) {
                        if (readers.getDado(j).equalsDesc(dado)){
                            if(readers.getDado(j).equalsIndex(dado)){
                                listaEscalonada.setTransacao(transacao);
                                arquivo.writer(conteudo);
                                continue FOR;
                            }
                        }
                        j++;
                    }
                    j = 0;
                    while (j < writers.getSize()) {
                        if (writers.getDado(j).equalsDesc(dado)){
                            if (writers.getDado(j).equalsIndex(dado)) {
                                listaEscalonada.setTransacao(transacao);
                                arquivo.writer(conteudo);
                                continue FOR;
                            }
                            else{
                                listaEspera.setTransacao(transacao);
                                continue FOR;
                            }
                        }
                        j++;
                    }
                    listaEscalonada.setTransacao(transacao);
                    arquivo.writer(conteudo);
                    readers.setDado(dado);
                }
            }
            
            else if (listaTransacao.getTransacao(i).getAction().charAt(0) == 'W') {

                if (writers.getSize() <= 0 && readers.getSize() <= 0) {
                    listaEscalonada.setTransacao(transacao);
                    arquivo.writer(conteudo);
                    writers.setDado(dado);
                } 
                else if (writers.getSize() > 0 && readers.getSize() <= 0) {
                    int j = 0;
                    while (j < writers.getSize()) {
                        if (writers.getDado(j).equalsDesc(dado)) {
                            if (writers.getDado(j).equalsIndex(dado)) {
                                listaEscalonada.setTransacao(transacao);
                                arquivo.writer(conteudo);
                                continue FOR;
                            }
                            else{
                            listaEspera.setTransacao(transacao);
                            continue FOR;
                            }
                        }
                        j++;
                    }
                    listaTransacao.setTransacao(transacao);
                    arquivo.writer(conteudo);
                    writers.setDado(dado);
                } 
                
                else if (writers.getSize() <= 0 && readers.getSize() > 0) {
                    int cont = 0;
                    int j = 0;
                    while (j < readers.getSize()) {
                        if (readers.getDado(j).equalsDesc(dado)) {
                            cont++;
                        }
                        j++;
                    }
                    if(cont <= 0){
                        listaEscalonada.setTransacao(transacao);
                        arquivo.writer(conteudo);
                        writers.setDado(dado);
                    }
                    else if (cont ==  1) {
                        j = 0;
                        while (j < readers.getSize()) {
                            if (readers.getDado(j).equalsDesc(dado)) {
                                if (readers.getDado(j).equalsIndex(dado)) {
                                    listaEscalonada.setTransacao(transacao);
                                    arquivo.writer(conteudo);
                                    writers.setDado(dado);
                                    continue FOR;
                                }
                                else{
                                listaEspera.setTransacao(transacao);
                                continue FOR;
                                }
                            }
                            j++;
                        } 
                    }
                    else if(cont > 1) {
                        listaEspera.setTransacao(transacao);
                    }
                } 
                
                
                else if (writers.getSize() > 0 && readers.getSize() > 0) {
                    int j = 0;
                    while (j < writers.getSize()) {
                        if (writers.getDado(j).equalsDesc(dado)) {
                            if (writers.getDado(j).equalsIndex(dado)) {
                                listaEscalonada.setTransacao(transacao);
                                arquivo.writer(conteudo);
                                continue FOR;
                            }
                            else{
                                listaEspera.setTransacao(transacao);
                                continue FOR;
                            }   
                        }
                        j++;
                    }
                    int cont = 0;
                    j = 0;
                    while (j < readers.getSize()) {
                        if (readers.getDado(j).equalsDesc(dado)) {
                            cont++;
                        }
                        j++;
                    }
                    if (cont <= 0) {
                        listaEscalonada.setTransacao(transacao);
                        arquivo.writer(conteudo);
                        writers.setDado(dado);
                    } 
                    else if (cont == 1) {
                        j = 0;
                        while (j < readers.getSize()) {
                            if (readers.getDado(j).equalsDesc(dado)) {
                                if (readers.getDado(j).equalsIndex(dado)){
                                    listaEscalonada.setTransacao(transacao);
                                    arquivo.writer(conteudo);
                                    writers.setDado(dado);
                                    continue FOR;
                                }
                                else{
                                    listaEspera.setTransacao(transacao);
                                    continue FOR;
                                }
                            }
                            j++;
                        }
                    } 
                    else if (cont > 1) {
                        listaEspera.setTransacao(transacao);
                    }
                }
            }
        }
    }
}

        

    
