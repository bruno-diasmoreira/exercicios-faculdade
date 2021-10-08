package br.edu.vianna.apsmobile;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button btnCadastrar,btnMostrar,btnExcluirPessoas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        binding();

        btnCadastrar.setOnClickListener(callViewCadastro());
        btnMostrar.setOnClickListener(callViewMostrar());
        btnExcluirPessoas.setOnClickListener(callViewExcluir());

    }

    private View.OnClickListener callViewExcluir() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent it = new Intent(getApplicationContext(),ExcluirPessoas.class);
                startActivityForResult(it,3);
            }
        };
    }

    private View.OnClickListener callViewMostrar() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent it = new Intent(getApplicationContext(),BuscandoPessoas.class);
                startActivityForResult(it,2);

            }
        };
    }


    private View.OnClickListener callViewCadastro() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent it = new Intent(getApplicationContext(),CadastroPessoas.class);
                startActivityForResult(it,1);
            }
        };
    }

    private void binding() {
        btnMostrar = findViewById(R.id.btnMostrar);
        btnCadastrar = findViewById(R.id.btnCadastrar);
        btnExcluirPessoas = findViewById(R.id.btnExcluirPessoas);
    }
}