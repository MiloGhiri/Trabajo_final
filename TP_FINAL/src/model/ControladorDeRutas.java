package model;

import java.util.List;
import java.util.Scanner;

import interfaces.IContraladorDeRutas;
import interfaces.INodo;

public class ControladorDeRutas<T> implements IContraladorDeRutas<T> {

    @Override
    public INodo<T> pedirOrigenUsuario(List<INodo<T>> nodos, Scanner scanner) {
        System.out.println("Ingrese el número del aeropuerto de origen:");
        for (INodo<T> nodo : nodos) {
            System.out.println(nodo.getIndice() + " - " + nodo.getDato());
        }

        int indice;
        while (true) {
            System.out.print(" --> Su elección: ");
            indice = scanner.nextInt();
            for (INodo<T> nodo : nodos) {
                if (nodo.getIndice() == indice) {
                    return nodo;
                }
            }
            System.out.println("Número inválido. Intente de nuevo.");
        }
    }

    @Override
    public void mostrarResultados(int[] distancias, INodo<T> origen, List<INodo<T>> nodos, int umbral) {
        System.out.println("\nResultados desde " + origen.getDato() + ":\n");

        for (INodo<T> destino : nodos) {
            if (destino.getIndice() == origen.getIndice()) continue;

            int costo = distancias[destino.getIndice()];
            String info = "Ruta a " + destino.getDato() + " cuesta ";

            if (costo == Integer.MAX_VALUE) {
                System.out.println(" No hay ruta disponible a " + destino.getDato());
            } else if (costo > umbral) {
                System.out.println(info + costo + " --> No conviene");
            } else {
                System.out.println(info + costo + " --> Conviene");
            }
        }
    }
}
