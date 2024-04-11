package com.desarrolloApps.tateti;

public class TaTeTi {
    private char[][] tablero = new char[3][3];
    private char turno;

    //Constructor


    public TaTeTi() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                tablero[i][j] = ' ';
            }
        }
    }

    //Getter y Setter
    public char getCasillero(int fila, int columna){
        return this.tablero[fila][columna];
    }

    public char getTurno(){
        return this.turno;
    }

    public void setCasillero(int fila, int columna, char valor){
        //marcar una posicion del tabelro
        this.tablero[fila][columna] = valor;
    }

    public void setTurno(char jugador){
        this.turno = jugador;
    }
    //Metodos de la clase

    //Este metodo va a llamar a los 3 metodos que verifican horizontal, vertical y diagonal
    public boolean chequearGanador(int fila,int columna,char valor){

        //Si alguno da true este metodo devuelve true. Si no false

        if (verificarDiagonales(fila, columna) || verificarHorizontal(fila, columna) ||
                verificarVertical(fila, columna)){
            return true;
        }else {
            return false;
        }


    }

    public boolean verificarVertical(int fila,int columna){
        for (int i = 0; i < 3; i++) {
            if (tablero[0][i] == tablero[1][i] && tablero[2][i] == tablero[0][i] && tablero[0][i] != ' ') {
                return true;
            }
        }
        return false;
    }

    public boolean verificarHorizontal(int fila,int columna){
        for (int i = 0; i < 3; i++) {
            if (tablero[i][0] == tablero[i][1] && tablero[i][2] == tablero[0][i] && tablero[0][i] != ' ') {
                return true;
            }
        }
        return false;
    }

    public boolean verificarDiagonales(int fila,int columna){
        //verificamos diagonal izq
        if (tablero[0][0] == tablero[1][1] && tablero[2][2] == tablero[0][0] && tablero[0][0] != ' ') {
            return true;
        }

        //verificamos diagonal derecha
        if (tablero[0][2] == tablero[1][1] && tablero[2][0] == tablero[0][2] && tablero[0][2] != ' ') {
            return true;
        }
        return false;
    }
}
