package interfaces;

public interface IGrafoMatriz<T> {
    void insertarArista(INodo<T> origen, INodo<T> destino, int peso);
    boolean adyacente(INodo<T> origen, INodo<T> destino);
    int numeroDeVertices();
    int[][] getMatrizAdy();
    void setMatrizAdy(int[][] matrizAdy);
    int getNumVertices();
    void setNumVertices(int numVertices);
    boolean adyacente(int origen, int destino);
}
