/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package periodicoonline;

/**
 *
 * @author Juan A. García Muelas <juangmuelas@hotmail.com>
 */
public class Usuario extends Cliente{
    protected boolean premium;
    
    
    // constructor vacio
    protected Usuario(){
        super();
    }
    
    //constructor con parámetros
    protected Usuario(String email, String contraseña, double descuento, boolean premium){
        super(email, contraseña, descuento);
        this.premium= premium;
    }
     
    
    //get y set
   

    /**
     * @return the premium
     */
    protected boolean isPremium() {
        return premium;
    }

    /**
     * @param premium the premium to set
     */
    protected void setPremium(boolean premium) {
        this.premium = premium;
    }
    
    
     
    
}
