package com.example.proyecto_biofit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.Cursor;
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
            Toast.makeText(getBaseContext(),"Campos vacíos",Toast.LENGTH_SHORT).show();
        }
    }
    public void mostrarClases(View view){
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this,"biofit",null,1);
        SQLiteDatabase db = admin.getWritableDatabase();
        String codigo = code.getText().toString();

        if(!codigo.isEmpty()){
            Cursor file = db.rawQuery("SELECT clase,intensidad FROM clases WHERE codigo ="+codigo,null);
            if(file.moveToFirst()){   //revisa si la consulta tiene valores
               clas.setText(file.getString(0));
               intensi.setText(file.getString(1));
            }else{
                Toast.makeText(getBaseContext(),"No hay clase asociada",Toast.LENGTH_SHORT).show();
            }
        }else{
            Toast.makeText(getBaseContext(),"Codigo vacío",Toast.LENGTH_SHORT).show();
        }
    }
    public void eliminarClases(View view){
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this,"biofit",null,1);
        SQLiteDatabase db = admin.getWritableDatabase();
        String codigo = code.getText().toString();
        if(!codigo.isEmpty()){
            int cant=db.delete("clases","codigo="+codigo,null);
            db.close();
            clean();
            if(cant==1){
                Toast.makeText(getBaseContext(),"Eliminaste la clase: "+codigo,Toast.LENGTH_SHORT).show();
            }else{
                Toast.makeText(getBaseContext(),"No existe la clase con el codigo asociado",Toast.LENGTH_SHORT).show();
            }
        }
    }
    public void actualizarClases(View view){

    }
    public void clean(){
        code.setText("");
        clas.setText("");
        intensi.setText("");
    }
}