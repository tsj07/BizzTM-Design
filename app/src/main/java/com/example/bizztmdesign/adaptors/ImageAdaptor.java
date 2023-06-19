package com.example.bizztmdesign.adaptors;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bizztmdesign.R;

public class ImageAdaptor extends RecyclerView.Adapter<ImageAdaptor.ImageViewHolder> {
    int[] i;

    public ImageAdaptor(int[] image) {
        this.i = image;
    }

    @NonNull
    @Override
    public ImageViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ImageViewHolder(
                LayoutInflater
                        .from(parent.getContext())
                        .inflate(R.layout.image_view_pager, parent, false)
        );
    }

    @Override
    public void onBindViewHolder(@NonNull ImageViewHolder holder, int position) {
        int i1 = i[position];
        holder.image.setImageResource(i1);
    }

    @Override
    public int getItemCount() {
        return i.length;
    }

    public static class ImageViewHolder extends RecyclerView.ViewHolder {
        ImageView image;

        public ImageViewHolder(@NonNull View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.ivImage);
        }
    }
}
