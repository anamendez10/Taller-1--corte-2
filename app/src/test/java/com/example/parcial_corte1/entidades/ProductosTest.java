package com.example.parcial_corte1.entidades;

import android.content.Context;

import com.example.parcial_corte1.db.DBProductos;

import junit.framework.TestCase;

import org.junit.Before;

public class ProductosTest extends TestCase {
    public Productos productos;

    @Before
    public void setUp(){
        productos = new Productos();
    }

    public void testRecursividadPrecio() {
        assertEquals(1, productos.recursividadPrecio(1));
        assertEquals(3628800, productos.recursividadPrecio(10));
        assertEquals(0, productos.recursividadPrecio(0));
    }
}