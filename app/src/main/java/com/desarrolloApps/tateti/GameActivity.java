package com.desarrolloApps.tateti;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class GameActivity extends AppCompatActivity {

    String nombreJugador, eleccionJugador;

    TextView playerName, mensajeTurnoView, mensajeGanador;

    TaTeTi controlJuego;

    boolean turnoJugador;

    Button btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        nombreJugador = getIntent().getStringExtra("nombre");
        eleccionJugador = getIntent().getStringExtra("eleccion");
        playerName = findViewById(R.id.playerName);
        playerName.setText(getString(R.string.welcome_message, nombreJugador, eleccionJugador));

        controlJuego = new TaTeTi(eleccionJugador);
        turnoJugador = true;

        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);
        btn4 = findViewById(R.id.btn4);
        btn5 = findViewById(R.id.btn5);
        btn6 = findViewById(R.id.btn6);
        btn7 = findViewById(R.id.btn7);
        btn8 = findViewById(R.id.btn8);
        btn9 = findViewById(R.id.btn9);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                seleccionarBoton(v);
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                seleccionarBoton(v);
            }
        });
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                seleccionarBoton(v);
            }
        });
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                seleccionarBoton(v);
            }
        });
        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                seleccionarBoton(v);
            }
        });
        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                seleccionarBoton(v);
            }
        });
        btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                seleccionarBoton(v);
            }
        });
        btn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                seleccionarBoton(v);
            }
        });
        btn9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                seleccionarBoton(v);
            }
        });
    }

    private void seleccionarBoton(View v) {
        Button seleccionado = (Button) v;
        seleccionado.setText(controlJuego.getTurno());
        int posicion = Integer.parseInt((String) seleccionado.getTag());
        seleccionado.setEnabled(false);// Deshabilito el boton para que no se elija mas de una vez.
        controlJuego.marcarCasillero(posicion);
        controlJuego.cambiarTurno();

        mensajeGanador = findViewById(R.id.win_text);
        if (controlJuego.hayGanador()) {
            mensajeGanador.setText(getString(R.string.ganador, controlJuego.getTurno()));
        } else if (controlJuego.getContadorMovimientos() == 9) {
            mensajeGanador.setText(getString(R.string.empate));
        } else {
            int pos = controlJuego.moverComputadora();
            controlJuego.cambiarTurno();
            Log.i("GAME", String.valueOf(pos));
            switch (pos) {
                case 1: {
                    btn1.setText(controlJuego.getTurno());
                    btn1.setEnabled(false);
                    break;
                }
                case 2: {
                    btn2.setText(controlJuego.getTurno());
                    btn2.setEnabled(false);
                    break;
                }
                case 3: {
                    btn3.setText(controlJuego.getTurno());
                    btn3.setEnabled(false);
                    break;
                }
                case 4: {
                    btn4.setText(controlJuego.getTurno());
                    btn4.setEnabled(false);
                    break;

                }
                case 5: {
                    btn5.setText(controlJuego.getTurno());
                    btn5.setEnabled(false);
                    break;

                }
                case 6: {
                    btn6.setText(controlJuego.getTurno());
                    btn6.setEnabled(false);
                    break;
                }
                case 7: {
                    btn7.setText(controlJuego.getTurno());
                    btn7.setEnabled(false);
                    break;
                }
                case 8: {
                    btn8.setText(controlJuego.getTurno());
                    btn8.setEnabled(false);
                    break;
                }
                case 9: {
                    btn9.setText(controlJuego.getTurno());
                    btn9.setEnabled(false);
                    break;
                }
                default: {
                    throw new IllegalArgumentException("Posicion de computadora no valida");
                }
            }
        }
    }
}