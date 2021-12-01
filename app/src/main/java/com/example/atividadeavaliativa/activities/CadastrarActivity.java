package com.example.atividadeavaliativa.activities;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.atividadeavaliativa.R;
import com.example.atividadeavaliativa.model.Elemento;
import com.example.atividadeavaliativa.controller.ElementoDAO;

public class CadastrarActivity extends AppCompatActivity {

    EditText etSigla;
    EditText etNome;
    EditText etZ;
    EditText etFamilia;
    Button bAdicionar;
    ElementoDAO dao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastrar);

        dao = new ElementoDAO();
        inicializarComponentes();

        bAdicionar.setOnClickListener(v -> {
            if (etSigla.getText().toString().isEmpty() ||
                etNome.getText().toString().isEmpty() ||
                etZ.getText().toString().isEmpty() ||
                etFamilia.getText().toString().isEmpty()) {
                Toast.makeText(this, "Por favor preencha todos os campos!", Toast.LENGTH_SHORT).show();
            } else {

                String sigla = etSigla.getText().toString();
                String nome = etNome.getText().toString();
                int z = Integer.parseInt(etZ.getText().toString());
                String familia = etFamilia.getText().toString();

                Elemento elemento = new Elemento(
                        sigla,
                        nome,
                        z,
                        familia
                );

                dao.adicionar(elemento);
                Toast.makeText(this, "Elemento cadastrado com sucesso!", Toast.LENGTH_SHORT).show();

                finish();
            }});}

    private void inicializarComponentes() {
        etSigla = findViewById(R.id.etSigla);
        etNome = findViewById(R.id.etNome);
        etZ = findViewById(R.id.etZ);
        etFamilia = findViewById(R.id.etFamilia);
        bAdicionar = findViewById(R.id.bAdicionar);
    }
}