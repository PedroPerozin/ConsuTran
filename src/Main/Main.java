/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import Beans.ListaOperacao;
import Scheduler.Escalonador;
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
    public static void main(String[] args) {
   
        
        ConexaoBD.Recuperador rec = new ConexaoBD.Recuperador();
        ListaOperacao aux = null;
        
        try {
            aux = rec.getGroup();
        } catch (SQLException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        Escalonador esc = new Escalonador();
        //esc.Escalonador(aux);
        
       
    }
    
}
