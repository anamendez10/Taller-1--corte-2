package com.example.parcial_corte1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.parcial_corte1.db.DBProductos;
import com.example.parcial_corte1.entidades.Productos;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class AgregarActivity extends AppCompatActivity {
    EditText txtNombre, txtCantidad;
    Button btnInsertar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agregar);

        txtNombre = findViewById(R.id.txtNombre);
        txtCantidad = findViewById(R.id.txtCantidad);
        btnInsertar = findViewById(R.id.btnInsertar);

        btnInsertar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DBProductos dbProductos = new DBProductos(AgregarActivity.this);
                Productos productos = new Productos();

                Productos info_productos = null;
                try {
                    FileInputStream file = openFileInput("producto.txt");
                    ObjectInputStream deserializacion = new ObjectInputStream(file);
                    info_productos = (Productos) deserializacion.readObject();
                    deserializacion.close();

                    long id = dbProductos.insertarProducto(info_productos.getUser(), txtNombre.getText().toString(), txtCantidad.getText().toString(), Integer.parseInt(txtCantidad.getText().toString()));

                    if (id > 0) {
                        Toast.makeText(AgregarActivity.this, "SE HA INSERTADO EL PRODUCTO " + " User: " + info_productos.getUser() + "\nNombre prod: " + txtNombre.getText().toString() + "\nCantidad: " + txtCantidad.getText().toString() + "\nPrecio: " + Integer.parseInt(txtCantidad.getText().toString()), Toast.LENGTH_SHORT).show();
                        limpiar();

                    } else {
                        Toast.makeText(AgregarActivity.this, "ERROR AL INSERTAR EL PRODUCTO", Toast.LENGTH_SHORT).show();
                    }

                } catch (IOException e) {
                    e.printStackTrace();
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }


            }
        });
    }

    private void limpiar() {
        txtNombre.setText("");
        txtCantidad.setText("");
    }
}