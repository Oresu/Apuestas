package com.example.zasha.apuestas;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;

import java.text.DateFormat;
import java.util.Calendar;

/**
 * Created by Zasha on 05/12/2017.
 */

public class DataPickerFragment extends DialogFragment implements DatePickerDialog.OnDateSetListener {
    public int i, il, i2;
    public EditText campo;

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        final Calendar calendar = Calendar.getInstance();
        //DatePickerDialog DP = new DatePickerDialog();
        return new DatePickerDialog(getActivity(),this, 2017,5,30);
        //return super.onCreateDialog(savedInstanceState);
    }

    @Override
    public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
        campo.setText(i + "-" + (il + 1) + "-"+  i2 );
    }
}
