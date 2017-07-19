package com.example.emili.udacity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class ColorActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    List<World> words;
    WordAdapter wordAdapter;
    RecyclerView.LayoutManager layoutManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_color);

        recyclerView = (RecyclerView) findViewById(R.id.recyclerViewColor);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(layoutManager);


        words = new ArrayList<World>();

        words.add(new World("red", "weṭeṭṭi", R.drawable.color_red));
        words.add(new World("mustard yellow", "chiwiiṭә", R.drawable.color_mustard_yellow));
        words.add(new World("dusty yellow", "ṭopiisә", R.drawable.color_dusty_yellow));
        words.add(new World("green", "chokokki", R.drawable.color_green));
        words.add(new World("brown", "ṭakaakki", R.drawable.color_brown));
        words.add(new World("gray", "ṭopoppi", R.drawable.color_gray));
        words.add(new World("black", "kululli", R.drawable.color_black));
        words.add(new World("white", "kelelli", R.drawable.color_white));

        wordAdapter = new WordAdapter(ColorActivity.this, words);
        recyclerView.setAdapter(wordAdapter);

    }
}
