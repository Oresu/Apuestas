package com.example.zasha.apuestas;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button buttonRegistro;
        Button buttonApuestas;
        Button buttonAjustes;
        Button buttonSorteo;
        final MainActivity main = this;

        //Creacion de botones
        buttonRegistro = (Button) this.findViewById(R.id.button_registro);
        buttonApuestas = (Button) this.findViewById(R.id.button_apuestas);
        buttonAjustes = (Button) this.findViewById(R.id.button_ajustes);
        buttonSorteo = (Button) this.findViewById(R.id.button_sorteo);

        //Coodigo de evento
        buttonRegistro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(main, Registro.class);
                startActivity(intent);
            }
        });

        buttonApuestas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(main, Apuestas.class);
                startActivity(intent);
            }
        });

        buttonAjustes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(main, Ajustes.class);
                startActivity(intent);
            }
        });


    }

}
