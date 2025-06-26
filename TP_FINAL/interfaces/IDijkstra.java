package interfaces;
import model.GrafoMatriz;

public interface IDijkstra {

    public int[] calcularRutaMasCorta(GrafoMatriz grafo, int origen);
    int minimoDistancia(int[] distancia, boolean[] visitado);



    
}
