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
public abstract class Cliente {
    protected String email;
    protected String contraseña;
    
    protected double descuento;
    
   
    
    //Constructor vacío
    protected Cliente(){}
    
    //Constructor con parámetros
    protected Cliente(String email, String contraseña, double descuento){
        this.email=email;
        this.contraseña=contraseña;
        this.descuento=descuento;
    }
    
    // get y set

    /**
     * @return the email
     */
    protected String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    protected void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the contraseña
     */
    protected String getContraseña() {
        return contraseña;
    }

    /**
     * @param contraseña the contraseña to set
     */
    protected void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    /**
     * @return the descuento
     */
    protected double getDescuento() {
        return descuento;
    }

    /**
     * @param descuento the descuento to set
     */
    protected void setDescuento(double descuento) {
        this.descuento = descuento;
    }
    
}
