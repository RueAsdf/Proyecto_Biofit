package com.example.proyecto_biofit.database;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

//Constructor para instanciar database
public class AdminSQLiteOpenHelper extends SQLiteOpenHelper {
    public AdminSQLiteOpenHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    //Método para poder crear modelo de trabajo
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE clases(codigo INT PRIMARY KEY, clase TEXT, intensidad TEXT)");

    }
    //Método para realizar actualizaciones en el modelo
    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
