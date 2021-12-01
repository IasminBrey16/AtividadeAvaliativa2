package com.example.atividadeavaliativa.controller;

import java.util.ArrayList;
import java.util.List;

import com.example.atividadeavaliativa.model.Elemento;

public class ElementoDAO {

    private static List<Elemento> ListaElementos = new ArrayList<>();

    public void adicionar (Elemento elemento){ ListaElementos.add(elemento); }

    public List<Elemento> getListaElementos(){
        return ListaElementos;
    }

    public Elemento getElemento(int i){
        return ListaElementos.get(i);
    }
}
