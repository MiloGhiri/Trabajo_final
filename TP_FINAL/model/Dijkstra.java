package model;
import interfaces.IDijkstra;
import java.util.Arrays;

public class Dijkstra implements IDijkstra {

    public int[] calcularRutaMasCorta(GrafoMatriz grafo, int origen) {
        int n = grafo.numeroDeVertices();
        int[] distancia = new int[n];
        boolean[] visitado = new boolean[n];

        Arrays.fill(distancia, Integer.MAX_VALUE);
        distancia[origen] = 0;

        for (int i = 0; i < n - 1; i++) {
            int u = minimoDistancia(distancia, visitado);
            visitado[u] = true;

            for (int v = 0; v < n; v++) {
                if (!visitado[v] &&
                        grafo.adyacente(u, v) &&
                        distancia[u] != Integer.MAX_VALUE &&
                        distancia[u] + grafo.getMatriz()[u][v] < distancia[v]) {
                    distancia[v] = distancia[u] + grafo.getMatriz()[u][v];
                }
            }
        }

        return distancia;
    }

    public int minimoDistancia(int[] distancia, boolean[] visitado) {
        int min = Integer.MAX_VALUE;
        int minIndex = -1;

        for (int v = 0; v < distancia.length; v++) {
            if (!visitado[v] && distancia[v] < min) {
                min = distancia[v];
                minIndex = v;
            }
        }

        return minIndex;
    }

    


}
