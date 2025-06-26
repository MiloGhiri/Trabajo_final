package interfaces;

public interface IDijkstra {
    <T> int[] calcularRutaMasCorta(IGrafoMatriz<T> grafo, INodo<T> origen);
}