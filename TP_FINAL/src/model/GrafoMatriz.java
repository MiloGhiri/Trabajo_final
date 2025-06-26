package model;

import interfaces.IGrafoMatriz;
import interfaces.INodo;

public class GrafoMatriz<T> implements IGrafoMatriz<T> {

    private int[][] matrizAdy;
    private int numVertices;

    public GrafoMatriz(int numVertices) {
        this.numVertices = numVertices;
        matrizAdy = new int[numVertices][numVertices];
    }

    // Método auxiliar para obtener índices
    private int[] obtenerIndices(INodo<T> origen, INodo<T> destino) {
        return new int[]{origen.getIndice(), destino.getIndice()};
    }

    @Override
    public void insertarArista(INodo<T> origen, INodo<T> destino, int peso) {
        int[] indices = obtenerIndices(origen, destino);
        matrizAdy[indices[0]][indices[1]] = peso;
        matrizAdy[indices[1]][indices[0]] = peso;
    }

    @Override
    public boolean adyacente(INodo<T> origen, INodo<T> destino) {
        int[] indices = obtenerIndices(origen, destino);
        return matrizAdy[indices[0]][indices[1]] > 0;
    }
    
    @Override
    public boolean adyacente(int origen, int destino) {
        return matrizAdy[origen][destino] > 0;
    }

    @Override
    public int numeroDeVertices() {
        return numVertices;
    }

    @Override
    public int[][] getMatrizAdy() {
        return matrizAdy;
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