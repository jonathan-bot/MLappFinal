package com.example.mlappfinal.Model;

import com.example.mlappfinal.Interface.ApiService;
import com.example.mlappfinal.Interface.InterfazInteractor;
import com.example.mlappfinal.Interface.InterfazPresenter;
import com.example.mlappfinal.Presenter.PresenterProducto;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class InteractorProducto implements InterfazInteractor {

    private InterfazPresenter presenter;

    public InteractorProducto(InterfazPresenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void enviarResultado(String q) {
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl("https://api.mercadolibre.com")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            ApiService servicio = retrofit.create(ApiService.class);
            Call<Productos> listaproductos = servicio.obtenerListaProductos(q);
            listaproductos.enqueue(new Callback<Productos>() {
                @Override
                public void onResponse(Call<Productos> call, Response<Productos> response) {
                    if(!response.isSuccessful()) {
                        consultaFallida();
                        System.out.println("FALLO");
                    }
                    Productos listadeproductos = response.body();
                    ArrayList<Producto> productos = listadeproductos.getResults();
                    if(productos.size()>0) {
                        consultaExitosa(productos);
                        System.out.println("EXITO"+productos);
                    }else{
                        consultaFallida();
                    }
                }

                @Override
                public void onFailure(Call<Productos> call, Throwable t) {
                    consultaFallida();
                }
            });
    }

    @Override
    public void consultaExitosa(ArrayList<Producto> productos) {
        presenter.enviarResultado(productos);
    }

    @Override
    public void consultaFallida() {
        presenter.mostrarError();
    }
}
