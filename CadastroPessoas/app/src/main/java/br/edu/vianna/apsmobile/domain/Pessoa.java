package br.edu.vianna.apsmobile.domain;

import androidx.appcompat.graphics.drawable.DrawerArrowDrawable;

import com.orm.SugarRecord;


public class Pessoa extends SugarRecord<Pessoa> {


    private String nome;
    private int idade;

    public Pessoa() {
    }

    public Pessoa(String nome, int idade) {
        this.nome = nome;
        this.idade = idade;
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
}
