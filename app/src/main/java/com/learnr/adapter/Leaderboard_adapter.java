package com.learnr.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.learnr.R;
import com.learnr.model.Leader_model;
import com.makeramen.roundedimageview.RoundedImageView;

import java.util.ArrayList;

public class Leaderboard_adapter extends RecyclerView.Adapter<Leaderboard_adapter.ViewHolder> {
    private Context context;
    public ArrayList<Leader_model> itemList = new ArrayList<Leader_model>();
    private String teama = "";
    private int position;
    Activity activity;
    String status;
    public Leaderboard_adapter(Activity activity, Context context, ArrayList<Leader_model> itemList) {
        this.context = context;
        this.itemList = itemList;
        this.activity = activity;
    }
    public Leaderboard_adapter(String status ,Activity activity, Context context, ArrayList<Leader_model> itemList) {
        this.context = context;
        this.itemList = itemList;
        this.activity = activity;
        this.status = status;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.leader_view, viewGroup, false);
        return new Leaderboard_adapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Leader_model leader_model = itemList.get(position);
        holder.serial_number.setText(leader_model.getId());
        holder.user_name.setText(leader_model.getName());
        holder.points.setText(leader_model.getPoint());
        holder.imageView1.setImageResource(leader_model.getImage());
//        iv.setImageResource(array_image .get(position));

    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView serial_number, user_name, points;
        public RoundedImageView imageView1;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            serial_number = itemView.findViewById(R.id.serial_number);
            user_name = itemView.findViewById(R.id.user_name);
            points = itemView.findViewById(R.id.points);
            imageView1 = itemView.findViewById(R.id.imageView1);
//            name = itemView.findViewById(R.id.name);
        }
    }
}
