package br.edu.vianna.pesquisapopulacao;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import br.edu.vianna.pesquisapopulacao.model.database.DataBase;
import br.edu.vianna.pesquisapopulacao.model.domain.Populacao;

public class MainActivity extends AppCompatActivity {

    private TextView tvQuantidadePessoas;
    private Button btnCadastrar,btnRealizarPesquisa;

    private static final int VIEW_CADASTRO= 1;
    private static final int RESULT_CADASTRO_OK = 10;

    private static final int VIEW_PESQUISA= 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        binding();


        btnCadastrar.setOnClickListener( callViewCadastro() );


        btnRealizarPesquisa.setOnClickListener( callViewPesquisa() );

    }

    private View.OnClickListener callViewPesquisa() {

        return new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(DataBase.pop.getHabitantes().size() == 0){
                    Toast.makeText(getApplicationContext(), "Cadastre pessoas antes de realizar a pesquisa",Toast.LENGTH_LONG).show();
                    return;
                }

                Intent it = new Intent(getApplicationContext(),ResultadoActivity.class);
                startActivityForResult(it,VIEW_PESQUISA);
            }
        };
    }

    private View.OnClickListener callViewCadastro() {

        return new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent it = new Intent(getApplicationContext(),CadastrarActivity.class);
                startActivityForResult(it,VIEW_CADASTRO);
            }
        };

    }


    @Override
    protected void onActivityResult(int requestCode,int resultCode, @Nullable Intent data) {
        super.onActivityResult(resultCode,resultCode, data);

        if (requestCode == VIEW_CADASTRO){
            if (resultCode == RESULT_CADASTRO_OK){
                tvQuantidadePessoas.setText(""+DataBase.pop.getHabitantes().size());
            }else{
                // não salvou
            }
        }
    }




    private void binding() {

        tvQuantidadePessoas = findViewById(R.id.tvQuantidadePessoas);
        btnCadastrar = findViewById(R.id.btnCadastrar);
        btnRealizarPesquisa = findViewById(R.id.btnRealizarPesquisa);

    }
}