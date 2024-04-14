package com.desarrolloApps.tateti;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText nombre;
    Button boton;
    RadioButton circulos, cruces;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nombre = findViewById(R.id.inputNombre);
        boton = findViewById(R.id.button);
        circulos = findViewById(R.id.circulo);
        cruces = findViewById(R.id.cruces);

        circulos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (cruces.isChecked()) {
                    cruces.setChecked(false);
                }
            }
        });

        cruces.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (circulos.isChecked()) {
                    circulos.setChecked(false);
                }
            }
        });
        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent aux = new Intent(MainActivity.this, GameActivity.class);
                String nombreJugador = nombre.getText().toString();
                if (nombreJugador.isEmpty()) {
                    nombreJugador = "Jugador";
                }
                aux.putExtra("nombre", nombreJugador);
                if (circulos.isChecked()) {
                    aux.putExtra("eleccion", "O");
                } else {
                    aux.putExtra("eleccion", "X");
                }
                startActivity(aux);
            }
        });
    }
}