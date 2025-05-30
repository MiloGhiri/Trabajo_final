package interfaces;


public interface IArbol<T> {

    void insertar(T dato);
    public void eliminar(T dato);
    INodo<T> buscar(T dato);
    
    void recorridoInorden();
    void recorridoPreorden();
    void recorridoPostorden();
    
    
}
