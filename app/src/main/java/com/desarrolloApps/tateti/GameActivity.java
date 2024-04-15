package com.desarrolloApps.tateti;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class GameActivity extends AppCompatActivity {

    String nombreJugador, eleccionJugador;

    TextView playerName, mensajeGanador;

    TaTeTi controlJuego;

    Button btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, reiniciar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        nombreJugador = getIntent().getStringExtra("nombre");
        eleccionJugador = getIntent().getStringExtra("eleccion");
        playerName = findViewById(R.id.playerName);
        playerName.setText(getString(R.string.welcome_message, nombreJugador, eleccionJugador));

        controlJuego = new TaTeTi(eleccionJugador);

        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);
        btn4 = findViewById(R.id.btn4);
        btn5 = findViewById(R.id.btn5);
        btn6 = findViewById(R.id.btn6);
        btn7 = findViewById(R.id.btn7);
        btn8 = findViewById(R.id.btn8);
        btn9 = findViewById(R.id.btn9);

        Button[][] matrizTateti = new Button[3][3];
        matrizTateti[0][0] = btn1;
        matrizTateti[0][1] = btn2;
        matrizTateti[0][2] = btn3;
        matrizTateti[1][0] = btn4;
        matrizTateti[1][1] = btn5;
        matrizTateti[1][2] = btn6;
        matrizTateti[2][0] = btn7;
        matrizTateti[2][1] = btn8;
        matrizTateti[2][2] = btn9;
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                seleccionarBoton(v,1, matrizTateti);
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                seleccionarBoton(v,2, matrizTateti);
            }
        });
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                seleccionarBoton(v,3, matrizTateti);
            }
        });
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                seleccionarBoton(v,4, matrizTateti);
            }
        });
        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                seleccionarBoton(v,5, matrizTateti);
            }
        });
        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                seleccionarBoton(v,6, matrizTateti);
            }
        });
        btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                seleccionarBoton(v,7, matrizTateti);
            }
        });
        btn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                seleccionarBoton(v,8, matrizTateti);
            }
        });
        btn9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                seleccionarBoton(v,9, matrizTateti);
            }
        });

        reiniciar = findViewById(R.id.reset);
        reiniciar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for (int i = 0; i < 3; i++) {
                    for (int j = 0; j < 3; j++) {
                        matrizTateti[i][j].setText(" ");
                        matrizTateti[i][j].setEnabled(true);
                    }
                }
                mensajeGanador.setText("");
                controlJuego.reiniciar();
            }
        });
    }

    private void seleccionarBoton(View v, int posicion, Button[][] matrizTateti) {
        mensajeGanador = findViewById(R.id.win_text);

        Button seleccionado = (Button) v;
        if (eleccionJugador.equals("O"))
            seleccionado.setText("O");
        else
            seleccionado.setText("X");
        seleccionado.setEnabled(false);
        controlJuego.marcarCasillero(posicion, eleccionJugador);

        if (controlJuego.hayGanador()) {
            mensajeGanador.setText(getString(R.string.ganador, nombreJugador));
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    matrizTateti[i][j].setEnabled(false);
                }
            }
        } else if (controlJuego.hayEmpate()) {
            mensajeGanador.setText(getString(R.string.empate));
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    matrizTateti[i][j].setEnabled(false);
                }
            }
        } else {
            int[] posicionesComputadora = controlJuego.moverComputadora(eleccionJugador);
            if (eleccionJugador.equals("O")) {
                matrizTateti[posicionesComputadora[0]][posicionesComputadora[1]].setText("X");
                matrizTateti[posicionesComputadora[0]][posicionesComputadora[1]].setEnabled(false);
            }
            else {
                matrizTateti[posicionesComputadora[0]][posicionesComputadora[1]].setText("O");
                matrizTateti[posicionesComputadora[0]][posicionesComputadora[1]].setEnabled(false);
            }
            if (controlJuego.hayGanador()) {
                for (int i = 0; i < 3; i++) {
                    for (int j = 0; j < 3; j++) {
                        matrizTateti[i][j].setEnabled(false);
                    }
                }
                mensajeGanador.setText(getString(R.string.ganador, "la IA"));
            }
            else if (controlJuego.hayEmpate()) {
                mensajeGanador.setText(getString(R.string.empate));
                for (int i = 0; i < 3; i++) {
                    for (int j = 0; j < 3; j++) {
                        matrizTateti[i][j].setEnabled(false);
                    }
                }
            }
        }
    }
}