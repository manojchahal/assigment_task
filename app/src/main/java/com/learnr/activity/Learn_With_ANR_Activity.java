package com.learnr.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import com.learnr.R;
import com.learnr.adapter.Leaderboard_adapter;
import com.learnr.adapter.Learn_adapter;
import com.learnr.model.Leader_model;

import java.util.ArrayList;

public class Learn_With_ANR_Activity extends AppCompatActivity {
    private RecyclerView learn_recy;
    public ArrayList<Leader_model> itemList = new ArrayList<Leader_model>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_learn__with__a_n_r);
        itemList.add(new Leader_model("1","Why Invest?",R.drawable.money,"why you should invest in stock \nmarket?"));
        itemList.add(new Leader_model("2","Basics of stock market.",R.drawable.bull_match,"what you should know before \ninvesting?"));
        itemList.add(new Leader_model("3","Finding great companies.",R.drawable.home_icon,"where you should invest?"));
        itemList.add(new Leader_model("4","Your investing life.",R.drawable.money_plant,"Enverthing you should know about \ninvesting."));
        itemList.add(new Leader_model("5","Getting started.",R.drawable.rocket,"How you should start investing?."));
        learn_recy=findViewById(R.id.learn_recy);
        learn_recy.setHasFixedSize(true);
        learn_recy.setLayoutManager(new LinearLayoutManager(this));
        Learn_adapter shareddevAdapter = new Learn_adapter(this, this, itemList);
        learn_recy.setAdapter(shareddevAdapter);
    }

    public void gotonextview(int position) {
        startActivity(new Intent(this, Deatils_view.class)
                .putExtra("title",itemList.get(position).getName())
                .putExtra("sub_title",itemList.get(position).getPoint())
        );

    }
}