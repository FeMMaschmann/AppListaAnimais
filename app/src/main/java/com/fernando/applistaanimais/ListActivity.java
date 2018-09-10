package com.fernando.applistaanimais;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.fernando.applistaanimais.dao.AnimalDAO;
import com.fernando.applistaanimais.model.Animal;

import java.util.List;

public class ListActivity extends AppCompatActivity {

    private ListView lvLista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        lvLista = (ListView) findViewById(R.id.lvLista);

        carregarLista();
    }

    private void carregarLista(){
        List<Animal> lista = AnimalDAO.getAnimais(this);
        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, lista);
        lvLista.setAdapter(adapter);
    }
}
