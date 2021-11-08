package com.example.proyecto_biofit;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class Insumos_Act extends AppCompatActivity {

    private Spinner spinsumos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insumos);

        spinsumos = findViewById(R.id.spnInsumos);

        Bundle bun = getIntent().getExtras();
        String[] listadeinsumos = bun.getStringArray("insumos");

        ArrayAdapter adaptInsumos = new ArrayAdapter(this, android.R.layout.simple_list_item_1,listadeinsumos);
        spinsumos.setAdapter(adaptInsumos);
    }
}