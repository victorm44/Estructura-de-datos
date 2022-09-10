/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arbolgrafico;

/**
 *
 * @author SaraTobonR
 */
public class NodoInt {
    
    private int dato;
    private NodoInt izq, der;

    public NodoInt(int dato, NodoInt izq, NodoInt der) {
        this.dato = dato;
        this.izq = izq;
        this.der = der;
    }

    public int getDato() {
        return dato;
    }

    public void setDato(int dato) {
        this.dato = dato;
    }

    public NodoInt getIzq() {
        return izq;
    }

    public void setIzq(NodoInt izq) {
        this.izq = izq;
    }

    public NodoInt getDer() {
        return der;
    }

    public void setDer(NodoInt der) {
        this.der = der;
    }
    
}
