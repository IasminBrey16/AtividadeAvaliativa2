package com.example.atividadeavaliativa.controller;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.atividadeavaliativa.R;

public class ElementoViewHolder extends RecyclerView.ViewHolder {

    TextView tvSigla;
    TextView tvNome;
    TextView tvZ;
    TextView tvFamilia;

    public ElementoViewHolder(@NonNull View itemView) {
        super(itemView);

        tvSigla = itemView.findViewById(R.id.tvSigla);
        tvNome  = itemView.findViewById(R.id.tvNome);
        tvZ = itemView.findViewById(R.id.tvZ);
        tvFamilia = itemView.findViewById(R.id.tvFamilia);
        }
}
