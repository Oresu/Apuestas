package com.example.zasha.apuestas;

import android.app.DialogFragment;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class Registro extends AppCompatActivity {

    Button validar;
    Button volver;
    EditText fecha;
    EditText nombre;
    EditText email;
    final Registro registro = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        validar = (Button) this.findViewById(R.id.button_validar);
        volver = (Button) this.findViewById(R.id.button_volver);
        fecha = (EditText) this.findViewById(R.id.editText_fecha);
        nombre = (EditText) this.findViewById(R.id.editText_nombre);
        email = (EditText) this.findViewById(R.id.editText_email);

        //Coodigo de evento
        validar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Date fecha_fija = new Date(fecha.getText().toString());

                fecha_fija.setYear(fecha_fija.getYear() + 18);
                Date fecha_actual = new Date();

                fecha_actual.compareTo(fecha_fija);




            }
        });

        volver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        fecha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DataPickerFragment fragment = new DataPickerFragment();
                fragment.campo = ((EditText) view);
                fragment.show(getFragmentManager(),"Datepicker");
            }
        });

    }
}
