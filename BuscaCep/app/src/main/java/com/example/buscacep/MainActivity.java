package com.example.buscacep;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.buscacep.ConfigRetrofit.RetrofitConfig;
import com.example.buscacep.model.Cep;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private EditText editCEP;
    private TextView tvCEP, tvLogradouro, tvComplemento, tvBairro, tvLocalidade, tvUF;
    private Button btnBuscar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        binding();

        btnBuscar.setOnClickListener(callViewBuscar());
    }


    private View.OnClickListener callViewBuscar() {

        return new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Call<Cep> call = new RetrofitConfig().getCEPService().findCEP(editCEP.getText().toString());

                call.enqueue(realizarRequestEobterResposta());

            }
        };
    }


    private Callback<Cep> realizarRequestEobterResposta() {
        return new Callback<Cep>() {
            @Override
            public void onResponse(Call<Cep> call, Response<Cep> response) {

                // Preenche o objeto CEP
                Cep cep = response.body();

                //Preencher os campos para aparecer na tela
                tvCEP.setText("CEP: " + cep.getCep());
                tvLogradouro.setText("Logradouro: " + cep.getLogradouro());
                tvComplemento.setText("Complemento: " + cep.getComplemento());
                tvBairro.setText("Bairro: " + cep.getBairro());
                tvLocalidade.setText("Localidade: " + cep.getLocalidade());
                tvUF.setText("UF: " + cep.getUf());
            }

            @Override
            public void onFailure(Call<Cep> call, Throwable t) {
                Log.e("Service CEP   ", "Encontrou erro ao buscar o CEP: " + t.getMessage());
            }
        };
    }


    private void binding() {

        editCEP = findViewById(R.id.editCEP);
        tvCEP = findViewById(R.id.tvCEP);
        tvLogradouro = findViewById(R.id.tvLogradouro);
        tvComplemento = findViewById(R.id.tvComplemento);
        tvBairro = findViewById(R.id.tvBairro);
        tvLocalidade = findViewById(R.id.tvLocalidade);
        tvUF = findViewById(R.id.tvUF);
        btnBuscar = findViewById(R.id.btnBuscar);
    }


}