package com.example.bizztmdesign.adaptors;

import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bizztmdesign.R;

public class VerticalRvAdapter extends RecyclerView.Adapter<VerticalRvAdapter.VerticalRvHolder> {
    String[] s1, s2, s3, s4;
    int[] i;

    public VerticalRvAdapter(String[] s1, String[] s2, String[] s3, String[] s4, int[] i) {
        this.s1 = s1;
        this.s2 = s2;
        this.s3 = s3;
        this.s4 = s4;
        this.i = i;
    }

    @NonNull
    @Override
    public VerticalRvHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.vertical_rv, parent, false);
        return new VerticalRvHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull VerticalRvHolder holder, int position) {
        String str1 = s1[position];
        holder.name.setText(str1);

        String str2 = s2[position];
        holder.discountedPrice.setText(str2);

        String str3 = s3[position];
        holder.originalPrice.setText(str3);

        String str4 = s4[position];
        holder.totalPrice.setText(str4);

        int i1 = i[position];
        holder.productImage.setImageResource(i1);
    }

    @Override
    public int getItemCount() {
        return s1.length;
    }

    public static class VerticalRvHolder extends RecyclerView.ViewHolder {
        ImageView productImage, ivMinus, ivPlus;
        TextView name, discountedPrice, originalPrice, totalPrice, tvCounter, tvDiscount;
        int count = 0;

        public VerticalRvHolder(@NonNull View itemView) {
            super(itemView);
            productImage = itemView.findViewById(R.id.vrvProductImage);
            name = itemView.findViewById(R.id.vrvName);
            discountedPrice = itemView.findViewById(R.id.vrvDiscountPrice);
            originalPrice = itemView.findViewById(R.id.vrvOriginalPrice);
            totalPrice = itemView.findViewById(R.id.totalPrice);
            ivMinus = itemView.findViewById(R.id.ivMinus);
            ivPlus = itemView.findViewById(R.id.ivPlus);
            tvCounter = itemView.findViewById(R.id.tvCounter);
            tvDiscount = itemView.findViewById(R.id.tvDiscount);

            ivMinus.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (count <= 0) {
                        count = 0;
                        tvCounter.setText("" + count);
                    } else {
                        count--;
                        tvCounter.setText("" + count);
                    }
                }
            });

            ivPlus.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    count++;
                    tvCounter.setText("" + count);
                }
            });

            tvDiscount.setText(Html.fromHtml(
                            "<font color='#1F9A29'" + "<b>" + "<small>₹</small>" + "</font>" + "</b>" +
                                    "<font color='#1F9A29'" + "<b>" + "1999" + "</font>" + "</b>" +
                                    "<font color='#1F9A29'" + "<b>" + "<small>off</small>" + "</font>" + "</b>"
                    )
            );
        }
    }
}

