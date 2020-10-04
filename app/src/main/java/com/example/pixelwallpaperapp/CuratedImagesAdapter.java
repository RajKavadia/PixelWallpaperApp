package com.example.pixelwallpaperapp;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

public class CuratedImagesAdapter extends RecyclerView.Adapter<Myviewholder> {
    CuratedImages curatedImages;
    Context context;

    public CuratedImagesAdapter(CuratedImages curatedImages, Context context) {
        this.curatedImages = curatedImages;
        this.context = context;
    }

    @NonNull
    @Override
    public Myviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new Myviewholder(LayoutInflater.from(parent.getContext()).inflate(R.layout.search_reasult,parent,false));
    }
    @Override
    public void onBindViewHolder(@NonNull Myviewholder holder, final int position) {
        Glide.with(context).load(curatedImages.photos.get(position).src.medium).centerCrop().into(holder.imageView);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String final_url =curatedImages.photos.get(position).src.large;
                Intent intent = new Intent(context,WallpaperActivity.class);
                intent.putExtra("url",final_url);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return curatedImages.photos.size();
    }
}
