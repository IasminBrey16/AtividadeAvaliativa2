package com.example.atividadeavaliativa.activities;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.atividadeavaliativa.R;
import com.example.atividadeavaliativa.controller.ElementoAdapter;
import com.example.atividadeavaliativa.controller.ElementoDAO;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity {

    RecyclerView rvLista;
    FloatingActionButton fabAdicionar;
    ElementoDAO elementoDAO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rvLista = findViewById(R.id.rvLista);
        fabAdicionar = findViewById(R.id.fabAdicionar);
        elementoDAO = new ElementoDAO();

        RecyclerView.LayoutManager meuLayout = new LinearLayoutManager(
                this,
                LinearLayoutManager.VERTICAL,
                false
        );

        rvLista.setLayoutManager(meuLayout);

        fabAdicionar.setOnClickListener(v -> startActivity(new Intent(this, CadastrarActivity.class)));
    }

    @Override
    protected void onResume() {
        super.onResume();
        ElementoAdapter elementoAdapter = new ElementoAdapter(this, elementoDAO);
        rvLista.setAdapter(elementoAdapter);
    }
}