package com.example.mlappfinal.Model;

import java.io.Serializable;
import java.util.ArrayList;

public class Productos implements Serializable {
    ArrayList<Producto> results;

    public ArrayList<Producto> getResults() {
        return results;
    }

    public void setResults(ArrayList<Producto> results) {
        this.results = results;
    }
}
