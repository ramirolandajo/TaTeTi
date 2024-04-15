package com.desarrolloApps.tateti;

import android.util.Log;

public class TaTeTi {
    private final String[][] tablero = new String[3][3];
    private int contadorMovimientos;

    //Constructor
    public TaTeTi(String eleccionJugador) {
        contadorMovimientos = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                tablero[i][j] = " ";
            }
        }
    }

    //Getter y Setter
    public String getCasillero(int fila, int columna){
        return this.tablero[fila][columna];
    }

    public int getContadorMovimientos() { return this.contadorMovimientos; }

    //Metodos de la clase
    public void marcarCasillero(int posicion, String marca){
        // parseamos la posicion a coordenadas de la matriz
        int fila = ((posicion-1) / 3);
        int columna = (posicion-1) % 3;

        //marcar una posicion del tablero
        this.tablero[fila][columna] = marca;
        this.contadorMovimientos++;
    }

    public int[] moverComputadora(String eleccionJugador){
        int posicion = (int) (1 + Math.random() * 9);
        int fila = ((posicion-1) / 3);
        int columna = (posicion-1) % 3;

        while(!this.tablero[fila][columna].equals(" ")){
            posicion = (int) (1 + Math.random() * 9);
            fila = ((posicion-1) / 3);
            columna = (posicion-1) % 3;
        }

        int[] posiciones = new int[2];
        posiciones[0] = fila;
        posiciones[1] = columna;

        if (eleccionJugador.equals("O")) {
            marcarCasillero(posicion, "X");
        }
        else {
            marcarCasillero(posicion, "O");
        }
        return posiciones;
    }

    //Este metodo va a llamar a los 3 metodos que verifican filas, columnas y diagonales
    public boolean hayGanador(){

        //Si alguno da true este metodo devuelve true. Si no false
        if (verificarDiagonales() || verificarFilas() || verificarColumnas()){
            return true;
        }else {
            return false;
        }

    }

    public boolean hayEmpate(){

        //Si alguno da true este metodo devuelve true. Si no false
        return !hayGanador() && contadorMovimientos == 9;

    }

    public void reiniciar() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                tablero[i][j] = " ";
                contadorMovimientos = 0;
            }
        }
    }

    public boolean verificarColumnas(){
        for (int i = 0; i < 3; i++) {
            if (tablero[0][i].equals(tablero[1][i]) && tablero[0][i].equals(tablero[2][i]) && !tablero[0][i].equals(" ")) {
                return true;
            }
        }
        return false;
    }

    public boolean verificarFilas(){
        for (int i = 0; i < 3; i++) {
            if (tablero[i][0].equals(tablero[i][1]) && tablero[i][0].equals(tablero[i][2]) && !tablero[i][0].equals(" ")) {
                return true;
            }
        }
        return false;
    }

    public boolean verificarDiagonales(){
        //verificamos diagonal izq
        if (tablero[0][0].equals(tablero[1][1]) && tablero[0][0].equals(tablero[2][2]) && !tablero[1][1].equals(" ")) {
            return true;
        }

        //verificamos diagonal derecha
        if (tablero[0][2].equals(tablero[1][1]) && tablero[0][2].equals(tablero[2][0]) && !tablero[1][1].equals(" ")) {
            return true;
        }
        return false;
    }
}
