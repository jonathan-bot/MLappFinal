package com.example.mlappfinal.Interface;

import com.example.mlappfinal.Model.Producto;
import com.example.mlappfinal.Model.Productos;

import java.util.ArrayList;

public interface InterfazPresenter {
    
    void enviarResultado(ArrayList<Producto> productos);
    void solicitarDatos(String q);
    void mostrarError();
}
