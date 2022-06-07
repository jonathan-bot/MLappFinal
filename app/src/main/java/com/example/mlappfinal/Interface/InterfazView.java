package com.example.mlappfinal.Interface;

import com.example.mlappfinal.Model.Producto;
import com.example.mlappfinal.Model.Productos;

import java.util.ArrayList;

public interface InterfazView {
    void mostrarResultado(ArrayList<Producto> productos);
    void mostrarError();
    void solicitarDatos(String q);
}
