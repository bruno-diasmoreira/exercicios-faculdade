package br.edu.vianna.votacao;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import br.edu.vianna.votacao.model.database.DataBase;
import br.edu.vianna.votacao.model.domain.Aluno;
import br.edu.vianna.votacao.model.domain.Turma;

public class VotacaoActivity extends AppCompatActivity {

    private ListView listAlunos;
    private Button btnResultado;
    private TextView tvResult1,tvResult2,tvResult3,tvResult4,tvRepresentante;

    Turma t = new Turma();

    ArrayAdapter<String> arrayAdapter;

    //ArrayList<String> alu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_votacao);

        binding();


       // alu = DataBase.preencherLista();




        arrayAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,DataBase.preencherLista());
        listAlunos.setAdapter(arrayAdapter);




        listAlunos.setOnItemClickListener( callViewLista() );


        btnResultado.setOnClickListener( callResultadoVotacao() );


    }

    private View.OnClickListener callResultadoVotacao() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                boolean todosVotaram = false;

                for (Aluno l:t.getAlunos()) {
                    if(l.isJahVotou()){
                        todosVotaram = true;
                    }else{
                        todosVotaram = false;
                        Toast.makeText(getApplicationContext(),"Todos os alunos tem que votar",Toast.LENGTH_LONG).show();
                    }
                }

                if(todosVotaram){
                    tvResult1.setText(DataBase.turma.getAlunos().get(0).getNome()+" tem "+DataBase.turma.getAlunos().get(0).getVoto()+ " votos" );
                    tvResult2.setText(DataBase.turma.getAlunos().get(1).getNome()+" tem "+DataBase.turma.getAlunos().get(1).getVoto()+ " votos" );
                    tvResult3.setText(DataBase.turma.getAlunos().get(2).getNome()+" tem "+DataBase.turma.getAlunos().get(2).getVoto()+ " votos" );
                    tvResult4.setText(DataBase.turma.getAlunos().get(3).getNome()+" tem "+DataBase.turma.getAlunos().get(3).getVoto()+ " votos" );

                    tvRepresentante.setText("O "+ DataBase.turma.repesentanteTurma().getNome()+ " é o representante da turma com "+ DataBase.turma.repesentanteTurma().getVoto() + " votos " +
                            "Percentual: "+ DataBase.turma.percentVotosGanhador() + "% dos votos");
                }
            }
        };

    }

    private AdapterView.OnItemClickListener callViewLista() {

        return new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {


                if(t.getAlunos().get(i).isJahVotou()){
                    Toast.makeText(getApplicationContext(),t.getAlunos().get(i).getNome() + " Ja Votou",Toast.LENGTH_LONG).show();
                    return;
                }

                Intent it = new Intent(getApplicationContext(),ResultadoVotoActivity.class);

                //it.putExtra("aluno", t.getAlunos().get(i));
                it.putExtra("aluno",i);
                startActivityForResult(it,10);
                //Toast.makeText(getApplicationContext(),""+t.getAlunos().get(i).getNome(),Toast.LENGTH_LONG).show();
            }
        };
    }


    private void binding() {

        listAlunos = findViewById(R.id.listAlunos);
        btnResultado = findViewById(R.id.btnResultado);
        tvResult1 = findViewById(R.id.tvResult1);
        tvResult2 = findViewById(R.id.tvResult2);
        tvResult3 = findViewById(R.id.tvResult3);
        tvResult4 = findViewById(R.id.tvResult4);
        tvRepresentante = findViewById(R.id.tvRepresentante);
    }

    protected void onActivityResult(int requestCode,int resultCode, @Nullable Intent data) {
        super.onActivityResult(resultCode,resultCode, data);

        if(requestCode == 10){

            if(resultCode == 20){

               int a = (int) data.getExtras().getSerializable("nome");

                t.getAlunos().get(a).setJahVotou(true);

                //Toast.makeText(getApplicationContext()," "+  t.getAlunos().get(a).isJahVotou(),Toast.LENGTH_LONG).show();

               // Toast.makeText(getApplicationContext(), "Voto computado com sucesso",Toast.LENGTH_LONG).show();
            }
        }

    }

}