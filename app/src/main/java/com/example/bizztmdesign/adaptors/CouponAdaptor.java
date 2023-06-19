package com.example.bizztmdesign.adaptors;

import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bizztmdesign.R;

public class CouponAdaptor extends RecyclerView.Adapter<CouponAdaptor.CouponHolder> {

    @NonNull
    @Override
    public CouponHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new CouponHolder(
                LayoutInflater
                        .from(parent.getContext())
                        .inflate(R.layout.coupon_layout, parent, false)
        );
    }

    @Override
    public void onBindViewHolder(@NonNull CouponHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 3;
    }

    public static class CouponHolder extends RecyclerView.ViewHolder {
        TextView buyAt, extra, allDeals;

        public CouponHolder(@NonNull View itemView) {
            super(itemView);
            buyAt = itemView.findViewById(R.id.cBuyAt);
            extra = itemView.findViewById(R.id.cExtra);
            allDeals = itemView.findViewById(R.id.cAllDeals);

            buyAt.setText(Html.fromHtml(
                            "Buy at " + "<b>" + "<big>₹9000</big>" + "</b>"
                    )
            );

            extra.setText(Html.fromHtml(
                            "<b>" + "<big>4.2%</big>" + "</b>" + " Extra"
                    )
            );

            allDeals.setText(Html.fromHtml(
                            "<b>" + "<u>All Deals</u>" + "</b>"
                    )
            );
        }
    }
}
