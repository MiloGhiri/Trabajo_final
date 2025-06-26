package model;
import interfaces.IArticulacion;



public class Articulacion implements IArticulacion {

    private static int tiempo;

    public void encontrarPuntos(GrafoMatriz grafo) {
        int n = grafo.numeroDeVertices();
        boolean[] visitado = new boolean[n];
        int[] tiempoDescubrimiento = new int[n];
        int[] tiempoBajo = new int[n];
        int[] padre = new int[n];

        // Inicializar arrays
        for (int i = 0; i < n; i++) {
            padre[i] = -1;
            visitado[i] = false;
        }

        tiempo = 0;

        for (int u = 0; u < n; u++) {
            if (!visitado[u]) {
                dfs(grafo, u, visitado, tiempoDescubrimiento, tiempoBajo, padre);
            }
        }
        System.out.println(" El método encontrarPuntos fue invocado correctamente.");
    }

    public void dfs(GrafoMatriz grafo, int u, boolean[] visitado, int[] tDesc, int[] tBajo, int[] padre) {
        visitado[u] = true;
        tDesc[u] = tBajo[u] = ++tiempo;
        int hijos = 0;

        for (int v = 0; v < grafo.numeroDeVertices(); v++) {
            if (grafo.adyacente(u, v)) {
                if (!visitado[v]) {
                    hijos++;
                    padre[v] = u;
                    dfs(grafo, v, visitado, tDesc, tBajo, padre);

                    tBajo[u] = Math.min(tBajo[u], tBajo[v]);

                    if (padre[u] == -1 && hijos > 1) {
                        System.out.println(" Nodo " + u + " es punto de articulación (raíz)");
                    }

                    if (padre[u] != -1 && tBajo[v] >= tDesc[u]) {
                        System.out.println(" Nodo " + u + " es punto de articulación");
                    }

                } else if (v != padre[u]) {
                    tBajo[u] = Math.min(tBajo[u], tDesc[v]);
                }
            }
        }
    }


    // Gets and Setters

    @Override
    public int getTiempo() {
        return tiempo;
    }


    @Override
    public void setTiempo(int tiempo) {
        Articulacion.tiempo = tiempo;
    }

}


