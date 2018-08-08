package com.example.kon_boot.internship;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.MyViewHolder> {


    Context context;
    private List<Photo> item;



    public RecyclerAdapter(Context context , List<Photo>item)

    {
        this.context = context;
        this.item=item;

    }


    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        view = LayoutInflater.from(context).inflate(R.layout.item,parent,false);

        MyViewHolder viewHolder = new MyViewHolder(view);
        return viewHolder;


    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        Photo item1=  item.get(position);
        holder.title.setText(item1.getId());
        Glide.with(context).load(item1.getUrlS()).into(holder.img);


    }

    public int getItemCount() {
        return item.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{

        TextView title;
        ImageView img;
        TextView description;

        public MyViewHolder(View itemView) {
            super(itemView);
            title=itemView.findViewById(R.id.Heading);
            img = itemView.findViewById(R.id.postimage);

        }
    }
}
