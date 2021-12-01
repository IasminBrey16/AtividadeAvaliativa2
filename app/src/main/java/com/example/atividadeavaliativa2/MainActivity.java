package com.example.atividadeavaliativa2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import android.content.Intent;
import android.os.Bundle;

import com.example.atividadeavaliativa2.adapter.PizzaAdapter;

public class MainActivity extends AppCompatActivity {

    RecyclerView rvPizzas;
    FloatingActionButton fabAdd;
    PizzaAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rvPizzas = findViewById(R.id.rvPizzas);
        fabAdd = findViewById(R.id.fabAdd);

        adapter = new PizzaAdapter(this);

        LinearLayoutManager layout = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);

        rvPizzas.setLayoutManager(layout);
        rvPizzas.setAdapter(adapter);

        fabAdd.setOnClickListener(v-> startActivity(new Intent(this, FormActivity.class)));
    }

    @Override
    protected void onResume() {
        super.onResume();
        adapter.atualizarDataSet();
    }
}