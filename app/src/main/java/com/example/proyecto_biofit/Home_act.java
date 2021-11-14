package com.example.proyecto_biofit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.TextureView;
import android.view.View;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.VideoView;

import Objetos.Insumos;

public class Home_act extends AppCompatActivity {

    private VideoView video;
    private Insumos in = new Insumos();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        video = findViewById(R.id.vw);
        String ruta = "android.resource://" + getPackageName() + "/" + R.raw.video;
        Uri uri = Uri.parse(ruta);
        video.setVideoURI(uri);

        MediaController media = new MediaController(this);
        video.setMediaController(media);


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
    public void clases(View view){
        Intent i = new Intent(this,clases_Act.class);
        startActivity(i);
    }

}