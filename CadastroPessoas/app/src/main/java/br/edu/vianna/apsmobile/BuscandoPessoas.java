package br.edu.vianna.apsmobile;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import br.edu.vianna.apsmobile.domain.Pessoa;

public class BuscandoPessoas extends AppCompatActivity {

    private ListView lvPessoasCadastradas;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buscando_pessoas);

        binding();

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,nomePessoas(Pessoa.listAll(Pessoa.class)));
        lvPessoasCadastradas.setAdapter(arrayAdapter);


    }

    private void binding() {
        lvPessoasCadastradas = findViewById(R.id.lvPessoasCadastradas);
    }



    public List<String> nomePessoas(List<Pessoa> p){
        List<String> nomes = new ArrayList<>();


        for(int i = 0; i < p.size(); i++){
            nomes.add(p.get(i).getNome());
        }

        return nomes;
    }
}