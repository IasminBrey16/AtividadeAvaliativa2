package com.example.atividadeavaliativa2;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.atividadeavaliativa2.database.dao.CardapioDB;
import com.example.atividadeavaliativa2.database.dao.PizzaDAO;
import com.example.atividadeavaliativa2.entity.Pizza;

public class DetalhesActivity extends AppCompatActivity {
    TextView tvSabor, tvPreco, tvIngredientes;
    Button bExcluir;
    PizzaDAO dao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhes);

        tvSabor = findViewById(R.id.tvDetalhes);
        tvPreco = findViewById(R.id.tvPreco);
        tvIngredientes = findViewById(R.id.tvIngredientes);

        dao = CardapioDB.getInstance(this).getPizzaDAO();
        Pizza pizzaIntent;

        Intent formIntent = getIntent();

        if (formIntent.hasExtra("pizza")){

            pizzaIntent = (Pizza) formIntent.getSerializableExtra("pizza");

            tvSabor.setText("Sabor: " + pizzaIntent.getSabor());
            tvPreco.setText("R$: " + String.valueOf(pizzaIntent.getPreco()));
            tvIngredientes.setText("Ingredientes: " + pizzaIntent.getIngredientes());
        } else {
            pizzaIntent = null;
        }
    }
}

