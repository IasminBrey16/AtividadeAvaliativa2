package com.example.atividadeavaliativa;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.atividadeavaliativa.Model.Carro;
import com.example.atividadeavaliativa.Model.CarroDAO;

public class DetalhesActivity extends AppCompatActivity {

    TextView tvMarca;
    TextView tvModelo;
    TextView tvAno;
    TextView tvCor;
    TextView tvMotor;
    TextView tvCombustivel;
    TextView tvFipe;
    CarroDAO dao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhes);

        inicializarComponentes();
        dao = new CarroDAO();

        Intent intent = getIntent();
        int position = intent.getIntExtra("position", -1);

        if(position == -1){
            finish();
        }

        Carro carro = dao.getCarro(position);
        if (carro != null) {
            tvMarca.setText(carro.getMarca());
            tvModelo.setText(carro.getModelo());
            tvAno.setText(String.valueOf( carro.getAno()));
            tvCor.setText(carro.getCor());
            tvMotor.setText(String.valueOf(carro.getMotor()));
            tvCombustivel.setText(carro.getCombustivel());
            tvFipe.setText(String.valueOf(carro.getFipe()));
        }
    }

    private void inicializarComponentes() {
        tvMarca = findViewById(R.id.tvMarca);
        tvModelo = findViewById(R.id.tvModelo);
        tvAno = findViewById(R.id.tvAno);
        tvCor = findViewById(R.id.tvCor);
        tvMotor = findViewById(R.id.tvMotor);
        tvCombustivel = findViewById(R.id.tvCombustivel);
        tvFipe = findViewById(R.id.tvFipe);
    }
}