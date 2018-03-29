package com.test.test;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;



public class BibliotecaSQLiteHelper extends SQLiteOpenHelper {
    //Sentencia SQL per la creació de la taula
    public String createBDSQL = "CREATE TABLE Ejemplar (_id integer primary key autoincrement, titulo TEXT, autor TEXT, anio TEXT)";
    // Definimos el constructor

    public BibliotecaSQLiteHelper(Context contexto, String nombre,
                                  SQLiteDatabase.CursorFactory factory, int version) {
        super(contexto, nombre, factory, version);
    }
    // Si la BD no existe, Android llama a este método
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(createBDSQL); //S'ejecuta la sentencia SQL
    }
    public void onUpgrade(SQLiteDatabase db, int versionAnterior, int
            versionNueva) {
        db.execSQL("DROP TABLE IF EXISTS Ejemplares"); //Elimina la versión anterior de la tabla
        db.execSQL(createBDSQL);
    }


} //Se crea la nueva versión de la tabla }}

