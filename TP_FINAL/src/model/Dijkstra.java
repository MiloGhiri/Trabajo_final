package model;

import interfaces.IDijkstra;
import interfaces.IGrafoMatriz;
import interfaces.INodo;

import java.util.Arrays;

public class Dijkstra implements IDijkstra {

    @Override
    public <T> int[] calcularRutaMasCorta(IGrafoMatriz<T> grafo, INodo<T> origen) {
        int n = grafo.numeroDeVertices();
        int[] distancia = new int[n];
        boolean[] visitado = new boolean[n];

        Arrays.fill(distancia, Integer.MAX_VALUE);
        distancia[origen.getIndice()] = 0;

        for (int i = 0; i < n - 1; i++) {
            int u = minimoDistancia(distancia, visitado);
            visitado[u] = true;

            for (int v = 0; v < n; v++) {
                if (!visitado[v] &&
                        grafo.adyacente(u, v) &&
                        distancia[u] != Integer.MAX_VALUE &&
                        distancia[u] + grafo.getMatrizAdy()[u][v] < distancia[v]) {
                    distancia[v] = distancia[u] + grafo.getMatrizAdy()[u][v];
                }
            }
        }

        return distancia;
    }

    private int minimoDistancia(int[] distancia, boolean[] visitado) {
        int min = Integer.MAX_VALUE;
        int minIndex = -1;

        for (int i = 0; i < distancia.length; i++) {
            if (!visitado[i] && distancia[i] < min) {
                min = distancia[i];
                minIndex = i;
            }
        }

        return minIndex;
    }
}
