package com.example.parcial_corte1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.parcial_corte1.db.DBProductos;
import com.example.parcial_corte1.entidades.Productos;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class MainActivity extends AppCompatActivity {

    EditText txtUser, txtPassword;
    Button btnContinuar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtUser = findViewById(R.id.txtUser);
        txtPassword = findViewById(R.id.txtPassword);
        btnContinuar = findViewById(R.id.btnContinuar);

        btnContinuar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(isEmpty(txtUser.getText().toString(), txtPassword.getText().toString()) == true){
                    Toast.makeText(MainActivity.this, "Ambos campos son obligatorios", Toast.LENGTH_SHORT).show();
                }
                else{
                    DBProductos dbProductos = new DBProductos(MainActivity.this);
                    Productos productos = new Productos();
                    productos.setUser(txtUser.getText().toString());

                    boolean correcto = dbProductos.validarUser(txtUser.getText().toString(),  txtPassword.getText().toString());

                    if(correcto){
                        FileOutputStream file = null;
                        try {
                            file = openFileOutput("producto.txt", Context.MODE_PRIVATE);
                            ObjectOutputStream serializacion = new ObjectOutputStream(file);
                            serializacion.writeObject(productos);
                            serializacion.close();
                        } catch (FileNotFoundException e) {
                            e.printStackTrace();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }

                        Intent intent = new Intent(MainActivity.this, AgregarActivity.class);
                        startActivity(intent);
                        limpiar();

                    }
                    else{
                        Toast.makeText(MainActivity.this, "NO SE ENCUENTRA REGISTRADO", Toast.LENGTH_SHORT).show();
                        limpiar();
                    }
                }
            }
        });
    }

    public boolean isEmpty(String txtUserS, String txtPassS){
        txtUserS = txtUser.getText().toString();
        txtPassS = txtPassword.getText().toString();
        if(txtUserS.equals("") || txtPassS.equals("")){
            return true;
        }
        else{
            return false;
        }
    }

    private void limpiar() {
        txtUser.setText("");
        txtPassword.setText("");
    }
}