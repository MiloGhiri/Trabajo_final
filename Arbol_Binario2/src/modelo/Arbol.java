package modelo;

import java.util.Comparator;
import interfaces.IArbol;
import interfaces.INodo;

public class Arbol<T> implements IArbol<T> {
	
    private INodo<T> raiz;
    private Comparator<T> comparador;

    public Arbol(Comparator<T> comparador) {
        this.raiz = null;
        this.comparador = comparador;
    }

    @Override
    public void insertar(T dato) {
        raiz = insertarRec(raiz, dato);
    }

    private INodo<T> insertarRec(INodo<T> nodoRaiz, T dato) {
        if (nodoRaiz == null) {
            return new Nodo<>(dato);
        }

        int cmp = comparador.compare(dato, nodoRaiz.getDato());
     
        if (cmp < 0) {
            nodoRaiz.setIzquierdo(insertarRec(nodoRaiz.getIzquierdo(), dato));
        } else if (cmp > 0) {
            nodoRaiz.setDerecho(insertarRec(nodoRaiz.getDerecho(), dato));
        }

        return nodoRaiz;
    }

        
        /*        
        if (dato.getDni() < nodoRaiz.getDato().getDni()) { 
            nodoRaiz.setIzquierdo(insertarRec(nodoRaiz.getIzquierdo(), dato));
            
        } else if (dato.getDni() > nodoRaiz.getDato().getDni()) {
            nodoRaiz.setDerecho(insertarRec(nodoRaiz.getDerecho(), dato));
        }
        return nodoRaiz;
    }
*/
    @Override
    public INodo<T> buscar(T dato) {
        return buscarRec(raiz, dato);
    }

    private INodo<T> buscarRec(INodo<T> nodo, T dato) {
        
    	if (nodo == null) {
    		return nodo;
        }
        int cmp = comparador.compare(dato, nodo.getDato());
        
        if (cmp==0) {
        	return nodo;
        } else if (cmp < 0) {
            return buscarRec(nodo.getIzquierdo(), dato);
        } else {
            return buscarRec(nodo.getDerecho(), dato);
        }
    }
    
        /*
        if (dato.getDni() < nodo.getDato().getDni()) {
            return buscarRec(nodo.getIzquierdo(), dato);
        } else {
            return buscarRec(nodo.getDerecho(), dato);
        }*/

   
    
    public void eliminar(T dato) {
        raiz = eliminarRec(raiz, dato);
    }

    private INodo<T> eliminarRec(INodo<T> nodo, T dato) {
        if (nodo == null) return null;

        int cmp = comparador.compare(dato, nodo.getDato());
        
        if (cmp < 0) {
        	nodo.setIzquierdo(eliminarRec(nodo.getIzquierdo(), dato));
        } else if (cmp > 0) {
        	nodo.setDerecho(eliminarRec(nodo.getDerecho(), dato));
        }
        /*
        if (dato.getDni() < nodo.getDato().getDni()){
            nodo.setIzquierdo(eliminarRec(nodo.getIzquierdo(), dato));
        } else if (dato.getDni() > nodo.getDato().getDni()) {
            nodo.setDerecho(eliminarRec(nodo.getDerecho(), dato));
        } 
        */
        else {
            // Caso 1: nodo sin hijos
            if (nodo.getIzquierdo() == null && nodo.getDerecho() == null) {
                return null;
            }
            // Caso 2: un solo hijo
            if (nodo.getIzquierdo() == null) {
                return nodo.getDerecho();
            }
            if (nodo.getDerecho() == null) {
                return nodo.getIzquierdo();
            }

            // Caso 3: dos hijos
            INodo<T> sucesor = encontrarMinimo(nodo.getDerecho());
            nodo.setDato(sucesor.getDato());
            nodo.setDerecho(eliminarRec(nodo.getDerecho(), sucesor.getDato()));
        }
        return nodo;
    }
    private INodo<T> encontrarMinimo(INodo<T> nodo) {
        while (nodo.getIzquierdo() != null) {
            nodo = nodo.getIzquierdo();
        }
        return nodo;
    }
    
    @Override
    public void recorridoInorden() {
        inordenRec(raiz);
    }

    private void inordenRec(INodo<T> nodo) {
        if (nodo != null) {
            inordenRec(nodo.getIzquierdo());
            System.out.print(nodo.getDato() + " ");
            inordenRec(nodo.getDerecho());
        }
    }

    @Override
    public void recorridoPreorden() {
        preordenRec(raiz);
    }

    private void preordenRec(INodo<T> nodo) {
        if (nodo != null) {
            System.out.print(nodo.getDato() + " ");
            preordenRec(nodo.getIzquierdo());
            preordenRec(nodo.getDerecho());
        }
    }

    @Override
    public void recorridoPostorden() {
        postordenRec(raiz);
    }

    private void postordenRec(INodo<T> nodo) {
        if (nodo != null) {
            postordenRec(nodo.getIzquierdo());
            postordenRec(nodo.getDerecho());
            System.out.print(nodo.getDato() + " ");
        }
    }
    
    
}