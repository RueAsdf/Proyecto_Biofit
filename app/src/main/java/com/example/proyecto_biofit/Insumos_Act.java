package com.example.proyecto_biofit;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.RatingBar;
import android.widget.Spinner;
import android.widget.TextView;

import Objetos.Insumos;

public class Insumos_Act extends AppCompatActivity {
    private Insumos in  = new Insumos();
    private Spinner spinsumos;
    private TextView result;
    private RatingBar estrella;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insumos);

        spinsumos = findViewById(R.id.spnInsumos);
        result = findViewById(R.id.result);
        estrella=findViewById(R.id.ratingBar);

        Bundle bun = getIntent().getExtras();
        String[] listadeinsumos = bun.getStringArray("insumos");

        ArrayAdapter adaptInsumos = new ArrayAdapter(this, android.R.layout.simple_list_item_1,listadeinsumos);
        spinsumos.setAdapter(adaptInsumos);
    }

    public void Calcular(View view){

        String opcion = spinsumos.getSelectedItem().toString();
        int resultado =0;

        for(int i = 0; i < opcion.length(); i++){
            if (opcion.equals(in.getInsumons()[i])){

                resultado=in.anadirAdicional(in.getPrecios()[i],350); //Regla de negocio
                estrella.setRating(i+1);
                break;

            }

        }
        result.setText("La opcion seleccionada es: " + opcion+" \nEl precio es : "+resultado);
    }
}