package com.example.proyecto_biofit;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

public class Insumos_Act extends AppCompatActivity {

    private Spinner spinsumos;
    private TextView result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insumos);

        spinsumos = findViewById(R.id.spnInsumos);
        result = findViewById(R.id.result);

        Bundle bun = getIntent().getExtras();
        String[] listadeinsumos = bun.getStringArray("insumos");

        ArrayAdapter adaptInsumos = new ArrayAdapter(this, android.R.layout.simple_list_item_1,listadeinsumos);
        spinsumos.setAdapter(adaptInsumos);
    }

    public void Calcular(View view){

        String opcion = spinsumos.getSelectedItem().toString();

        for(int i = 0; i < opcion.length(); i++){
            if (opcion.equals(opcion)){
                result.setText("La opcion seleccionada es: " + opcion);
            }
        }
    }
}