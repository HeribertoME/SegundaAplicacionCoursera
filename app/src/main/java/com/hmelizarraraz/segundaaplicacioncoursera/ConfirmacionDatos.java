package com.hmelizarraraz.segundaaplicacioncoursera;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ConfirmacionDatos extends AppCompatActivity {

    // tv a setear datos
    private TextView tvNombre;
    private TextView tvFecha;
    private TextView tvTelefono;
    private TextView tvEmail;
    private TextView tvDescripcion;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirmacion_datos);

        Bundle bundle = getIntent().getExtras();

        String  nombre      = bundle.getString(getResources().getString(R.string.pnombre));
        String  fecha       = bundle.getString(getResources().getString(R.string.pfecha));
        String  telefono    = bundle.getString(getResources().getString(R.string.ptelefono));
        String  email       = bundle.getString(getResources().getString(R.string.pemail));
        String  descripcion = bundle.getString(getResources().getString(R.string.pdescripcion));


        tvNombre        = (TextView) findViewById(R.id.tvNombre);
        tvFecha         = (TextView) findViewById(R.id.tvFecha);
        tvTelefono      = (TextView) findViewById(R.id.tvTelefono);
        tvEmail         = (TextView) findViewById(R.id.tvEmail);
        tvDescripcion   = (TextView) findViewById(R.id.tvDescripcion);


        tvNombre.setText(nombre);
        tvFecha.setText(fecha);
        tvTelefono.setText(telefono);
        tvEmail.setText(email);
        tvDescripcion.setText(descripcion);

    }
}



