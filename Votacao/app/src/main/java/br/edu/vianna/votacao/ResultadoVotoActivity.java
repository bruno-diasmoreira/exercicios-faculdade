package br.edu.vianna.votacao;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import br.edu.vianna.votacao.model.database.DataBase;
import br.edu.vianna.votacao.model.domain.Aluno;
import br.edu.vianna.votacao.model.domain.Turma;

public class ResultadoVotoActivity extends AppCompatActivity {

    private TextView tvTeste;

    private Aluno aluno;

    private ListView listVotacao;
    private int indice;

    Turma t = new Turma();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultado_voto);

        binding();

        indice = (int) getIntent().getExtras().getSerializable("aluno");

       // aluno = (Aluno) getIntent().getExtras().getSerializable("aluno");

        aluno = t.getAlunos().get(indice);

        tvTeste.setText("Bem vindo: "+ aluno.getNome());



       // ArrayList<String> alu = preencherLista(t.getAlunos());

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,DataBase.preencherLista());
        listVotacao.setAdapter(arrayAdapter);



        listVotacao.setOnItemClickListener( callViewVotacao() );

    }

    private AdapterView.OnItemClickListener callViewVotacao() {

        return new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {



                if(indice == i){

                    Toast.makeText(getApplicationContext()," Não pode votar em si mesmo ",Toast.LENGTH_LONG).show();
                    return ;
                }


               //t.getAlunos().get(i).voto();
                DataBase.turma.getAlunos().get(i).voto();

               // Toast.makeText(getApplicationContext()," "+ DataBase.turma.getAlunos().get(i).getNome(),Toast.LENGTH_LONG).show();

                Toast.makeText(getApplicationContext(),"VOTO REALIZADO",Toast.LENGTH_LONG).show();

                Intent it = new Intent();

                it.putExtra("nome",indice);

                setResult(20,it);

                finish();
            }
        };
    }

    private void binding() {
        tvTeste = findViewById(R.id.tvTeste);
        listVotacao = findViewById(R.id.listVotacao);
    }

//    public ArrayList<String> preencherLista(ArrayList<Aluno> list){
//
//        ArrayList<String> alunos = new ArrayList<>();
//
//        for(int i = 0; i < list.size(); i++){
//            alunos.add(list.get(i).getNome());
//        }
//
//        alunos.remove(aluno.getNome());
//
//        return alunos;
//    }
//


}