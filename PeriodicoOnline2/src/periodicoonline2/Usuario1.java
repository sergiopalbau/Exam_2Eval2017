/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package periodicoonline2;

/**
 *
 * @author Juan A. García Muelas <juangmuelas@hotmail.com>
 */
public class Usuario1 extends Cliente1{
  
    protected boolean premium;
    
    
    // constructor vacio
    protected Usuario1(){
        super();
    }
    
    //constructor con parámetros
    protected Usuario1(String email, String contraseña, double descuento, boolean premium){
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
    
    //método ingresos totales
    protected double ingresoTotal(double usuarioNormal, double usuarioPremium){
    
        return usuarioNormal+(usuarioPremium-descuento);
    }
     
    
}
