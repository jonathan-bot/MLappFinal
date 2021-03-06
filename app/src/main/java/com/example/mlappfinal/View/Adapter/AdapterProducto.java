package com.example.mlappfinal.View.Adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.example.mlappfinal.Model.Producto;
import com.example.mlappfinal.Model.Productos;
import com.example.mlappfinal.R;
import com.example.mlappfinal.View.DetalleProducto;
import com.example.mlappfinal.View.MainActivity;

import java.io.Serializable;
import java.text.DecimalFormat;
import java.util.ArrayList;

public class AdapterProducto extends RecyclerView.Adapter<AdapterProducto.viewHolderProducto> implements Serializable {

    private ArrayList<Producto> productosArrayList;
    private Context context;

    public AdapterProducto(ArrayList<Producto> productosArrayList, Context context) {
        this.productosArrayList = productosArrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public viewHolderProducto onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list,null,false);
        return new viewHolderProducto(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolderProducto holder, int position) {
        Producto p = productosArrayList.get(position);
        holder.txtnombre.setText(p.getTitle());
        holder.txtprecio.setText(String.valueOf(new DecimalFormat("###,###,###").format(p.getPrice())));
        holder.txtcantidad.setText(String.valueOf(p.getAvailable_quantity()));
        Glide.with(context).load(p.getthumbnail().replaceFirst("http","https"))
                .centerCrop()
                .diskCacheStrategy(DiskCacheStrategy.ALL).into(holder.img);
        holder.itemView.setOnClickListener(view -> {
            Intent a = new Intent(this.context, DetalleProducto.class);
            a.putExtra("img",p.getthumbnail());
            a.putExtra("titulo", p.getTitle());
            a.putExtra("precio", p.getPrice());
            a.putExtra("Atributos",p.getAttributes());
            context.startActivity(a);
        });
    }

    @Override
    public int getItemCount() {
        return productosArrayList.size();
    }

    public class viewHolderProducto extends RecyclerView.ViewHolder {

        private TextView txtnombre,txtprecio,txtcantidad;
        private ImageView img;

        public viewHolderProducto(@NonNull View itemView) {
            super(itemView);
            txtnombre = itemView.findViewById(R.id.txtnombre);
            txtprecio = itemView.findViewById(R.id.txtprecio);
            txtcantidad = itemView.findViewById(R.id.txtcantidad);
            img = itemView.findViewById(R.id.img);
        }
    }
}
