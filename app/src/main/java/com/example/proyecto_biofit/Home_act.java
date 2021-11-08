package com.example.proyecto_biofit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.TextureView;
import android.view.View;
import android.widget.TextView;

import Objetos.Insumos;

public class Home_act extends AppCompatActivity {

    private Insumos in = new Insumos();
    private TextView usuario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        usuario = findViewById(R.id.usuario);

        String us = getIntent().getStringExtra("usuario");

        usuario.setText("bienvenido; " + us);

    }

    public void task(View view){

        try {
            for (int i = 0; i <= 10; i++){
                Thread.sleep(2000);
            }
        }
        catch (InterruptedException e){
            e.printStackTrace();
        }
    }

    public void insumos(View view){
        Intent i = new Intent(this, Insumos_Act.class);

        Bundle bun = new Bundle();
        bun.putStringArray("insumos", in.getInsumons());
        i.putExtras(bun);

        startActivity(i);
    }

}