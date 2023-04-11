package com.example.parcial_corte1.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.widget.Toast;

import androidx.annotation.Nullable;

import com.example.parcial_corte1.entidades.Productos;

public class DBProductos extends DBHelper {
    Context context;

    public DBProductos(@Nullable Context context) {
        super(context);

        this.context = context;
    }

    public boolean validarUser(String user, String password) {
        long id = 0;
        Cursor existe = null;
        boolean correcto = false;

        try {
            DBHelper dbHelper = new DBHelper(context);
            SQLiteDatabase db = dbHelper.getWritableDatabase();

            ContentValues values = new ContentValues();
            values.put("user", "ana.mendezr");
            values.put("password", "Prueba123");
            db.insert(USER_TABLE, null, values);

            existe = db.rawQuery("SELECT * FROM " + USER_TABLE + " WHERE user = " + "'" + user + "'", null);


            if(existe.getCount() > 0)
            {
                correcto = true;
            }
            else
            {
                correcto = false;
            }
        } catch (Exception ex) {
            ex.toString();
        }
        return correcto;
    }

    public long insertarProducto(String user, String name_prod, String cantidad, int precio) {
        long id = 0;

        Productos productos = new Productos();
        int precioFinal = 0;

        try {
            DBHelper dbHelper = new DBHelper(context);
            SQLiteDatabase db = dbHelper.getWritableDatabase();

            ContentValues values = new ContentValues();
            values.put("user", user);
            values.put("name_prod", name_prod);
            values.put("cantidad", cantidad);
            precioFinal = productos.recursividadPrecio(precio);
            values.put("precio", precioFinal);

            id = db.insert(DATABASE_TABLE, null, values);
        } catch (Exception ex) {
            ex.toString();
        }
        return id;
    }

}