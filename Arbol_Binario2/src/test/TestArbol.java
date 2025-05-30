package test;


import modelo.Persona;
import modelo.Arbol;

import java.util.Comparator;

public class TestArbol {

    public static void main(String[] args) {
        // Comparador compuesto: primero por nombre, luego por DNI
        Comparator<Persona> comparadorNombreDni = Comparator
                .comparing(Persona::getNombre)
                .thenComparingInt(Persona::getDni);

        // Crear el árbol con ese comparador
        Arbol<Persona> arbol = new Arbol<>(comparadorNombreDni);
        
        
        //Crear Personas
        Persona p1 = new Persona(123, "Felipe");
        Persona p2 = new Persona(328, "Jose");
        Persona p3 = new Persona(487, "Hernan");
        Persona p4 = new Persona(593, "Martin");
        Persona p5 = new Persona(759, "Oracio");
        Persona p6 = new Persona(698, "Marta");
        Persona p7 = new Persona(578, "Clara");
        Persona p8 = new Persona(180, "Anabel");// mismo nombre, menor DNI
        Persona p9 = new Persona(235, "Anabel");// mismo nombre, mayor DNI
        Persona p10 = new Persona(153, "Agustin");
        Persona p11 = new Persona(675, "Benito");
        Persona p12 = new Persona(900, "Silva");
        Persona p13 = new Persona(800, "Gianina");
        Persona p14 = new Persona(957, "Juan");
        Persona p15 = new Persona(850, "Brayan");

        
        // Insertar personas
        arbol.insertar(p1);
        arbol.insertar(p2);
        arbol.insertar(p3);
        arbol.insertar(p4);
        arbol.insertar(p5);
        arbol.insertar(p6);
        arbol.insertar(p7);
        arbol.insertar(p8);
        arbol.insertar(p9);
        arbol.insertar(p10);
        arbol.insertar(p11);
        arbol.insertar(p12);
        arbol.insertar(p13);
        arbol.insertar(p14);
        arbol.insertar(p15);

        
        // Mostrar árbol inorden
        System.out.println("Recorrido inorden (nombre + DNI):");
        arbol.recorridoInorden();

        // Buscar por nombre y DNI
        System.out.println("\nBuscando a Agustin con DNI 153:");
        if (arbol.buscar(p10) != null) {
            System.out.println("Persona encontrada.");
        } else {
            System.out.println("Persona no encontrada.");
        }

        // Eliminar a Anabel con DNI 180
        System.out.println("\nEliminando a Anabel con DNI 180:");
        arbol.eliminar(p8);

        // Verificar que la otra Anabel sigue (con inorden)
        System.out.println("Recorrido inorden después de eliminar:");
        arbol.recorridoInorden();
        
        // Mostrar árbol preorden
        System.out.println("\nRecorrido preorden (nombre + DNI):");
        arbol.recorridoPreorden();
        
        // Mostrar árbol inorden
        System.out.println("\nRecorrido postorden (nombre + DNI):");
        arbol.recorridoPostorden();

        
    }
	
}
