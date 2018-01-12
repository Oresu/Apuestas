package com.example.zasha.apuestas;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TabHost;
import android.widget.TextView;
import android.widget.Toast;

public class Ajustes extends AppCompatActivity {
    TextView texto_num1;
    TextView texto_num2;
    TextView partidos;

    TabHost tab;
    final Integer[] cantidad = {1, 2, 5, 10};
    private ArrayAdapter<Integer> adaptador;
    private Spinner spinner;

    int deporte;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ajustes);

        texto_num1 =  findViewById(R.id.textnumero1);
        texto_num2 =  findViewById(R.id.textnumero2);

        partidos = findViewById(R.id.partidos);

        deporte = getIntent().getExtras().getInt("deporte");

        switch (deporte) {
            case R.string.football:
                partidos.setText("Real Madrid - Mierda Barcelona");
                break;
            case R.string.tennis:
                partidos.setText("Nadal - Ferrer");
                break;
            case R.string.handball:
                partidos.setText(" Unicaja - Madrid");
                break;
            case R.string.basket:
                partidos.setText("Real Madrid - Toyo BC");
                break;

        }
        Button btguardar = (Button) findViewById(R.id.botonguardar);
        btguardar.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                guardar();
            }
        });
        Button btguardar2 = (Button) findViewById(R.id.botonguardar2);
        btguardar2.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                guardar();
            }
        });
        Button btvolver = (Button) findViewById(R.id.botonvolver);
        btvolver.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                finish();
            }
        });
        Button btvolver2 = (Button) findViewById(R.id.botonvolver2);
        btvolver2.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                finish();
            }
        });

        tab = findViewById(R.id.TabsHost);
        tab.setup();
        TabHost.TabSpec spec = tab.newTabSpec("dinero");
        spec.setContent(R.id.tabdinero);
        spec.setIndicator("Dinero");
        tab.addTab(spec);

        spec = tab.newTabSpec("Combinacion");
        spec.setContent(R.id.tabcombinacion);
        spec.setIndicator("Combinación");
        tab.addTab(spec);

        tab.setCurrentTab(0);

        adaptador = new ArrayAdapter<Integer>(this,
                android.R.layout.simple_spinner_item, cantidad);

        adaptador.setDropDownViewResource(
                android.R.layout.simple_spinner_dropdown_item);

        spinner = findViewById(R.id.spinnerapuesta);
        spinner.setAdapter(adaptador);
    }

    public void guardar() {
        boolean comprobar = true;
        if (texto_num1.getText().toString().equals("")||texto_num2.getText().toString().equals("")) {
            comprobar = false;
            Toast.makeText(getApplicationContext(), "No son numeros algunos valores",
                    Toast.LENGTH_SHORT).show();
        } else {
            int numero1 = Integer.parseInt(texto_num1.getText().toString());
            int numero2 = Integer.parseInt(texto_num2.getText().toString());
            if (numero1 > 300 || numero2 > 300) {
                Toast.makeText(getApplicationContext(), "Los numero son mayores de 300",
                        Toast.LENGTH_SHORT).show();
                comprobar = false;
            }
        }
        if (spinner.getSelectedItem().equals("")) {
            comprobar = false;

        }
        if (comprobar) {
            Toast.makeText(getApplicationContext(), "Apuesta Guarda correctamente",
                    Toast.LENGTH_SHORT).show();
            finish();
        } else {

        }
    }
}
