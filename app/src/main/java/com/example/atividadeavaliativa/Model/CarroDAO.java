package com.example.atividadeavaliativa.Model;

import java.util.ArrayList;
import java.util.List;

public class CarroDAO {

    private static List<Carro> lista = new ArrayList<>();

    public void cadastrar (Carro contato){
        lista.add(contato);
    }

    public Carro getCarro(int position){
        return lista.get(position);
    }

    public List<Carro> getLista(){
        return lista;
    }


}
