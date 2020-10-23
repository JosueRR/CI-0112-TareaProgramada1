
/**
 * Clase Tablero: contiene métodos realacionados al tablero del juego
 * 
 * @author Josué RR
 * @version 1
 */

public class Tablero {
    
   /**
    * Método para inicializar el tablero en blanco
    * @return Retorna el tablero en blanco
    */
   public static String[][] inicializaciónTablero() {
       String matrizTablero[][] = new String [6][7];
       for (int filas = 0; filas < 6; filas++) {
         for (int columnas = 0; columnas < 7; columnas++) {
               matrizTablero[filas][columnas] = null; 
         }
       }
       return matrizTablero;
   }
   
   /**
    * Método que verifica si aún quedan espacios en la matriz tablero
    * @return Retorna un valor booleano indicando si sí o no queda espacio
    */
   public static boolean verificarEspacio(String matrizTablero[][]) {
       boolean quedaEspacio = false;
        for (int filas = 0; filas < 6; filas++) {
             for (int columnas = 0; columnas < 7; columnas++) {
                if (matrizTablero[filas][columnas] == null) {
                       return quedaEspacio = true;
                }
                else {
                       quedaEspacio = false;
                }
         }
       }
       return quedaEspacio;
   }
   
   /**
    * Método para ingresar una ficha en el tablero
    * @return Retorna la matrizTablero actualizada 
    */
   public static String[][] agregarFichaTablero(String matrizTablero[][], int columnaDeseada, String jugadorActual) {
        for (int filas = 5; filas >= 0; filas = filas -1) {
           if ((matrizTablero[filas][columnaDeseada]) == null) {
               matrizTablero[filas][columnaDeseada] = jugadorActual;
               break;
           }
        }
        return matrizTablero;
   }
   
   /**
    * Método para verificar si la columna a ingresar una ficha se encuantra llena o vacía
    * @return Retorna valor booleano indicando si está o no llena
    */
   public static boolean verificarEspacioColumna(String matrizTablero[][],int columnaDeseada) {
       if (matrizTablero[0][columnaDeseada] == null) {
           return true;
       }
       else {
           return false;
       }
    }
}
