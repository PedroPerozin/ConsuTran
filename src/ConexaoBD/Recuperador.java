/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ConexaoBD;


import Beans.ListaOperacao;
import Beans.Operacao;
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
    
    public ListaOperacao getGroup() throws SQLException{

        Connection conn = minhaConexao.getConnection();
        Statement stm = conn.createStatement();
        String sql = "SELECT * FROM schedule WHERE status = 'f' ORDER BY idOperacao ASC LIMIT 100";
        
        ResultSet rs = stm.executeQuery(sql);
        
        Operacao tupla;
        ListaOperacao list = new ListaOperacao();
        
        
        while(rs.next()){
            tupla = new Operacao();
            tupla.setIdOperacao(rs.getInt(1));
            tupla.setIndiceTransacao(rs.getInt(2));
            tupla.setOperacao(rs.getString(3));
            tupla.setItemDado(rs.getString(4));
            tupla.setTimestampj(rs.getString(5));
            tupla.setStatus(rs.getBoolean(6));
            list.setOperacao(tupla);
        }
        
        //list.printList();
        
    return list;
    }
    
    
}
