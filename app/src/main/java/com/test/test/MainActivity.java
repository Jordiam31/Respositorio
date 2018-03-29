package com.test.test;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import Objetos.Ejemplar;

public class MainActivity extends AppCompatActivity {
    String insert = "insert into Ejemplar (titulo, autor, anio) values ('harry potter', 'jkrowling', '2000')";
    String select = "select * from Ejemplar";
    TextView tv1 = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BibliotecaSQLiteHelper bibliotecaSQLiteHelper = new BibliotecaSQLiteHelper(this, "prueba.db",null,1);
        SQLiteDatabase db = bibliotecaSQLiteHelper.getWritableDatabase();
//        bibliotecaSQLiteHelper.onCreate(db);
        
        Cursor cursor =null;
        tv1 = findViewById(R.id.tv1);
        int contador = 0;
        String resultado = "";

        try{
            db.execSQL(insert);
            cursor = db.rawQuery(select, null);
            Toast.makeText(this, "Base de datos creada correctamente.", Toast.LENGTH_SHORT).show();

            cursor.moveToFirst();

            while ( !cursor.isAfterLast()) {
                int id = cursor.getInt(cursor.getColumnIndex("_id"));
                String titulo= cursor.getString(cursor.getColumnIndex("titulo"));
                String autor= cursor.getString(cursor.getColumnIndex("autor"));
                String anio= cursor.getString(cursor.getColumnIndex("anio"));
                cursor.moveToNext();
                contador++;
                resultado += "\n-Valor "+contador+
                        "\n       ID: " + id+
                        "\n       Titulo: " + titulo+
                        "\n       Autor: " + autor+
                        "\n       Anio: " + anio;
            }
            tv1.setText(resultado);
        }catch(Exception e){
            e.printStackTrace();
            Toast.makeText(this, "Error al crear la base de datos.", Toast.LENGTH_SHORT).show();
        }










    }
}
