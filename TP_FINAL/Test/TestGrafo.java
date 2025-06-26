package Test;

import java.util.Scanner;
import model.Dijkstra;
import model.ControladorDeRutas;
import model.GrafoMatriz;

public class TestGrafo {

    public static void main(String[] args) {
        String[] aeropuertos = {
            "Ezeiza (EZE)",    // 0
            "Córdoba (COR)",   // 1
            "Mendoza (MDZ)",   // 2
            "Miami (MIA)",     // 3
            "Madrid (MAD)",    // 4
            "São Paulo (GRU)", // 5
            "Londres (LHR)"    // 6
        };

        GrafoMatriz grafo = new GrafoMatriz(aeropuertos.length);

        // Rutas aéreas simuladas (peso = costo o tiempo)
        grafo.insertarArista(0, 1, 100);   // EZE ↔ COR
        grafo.insertarArista(0, 2, 180);   // EZE ↔ MDZ
        grafo.insertarArista(0, 3, 900);   // EZE ↔ MIA
        grafo.insertarArista(0, 5, 320);   // EZE ↔ GRU
        grafo.insertarArista(3, 4, 700);   // MIA ↔ MAD
        grafo.insertarArista(4, 6, 200);   // MAD ↔ LHR
        grafo.insertarArista(1, 5, 400);   // COR ↔ GRU
        grafo.insertarArista(2, 4, 1000);  // MDZ ↔ MAD

        Scanner scanner = new Scanner(System.in);

        int origen = ControladorDeRutas.pedirOrigenUsuario(aeropuertos, scanner);

        Dijkstra dijkstra = new Dijkstra();
        int[] distancias = dijkstra.calcularRutaMasCorta(grafo, origen);

        int umbral = 1000;

        ControladorDeRutas.mostrarResultados(distancias, origen, aeropuertos, umbral);

        scanner.close();
    }
}
