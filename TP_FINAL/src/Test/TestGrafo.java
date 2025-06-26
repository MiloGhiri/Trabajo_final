package Test;

import java.util.Scanner;
import model.Dijkstra;
import model.ControladorDeRutas;
import interfaces.IContraladorDeRutas;
import interfaces.INodo;
import model.GrafoMatriz;
import java.util.Arrays;
import java.util.List;
import model.Nodo;

public class TestGrafo {

    public static void main(String[] args) {
        String[] nombresAeropuertos = {
            "Ezeiza (EZE)",    // 0
            "Córdoba (COR)",   // 1
            "Mendoza (MDZ)",   // 2
            "Miami (MIA)",     // 3
            "Madrid (MAD)",    // 4
            "São Paulo (GRU)", // 5
            "Londres (LHR)"    // 6
        };

        int cantidad = nombresAeropuertos.length;

        // Crear nodos
        @SuppressWarnings("unchecked")
        INodo<String>[] aeropuertos = new INodo[cantidad];
        for (int i = 0; i < cantidad; i++) {
            aeropuertos[i] = new Nodo<>(nombresAeropuertos[i], i);
        }

        // Crear grafo
        GrafoMatriz<String> grafo = new GrafoMatriz<>(cantidad);

        // Insertar aristas con nodos
        grafo.insertarArista(aeropuertos[0], aeropuertos[1], 100);   // EZE ↔ COR
        grafo.insertarArista(aeropuertos[0], aeropuertos[2], 180);   // EZE ↔ MDZ
        grafo.insertarArista(aeropuertos[0], aeropuertos[3], 900);   // EZE ↔ MIA
        grafo.insertarArista(aeropuertos[0], aeropuertos[5], 320);   // EZE ↔ GRU
        grafo.insertarArista(aeropuertos[3], aeropuertos[4], 700);   // MIA ↔ MAD
        grafo.insertarArista(aeropuertos[4], aeropuertos[6], 200);   // MAD ↔ LHR
        grafo.insertarArista(aeropuertos[1], aeropuertos[5], 400);   // COR ↔ GRU
        grafo.insertarArista(aeropuertos[2], aeropuertos[4], 1000);  // MDZ ↔ MAD

        Scanner scanner = new Scanner(System.in);
        IContraladorDeRutas<String> controlador = new ControladorDeRutas<>();

        // Pedir al usuario el nodo de origen
        List<INodo<String>> listaAeropuertos = Arrays.asList(aeropuertos);
        INodo<String> nodoOrigen = controlador.pedirOrigenUsuario(listaAeropuertos, scanner);

        // Calcular rutas
        Dijkstra dijkstra = new Dijkstra();
        int[] distancias = dijkstra.calcularRutaMasCorta(grafo, nodoOrigen);

        int umbral = 1000;
        controlador.mostrarResultados(distancias, nodoOrigen, listaAeropuertos, umbral);

        scanner.close();
    }
}