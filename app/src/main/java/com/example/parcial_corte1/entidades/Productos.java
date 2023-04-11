package com.example.parcial_corte1.entidades;

import java.io.Serializable;

public class Productos implements Serializable {

    private int id;
    private String user;
    private String name_prod;
    private String cantidad;
    private int precio;

    public int recursividadPrecio(int cantidad)
    {
        if(cantidad == 1)
        {
            return 1;
        }
        else
        {
            return cantidad *  recursividadPrecio(cantidad - 1);
        }
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getName_prod() {
        return name_prod;
    }

    public void setName_prod(String name_prod) {
        this.name_prod = name_prod;
    }

    public String getCantidad() {
        return cantidad;
    }

    public void setCantidad(String cantidad) {
        this.cantidad = cantidad;
    }

    public int getPrecio() {
        return recursividadPrecio(Integer.parseInt(cantidad));
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }
}
