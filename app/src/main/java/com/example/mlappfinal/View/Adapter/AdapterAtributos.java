package com.example.mlappfinal.View.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mlappfinal.Model.Atributos;
import com.example.mlappfinal.R;

import java.io.Serializable;
import java.util.ArrayList;

public class AdapterAtributos extends RecyclerView.Adapter<AdapterAtributos.viewHolderAtributos> {

    private ArrayList<Atributos> atributos;
    private Context context;

    public AdapterAtributos(ArrayList<Atributos> atributos, Context context) {
        this.atributos = atributos;
        this.context = context;
    }

    @NonNull
    @Override
    public viewHolderAtributos onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_atributos,null,false);
        return new viewHolderAtributos(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolderAtributos holder, int position) {
        Atributos a = atributos.get(position);
        holder.titulo.setText(a.getName());
        holder.descripcion.setText(a.getValue_name());
    }

    @Override
    public int getItemCount() {
        return atributos.size();
    }

    public class viewHolderAtributos extends RecyclerView.ViewHolder {

        private TextView titulo, descripcion;

        public viewHolderAtributos(@NonNull View itemView) {
            super(itemView);
            titulo = itemView.findViewById(R.id.titulo1);
            descripcion = itemView.findViewById(R.id.descripcion1);
        }
    }
}
