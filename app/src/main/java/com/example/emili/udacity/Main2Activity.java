package com.example.emili.udacity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {

    TextView nombre;
    TextView famille;
    TextView couleur;
    TextView phrase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        nombre = (TextView) findViewById(R.id.nombre);
        famille = (TextView) findViewById(R.id.famille);
        couleur = (TextView) findViewById(R.id.couleur);
        phrase = (TextView) findViewById(R.id.phrase);





        nombre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(Main2Activity.this, NombreActivity.class);
                startActivity(intent);
            }
        });

        famille.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(Main2Activity.this, FamilleActivity.class);
                startActivity(intent);
            }
        });


        couleur.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(Main2Activity.this, ColorActivity.class);
                startActivity(intent);
            }
        });


        phrase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(Main2Activity.this, PhraseActivity.class);
                startActivity(intent);
            }
        });

    }
}
