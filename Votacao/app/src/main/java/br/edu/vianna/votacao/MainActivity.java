package br.edu.vianna.votacao;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button btnVotacao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        binding();

        btnVotacao.setOnClickListener(callViewVotacao() );
    }

    private View.OnClickListener callViewVotacao() {

        return new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent it = new Intent(getApplicationContext(),VotacaoActivity.class);
                startActivityForResult(it,1);
            }
        };
    }

    private void binding() {
        btnVotacao = findViewById(R.id.btnVotacao);
    }
}