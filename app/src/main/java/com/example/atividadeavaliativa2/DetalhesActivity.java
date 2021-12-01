package com.example.atividadeavaliativa2;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
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

        bExcluir = findViewById(R.id.bExcluir);

        dao = new PizzaDAO();

        Intent intent = getIntent();

        int i = intent.getIntExtra("i", -1);

        if (i == -1) { finish(); }
        else {
            Pizza pizza = (Pizza) dao.getPizzas(i);

            tvSabor.setText("Sabor: " + pizza.getSabor());
            tvPreco.setText("R$: " + String.valueOf(pizza.getPreco()));
            tvIngredientes.setText("Ingredientes: " + pizza.getIngredientes());

            bExcluir.setOnClickListener(v -> {

                new AlertDialog.Builder(this)
                        .setTitle("Excluir Pizza")
                        .setMessage("Tem certeza que deseja excluir este sabor de Pizza?\n" +
                                "Esta ação não pode ser desfeita.")
                        .setPositiveButton("Sim", (dialogInterface, i1) -> {
                            dao.excluir(i);
                            Toast.makeText(this, "Sabor Excluído", Toast.LENGTH_SHORT).show();
                            finish();
                        })
                        .setNegativeButton("Não", null)
                        .show();
            });
        }
    }
}

