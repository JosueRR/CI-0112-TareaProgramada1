
/**
 * Clase JugadasJugadorVirtual: contiene el método que selecciona una columna automáticamente
 * 
 * @author Josué RR
 * @version 1
 */

public class JugadorVirtual {
    //Variables que almacenan el contenido de diferentes posiciones de la matriz tablero 
    static String posicion1 = "";
    static String posicion2 = "";
    static String posicion3 = "";
    static String posicion4 = "";
    //Variable que almacena la columna elegida por el jugador virtual
    static int columnaSeleccionada;
    
    /**
     * Método que selecciona una columna al azar
     * @return Retorna un int con el valor de la columna
     */
    public static int eleccionAzar() {
        columnaSeleccionada = (int) (Math.random() * 7);
        return columnaSeleccionada;
    }
    
     
    /**
     * Método que por medio de otros métodos decide cuál columna debe ser seleccionada
     * @return Retorna un int correspondiente a la columna seleccionada
     */
    public static int eleccionColumna(String matrizTablero[][]) {
        if ((victoriaHorizontal(matrizTablero)) != 0) {
            return victoriaHorizontal(matrizTablero);
        }
        if ((victoriaVertical(matrizTablero)) != 0) {
            return victoriaVertical(matrizTablero);
        }
        if ((victoriaDiagonal(matrizTablero)) != 0) {
            return victoriaDiagonal(matrizTablero);
        }
        return eleccionAzar();
    }
    
    /**
     * Método que compara 4 fichas y verifica si son iguales y alguna tiene un espacio vacío
     * @return Retorna un valor booleano en caso de sí o no ser cumplir con los requisitos
     */
    public static boolean comparacionFichas(String posicion1, String posicion2,String posicion3,String posicion4) {
       boolean fichasIguales = false;
       try {
            if (posicion1.equals(posicion2) && posicion3.equals(posicion1) && posicion4 == null) {
                return fichasIguales = true;
            }
            if (posicion1.equals(posicion2) && posicion4.equals(posicion1) && posicion3 == null) {
                return fichasIguales = true;
            } 
            if (posicion1.equals(posicion3) && posicion4.equals(posicion1) && posicion2 == null) {
                return fichasIguales = true;
            }
            if (posicion2.equals(posicion3) && posicion4.equals(posicion2) && posicion1 == null) {
                return fichasIguales = true;
            }
            return fichasIguales;
       }
       catch (NullPointerException errorNull) {
            return fichasIguales;
       }
    }
    
    /**
     * Método que recorre la matriz Tablero en grupos de 4 de forma horizontal
     * @return Retorna un int correspondiente a la columna seleccionada
     * retorna 0 en caso de no encontrarse una columna válida
     */
    public static int victoriaHorizontal(String matrizTablero[][]) {
        //Ciclo que recorre la matriz en forma horizontal
        for (int filas = 0; filas < 6; filas++) {
           for (int columnas = 0; columnas < 4; columnas++) {
               
               posicion1 = matrizTablero[filas][columnas];
               posicion2 = matrizTablero[filas][columnas + 1];
               posicion3 = matrizTablero[filas][columnas + 2]; 
               posicion4 = matrizTablero[filas][columnas + 3];
               
               //if anudados para detectar en qué posición se debe poner la ficha
               if (comparacionFichas(posicion1, posicion2, posicion3, posicion4) == true) {
                   if (posicion1 == null) {
                       columnaSeleccionada = columnas;
                       return columnaSeleccionada;
                   }
                   if (posicion2 == null) {
                       columnaSeleccionada = columnas + 1;
                       return columnaSeleccionada;
                   }
                   if (posicion3 == null) {
                       columnaSeleccionada = columnas + 2;
                       return columnaSeleccionada;
                   }
                   if (posicion4 == null) {
                       columnaSeleccionada = columnas + 3;
                       return columnaSeleccionada;
                   }
               }
           }
        }
        return 0;
    }
    
    /**
     * Método que recorre la matriz Tablero en grupos de 4 de forma vertical
     * @return Retorna un int correspondiente a la columna seleccionada
     * retorna 0 en caso de no encontrarse una columna válida
     */
    public static int victoriaVertical(String matrizTablero[][]) {
        //Ciclo que recorre la matriz en forma vertical
        for (int columnas = 0; columnas < 7; columnas++) {
           for (int filas = 0; filas < 3; filas++) {
               
               posicion1 = matrizTablero[filas][columnas];
               posicion2 = matrizTablero[filas + 1][columnas];
               posicion3 = matrizTablero[filas + 2][columnas]; 
               posicion4 = matrizTablero[filas + 3][columnas];
               
               //if para detectar en qué posición se debe poner la ficha
               if (comparacionFichas(posicion1, posicion2, posicion3, posicion4) == true) {
                   columnaSeleccionada = columnas;
                   return columnaSeleccionada;
               }
           }
        }
        return 0;
    }
    
    /**
     * Método que recorre la matriz Tablero en grupos de 4 de forma diagonal ascendente
     * @return Retorna un int correspondiente a la columna seleccionada 
     * retorna 0 en caso de no encontrarse una columna válida
     */
    public static int victoriaDiagonal(String matrizTablero[][]) {
        //Ciclo que recorre la matriz en forma diagonal ascendente hacia la derecha 
        for (int filas = 3; filas < 6; filas++){
           for (int columnas = 0; columnas < 7 - 3; columnas++){
                    
              posicion1 = matrizTablero[filas][columnas];
              posicion2 = matrizTablero[filas - 1][columnas + 1];
              posicion3 = matrizTablero[filas - 2][columnas + 2];
              posicion4 = matrizTablero[filas - 3][columnas + 3];
                    
              //if anudados para detectar en qué posición se debe poner la ficha      
              if (comparacionFichas(posicion1, posicion2, posicion3, posicion4) == true) {
                 if (posicion1 == null) {
                           columnaSeleccionada = columnas;
                           return columnaSeleccionada;
                 }
                 if (posicion2 == null) {
                           columnaSeleccionada = columnas + 1;
                           return columnaSeleccionada;
                 }
                 if (posicion3 == null) {
                           columnaSeleccionada = columnas + 2;
                           return columnaSeleccionada;
                 }
                 if (posicion4 == null) {
                           columnaSeleccionada = columnas + 3;
                           return columnaSeleccionada;
                 }
              }
           }
        }
            
        //Ciclo que recorre la matriz en forma diagonal ascendente hacia la izquierda
        for (int filas = 3; filas < 6; filas++){
            for (int columnas = 6; columnas < 7 - 5; columnas--){
                  
               posicion1 = matrizTablero[filas][columnas];
               posicion2 = matrizTablero[filas - 1][columnas - 1];
               posicion3 = matrizTablero[filas - 2][columnas - 2];
               posicion4 = matrizTablero[filas - 3][columnas - 3];
                    
               //if anudados para detectar en qué posición se debe poner la ficha     
               if (comparacionFichas(posicion1, posicion2, posicion3, posicion4) == true) {
                   if (posicion1 == null) {
                      columnaSeleccionada = columnas;
                      return columnaSeleccionada;
                   }
                   if (posicion2 == null) {
                      columnaSeleccionada = columnas - 1;
                      return columnaSeleccionada;
                   }
                   if (posicion3 == null) {
                      columnaSeleccionada = columnas - 2;
                      return columnaSeleccionada;
                   }
                   if (posicion4 == null) {
                      columnaSeleccionada = columnas - 3;
                      return columnaSeleccionada;
                   }
               }
           }
        }
        return 0;
    }
}
