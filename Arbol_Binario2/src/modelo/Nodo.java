package modelo;

import interfaces.INodo;

public class Nodo<T> implements INodo<T>{
	
	//Que la persona pueda ser cualquier cosa!
	
    private T dato;
    private INodo<T> izquierdo;
    private INodo<T> derecho;
	
    public Nodo(T dato) {
		super();
		this.dato = dato;
		this.izquierdo = null;
		this.derecho = null;
	}

	public T getDato() {
		return dato;
	}

	public void setDato(T dato) {
		this.dato = dato;
	}

	public INodo<T> getIzquierdo() {
		return izquierdo;
	}

	public void setIzquierdo(INodo<T> izquierdo) {
		this.izquierdo = izquierdo;
	}

	public INodo<T> getDerecho() {
		return derecho;
	}

	public void setDerecho(INodo<T> derecho) {
		this.derecho = derecho;
	}

    
    
}
