package com.example.atividadeavaliativa2;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.atividadeavaliativa2.database.dao.CardapioDB;
import com.example.atividadeavaliativa2.database.dao.PizzaDAO;
import com.example.atividadeavaliativa2.entity.Pizza;
import com.example.atividadeavaliativa2.util.Util;

public class FormActivity extends AppCompatActivity {

    EditText etSabor;
    EditText etIngredientes;
    EditText etPreco;
    Button bSalvar;
    Button bExcluir;

    PizzaDAO dao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);

        etSabor = findViewById(R.id.etSabor);
        etIngredientes = findViewById(R.id.etIngredientes);
        etPreco = findViewById(R.id.etPreco);
        bSalvar  = findViewById(R.id.bSalvar);
        bExcluir = findViewById(R.id.bExcluir);

        dao = CardapioDB.getInstance(this).getPizzaDAO();
        Pizza pizzaIntent;

        Intent formIntent = getIntent();

        if (formIntent.hasExtra("pizza")){

            pizzaIntent = (Pizza) formIntent.getSerializableExtra("pizza");
            etSabor.setText(pizzaIntent.getSabor());
            etIngredientes.setText(pizzaIntent.getIngredientes());
            etPreco.setText(String.valueOf(pizzaIntent.getPreco()));
            bExcluir.setVisibility(View.VISIBLE);
        } else {
            pizzaIntent = null;
        }

        bSalvar.setOnClickListener(v->{

            if (etIngredientes.getText().toString().isEmpty() || etSabor.getText().toString().isEmpty() || etPreco.getText().toString().isEmpty()) {
                Util.exibirToast(this, "Preencha todos os campos!");
            } else {

                Pizza c = new Pizza(0, etSabor.getText().toString(), etIngredientes.getText().toString(), Double.parseDouble(etPreco.getText().toString()));
                String msg;

                if (pizzaIntent == null){
                    dao.salvar(c);
                    msg = "Sabor salvo!";

                } else {
                    c.setId(pizzaIntent.getId());
                    dao.editar(c);
                    msg = "Alterações salvas!";
                }
                Util.exibirToast(this, msg);
                finish();
            }
        });

        bExcluir.setOnClickListener(v->{
            new AlertDialog.Builder(this)
                    .setTitle("Excluir")
                    .setMessage("Tem certeza que deseja excluir esse sabor?\nEsta ação não poderá ser desfeita.")
                    .setNegativeButton("Não", null)
                    .setPositiveButton("Sim, remova!", (dialogInterface, i) -> {
                        dao.excluir(pizzaIntent);
                        Util.exibirToast(this, "Sabor excluído!");
                        finish();
                    })
                    .show();
        });
    }
}
