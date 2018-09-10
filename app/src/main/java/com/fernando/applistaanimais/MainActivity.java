package com.fernando.applistaanimais;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button btnListar, btnCadastrarAnimal, btnCadastrarCategoria;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnListar = (Button) findViewById(R.id.btnListar);
        btnCadastrarAnimal = (Button) findViewById(R.id.btnCadastrarAnimal);
        btnCadastrarCategoria = (Button) findViewById(R.id.btnCadastrarCategoria);

        btnListar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, ListActivity.class);
                startActivity(i);
            }
        });

        btnCadastrarAnimal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, AnimalActivity.class);
                startActivity(i);
            }
        });

        btnCadastrarCategoria.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, CadastrarActivity.class);
                startActivity(i);
            }
        });
    }
}
