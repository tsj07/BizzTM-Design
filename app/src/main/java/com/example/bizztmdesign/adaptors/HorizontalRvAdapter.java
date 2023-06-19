package com.example.bizztmdesign.adaptors;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bizztmdesign.R;

public class HorizontalRvAdapter extends RecyclerView.Adapter<HorizontalRvAdapter.HorizontalRvHolder> {

    String[] s1, s2, s3;
    int[] image;

    public HorizontalRvAdapter(String[] s1, String[] s2, String[] s3 , int[] image) {
        this.s1 = s1;
        this.s2 = s2;
        this.s3 = s3;
        this.image = image;
    }

    @NonNull
    @Override
    public HorizontalRvHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

//        return new HorizontalRvHolder(LayoutInflater.from(context).inflate(R.layout.horizontal_rv, parent, false);

//        LayoutInflater inflater = LayoutInflater.from(context);
//        return new HorizontalRvHolder(inflater.inflate(R.layout.horizontal_rv, parent, false));

        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.horizontal_rv, parent, false);
        HorizontalRvHolder rv = new HorizontalRvHolder(view);
        return rv;
    }

    @Override
    public void onBindViewHolder(@NonNull HorizontalRvHolder holder, int position) {
        String str1 = s1[position];
        holder.name.setText(str1);

        String str2 = s2[position];
        holder.discountedPrice.setText(str2);

        String str3 = s3[position];
        holder.originalPrice.setText(str3);

        int i = image[position];
        holder.productImage.setImageResource(i);
    }

    @Override
    public int getItemCount() {
        return s1.length;
    }

    public static class HorizontalRvHolder extends RecyclerView.ViewHolder {
        ImageView productImage;
        TextView name, discountedPrice, originalPrice;

        public HorizontalRvHolder(@NonNull View itemView) {
            super(itemView);
            productImage = itemView.findViewById(R.id.productImage);
            name = itemView.findViewById(R.id.name);
            discountedPrice = itemView.findViewById(R.id.discountedPrice);
            originalPrice = itemView.findViewById(R.id.originalPrice);
        }
    }

}
