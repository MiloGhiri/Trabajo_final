package interfaces;
import java.util.Scanner;


public interface IContraladorDeRutas {

    public int pedirOrigenUsuario(String[] aeropuertos, Scanner scanner);
    public void mostrarResultados(int[] distancias, int origen, String[] aeropuertos, int umbral);

    
}
