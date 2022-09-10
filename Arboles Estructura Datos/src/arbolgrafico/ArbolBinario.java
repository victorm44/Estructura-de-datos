/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arbolgrafico;

import java.util.ArrayList;
import javax.swing.JPanel;

/**
 *
 * @author SaraTobonR
 */
public class ArbolBinario {
    
    Arbol miArbol = new Arbol();

    public ArbolBinario() {
    }

    public boolean insertar(Integer dato) {
        return (this.miArbol.agregar(dato));
    }
    
    public boolean insertarConComas(String datos){
        return (this.miArbol.insertarConComas(datos));
    }

    public String borrar(Integer dato) {
        Integer x = this.miArbol.borrar(dato);
        if (x == null) {
            return ("No existe el dato en el arbol");
        }
        return ("Borrado el dato: " + x.toString());
    }   
   
    
    public String inOrden() {
        ArrayList it = this.miArbol.inOrden();
        return (recorrido(it, "Recorrido InOrden"));
    }

   // Metodo para buscar si un dato existe.
    public String existe(Integer dato) {
        boolean siEsta = this.miArbol.buscar(dato);
        String r = "El dato:" + dato.toString() + "\n";
        r += siEsta ? "Si se encuentra en el arbol" : "No se encuentra en el arbol";
        return (r);
    }

    private String recorrido(ArrayList it, String msg) {
        int i = 0;
        String r = msg + "\n";
        while (i < it.size()) {
            r += "\t" + it.get(i).toString() + "\n";
            i++;
        }
        return (r);
    }
 // Metodo para buscar la cantidad de nodos arbol
    public String CantidadNodos(){
        return this.miArbol.cantidadNodos();
    }
// Metodo para buscar la cantidad de nodos arbol
    public String CantidadHojas(){
        return this.miArbol.cantidadNodosHoja();
    }
    
// Metodo para  la altura arbol
    public String alturaArbol(){
        return this.miArbol.retornarAltura();
    }
    // metodo para el nodo mayor
    public String menorValor(){
        return this.miArbol.menorValor();
    }
 // metodo para el nodo mayor
    public String mayorValor(){
        return this.miArbol.mayorValor();
    }
    
    public String borrarMenor(){
        return this.miArbol.borrarMenor();
    }
    public String borrarMayor(){
        return this.miArbol.borrarMayor();
    }
    
    public String porNivel(){
        this.miArbol.alturaArbol();
        ArrayList it = this.miArbol.imprimirNivel();
        return (recorrido(it, "Imprimir por niveles en orden!!!"));
    }
   
public JPanel getDibujo() {
        return this.miArbol.getdibujo();
    }
    
}
