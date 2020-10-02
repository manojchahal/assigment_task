package com.learnr.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.learnr.R;
import com.learnr.activity.Learn_With_ANR_Activity;
import com.learnr.model.Leader_model;
import com.makeramen.roundedimageview.RoundedImageView;

import java.util.ArrayList;

public class Learn_adapter extends RecyclerView.Adapter<Learn_adapter.ViewHolder> {
    private Context context;
    public ArrayList<Leader_model> itemList = new ArrayList<Leader_model>();
    private String teama = "";
    private int position;
    Activity activity;
    String status;
    public Learn_adapter(Activity activity, Context context, ArrayList<Leader_model> itemList) {
        this.context = context;
        this.itemList = itemList;
        this.activity = activity;
    }
    @NonNull
    @Override
    public Learn_adapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.learn_adapter_view, viewGroup, false);
        return new Learn_adapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Learn_adapter.ViewHolder holder, final int position) {
        Leader_model leader_model = itemList.get(position);
        holder.title.setText(leader_model.getName());
        holder.title_tag.setText(leader_model.getPoint());
        holder.imageview.setImageResource(leader_model.getImage());
        holder.mainlayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (activity instanceof Learn_With_ANR_Activity) {
                    ((Learn_With_ANR_Activity) activity).gotonextview(position);
                }
            }
        });

    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView title, title_tag, points;
        RelativeLayout mainlayout;
        public ImageView imageview;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.title);
            title_tag = itemView.findViewById(R.id.title_tag);
            mainlayout = itemView.findViewById(R.id.mainlayout);
            imageview = itemView.findViewById(R.id.imageview);
//            name = itemView.findViewById(R.id.name);
        }
    }
}
