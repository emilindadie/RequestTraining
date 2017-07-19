package com.example.emili.udacity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class PhraseActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    List<World> words;
    WordAdapter wordAdapter;
    RecyclerView.LayoutManager layoutManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phrase);

        recyclerView = (RecyclerView) findViewById(R.id.recyclerViewPhrase);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(layoutManager);

        words = new ArrayList<World>();

        words.add(new World("Where are you going?", "minto wuksus"));
        words.add(new World("What is your name?", "tinnә oyaase'nә"));
        words.add(new World("My name is...", "oyaaset..."));
        words.add(new World("How are you feeling?", "michәksәs?"));
        words.add(new World("I’m feeling good.", "kuchi achit"));
        words.add(new World("Are you coming?", "әәnәs'aa?"));
        words.add(new World("Yes, I’m coming.", "hәә’ әәnәm"));
        words.add(new World("I’m coming.", "әәnәm"));
        words.add(new World("Let’s go.", "yoowutis"));
        words.add(new World("Come here.", "әnni'nem"));

        wordAdapter = new WordAdapter(PhraseActivity.this, words);
        recyclerView.setAdapter(wordAdapter);

    }
}
