
/**
 * Clase CondicionesDeVictoria: contiene métodos que verifican si ya hay algún ganador según la condición de 4 en raya
 * 
 * @author Josué RR
 * @version 1
 */

public class CondicionesDeVictoria {
    //Variables que almacenan el contenido de diferentes posiciones de la matriz tablero 
    static String posicion1 = "";
    static String posicion2 = "";
    static String posicion3 = "";
    static String posicion4 = "";
    
    /**
     * Método que llama a todos los métodos que revisan las distintas formas de ganar
     * @return Retorna un valor booleano en caso de encontrarse algún ganador
     */
    public static boolean revisionGeneral(String matrizTablero[][], String jugadorActual) {
        if ((victoriaHorizontal(matrizTablero)) == true) {
            return true;
        }
        if ((victoriaVertical(matrizTablero)) == true) {
            return true;
        }
        if ((victoriaDiagonal(matrizTablero)) == true) {
            return true;
        }
        return false;
    }
    
    /**
     * Método que compara 4 fichas y verifica si son iguales
     * @return Retorna un valor booleano en caso de sí o no ser todas iguales
     */
    public static boolean comparacionFichas(String posicion1, String posicion2,String posicion3,String posicion4) {
       boolean fichasIguales = false;
       try {
            if (posicion1.equals(posicion2) && posicion3.equals(posicion4) && posicion2.equals(posicion3)) {
                fichasIguales = true;
            }
            return fichasIguales;
       }
       catch (NullPointerException errorNull) {
            return fichasIguales;
       }
    }
    
    /**
     * Método que recorre la matriz Tablero en grupos de 4 de forma horizontal
     * @return Retorna un valor booleano en caso de haber o no una victoria
     */
    public static boolean victoriaHorizontal(String matrizTablero[][]) {
        boolean victoria = false;
        //Ciclo que recorre la matriz en forma horizontal
        for (int filas = 0; filas < 6; filas++) {
           for (int columnas = 0; columnas < 4; columnas++) {
               
               posicion1 = matrizTablero[filas][columnas];
               posicion2 = matrizTablero[filas][columnas + 1];
               posicion3 = matrizTablero[filas][columnas + 2]; 
               posicion4 = matrizTablero[filas][columnas + 3];
               
               if (comparacionFichas(posicion1, posicion2, posicion3, posicion4) == true) {
                   return victoria = true;
               }
           }
        }
        return victoria;
    }
    
    /**
     * Método que recorre la matriz Tablero en grupos de 4 de forma vertical
     * @return Retorna un valor booleano en caso de haber o no una victoria 
     */
    public static boolean victoriaVertical(String matrizTablero[][]) {
        boolean victoria = false;
        //Ciclo que recorre la matriz en forma vertical
        for (int columnas = 0; columnas < 7; columnas++) {
           for (int filas = 0; filas < 3; filas++) {
               
               posicion1 = matrizTablero[filas][columnas];
               posicion2 = matrizTablero[filas + 1][columnas];
               posicion3 = matrizTablero[filas + 2][columnas]; 
               posicion4 = matrizTablero[filas + 3][columnas];
               
               if (comparacionFichas(posicion1, posicion2, posicion3, posicion4) == true) {
                   return victoria = true;
               }
           }
        }
        return victoria;
    }
    
    /**
     * Método que recorre la matriz Tablero en grupos de 4 de forma diagonal
     * @return Retorna un valor booleano en caso de haber o no una victoria
     */
    public static boolean victoriaDiagonal(String matrizTablero[][]) {
        //Ciclo que recorre la matriz en forma diagonal ascendente 
        for (int fila = 3; fila < 6; fila++) {
           for (int columna = 0; columna < 7 - 3 ; columna++) {
                    
              posicion1 = matrizTablero[fila][columna];
              posicion2 = matrizTablero[fila - 1][columna + 1];
              posicion3 = matrizTablero[fila - 2][columna + 2];
              posicion4 = matrizTablero[fila - 3][columna + 3];
                    
                    
              if (comparacionFichas(posicion1, posicion2, posicion3, posicion4)) {
                  return true; 
              }
           }
        }
            
        //Ciclo que recorre la matriz en forma diagonal descendente
        for (int fila = 3; fila < 6; fila++) {
           for (int columna = 6; columna > 7 - 5; columna--) {
                  
              posicion1 = matrizTablero[fila][columna];
              posicion2 = matrizTablero[fila - 1][columna - 1];
              posicion3 = matrizTablero[fila - 2][columna - 2];
              posicion4 = matrizTablero[fila - 3][columna - 3];
                    
                    
              if (comparacionFichas(posicion1, posicion2, posicion3, posicion4)) {
                        return true;
              }
           }
        }
        return false;
    }
}

