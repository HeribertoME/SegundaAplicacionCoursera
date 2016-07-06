package com.hmelizarraraz.segundaaplicacioncoursera;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    public final static String EXTRA_NOMBRE = "com.hmelizarraraz.SegundaAplicacionCoursera.Heriberto";



    private EditText etNombre;
    private EditText etFecha;
    private EditText etTelefono;
    private EditText etEmail;
    private EditText etDescripcion;

    private Button btnSiguiente;

    private DatePickerDialog datePickerDialog;

    private SimpleDateFormat dateFormat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dateFormat = new SimpleDateFormat("dd-MM-yyyy", Locale.US);
        findViewsById();
        setDateTimeField();
        btnSiguiente.setOnClickListener(this);

    }


    private void setDateTimeField() {
        etFecha.setOnClickListener(this);

        Calendar newCalendar = Calendar.getInstance();
        datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                Calendar newDate = Calendar.getInstance();
                newDate.set(year, monthOfYear, dayOfMonth);
                etFecha.setText(dateFormat.format(newDate.getTime()));

            }
        }, newCalendar.get(Calendar.YEAR), newCalendar.get(Calendar.MONTH), newCalendar.get(Calendar.DAY_OF_MONTH));

    }

    public void findViewsById() {

        etNombre        = (EditText) findViewById(R.id.etnombre);
        etFecha         = (EditText) findViewById(R.id.etFecha);
        etFecha.setInputType(InputType.TYPE_NULL);
        etTelefono      = (EditText) findViewById(R.id.etTelefono);
        etEmail         = (EditText) findViewById(R.id.etEmail);
        etDescripcion   = (EditText) findViewById(R.id.etDescripcion);

        btnSiguiente    = (Button) findViewById(R.id.btnSiguiente);

    }

    @Override
    public void onClick(View view) {

        if (view == etFecha) {
            datePickerDialog.show();
        }

        if (view == btnSiguiente) {
            lanzaIntent();
        }

    }

    private void lanzaIntent() {
        Intent intent = new Intent(this, ConfirmacionDatos.class);
        intent.putExtra(getResources().getString(R.string.pnombre), etNombre.getText().toString());
        intent.putExtra(getResources().getString(R.string.pfecha), etFecha.getText().toString());
        intent.putExtra(getResources().getString(R.string.ptelefono), etTelefono.getText().toString());
        intent.putExtra(getResources().getString(R.string.pemail), etEmail.getText().toString());
        intent.putExtra(getResources().getString(R.string.pdescripcion), etDescripcion.getText().toString());
        startActivity(intent);
        finish();
    }

}
