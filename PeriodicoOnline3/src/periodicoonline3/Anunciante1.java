/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package periodicoonline3;

import java.io.Serializable;

/**
 *
 * @author Juan A. García Muelas <juangmuelas@hotmail.com>
 */
public class Anunciante1 extends Cliente1 implements Serializable{
    
    protected int numAnuncios;
    
    
    // constructor vacío
    protected Anunciante1(){
        super();
    }
    
    // constructor con parámetros 
    protected Anunciante1(String email, String contraseña, double descuento, int numAnuncios){
        super(email, contraseña, descuento);
        this.numAnuncios= numAnuncios;
    }

    /**
     * @return the numAnuncios
     */
    protected int getNumAnuncios() {
        return numAnuncios;
    }

    /**
     * @param numAnuncios the numAnuncios to set
     */
    protected void setNumAnuncios(int numAnuncios) {
        this.numAnuncios = numAnuncios;
    }
    
}
