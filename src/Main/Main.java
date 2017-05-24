/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import Beans.Dado;
import Beans.ListaDado;
import Beans.ListaTransacao;
import Scheduler.Escalonador;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jeffersonmantovani
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        
        
        Scheduler.Recuperador rec = new Scheduler.Recuperador();
        ListaTransacao listaTransacao = new ListaTransacao();
        
        try {
            listaTransacao = rec.getGroup();
        } catch (SQLException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        ListaTransacao listaEscalonada = new ListaTransacao();
        ListaTransacao listaEspera = new ListaTransacao();
        
        Escalonador esc = new Escalonador();
        esc.escalonador(listaTransacao, listaEscalonada, listaEspera);
        
        
        //listaTransacao.printListaTransacao();
        //listaEscalonada.printListaTransacao();
        //listaEspera.printListaTransacao();
       
    }
    
}
