package com.desarrolloApps.tateti;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class GameActivity extends AppCompatActivity {

    String nombreJugador, eleccionJugador, turno;

    TextView playerName, mensajeGanador;

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
        turno = eleccionJugador;

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
        seleccionado.setText(turno);
        int posicion = Integer.parseInt((String) seleccionado.getTag());
        seleccionado.setEnabled(false);// Deshabilito el boton para que no se elija mas de una vez.
        controlJuego.marcarCasillero(posicion, turno);

        mensajeGanador = findViewById(R.id.win_text);
        if (controlJuego.hayGanador()) {
            mensajeGanador.setText(getString(R.string.ganador, turno));
        } else if (controlJuego.getContadorMovimientos() == 9) {
            mensajeGanador.setText(getString(R.string.empate));
        } else {
            if (turno.equals("O")) {
                turno = "X";
                int pos = controlJuego.moverComputadora(turno);
                actualizarBotonComputadora(pos);
            }
            else {
                turno = "O";
                int pos = controlJuego.moverComputadora(turno);
                actualizarBotonComputadora(pos);
            }
        }
    }

    private void actualizarBotonComputadora(int pos) {
        switch (pos) {
            case 1: {
                btn1.setText(this.turno);
                btn1.setEnabled(false);
                turnoJugador = true;
                break;
            }
            case 2: {
                btn2.setText(this.turno);
                btn2.setEnabled(false);
                turnoJugador = true;
                break;
            }
            case 3: {
                btn3.setText(this.turno);
                btn3.setEnabled(false);
                turnoJugador = true;
                break;
            }
            case 4: {
                btn4.setText(this.turno);
                btn4.setEnabled(false);
                turnoJugador = true;
                break;

            }
            case 5: {
                btn5.setText(this.turno);
                btn5.setEnabled(false);
                turnoJugador = true;
                break;

            }
            case 6: {
                btn6.setText(this.turno);
                btn6.setEnabled(false);
                turnoJugador = true;
                break;
            }
            case 7: {
                btn7.setText(this.turno);
                btn7.setEnabled(false);
                turnoJugador = true;
                break;
            }
            case 8: {
                btn8.setText(this.turno);
                btn8.setEnabled(false);
                turnoJugador = true;
                break;
            }
            case 9: {
                btn9.setText(this.turno);
                btn9.setEnabled(false);
                turnoJugador = true;
                break;
            }
            default: {
                throw new IllegalArgumentException("Posicion de computadora no valida");
            }
        }
    }
}