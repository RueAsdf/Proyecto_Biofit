package com.example.proyecto_biofit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

import Objetos.Administrador;
import Objetos.Insumos;

public class MainActivity extends AppCompatActivity {

    private EditText user, pass;
    private TextView msj;
    private Administrador adm = new Administrador();
    private Insumos in = new Insumos();
    private Button btn;
    private ProgressBar pb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        user = findViewById(R.id.txtUser);
        pass = findViewById(R.id.txtPass);
        msj  = findViewById(R.id.msj);
        btn = findViewById(R.id.btn);
        pb = findViewById(R.id.pb);

        msj.setVisibility(View.INVISIBLE);
        pb.setVisibility(View.INVISIBLE);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new Task().execute();
            }
        });

    }

    class Task extends AsyncTask<String, Void, String>{
        @Override

        // Define configuracion inicial de la tarea asincrona
        protected void onPreExecute() {
            super.onPreExecute();
            pb.setVisibility(View.VISIBLE);
        }

        //Realiza el proceso pesado en segundo plano o mi tarea de larga duracion
        @Override
        protected String doInBackground(String... strings) {
            try {
                for (int i = 0; i <= 10; i++){
                    Thread.sleep(2000);
                }
            }
            catch (InterruptedException e){
                e.printStackTrace();
            }

            return null;

        }

        //Finaliza mi tarea asincrona y define su final
        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            pb.setVisibility(View.INVISIBLE);
            Intent i = new Intent(getBaseContext(), Home_act.class);
            i.putExtra("usuario",user.getText().toString());
            startActivity(i);
        }
    }

    public void Info (View view){
        Intent i = new Intent(this, Info_act.class);
        startActivity(i);
    }





    public void LoadSession (View view){
        String userObj    = adm.getUser().toString().trim();
        String passObj    = adm.getPass().toString().trim();

        String usuario    = user.getText().toString().trim();
        String contrasena = pass.getText().toString().trim();

        switch (usuario){
            case "diego" :
                if (usuario.equals(userObj) && contrasena.equals(passObj)){
                    Intent i = new Intent(this, Home_act.class);

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