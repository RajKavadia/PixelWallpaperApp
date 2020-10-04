package com.example.pixelwallpaperapp;

import android.view.View;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class Myviewholder extends RecyclerView.ViewHolder {
    ImageView imageView;
    public Myviewholder(@NonNull View itemView) {
        super(itemView);
        imageView= itemView.findViewById(R.id.image);
    }
}
