
package Beans;
/**
 *
 * @author jeffersonmantovani
 */
public enum Bloqueio {
    UNLOCKED("U"),
    SHARED("S"),
    EXCLUSIVE("X");
    String texto;
    
    private Bloqueio(String texto){
        this.texto = texto;
    }
    
    @Override
    public String toString(){
        return texto;
    }
    
    
}
