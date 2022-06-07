package com.example.mlappfinal.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.example.mlappfinal.Interface.InterfazPresenter;
import com.example.mlappfinal.Interface.InterfazView;
import com.example.mlappfinal.Model.Producto;
import com.example.mlappfinal.Model.Productos;
import com.example.mlappfinal.Presenter.PresenterProducto;
import com.example.mlappfinal.R;
import com.example.mlappfinal.View.Adapter.AdapterProducto;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements InterfazView, SearchView.OnQueryTextListener {

    private TextView txterror;
    private RecyclerView recyclerView;
    private InterfazPresenter presenter;
    private AdapterProducto adapterProducto;
    androidx.appcompat.widget.SearchView searchView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        presenter = new PresenterProducto(this);
        txterror=findViewById(R.id.txterror);
        recyclerView = findViewById(R.id.recycler1);
        searchView = findViewById(R.id.searchview);
        searchView.setOnQueryTextListener(this);
    }

    @Override
    protected void onPostResume() {
        searchView.clearFocus();
        super.onPostResume();
    }

    @Override
    public void mostrarResultado(ArrayList<Producto> productos) {
        txterror.setVisibility(View.GONE);
        adapterProducto = new AdapterProducto(productos,this);
        recyclerView.setAdapter(adapterProducto);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setVisibility(View.VISIBLE);
    }

    @Override
    public void solicitarDatos(String q) {
        presenter.solicitarDatos(q);
    }

    @Override
    public void mostrarError() {
        recyclerView.setVisibility(View.GONE);
        txterror.setVisibility(View.VISIBLE);
    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        searchView.clearFocus();
        solicitarDatos(query);
        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        return false;
    }
}