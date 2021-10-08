package br.edu.vianna.apsmobile;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.lang.reflect.Field;
import java.util.List;

import br.edu.vianna.apsmobile.domain.Pessoa;

public class CadastroPessoas extends AppCompatActivity {

    private EditText edtNome,edtIdade;
    private Button btnSalvar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_pessoas);

        binding();

        btnSalvar.setOnClickListener( callviewSalvarCadastro() );


    }

    private View.OnClickListener callviewSalvarCadastro() {

        return new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!edtNome.getText().toString().isEmpty() &&
                   !edtIdade.getText().toString().isEmpty()){
                    Pessoa p = new Pessoa(edtNome.getText().toString(),Integer.parseInt(edtIdade.getText().toString()));
                    p.save();
                    Toast.makeText(getApplicationContext(),"Cadastro salvo com sucesso",Toast.LENGTH_LONG).show();
                    finish();
                }
                else{
                    Toast.makeText(getApplicationContext(), "Preencha os campos corretamente", Toast.LENGTH_SHORT).show();
                }
            }
        };
    }

    private void binding() {
        edtNome = findViewById(R.id.edtNome);
        edtIdade = findViewById(R.id.edtIdade);
        btnSalvar = findViewById(R.id.btnSalvar);
    }
}