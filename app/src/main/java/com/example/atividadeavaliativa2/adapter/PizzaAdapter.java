package com.example.atividadeavaliativa2.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.atividadeavaliativa2.DetalhesActivity;
import com.example.atividadeavaliativa2.FormActivity;
import com.example.atividadeavaliativa2.R;
import com.example.atividadeavaliativa2.database.dao.CardapioDB;
import com.example.atividadeavaliativa2.database.dao.PizzaDAO;
import com.example.atividadeavaliativa2.entity.Pizza;

import java.util.List;

public class PizzaAdapter extends RecyclerView.Adapter {

    private Context context;
    private PizzaDAO dao;
    private List<Pizza> cardapio;

    public PizzaAdapter(Context context) {
        this.context = context;
        dao = CardapioDB.getInstance(context).getPizzaDAO();
        cardapio = dao.getPizzas();
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View itemView = LayoutInflater.from(context).inflate(R.layout.pizza_layout, parent, false);

        PizzaViewHolder pizzaVH = new PizzaViewHolder(itemView);

        return pizzaVH;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        PizzaViewHolder pizzaVH = (PizzaViewHolder) holder;

        Pizza pizza = cardapio.get(position);

        pizzaVH.tvSaborL.setText(pizza.getSabor());
        pizzaVH.tvPrecoL.setText(String.valueOf(pizza.getPreco()));

        pizzaVH.tvSaborL.setOnLongClickListener(view -> {
            Intent intent = new Intent(context, DetalhesActivity.class);
            intent.putExtra("pizza", pizza);
            context.startActivity(intent);
            return false;
        });
    }

    @Override
    public int getItemCount() {
        return cardapio.size();
    }

    public void atualizarDataSet() {
        cardapio.clear();
        cardapio = dao.getPizzas();
        notifyDataSetChanged();
    }
}
