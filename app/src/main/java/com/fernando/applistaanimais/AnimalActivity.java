package com.fernando.applistaanimais;

import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.fernando.applistaanimais.dao.AnimalDAO;
import com.fernando.applistaanimais.dao.CategoriaDAO;
import com.fernando.applistaanimais.model.Animal;
import com.fernando.applistaanimais.model.Categoria;

import java.util.List;

public class AnimalActivity extends AppCompatActivity {

    private EditText etNome, etIdade;
    private Button btnSalvarAnimal;
    private Spinner spCategoria;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animal);

        etNome = (EditText) findViewById(R.id.etNomeAnimal);
        etIdade = (EditText) findViewById(R.id.etIdade);
        btnSalvarAnimal = (Button) findViewById(R.id.btnSalvarAnimal);
        spCategoria = (Spinner) findViewById(R.id.spCategoria);

        carregarCategorias();

        btnSalvarAnimal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                salvar();
            }
        });
    }

    private void salvar(){
        String nome = etNome.getText().toString();

        if (nome.isEmpty() || spCategoria.getSelectedItemPosition() == 0){
            AlertDialog.Builder alerta = new AlertDialog.Builder(this);
            alerta.setTitle(getResources().getString(R.string.txtAtencao));
            alerta.setMessage(R.string.txtCamposObrigatorios);
            alerta.setIcon(android.R.drawable.ic_dialog_alert);
            alerta.setNeutralButton("OK", null);
            alerta.show();
        }else {
            String idade = etIdade.getText().toString();
            if (idade.isEmpty())
                idade = "0";
            idade = idade.replace(",", ".");
            int ida = Integer.valueOf(idade);

            Animal animal = new Animal();
            animal.setNome(nome);
            animal.setIdade(ida);
            animal.setCategoria((Categoria) spCategoria.getSelectedItem());

            AnimalDAO.inserir(this, animal);

            finish();
        }
    }

    private void carregarCategorias(){
        List<Categoria> lista = CategoriaDAO.getCategorias(this);
        Categoria fake = new Categoria();
        fake.setId(0);
        fake.setNome(getResources().getString(R.string.txtSelecione));
        lista.add(0, fake);

        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, lista);
        spCategoria.setAdapter(adapter);

    }
}
