package br.edu.vianna.pesquisapopulacao;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import br.edu.vianna.pesquisapopulacao.model.database.DataBase;
import br.edu.vianna.pesquisapopulacao.model.domain.Habitante;
import br.edu.vianna.pesquisapopulacao.model.domain.Populacao;

public class CadastrarActivity extends AppCompatActivity {

    private RadioButton rbMasculino,rbAzul,rbVerde,rbLouro,rbCastanho;
    private Button btnSalvar;

    private EditText editIdade,editAltura;

    private static final int RESULTADO_OK = 10;

    Habitante habitante = new Habitante();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastrar);

        binding();

        rbMasculino.setChecked(true);
        rbAzul.setChecked(true);
        rbLouro.setChecked(true);

        btnSalvar.setOnClickListener( callSalvarCadastro() );





    }

    private View.OnClickListener callSalvarCadastro() {

        return new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                String idade = editIdade.getText().toString();
                String altura = editAltura.getText().toString();


                if(idade.equals("")){
                    editIdade.requestFocus();
                    return;
                }
                else if(altura.equals("")){
                    editAltura.requestFocus();
                    return;
                }

                Habitante h = preencherHabitante();

                h.setAltura(Double.parseDouble(editAltura.getText().toString()));
                h.setIdade(Integer.parseInt(editIdade.getText().toString()));



                DataBase.save(h);

                Toast.makeText(getApplicationContext(), "Salvo com sucesso",Toast.LENGTH_LONG).show();

                setResult(RESULTADO_OK);
                finish();
            }
        };
    }

    private Habitante preencherHabitante() {



        if(rbMasculino.isChecked()){
            habitante.setSexo("Masculino");
        }else{
            habitante.setSexo("Feminino");
        }

        if(rbAzul.isChecked()){
            habitante.setCorOlhos("Azul");
        }else if(rbVerde.isChecked()){
            habitante.setCorOlhos("Verde");
        }else{
            habitante.setCorOlhos("Castanho");
        }

        if(rbLouro.isChecked()){
            habitante.setCorCabelo("Louro");
        }else if(rbCastanho.isChecked()){
            habitante.setCorCabelo("Castanho");
        }else{
            habitante.setCorCabelo("Preto");
        }

        return habitante;
    }

    private void binding() {
        rbMasculino = findViewById(R.id.rbMasculino);
        rbAzul = findViewById(R.id.rbAzul);
        rbVerde = findViewById(R.id.rbVerde);
        rbLouro = findViewById(R.id.rbLouro);
        rbCastanho = findViewById(R.id.rbCastanho);

        editIdade = findViewById(R.id.editIdade);
        editAltura = findViewById(R.id.editAltura);

        btnSalvar = findViewById(R.id.btnSalvar);


    }
}