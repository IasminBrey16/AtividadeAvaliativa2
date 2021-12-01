package com.example.atividadeavaliativa2.entity;

import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import java.io.Serializable;

@Entity
public class Pizza implements Serializable {

    @PrimaryKey (autoGenerate = true)
    private int id;
    private String sabor;
    private String ingredientes;
    private double preco;

    @Ignore
    public Pizza(int id, String sabor, String ingredientes, double preco) {
        this.id = id;
        this.sabor = sabor;
        this.ingredientes = ingredientes;
        this.preco = preco;
    }

    public Pizza(){

    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getSabor() {
        return sabor;
    }
    public void setSabor(String sabor) {
        this.sabor = sabor;
    }
    public String getIngredientes() {
        return ingredientes;
    }
    public void setIngredientes(String ingredientes) {
        this.ingredientes = ingredientes;
    }
    public double getPreco() {
        return preco;
    }
    public void setPreco(double preco) { this.preco = preco; }

    @Override
    public String toString() { return this.sabor + " " + this.preco; }
}
