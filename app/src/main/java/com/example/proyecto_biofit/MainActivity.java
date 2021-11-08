package com.example.proyecto_biofit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import Objetos.Administrador;

public class MainActivity extends AppCompatActivity {

    private EditText user, pass;
    private TextView msj;
    private Administrador adm = new Administrador();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        user = findViewById(R.id.txtUser);
        pass = findViewById(R.id.txtPass);
        msj  = findViewById(R.id.msj);

        msj.setVisibility(View.INVISIBLE);

    }

    public void LoadSession (View view){
        String userObj    = adm.getUser().toString().trim();
        String passObj    = adm.getPass().toString().trim();

        String usuario    = user.getText().toString().trim();
        String contrasena = pass.getText().toString().trim();

        switch (usuario){
            case "diego" :
                if (usuario.equals(userObj) && contrasena.equals(passObj)){
                    Intent i = new Intent(this, Insumos_Act.class);
                    startActivity(i);
                }
                break;
            case "":
                if (usuario.equals("") && contrasena.equals("")){
                    msj.setVisibility(View.VISIBLE);
                    msj.setText("Campos vacios, por favor llenar campos");

                }
                break;
            default:
                if (!usuario.equals(userObj) && !contrasena.equals(passObj)){
                    msj.setVisibility(View.VISIBLE);
                    msj.setText("Campos incorrectos");
                }
                break;
        }
    }

    public void Facebook(View view){
        Intent i = new Intent(Intent.ACTION_VIEW);
        i.setData(Uri.parse("https://www.facebook.com/"));
        startActivity(i);
    }

    public void Twitter(View view){
        Intent i = new Intent(Intent.ACTION_VIEW);
        i.setData(Uri.parse("https://www.twitter.com/"));
        startActivity(i);
    }

    public void Youtube(View view){
        Intent i = new Intent(Intent.ACTION_VIEW);
        i.setData(Uri.parse("https://www.youtube.com/"));
        startActivity(i);
    }

}