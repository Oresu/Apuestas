package com.example.zasha.apuestas;

import android.app.DialogFragment;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.text.ParseException;
import java.text.SimpleDateFormat;
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

                //Control de campos vacios
                //Si error salimos sino continuamos validando
                if (nombre.getText().toString().length() == 0 || email.getText().toString().length() == 0 || fecha.getText().toString().length() == 0) {
                    Toast.makeText(registro, R.string.msg_error_campos_vacios, Toast.LENGTH_LONG).show();
                    return;
                }

                //Comprobamos que la fecha sea correcta
                String formato_fecha = "yyyy/MM/dd";
                SimpleDateFormat dateFormat_fecha = new SimpleDateFormat(formato_fecha);
                Date fecha_nac = null;
                try {
                    fecha_nac = dateFormat_fecha.parse(fecha.getText().toString());
                } catch (ParseException e) {
                    Toast.makeText(registro,  R.string.msg_error_formato_fecha, Toast.LENGTH_LONG).show();
                    return;
                }

                //Control de edad
                String formato="yyyy";
                SimpleDateFormat dateFormat = new SimpleDateFormat(formato);

                int anno = Integer.parseInt(dateFormat.format(fecha_nac));
                int anno_act = Integer.parseInt(dateFormat.format(new Date()));
                if (anno_act - anno < 18 ) {
                    Toast.makeText(registro,R.string.msg_error_edad, Toast.LENGTH_LONG).show();
                    return;
                }

                //Si llegamos hasta aquí suponemos que todo esta correcto y salimos.
                //Todo camibiar por destruir activity?
                setResult(RESULT_OK);
                Toast.makeText(registro,R.string.login_ok, Toast.LENGTH_LONG).show();
                finish();
            }
        });

        volver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setResult(RESULT_CANCELED);
                finish();
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
