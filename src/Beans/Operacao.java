/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;

import java.util.Iterator;
import java.util.LinkedList;

/**
 *
 * @author jeffersonmantovani
 */
public class Operacao {
    
    private Integer idOperacao;
    private Integer indiceTransacao;
    private String operacao;
    private String itemDado;
    private String timestampj;
    private Boolean status;
    
    public Operacao(){
        
    }

    public Integer getIdOperacao() {
        return idOperacao;
    }

    public void setIdOperacao(Integer aIdOperacao) {
        idOperacao = aIdOperacao;
    }

    public Integer getIndiceTransacao() {
        return indiceTransacao;
    }

    public void setIndiceTransacao(Integer aIndiceTransacao) {
        indiceTransacao = aIndiceTransacao;
    }

    public String getOperacao() {
        return operacao;
    }

    public void setOperacao(String operacao) {
        this.operacao = operacao;
    }

    public String getItemDado() {
        return itemDado;
    }

    public void setItemDado(String itemDado) {
        this.itemDado = itemDado;
    }

    public String getTimestampj() {
        return timestampj;
    }

    public void setTimestampj(String timestampj) {
        this.timestampj = timestampj;
    }
    
    public Boolean getStatus(){
        return this.status;
    }
    
    public void setStatus(Boolean status){
        this.status = status;
    }
    
    

    public void printOperacao(){
        
        System.out.print(this.getIdOperacao());
        System.out.print(", " + this.getIndiceTransacao());
        System.out.print(", " + this.getOperacao());
        System.out.print(", " + this.getItemDado());
        System.out.print(", " + this.getTimestampj());
        System.out.println(", " + this.getStatus());
        
    }
    
}
