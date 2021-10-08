package br.edu.vianna.votacao.model.database;

import java.util.ArrayList;

import br.edu.vianna.votacao.model.domain.Aluno;
import br.edu.vianna.votacao.model.domain.Turma;

public class DataBase {

    public static Turma turma = new Turma();

    public static void save(Aluno alu) {

        turma.addAlunos(alu);

    }



    public static ArrayList<String> preencherLista(){

        ArrayList<String> alunos = new ArrayList<>();

        for(int i = 0; i < turma.getAlunos().size(); i++){
            alunos.add(turma.getAlunos().get(i).getNome());
        }

        return alunos;
    }


}
