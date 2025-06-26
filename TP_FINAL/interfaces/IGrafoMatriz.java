package interfaces;



public interface IGrafoMatriz {

    public void insertarArista(int origen, int destino, int peso);

    public boolean adyacente(int origen, int destino);

    public int numeroDeVertices();

    public int[][] getMatriz();

    public int[][] getMatrizAdy();


    public void setMatrizAdy(int[][] matrizAdy);

    public int getNumVertices();

    public void setNumVertices(int numVertices);
    
}
