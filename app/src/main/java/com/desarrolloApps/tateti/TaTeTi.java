package com.desarrolloApps.tateti;

public class TaTeTi {
    private final Character[][] tablero = new Character[3][3];
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

    public void marcarCasillero(int fila, int columna, char turnoActual){
        //marcar una posicion del tabelro
        this.tablero[fila][columna] = turnoActual;
        cambiarTurno();
    }

    //Metodos de la clase

    public void cambiarTurno(){

        if (this.turno == 'X') {
            this.turno = 'O';
        }else if (this.turno == 'O'){
            this.turno = 'X';
        }
    }

    public void  moverComputadora(){

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (getCasillero(i,j) != ' '){
                    marcarCasillero(i,j,turno);
                }
            }
        }
    }

    //Este metodo va a llamar a los 3 metodos que verifican horizontal, vertical y diagonal
    public Character chequearGanador(){

        //Si alguno da true este metodo devuelve true. Si no false

        if (verificarDiagonales() || verificarHorizontal() || verificarVertical()){
            return this.getTurno();
        }else {
            return null;
        }


    }

    public boolean verificarVertical(){
        for (int i = 0; i < 3; i++) {
            if (tablero[0][i] == tablero[1][i] && tablero[2][i] == tablero[0][i] && tablero[0][i] != ' ') {
                return true;
            }
        }
        return false;
    }

    public boolean verificarHorizontal(){
        for (int i = 0; i < 3; i++) {
            if (tablero[i][0] == tablero[i][1] && tablero[i][2] == tablero[0][i] && tablero[0][i] != ' ') {
                return true;
            }
        }
        return false;
    }

    public boolean verificarDiagonales(){
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
