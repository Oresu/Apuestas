package com.example.zasha.apuestas;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
//-------------------------------
    //Variables estaticas
    final static int codigo_registro=0;
    final static int codigo_apuesta=1;
    final static int codigo_ajustes=2;

    final static int codigo_futbol = R.string.football;
    final static int codigo_basket = R.string.basket;
    final static int codigo_tenis = R.string.tennis;
    final static int codigo_balonmano = R.string.handball;

    //Variables y banderas
    boolean registrado = false;

    //Button btapuestas,btajustes;
    String apuesta;


    Button buttonRegistro;
    Button buttonApuestas;
    Button buttonAjustes;
    Button buttonSorteo;

    boolean abrirajustes=false,abrirapuestas=false;
    private int deporte_seleccionado = -1;
    //----------------------------------------

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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
                startActivityForResult(intent, codigo_registro);
            }
        });

        buttonApuestas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!registrado) {
                    Toast.makeText(main, "Registrate Primero", Toast.LENGTH_LONG).show();
                    return;
                }

                Intent intent = new Intent(main, Apuestas.class);
                startActivityForResult(intent, codigo_apuesta);
            }
        });

        buttonAjustes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!registrado) {
                    Toast.makeText(main, "Registrate Primero", Toast.LENGTH_LONG).show();
                    return;
                }

                if(deporte_seleccionado == -1) {
                    Toast.makeText(main, "Selecciona un tipo de apuesta primero.", Toast.LENGTH_LONG).show();
                    return;
                }

                Intent intent = new Intent(main, Ajustes.class);
                intent.putExtra("deporte", deporte_seleccionado);
                startActivity(intent);
            }
        });

        buttonSorteo.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                Toast.makeText(getApplicationContext(),R.string.out,
                        Toast.LENGTH_SHORT).show();
            }
        });


    }

    /*
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id= item.getItemId();

        if(id==R.id.menuayuda){
            Intent intent = new Intent(this, Ayuda.class);
            startActivity(intent);
            return true;
        }else{
            Intent intent = new Intent(this, Acercade.class);
            startActivity(intent);
            return true;
        }
    }

    */
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        switch(requestCode) {
            case codigo_registro :
                if (resultCode == RESULT_OK) {
                    registrado = true;
                }
                break;
            case codigo_apuesta :
                deporte_seleccionado = resultCode;
                actualizarDeporte();
                break;
        }
    }

    private void actualizarDeporte() {
        if (deporte_seleccionado != -1) {
            buttonApuestas.setText(getResources().getString(R.string.apuestas) + " - "+  getResources().getString(deporte_seleccionado));
        } else {
            buttonApuestas.setText(getResources().getString(R.string.apuestas));
        }
    }
}
