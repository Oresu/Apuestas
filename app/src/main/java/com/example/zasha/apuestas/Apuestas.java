package com.example.zasha.apuestas;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Apuestas extends AppCompatActivity {


    //Definimos card
    CardView card_futbol;
    CardView card_basket;
    CardView card_tenis;
    CardView card_balonmano;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_apuetas_recuperacion);

        //Recuperamos los objetos de las cartas
        card_futbol = findViewById(R.id.card_futbol);
        card_basket = findViewById(R.id.card_basket);
        card_tenis = findViewById(R.id.card_tenis);
        card_balonmano = findViewById(R.id.card_balonmano);

        final AppCompatActivity este = this;

        //Añadimos eventos de click
        card_futbol.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setResult(MainActivity.codigo_futbol);
                String  texto = getResources().getString(R.string.msg_apuesta_guardada);
                String deporte = getResources().getString(R.string.football);
                Toast.makeText(este, texto + deporte, Toast.LENGTH_SHORT).show();
                finish();
            }
        });

        card_basket.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setResult(MainActivity.codigo_basket);
                String  texto = getResources().getString(R.string.msg_apuesta_guardada);
                String deporte = getResources().getString(R.string.basket);
                Toast.makeText(este, texto + deporte, Toast.LENGTH_SHORT).show();
                finish();
            }
        });

        card_tenis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setResult(MainActivity.codigo_tenis);
                String  texto = getResources().getString(R.string.msg_apuesta_guardada);
                String deporte = getResources().getString(R.string.tennis);
                Toast.makeText(este, texto + deporte, Toast.LENGTH_SHORT).show();
                finish();
            }
        });

        card_balonmano.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setResult(MainActivity.codigo_balonmano);
                String  texto = getResources().getString(R.string.msg_apuesta_guardada);
                String deporte = getResources().getString(R.string.handball);
                Toast.makeText(este, texto + deporte, Toast.LENGTH_SHORT).show();
                finish();
            }
        });

    }
}
