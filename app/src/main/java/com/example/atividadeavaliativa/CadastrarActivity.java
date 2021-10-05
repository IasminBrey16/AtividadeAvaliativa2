package com.example.atividadeavaliativa;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.atividadeavaliativa.Model.Carro;
import com.example.atividadeavaliativa.Model.CarroDAO;

public class CadastrarActivity extends AppCompatActivity {

    EditText etMarca;
    EditText etModelo;
    EditText etAno;
    EditText etCor;
    EditText etMotor;
    EditText etCombustivel;
    EditText etFipe;
    Button bCadastrar;
    CarroDAO dao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastrar);

        dao = new CarroDAO();
        inicializarComponentes();

        bCadastrar.setOnClickListener(v -> {
            if (etMarca.getText().toString().isEmpty() ||
                etModelo.getText().toString().isEmpty() ||
                etAno.getText().toString().isEmpty() ||
                etCor.getText().toString().isEmpty() ||
                etMotor.getText().toString().isEmpty() ||
                etCombustivel.getText().toString().isEmpty() ||
                etFipe.getText().toString().isEmpty()) {
                Toast.makeText(this, "Por favor preencha todos os campos!", Toast.LENGTH_SHORT).show();
            } else {

                String marca = etMarca.getText().toString();
                String modelo = etModelo.getText().toString();
                int ano = Integer.parseInt(etAno.getText().toString());
                String cor = etCor.getText().toString();
                float motor = Float.parseFloat(etMotor.getText().toString());
                String combustivel = etCombustivel.getText().toString();
                float fipe = Float.parseFloat(etFipe.getText().toString());

                Carro carro = new Carro(
                        marca,
                        modelo,
                        ano,
                        cor,
                        motor,
                        combustivel,
                        fipe
                );

                dao.cadastrar(carro);
                Toast.makeText(this, "Carro cadastrado com sucesso!", Toast.LENGTH_SHORT).show();

                finish();
            }
        });

    }

    private void inicializarComponentes() {
        etMarca = findViewById(R.id.etMarca);
        etModelo = findViewById(R.id.etModelo);
        etAno = findViewById(R.id.etAno);
        etCor = findViewById(R.id.etCor);
        etMotor = findViewById(R.id.etMotor);
        etCombustivel = findViewById(R.id.etCombustivel);
        etFipe = findViewById(R.id.etFipe);
        bCadastrar = findViewById(R.id.bCadastrar);
    }
}