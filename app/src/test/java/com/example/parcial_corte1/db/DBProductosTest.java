package com.example.parcial_corte1.db;

import android.content.Context;

import junit.framework.TestCase;

import org.junit.Before;

public class DBProductosTest extends TestCase {
    public DBProductos dbProductos;
    Context context;

    @Before
    public void setUp(){
        dbProductos = new DBProductos(context);
    }

    public void testValidarUser(){
        assertEquals(true, dbProductos.validarUser("ana.mendezr", "Prueba123"));
        assertEquals(false, dbProductos.validarUser("usernoes", "sflkjs"));
    }

    public void testInsertarProducto() {
        assertEquals(0, dbProductos.insertarProducto(null, null, null, 0));
    }
}