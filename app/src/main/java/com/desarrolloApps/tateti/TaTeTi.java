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
    public boolean ganador(int fila,int columna,char valor){

        //Si alguno da true este metodo devuelve true. Si no false

        if (verificarDiagonal(fila, columna) || verificarHorizontal(fila, columna) ||
                verificarVertical(fila, columna)){
            return true;
        }else {
            return false;
        }

    }

    public boolean verificarVertical(int fila,int columna){
        return false;
    }

    public boolean verificarHorizontal(int fila,int columna){
        return false;
    }

    public boolean verificarDiagonal(int fila,int columna){
        return false;
    }
}
