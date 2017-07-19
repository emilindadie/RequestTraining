package com.example.emili.udacity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class NombreActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    List<World> words;
    WordAdapter wordAdapter;
    RecyclerView.LayoutManager layoutManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nombre);

        recyclerView = (RecyclerView) findViewById(R.id.recyclerViewNombre);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(layoutManager);


        words = new ArrayList<World>();

        words.add(new World("one", "lutti", R.drawable.number_one));
        words.add(new World("two", "otiiko", R.drawable.number_two));
        words.add(new World("three", "tolookosu", R.drawable.number_three));
        words.add(new World("four", "oyyisa", R.drawable.number_four));
        words.add(new World("five", "massokka", R.drawable.number_five));
        words.add(new World("six", "temmokka", R.drawable.number_six));
        words.add(new World("seven", "kenekaku", R.drawable.number_seven));
        words.add(new World("eight", "kawinta", R.drawable.number_eight));
        words.add(new World("nine", "wo’e", R.drawable.number_nine));
        words.add(new World("ten", "na’aacha", R.drawable.number_ten));

        wordAdapter = new WordAdapter(NombreActivity.this, words);
        recyclerView.setAdapter(wordAdapter);

    }
}
