package com.example.task4;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

public class Adaptery extends RecyclerView.Adapter<Adaptery.MyViewHolder> {


    private Context mContext;
    private List<model>modelslist;

    public Adaptery(Context mContext, List<model> modelslist) {
        this.mContext = mContext;
        this.modelslist = modelslist;
    }

    @NonNull

    @Override
    public MyViewHolder onCreateViewHolder(@NonNull  ViewGroup parent, int viewType) {
        View v;
        LayoutInflater layoutInflater=LayoutInflater.from(mContext);
        v=layoutInflater.inflate(R.layout.model_items,parent,false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull  Adaptery.MyViewHolder holder, int position) {

        holder.name.setText(modelslist.get(position).getUser());
        holder.li.setText(modelslist.get(position).getLikes());

        //adding glide library to display images
        Glide.with(mContext)
        .load(modelslist.get(position).getUserImageURL())
        .into(holder.img);

    }

    @Override
    public int getItemCount() {
        return modelslist.size();
    }


    public static class MyViewHolder extends RecyclerView.ViewHolder{

       TextView name;
       TextView li;
       ImageView img;

        public MyViewHolder(@NonNull  View itemView) {
            super(itemView);
            name=itemView.findViewById(R.id.textView2);
            li=itemView.findViewById(R.id.textView);
            img=itemView.findViewById(R.id.imageView);
        }
    }
}
