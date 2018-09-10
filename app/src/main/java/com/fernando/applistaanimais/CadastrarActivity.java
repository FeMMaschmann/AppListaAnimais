package com.fernando.applistaanimais;

import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.fernando.applistaanimais.dao.CategoriaDAO;
import com.fernando.applistaanimais.model.Categoria;

public class CadastrarActivity extends AppCompatActivity {

    private EditText etNomeCategoria;
    private Button btnSalvarCategoria;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastrar);

        etNomeCategoria = (EditText) findViewById(R.id.etNomeCategoria);
        btnSalvarCategoria = (Button) findViewById(R.id.btnSalvarCategoria);

        btnSalvarCategoria.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                salvar();
            }
        });
    }

    private void salvar(){
        String nome = etNomeCategoria.getText().toString();

        if (nome.isEmpty()){
            AlertDialog.Builder alerta = new AlertDialog.Builder(this);
            alerta.setTitle(getResources().getString(R.string.txtAtencao));
            alerta.setMessage(R.string.txtCamposObrigatoriosAnimal);
            alerta.setIcon(android.R.drawable.ic_dialog_alert);
            alerta.setNeutralButton("OK", null);
            alerta.show();
        } else {
            Categoria cat = new Categoria();
            cat.setNome(nome);

            CategoriaDAO.inserir(this, cat);

            finish();
        }
    }
}
