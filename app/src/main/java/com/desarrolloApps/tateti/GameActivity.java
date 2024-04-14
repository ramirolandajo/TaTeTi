package com.desarrolloApps.tateti;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class GameActivity extends AppCompatActivity {

    String nombreJugador;

    TextView playerName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        nombreJugador = getIntent().getStringExtra("nombre");
        playerName = findViewById(R.id.playerName);
        playerName.setText(nombreJugador);
    }

//    private void controloBoton(View v){
//        if(tengoTurno) {
//            Button seleccionado = (Button) v;
//            if (usa.equalsIgnoreCase("circulos"))
//                seleccionado.setText("O");
//            else
//                seleccionado.setText("X");
//            tengoTurno = false;
//            seleccionado.setEnabled(false);// Deshabilito el boton para que no se elija mas de una vez.
//            cj.asignarValor(1,1,usa);
//            if(cj.gano())
//                lblGanador.setText("El ganador es " + nombre);
//            else {
//                cj.proximoMovimiento(usa);
//                if(cj.gano())
//                    lblGanador.setText("El ganador es la mÃ¡quina");
//                tengoTurno = true;
//            }
//        }
//    }
}