package Test;

import java.util.Scanner;
import java.util.Arrays;
import java.util.List;

import model.Dijkstra;
import model.ControladorDeRutas;
import interfaces.IContraladorDeRutas;
import interfaces.INodo;
import model.GrafoMatriz;
import model.Nodo;


public class TestGrafoNum {
	
    public static void main(String[] args) {
        // Nombres reemplazados por IDs de aeropuerto (ej. códigos internos)
        Integer[] codigosAeropuertos = {
            101, 102, 103, 104, 105, 106, 107
        };

        int cantidad = codigosAeropuertos.length;

        // Crear nodos con tipo Integer
        @SuppressWarnings("unchecked")
        INodo<Integer>[] aeropuertos = new INodo[cantidad];
        for (int i = 0; i < cantidad; i++) {
            aeropuertos[i] = new Nodo<>(codigosAeropuertos[i], i);
        }

        // Crear grafo
        GrafoMatriz<Integer> grafo = new GrafoMatriz<>(cantidad);

        // Insertar aristas
        grafo.insertarArista(aeropuertos[0], aeropuertos[1], 100);
        grafo.insertarArista(aeropuertos[0], aeropuertos[2], 180);
        grafo.insertarArista(aeropuertos[0], aeropuertos[3], 900);
        grafo.insertarArista(aeropuertos[0], aeropuertos[5], 320);
        grafo.insertarArista(aeropuertos[3], aeropuertos[4], 700);
        grafo.insertarArista(aeropuertos[4], aeropuertos[6], 200);
        grafo.insertarArista(aeropuertos[1], aeropuertos[5], 400);
        grafo.insertarArista(aeropuertos[2], aeropuertos[4], 1000);

        Scanner scanner = new Scanner(System.in);
        IContraladorDeRutas<Integer> controlador = new ControladorDeRutas<>();

        // Convertir array a lista para pasárselo al controlador
        List<INodo<Integer>> listaAeropuertos = Arrays.asList(aeropuertos);
        INodo<Integer> nodoOrigen = controlador.pedirOrigenUsuario(listaAeropuertos, scanner);

        // Calcular rutas
        Dijkstra dijkstra = new Dijkstra();
        int[] distancias = dijkstra.calcularRutaMasCorta(grafo, nodoOrigen);

        int umbral = 1000;
        controlador.mostrarResultados(distancias, nodoOrigen, listaAeropuertos, umbral);

        scanner.close();
    }
}


