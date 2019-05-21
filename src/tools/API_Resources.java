/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tools;

import arquitectura.Entorno;

/**
 *
 * @author alvaroluismartinez
 */
public class API_Resources {
    private Entorno entorno;
    
    public API_Resources(Entorno entorno){
        this.entorno = entorno;
    }

    public Entorno getEntorno() {
        return entorno;
    }

    public void setEntorno(Entorno entorno) {
        this.entorno = entorno;
    }
    
    
}
