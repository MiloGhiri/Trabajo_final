package interfaces;

import java.util.List;
import java.util.Scanner;

public interface IContraladorDeRutas<T> {

    INodo<T> pedirOrigenUsuario(List<INodo<T>> nodos, Scanner scanner);
    
    void mostrarResultados(int[] distancias, INodo<T> origen, List<INodo<T>> nodos, int umbral);
}
