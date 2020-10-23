
/**
 * Clase VistaTablero: contiene el método que imprime el tablero
 * 
 * @author Josué RR
 * @version 1
 */

import javax.swing.JOptionPane;


public class VistaTablero {
    /**
     * Método que imprime el tablero en su forma actual
     */
    public void imprimirTablero(String matrizTablero[][]) {
        //Variable que almacena los strings de la matriz para imprimirla
        String matrizAlmacenadaImprimir = "";
        //Ciclo que recorre las filas de la matriz Tablero
        for (int filas = 0; filas < 6; filas++) {
               //Ciclo que recorre las columnas de la matriz Tablero
               for (int columnas = 0; columnas < 7; columnas++) {
                   if (matrizTablero[filas][columnas] == null) {
                      matrizAlmacenadaImprimir += "   ";
                   }
                   else {
                      matrizAlmacenadaImprimir += matrizTablero[filas][columnas];
                   }
                   matrizAlmacenadaImprimir += "    ";
               }
               matrizAlmacenadaImprimir += "\n";
        }
        //Despliegue de la matriz 
        JOptionPane.showMessageDialog(null, "0     1     2     3     4     5     6 \n" + matrizAlmacenadaImprimir);
    }

}
