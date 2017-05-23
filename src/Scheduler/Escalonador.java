package Scheduler;

import Beans.Dado;
import Beans.ListaDado;
import Beans.ListaTransacao;
import Beans.Transacao;
import Main.Arquivo;
import java.io.IOException;

public class Escalonador {

    Arquivo arquivo;
    String conteudo;
    ListaDado readers;
    ListaDado writers;
    int cont;
    int i, j;

    public Escalonador() {
        arquivo = new Arquivo();
        readers = new ListaDado();
        writers = new ListaDado();
    }

    public void escalonador(ListaTransacao listaTransacao, ListaTransacao listaEscalonada, ListaTransacao listaEspera) throws IOException {

        Transacao transacao;
        Dado dado;
        

        for (int i = 0; i < listaTransacao.getSize(); i++) {

            transacao = new Transacao();
            transacao = listaTransacao.getTransacao(i);
            dado = new Dado();
            dado = listaTransacao.getTransacao(i).getDado();
            String conteudo = transacao.getAction() + transacao.getIndice() + transacao.getDado().getDescricao();

            if (listaTransacao.getTransacao(i).getAction().charAt(0) == 'B') {
                listaEscalonada.setTransacao(transacao);
                arquivo.writer(transacao.getAction() + transacao.getIndice());
            } 
            
            else if (listaTransacao.getTransacao(i).getAction().charAt(0) == 'R') {

                if (readers.getSize() <= 0 && writers.getSize() <= 0) {
                    listaEscalonada.setTransacao(transacao);
                    arquivo.writer(conteudo);
                    readers.setDado(dado);
                } 
                
                else if (readers.getSize() > 0 && writers.getSize() <= 0) {
                    j = 0;
                    while (j < readers.getSize()) {
                        if (readers.getDado(j).getDescricao() == dado.getDescricao()) {
                            if (readers.getDado(j).getIndice() == dado.getIndice()) {
                                listaEscalonada.setTransacao(transacao);
                                arquivo.writer(conteudo);
                                System.exit(0);
                            }
                        }
                        j++;
                    }
                    listaEscalonada.setTransacao(transacao);
                    arquivo.writer(conteudo);
                    readers.setDado(dado);
                } 
                
                else if (readers.getSize() <= 0 && writers.getSize() > 0) {
                    j = 0;
                    while (j < writers.getSize()) {
                        if (writers.getDado(j).getDescricao() == dado.getDescricao()) {
                            if (writers.getDado(j).getIndice() == dado.getIndice()) {
                                listaEscalonada.setTransacao(transacao);
                                arquivo.writer(conteudo);
                                readers.setDado(dado);
                                System.exit(0);
                            }
                            else{
                                listaEspera.setTransacao(transacao);
                                System.exit(0);
                            }
                        }
                        j++;
                    }
                } 
                
                else if (readers.getSize() > 0 && writers.getSize() > 0) {
                    j = 0;
                    while (j < readers.getSize()) {
                        if (readers.getDado(j).getDescricao() == dado.getDescricao()) {
                            if (readers.getDado(j).getIndice() == dado.getIndice()) {
                                listaEscalonada.setTransacao(transacao);
                                arquivo.writer(conteudo);
                                System.exit(0);
                            }
                        }
                        j++;
                    }
                    j = 0;
                    while (j < writers.getSize()) {
                        if (writers.getDado(j).getDescricao() == dado.getDescricao()) {
                            if (writers.getDado(j).getIndice() == dado.getIndice()) {
                                listaEscalonada.setTransacao(transacao);
                                arquivo.writer(conteudo);
                                System.exit(0);
                            }
                            else{
                                listaEspera.setTransacao(transacao);
                                System.exit(0);
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
                    j = 0;
                    while (j < writers.getSize()) {
                        if (writers.getDado(j).getDescricao() == dado.getDescricao()) {
                            if (writers.getDado(j).getIndice() == dado.getIndice()) {
                                listaEscalonada.setTransacao(transacao);
                                arquivo.writer(conteudo);
                                System.exit(0);
                            }
                            else{
                            listaEspera.setTransacao(transacao);
                            System.exit(0);
                            }
                        }
                        j++;
                    }
                    listaTransacao.setTransacao(transacao);
                    arquivo.writer(conteudo);
                    writers.setDado(dado);
                } 
                
                else if (writers.getSize() <= 0 && readers.getSize() > 0) {
                    cont = 0;
                    j = 0;
                    while (j < readers.getSize()) {
                        if (readers.getDado(j).getDescricao() == dado.getDescricao()) {
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
                            if (readers.getDado(j).getDescricao() == dado.getDescricao()) {
                                if (readers.getDado(j).getIndice() == dado.getIndice()) {
                                    listaEscalonada.setTransacao(transacao);
                                    arquivo.writer(conteudo);
                                    writers.setDado(dado);
                                    System.exit(0);
                                }
                                else{
                                listaEspera.setTransacao(transacao);
                                System.exit(0);
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
                    j = 0;
                    while (j < writers.getSize()) {
                        if (writers.getDado(j).getDescricao() == dado.getDescricao()) {
                            if (writers.getDado(j).getIndice() == dado.getIndice()) {
                                listaEscalonada.setTransacao(transacao);
                                arquivo.writer(conteudo);
                                System.exit(0);
                            }
                            else{
                                listaEspera.setTransacao(transacao);
                                System.exit(0);
                            }   
                        }
                        j++;
                    }
                    cont = 0;
                    j = 0;
                    while (j < readers.getSize()) {
                        if (readers.getDado(j).getDescricao() == dado.getDescricao()) {
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
                            if (readers.getDado(j).getDescricao() == dado.getDescricao()) {
                                if (readers.getDado(j).getIndice() == dado.getIndice()) {
                                    listaEscalonada.setTransacao(transacao);
                                    arquivo.writer(conteudo);
                                    writers.setDado(dado);
                                    System.exit(0);
                                }
                                else{
                                listaEspera.setTransacao(transacao);
                                System.exit(0);
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
