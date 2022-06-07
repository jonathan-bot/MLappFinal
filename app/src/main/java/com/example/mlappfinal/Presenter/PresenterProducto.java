package com.example.mlappfinal.Presenter;

import com.example.mlappfinal.Interface.InterfazInteractor;
import com.example.mlappfinal.Interface.InterfazPresenter;
import com.example.mlappfinal.Interface.InterfazView;
import com.example.mlappfinal.Model.InteractorProducto;
import com.example.mlappfinal.Model.Producto;
import com.example.mlappfinal.Model.Productos;

import java.util.ArrayList;

public class PresenterProducto  implements InterfazPresenter {

    private InterfazInteractor interactor;
    private InterfazView view;

    public PresenterProducto( InterfazView view) {
        this.interactor = new InteractorProducto(this);
        this.view = view;
    }

    @Override
    public void enviarResultado(ArrayList<Producto> productos) {
        view.mostrarResultado(productos);
    }

    @Override
    public void solicitarDatos(String q) {
        interactor.enviarResultado(q);
    }

    @Override
    public void mostrarError() {
        view.mostrarError();
    }
}
