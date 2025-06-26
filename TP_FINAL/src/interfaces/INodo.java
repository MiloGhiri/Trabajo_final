package interfaces;

public interface INodo<T> {
    T getDato();
    void setDato(T dato);
    
    int getIndice();
    void setIndice(int indice);
}