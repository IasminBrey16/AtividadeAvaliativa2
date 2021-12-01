package com.example.atividadeavaliativa2.adapter;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.atividadeavaliativa2.R;

public class PizzaViewHolder extends RecyclerView.ViewHolder {

    TextView tvSaborL;
    TextView tvPrecoL;

    public PizzaViewHolder(@NonNull View itemView) {
        super(itemView);

        tvSaborL = itemView.findViewById(R.id.tvSaborL);
        tvPrecoL = itemView.findViewById(R.id.tvPrecoL);
    }

}
