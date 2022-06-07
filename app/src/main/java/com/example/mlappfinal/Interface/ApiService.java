package com.example.mlappfinal.Interface;

import com.example.mlappfinal.Model.Productos;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiService {
    @GET("/sites/MCO/search?q=")
    Call<Productos> obtenerListaProductos(@Query("q") String q);
}
