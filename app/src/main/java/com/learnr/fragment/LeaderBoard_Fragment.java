package com.learnr.fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.learnr.R;
import com.learnr.adapter.Leaderboard_adapter;
import com.learnr.model.Leader_model;

import java.util.ArrayList;

public class LeaderBoard_Fragment extends Fragment {
    private RecyclerView leaderboard_view;
    public ArrayList<Leader_model> itemList = new ArrayList<Leader_model>();
    public LeaderBoard_Fragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_leader_board, container, false);
        itemList.add(new Leader_model("1","Anjali",R.drawable.anjali,"1521 points"));
        itemList.add(new Leader_model("2","Akansha",R.drawable.akansha,"1221 points"));
        itemList.add(new Leader_model("3","Soni",R.drawable.soni,"1210 points"));
        itemList.add(new Leader_model("4","Deepa",R.drawable.deepa,"1021 points"));
        itemList.add(new Leader_model("5","Gautam",R.drawable.gautam,"521 points"));
        itemList.add(new Leader_model("6","Manjeet",R.drawable.manjit,"500 points"));
        itemList.add(new Leader_model("7","Demo",R.drawable.demo1,"500 points"));
        itemList.add(new Leader_model("8","Demo",R.drawable.demo2,"480 points"));
        itemList.add(new Leader_model("9","Demo",R.drawable.demo3,"300 points"));
        itemList.add(new Leader_model("10","Demo",R.drawable.demo1,"200 points"));
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        leaderboard_view=view.findViewById(R.id.leaderboard_recyerview);
        leaderboard_view.setHasFixedSize(true);
        leaderboard_view.setLayoutManager(new LinearLayoutManager(getActivity()));
        Leaderboard_adapter shareddevAdapter = new Leaderboard_adapter(getActivity(), getActivity(), itemList);
        leaderboard_view.setAdapter(shareddevAdapter);
    }
}