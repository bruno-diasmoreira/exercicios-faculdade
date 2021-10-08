package br.edu.vianna.pesquisapopulacao;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.provider.ContactsContract;
import android.widget.TextView;

import br.edu.vianna.pesquisapopulacao.model.database.DataBase;
import br.edu.vianna.pesquisapopulacao.model.domain.Populacao;

public class ResultadoActivity extends AppCompatActivity {

    private TextView tvMaiorMenorAltura,tvMediaAlturaMulheres,tvQntHomens,tvPorcentHomemMulher,
            tvPorcentMulher,tvPorcentFemininoIdadeCor;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultado);

        binding();

        tvMaiorMenorAltura.setText("Maior Altura: "+ DataBase.pop.maiorAltura() + "::  Menor Altura: " +DataBase.pop.menorAltura() );
        tvMediaAlturaMulheres.setText("Média Altura das Mulheres: "+DataBase.pop.mediaAlturaMulheres());
        tvQntHomens.setText("Quantidade de Homens: "+DataBase.pop.qntHomens());

        tvPorcentHomemMulher.setText("Porcent Homem: "+ DataBase.pop.porcentHomem() + "%");

        tvPorcentMulher.setText("Porcent Mulher: "+ DataBase.pop.porcentMulher() + "%");

        tvPorcentFemininoIdadeCor.setText("Porcent Mulher Idade entre 18 a 35: "+ DataBase.pop.porcentFemininoIdade() + "%");

    }

    private void binding() {

        tvMaiorMenorAltura = findViewById(R.id.tvMaiorMenorAltura);
        tvMediaAlturaMulheres = findViewById(R.id.tvMediaAlturaMulheres);
        tvQntHomens = findViewById(R.id.tvQntHomens);

        tvPorcentMulher = findViewById(R.id.tvPorcentMulher);

        tvPorcentFemininoIdadeCor = findViewById(R.id.tvPorcentFemininoIdadeCor);

        tvPorcentHomemMulher = findViewById(R.id.tvPorcentHomemMulher);


    }
}