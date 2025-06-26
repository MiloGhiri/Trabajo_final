package model;
import java.util.Scanner;

public class ControladorDeRutas {

    public static int pedirOrigenUsuario(String[] aeropuertos, Scanner scanner) {
        System.out.println("Ingrese el número del aeropuerto de origen:");
        for (int i = 0; i < aeropuertos.length; i++) {
            System.out.println(i + " - " + aeropuertos[i]);
        }

        int origen;
        while (true) {
            System.out.print(" --> Su elección: ");
            origen = scanner.nextInt();
            if (origen >= 0 && origen < aeropuertos.length) {
                return origen;
            }
            System.out.println("Número inválido. Intente de nuevo.");
        }
    }

    public static void mostrarResultados(int[] distancias, int origen, String[] aeropuertos, int umbral) {
        System.out.println("\n Resultados desde " + aeropuertos[origen] + ":\n");

        for (int i = 0; i < distancias.length; i++) {
            if (i == origen) continue;

            String destino = aeropuertos[i];
            int costo = distancias[i];

            if (costo == Integer.MAX_VALUE) {
                System.out.println(" No hay ruta disponible a " + destino);
            } else if (costo > umbral) {
                System.out.println(" Ruta a " + destino + " cuesta " + costo + " -->  No conviene ");
            } else {
                System.out.println(" Ruta a " + destino + " cuesta " + costo + " --> Conviene ");
            }
        }
    }

    
}

