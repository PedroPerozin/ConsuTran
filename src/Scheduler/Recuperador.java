/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Scheduler;


import Beans.Bloqueio;
import Beans.ListaTransacao;
import Beans.Transacao;
import ConexaoBD.MinhaConexao;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author jeffersonmantovani
 */
public class Recuperador {
    
    private static MinhaConexao minhaConexao;
    
    public Recuperador(){
        minhaConexao = new MinhaConexao();
        MinhaConexao.getCabecalho();
    }
    
    public ListaTransacao getGroup() throws SQLException{

        Connection conn = minhaConexao.getConnection();
        Transacao transacao;
        ListaTransacao listaTransacao;
        
        while(!conn.isClosed()){
            
            Statement stm = conn.createStatement();
            String sql = "SELECT * FROM schedule WHERE status = 'f' ORDER BY idOperacao";
        
            ResultSet rs = stm.executeQuery(sql);
        
            listaTransacao = new ListaTransacao();
        
            while(rs.next()){
                transacao = new Transacao();
                transacao.action = rs.getString(3);
                transacao.indice = rs.getInt(2);
                transacao.dado.setDescricao(rs.getString(4));
                transacao.dado.setIndice(transacao.indice);
                listaTransacao.setTransacao(transacao);    
            }
        
        return listaTransacao;    
        }
    return null;
    }
    
}
