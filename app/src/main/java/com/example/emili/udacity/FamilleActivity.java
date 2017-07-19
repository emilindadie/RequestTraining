package com.example.emili.udacity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class FamilleActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    List<World> words;
    WordAdapter wordAdapter;
    RecyclerView.LayoutManager layoutManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_famille);

        recyclerView = (RecyclerView) findViewById(R.id.recyclerViewFamille);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(layoutManager);


        words = new ArrayList<World>();

        words.add(new World("father", "әpә", R.drawable.family_father));
        words.add(new World("mother", "әṭa", R.drawable.family_mother));
        words.add(new World("son", "angsi", R.drawable.family_son));
        words.add(new World("daughter", "tune", R.drawable.family_daughter));
        words.add(new World("older brother", "taachi", R.drawable.family_older_brother));
        words.add(new World("younger brother", "chalitti", R.drawable.family_younger_brother));
        words.add(new World("older sister", "teṭe", R.drawable.family_older_sister));
        words.add(new World("younger sister", "kolliti", R.drawable.family_younger_sister));
        words.add(new World("grandmother ", "ama", R.drawable.family_grandmother));
        words.add(new World("grandfather", "paapa", R.drawable.family_grandfather));

        wordAdapter = new WordAdapter(FamilleActivity.this, words);
        recyclerView.setAdapter(wordAdapter);

    }
}
