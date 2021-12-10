package com.example.andrevina;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import java.util.AbstractSequentialList;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;


public class RankingActivity extends AppCompatActivity {

    public static ArrayList players = new ArrayList<Player>();

    RecyclerView recycler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ranking);

        sortArrayList();

        recycler=(RecyclerView) findViewById(R.id.recyclerId);
        recycler.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL, false));

        CustomAdapter adapter = new CustomAdapter(players);
        recycler.setAdapter(adapter);

        //names[0] = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);
    }


    private void sortArrayList(){
        Collections.sort(players, new Comparator<Player>(){
            @Override
            public int compare(Player o1, Player o2) {
                if (o1.get_intents() == o2.get_intents()){
                    return o1.get_segundos() - o2.get_segundos();
                } else {
                    return o1.get_intents() - o2.get_intents();
                }
            }
        });

    }
}