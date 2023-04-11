package com.example.parcial_corte1.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {
    // Debe ser "static final" debido a que estos "variables" se envían a
    // una clase abstracta y además estas variables deben ser constantes, es decir que no cambian su valor
    private static final int DATABASE_VERSION = 1; // Versión de la empresa, debe ser privado
    private static final String DATABASE_NAME = "empresa.db"; // El nombre de la base de datos
    public static final String USER_TABLE= "users";
    public String DATABASE_TABLE = "productos"; // El nombre de la tabla debe ser público para poder acceder a esta

    public DBHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        // Se va a ejacutar una sentencia SQL
        sqLiteDatabase.execSQL("CREATE TABLE " + DATABASE_TABLE + "(" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "user TEXT, " +
                "name_prod TEXT," +
                "cantidad INTEGER," +
                "precio INTEGER)");

        sqLiteDatabase.execSQL("CREATE TABLE " + USER_TABLE + "(" +"user TEXT, " +
                "name_prod TEXT," +
                "password TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) { // Es el paso a seguir cuando se va a crear una nueva versión de la BD
        sqLiteDatabase.execSQL("DROP TABLE " + DATABASE_TABLE);
        onCreate(sqLiteDatabase);
    }
}
