/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;


/**
 *
 * @author jeffersonmantovani
 */
public class Dado{
    
    private String descricao;
    private Integer indice;
    
    public Dado(){
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getIndice() {
        return indice;
    }

    public void setIndice(int indice) {
        this.indice = indice;
    }
    
    public boolean equalsDesc(Dado dado){
        String desc = dado.getDescricao();
        if(this.descricao.equalsIgnoreCase(desc)){
            return true;
        }
        return false;
    }
    
    public boolean equalsIndex(Dado dado){
        Integer index = dado.getIndice();
        if(this.indice == index){
            return true;
        }
        return false;
    }

}
