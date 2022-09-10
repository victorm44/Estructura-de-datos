/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arbolgrafico;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JPanel;

/**
 *
 * @author SaraTobonR
 */
public class Arbol {
    
    private NodoInt raiz;
    int cant;
    int altura;
    String[] niveles;

    public NodoInt getRaiz() {
        return raiz;
    }

    public void setRaiz(NodoInt r) {
        raiz = r;
    }

    public Arbol() {
        raiz = null;
    }

    public boolean agregar(int dato) {
        NodoInt nuevo = new NodoInt(dato, null, null);
        insertar(nuevo, raiz);
        return true;
    }

    public void insertar(NodoInt nuevo, NodoInt pivote) {  
        if (this.raiz == null) {
            raiz = nuevo;
        } else {           
            if (nuevo.getDato() < pivote.getDato()) {
                if (pivote.getIzq() == null) {
                    pivote.setIzq(nuevo);
                } else {
                    insertar(nuevo, pivote.getIzq());                  
                }
            } else if (nuevo.getDato() > pivote.getDato()){
                if (pivote.getDer() == null) {
                    pivote.setDer(nuevo);
                } else {
                    insertar(nuevo, pivote.getDer());                    
                }
            }  
        }
        
        

    }
    
    public boolean insertarConComas(String datos){
        String[] numeros= datos.split(",");
        for(int i=0; i<numeros.length;i++){
            int p= Integer.parseInt(numeros[i]);
            agregar(p);
        }
        return true;
    }
    //cantidad de nodos del arbol
    public String cantidadNodos() {
        cant = 0;
        cantidadNodos(raiz);
        return ""+cant;
    }

    private void cantidadNodos(NodoInt reco) {
        
        if (reco != null) {
            cant++;
            cantidadNodos(reco.getIzq());
            cantidadNodos(reco.getDer());
        }       
    }
    
   //Cantidad de nodos hojas.
    public String cantidadNodosHoja() {
        cant = 0;
        cantidadNodosHoja(raiz);
        return ""+cant;
    }
      private void cantidadNodosHoja(NodoInt reco) {
        if (reco != null) {
            if (reco.getIzq() == null && reco.getDer() == null) {
                cant++;
            }
            cantidadNodosHoja(reco.getIzq());
            cantidadNodosHoja(reco.getDer());
        }
    }

  // Altura del Arbol
      public String retornarAltura() {
        altura = 0;
        retornarAltura(raiz, 1);
        return ""+altura;
    }

    private void retornarAltura(NodoInt reco, int nivel) {
        if (reco != null) {
            retornarAltura(reco.getIzq(), nivel + 1);
            if (nivel > altura) {
                altura = nivel;
            }
            retornarAltura(reco.getDer(), nivel + 1);
        }
    }
    
    //Valor menor
     public String menorValor() {
         NodoInt reco = raiz;
        if (raiz != null) {
            
            while (reco.getIzq() != null) {
                reco = reco.getIzq();
            }
        }
        return ("" + reco.getDato());
    }
     //mayor Valor
    public String mayorValor() {
        NodoInt reco = raiz;
        if (raiz != null) {
            while (reco.getDer() != null) {
                reco = reco.getDer();
            }
        }
        return ("" + reco.getDato());
    }       
        
    //Borrar menor
    public String borrarMenor() {
        NodoInt reco=raiz.getIzq();
        if (raiz != null) {
            if (raiz.getIzq() == null) {
                raiz = raiz.getDer();
            } else {
                NodoInt anterior = raiz;
                reco = raiz.getIzq();
                while (reco.getIzq() != null) {
                    anterior = reco;
                    reco = reco.getIzq();
                }
                
                anterior.setIzq(reco.getDer());
            }
        }
        return ("Valor eliminado: " + reco.getDato());
    }

    //borrar mayor
    public String borrarMayor() {
        NodoInt reco=raiz.getIzq();
        if (raiz != null) {
            if (raiz.getDer() == null) {
                raiz = raiz.getIzq();
            } else {
                NodoInt anterior = raiz;
                reco = raiz.getDer();
                while (reco.getDer() != null) {
                    anterior = reco;
                    reco = reco.getDer();
                }
                
                anterior.setDer(reco.getIzq());
            }
        }
        return ("Valor eliminado: " + reco.getDato());
    }
   
      
   public int alturaArbol() {
        altura = 0;
        alturaArbol(raiz, 0);
        return altura;
    }

    private void alturaArbol(NodoInt pivote, int nivel) {
        if (pivote != null) {
            alturaArbol(pivote.getIzq(), nivel + 1);
            if (nivel > altura) {
                altura = nivel;
            }
            alturaArbol(pivote.getDer(), nivel + 1);
        }
    }

       
    public ArrayList imprimirNivel() {
        niveles = new String[altura + 1];
        ArrayList l=new ArrayList();
        imprimirNivel(raiz, 0);
        for (int i = 0; i < niveles.length; i++) {
            l.add(niveles[i] + " ");
            //System.out.println(niveles[i] + " ");
        }
        return l;
    }
      public void imprimirNivel(NodoInt pivote, int nivel2) {
        if (pivote != null) {
            niveles[nivel2] = pivote.getDato() + ", " + ((niveles[nivel2] != null) ? niveles[nivel2] : "");
            imprimirNivel(pivote.getDer(), nivel2 + 1);
            imprimirNivel(pivote.getIzq(), nivel2 + 1);
        }
    }
    
    //Borrar el que sea
    public int borrar(int x) {
        if (!this.buscar(x)) {
            return 0;
        }

        NodoInt z = borrar(this.raiz, x);
        this.setRaiz(z);
        return x;

    }

    private NodoInt borrar(NodoInt r, int x) {
        if (r == null) {
            return null;//<--Dato no encontrado		
        }
        int compara = ((Comparable) r.getDato()).compareTo(x);
        if (compara > 0) {
            r.setIzq(borrar(r.getIzq(), x));
        } else if (compara < 0) {
            r.setDer(borrar(r.getDer(), x));
        } else {
            System.out.println("Encontro el dato:" + x);
            if (r.getIzq() != null && r.getDer() != null) {
                /*
                 *	Buscar el menor de los derechos y lo intercambia por el dato
                 *	que desea borrar. La idea del algoritmo es que el dato a borrar 
                 *	se coloque en una hoja o en un nodo que no tenga una de sus ramas.
                 **/
                NodoInt cambiar = buscarMin(r.getDer());
                int aux = cambiar.getDato();
                cambiar.setDato(r.getDato());
                r.setDato(aux);
                r.setDer(borrar(r.getDer(), x));
                System.out.println("2 ramas");
            } else {
                r = (r.getIzq() != null) ? r.getIzq() : r.getDer();
                System.out.println("Entro cuando le faltan ramas ");
            }
        }
        return r;
    }

    //buscar
    public boolean buscar(int x) {
        return (buscar(this.raiz, x));
    }

    private boolean buscar(NodoInt r, int x) {
        if (r == null) {
            return (false);
        }
        int compara = ((Comparable) r.getDato()).compareTo(x);
        if (compara > 0) {
            return (buscar(r.getIzq(), x));
        } else if (compara < 0) {
            return (buscar(r.getDer(), x));
        } else {
            return (true);
        }
    }

    //buscar min
    private NodoInt buscarMin(NodoInt r) {
        for (; r.getIzq() != null; r = r.getIzq());
        return (r);
    }
    
    //imprimir InOrden
    public ArrayList inOrden() {
        ArrayList l=new ArrayList();
        inOrden(raiz,l);
        return l;
    }

    private void inOrden(NodoInt reco,ArrayList l) {
        if (reco != null) {
            inOrden(reco.getIzq(),l);
            l.add(reco.getDato() + " ");
            inOrden(reco.getDer(),l);
        }
    }
    
    //hojas
    public ArrayList getHojas() {
        ArrayList l = new ArrayList();
        getHojas(this.raiz, l);
        return (l);
    }

    private void getHojas(NodoInt r, ArrayList l) {
        if (r != null) {
            if (this.esHoja(r)) {
                l.add(r.getDato());
            }
            getHojas(r.getIzq(), l);
            getHojas(r.getDer(), l);
        }

    }
    protected boolean esHoja(NodoInt x) {
        return (x != null && x.getIzq() == null && x.getDer() == null);
    }
         
    //Dibujamos el Arbol (Arbol Grafico)
     public JPanel getdibujo() {           
         return new ArbolGrafico(this);
    }
    
}
