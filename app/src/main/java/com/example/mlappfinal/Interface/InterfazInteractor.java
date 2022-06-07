package com.example.mlappfinal.Interface;

import com.example.mlappfinal.Model.Producto;
import com.example.mlappfinal.Model.Productos;

import java.util.ArrayList;

public interface InterfazInteractor {
    void enviarResultado(String q);
    void consultaExitosa(ArrayList<Producto> productos);
    void consultaFallida();
}
