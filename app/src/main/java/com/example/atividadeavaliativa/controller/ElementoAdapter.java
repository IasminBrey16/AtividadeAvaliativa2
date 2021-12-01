package com.example.atividadeavaliativa.controller;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.atividadeavaliativa.R;

public class ElementoAdapter extends RecyclerView.Adapter {

    private Context context;
    private ElementoDAO elementoDAO;

    public ElementoAdapter(Context context, ElementoDAO elementoDAO) {
        this.context = context;
        this.elementoDAO = elementoDAO;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View itemView = LayoutInflater.from(context).inflate(R.layout.layout_celula, parent, false);
        return new ElementoViewHolder(itemView);
        }

        @Override
        public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

            ElementoViewHolder elementoViewHolder = (ElementoViewHolder) holder;
            elementoViewHolder.tvSigla.setText(elementoDAO.getElemento(position).getSigla());
            elementoViewHolder.tvNome.setText(elementoDAO.getElemento(position).getNome());
            elementoViewHolder.tvZ.setText(String.valueOf(elementoDAO.getElemento(position).getZ()));
            elementoViewHolder.tvFamilia.setText(elementoDAO.getElemento(position).getFamilia());
        }

        @Override
        public int getItemCount() {
            return elementoDAO.getListaElementos().size();
        }
}
