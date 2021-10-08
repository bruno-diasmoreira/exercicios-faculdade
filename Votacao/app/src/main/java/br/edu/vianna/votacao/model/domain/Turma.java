package br.edu.vianna.votacao.model.domain;

import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Turma {

    private ArrayList<Aluno> alunos;
    private Aluno representante;

    public Turma() {
        Aluno alu1 = new Aluno("Zezin");
        Aluno alu2 = new Aluno("Pedrin");
        Aluno alu3 = new Aluno("Gustavo");
        Aluno alu4 = new Aluno("Bruno");
        alunos = new ArrayList<Aluno>(Arrays.asList(new Aluno[]{alu1,alu2,alu3,alu4}));
    }



    public Aluno repesentanteTurma(){

        Aluno maior = alunos.get(0);


        for(int i = 1; i < alunos.size(); i++){

            if(alunos.get(i).getVoto() > maior.getVoto()){
                maior = alunos.get(i);
            }
        }
        return maior;
    }


    public double percentVotosGanhador(){


        return (double)repesentanteTurma().getVoto() / TotalVotos() * 100;
    }


    public int TotalVotos(){

        int votosTotal = 0;

        for (Aluno a: alunos) {
            votosTotal += a.getVoto();
        }
        return votosTotal;
    }






    public Turma(Aluno representante) {
        this.representante = representante;
    }

    public ArrayList<Aluno> getAlunos() {
        return alunos;
    }

    public void addAlunos(Aluno aluno) {
        alunos.add(aluno);
    }

    public Aluno getRepresentante() {
        return representante;
    }

    public void setRepresentante(Aluno representante) {
        this.representante = representante;
    }
}
