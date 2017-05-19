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
public class Anunciante extends Cliente{
    
    protected int numAnuncios;
    
    
    // constructor vacío
    protected Anunciante(){
        super();
    }
    
    // constructor con parámetros 
    protected Anunciante(String email, String contraseña, double descuento, int numAnuncios){
        super(email, contraseña, descuento);
        this.numAnuncios= numAnuncios;
    }
    
}
