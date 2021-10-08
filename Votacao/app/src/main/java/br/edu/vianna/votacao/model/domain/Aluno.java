package br.edu.vianna.votacao.model.domain;

import java.io.Serializable;

public class Aluno implements Serializable {

    private String nome;
    private int voto;

    private boolean jahVotou;


    public Aluno() {
        jahVotou = false;
    }

    public Aluno(String nome) {
        this.nome = nome;
    }


    public void voto(){
        voto++;
    }






    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getVoto() {
        return voto;
    }

    public void setVoto(int voto) {
        this.voto = voto;
    }

    public boolean isJahVotou() {
        return jahVotou;
    }

    public void setJahVotou(boolean jahVotou) {
        this.jahVotou = jahVotou;
    }
}
