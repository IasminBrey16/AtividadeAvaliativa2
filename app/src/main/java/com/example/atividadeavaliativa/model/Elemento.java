package com.example.atividadeavaliativa.model;

public class Elemento {

    private String sigla;
    private String nome;
    private int z;
    private String familia;

    public Elemento(String sigla, String nome, int z, String familia) {
        this.sigla = sigla;
        this.nome = nome;
        this.z = z;
        this.familia = familia;
    }


    public String getSigla() {
        return sigla;
    }

    public void setSigla(String marca) {
        this.sigla = sigla;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getZ() {
        return z;
    }

    public void setZ(int z) {
        this.z = z;
    }

    public String getFamilia() {
        return familia;
    }

    public void setFamilia(String familia) {
        this.familia = familia;
    }

    @Override
    public String toString() {
        return "Elemento{" +
                "sigla='" + sigla + '\'' +
                ", nome='" + nome + '\'' +
                ", numero atômico='" + z + '\'' +
                ", familia='" + familia + '\'' +
                '}';
    }
}
