package model;


import interfaces.IGrafoMatriz;

public class GrafoMatriz implements IGrafoMatriz {
    private int[][] matrizAdy;
    private int numVertices;

    public GrafoMatriz(int numVertices) {
        this.numVertices = numVertices;
        matrizAdy = new int[numVertices][numVertices];
    }

    public void insertarArista(int origen, int destino, int peso) {
        matrizAdy[origen][destino] = peso;
        matrizAdy[destino][origen] = peso; // bidireccional
    }

    public boolean adyacente(int origen, int destino) {
        return matrizAdy[origen][destino] > 0;
    }

    public int numeroDeVertices() {
        return numVertices;
    }

    public int[][] getMatriz() {
        return matrizAdy;
    }


    // Get and Setters
    @Override
    public int[][] getMatrizAdy() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void setMatrizAdy(int[][] matrizAdy) {
        this.matrizAdy = matrizAdy;
    }

    @Override
    public int getNumVertices() {
        return numVertices;
    }

    @Override
    public void setNumVertices(int numVertices) {
        this.numVertices = numVertices;
    }

}

