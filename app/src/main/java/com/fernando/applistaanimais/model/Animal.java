package com.fernando.applistaanimais.model;

/**
 * Created by android on 06/09/2018.
 */

public class Animal {

    private int id;
    private String nome;
    private int idade;
    private Categoria categoria;

    public Animal() {
    }

    public Animal(int id, String nome, int idade, Categoria categoria) {
        this.id = id;
        this.nome = nome;
        this.idade = idade;
        this.categoria = categoria;
    }

    @Override
    public String toString() {
        return nome;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }
}
