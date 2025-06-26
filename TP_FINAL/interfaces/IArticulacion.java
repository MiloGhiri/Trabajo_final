package interfaces;
import model.GrafoMatriz;

public interface IArticulacion {

    public void encontrarPuntos(GrafoMatriz grafo);
    void dfs(GrafoMatriz grafo, int u, boolean[] visitado, int[] tDesc, int[] tBajo, int[] padre);
    public int getTiempo();
    public void setTiempo(int tiempo);

    
    
}
