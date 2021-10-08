package br.edu.vianna.apsmobile;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import br.edu.vianna.apsmobile.domain.Pessoa;

public class ExcluirPessoas extends AppCompatActivity {

    private TextView tvQuantidade;
    private Button btnExcluir;

    List<Pessoa> pessoas = Pessoa.listAll(Pessoa.class);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_excluir_pessoas);
        binding();


        tvQuantidade.setText("Quantidade de Pessoas Cadastradas: "+pessoas.size());
        btnExcluir.setOnClickListener( callExcluirPessoas() );




    }

    private View.OnClickListener callExcluirPessoas() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Pessoa.deleteAll(Pessoa.class);
                Toast.makeText(getApplicationContext(),"Pessoas excluidas com sucesso!!!",Toast.LENGTH_LONG).show();
                finish();
            }
        };
    }

    private void binding() {
        btnExcluir = findViewById(R.id.btnExcluir);
        tvQuantidade = findViewById(R.id.tvQuantidade);
    }
}