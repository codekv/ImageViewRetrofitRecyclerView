package com.example.imageviewretrofitrecyclerview;

import android.content.Context;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

import java.util.List;


public class MyAdapter extends RecyclerView.Adapter<Holder> {

    public MyAdapter(List<Model> userList, Context context) {
        this.userList = userList;
        this.context = context;
    }

    List<Model> userList;
    Context context;


    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.single_row,parent,false);
        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int position) {
        holder.albumId.setText("Album Id: " + String.valueOf(userList.get(position).getAlbumId()));
        holder.userId.setText("Serial No: " + String.valueOf(userList.get(position).getId()));
        holder.title.setText("Title: " + userList.get(position).getTitle());
        holder.url.setText(String.valueOf(userList.get(position).getUrl()));
        Picasso.get().load(userList.get(position).getUrl())
                .placeholder(R.drawable.rotate_drawble)
                .into(holder.thumbnail);
    }

    @Override
    public int getItemCount() {
        return userList.size();
    }
}

class Holder extends RecyclerView.ViewHolder{

    TextView userId , albumId , title , url;
    ImageView thumbnail;

    public Holder(@NonNull View itemView) {
        super(itemView);

        userId = itemView.findViewById(R.id.idId);
        albumId = itemView.findViewById(R.id.albumId);
        title = itemView.findViewById(R.id.titleId);
        thumbnail = itemView.findViewById(R.id.albumThumbnailId);
        url = itemView.findViewById(R.id.urlId);
    }
}
