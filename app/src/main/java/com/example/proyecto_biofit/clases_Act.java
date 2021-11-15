package com.example.proyecto_biofit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.proyecto_biofit.database.AdminSQLiteOpenHelper;

public class clases_Act extends AppCompatActivity {

    private EditText code,clas,intensi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clases);

        code= findViewById(R.id.code);
        clas= findViewById(R.id.clase);
        intensi= findViewById(R.id.intensi);
    }

    public void anadirClases(View view){
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this,"biofit",null,1);
        SQLiteDatabase db = admin.getWritableDatabase();
        String codigo = code.getText().toString();
        String clase = clas.getText().toString();
        String inten = intensi.getText().toString();

        if(!codigo.isEmpty() && !clase.isEmpty() && !inten.isEmpty()){
            ContentValues cont = new ContentValues();
            cont.put("codigo",codigo);
            cont.put("clase",clase);
            cont.put("intensidad",inten);
            db.insert("clases",null,cont);
            db.close();
            clean();
            Toast.makeText(getBaseContext(),"Has guardado una clase",Toast.LENGTH_SHORT).show();

        }else{
            Toast.makeText(getBaseContext(),"Campos vacios",Toast.LENGTH_SHORT).show();
        }
    }
    public void mostrarClases(View view){

    }
    public void eliminarClases(View view){

    }
    public void actualizarClases(View view){

    }
    public void clean(){
        code.setText("");
        clas.setText("");
        intensi.setText("");
    }
}