package com.example.bizztmdesign.adaptors;

import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatButton;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bizztmdesign.OnItemClick;
import com.example.bizztmdesign.R;
import com.google.android.material.bottomsheet.BottomSheetDialog;

public class SkuListingAdaptor extends RecyclerView.Adapter<SkuListingAdaptor.SkuListingViewHolder> {
    String[] s1, s2, s3, s4;
    int[] i;
    OnItemClick listener;

    public SkuListingAdaptor(String[] s1, String[] s2, String[] s3, String[] s4, int[] i, OnItemClick listener) {
        this.s1 = s1;
        this.s2 = s2;
        this.s3 = s3;
        this.s4 = s4;
        this.i = i;
        this.listener = listener;
    }

    @NonNull
    @Override
    public SkuListingViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.sku_listing_rv, parent, false);
        return new SkuListingViewHolder(view, listener);
    }

    @Override
    public void onBindViewHolder(@NonNull SkuListingViewHolder holder, int position) {
        String str1 = s1[position];
        holder.productName.setText(str1);

        String str2 = s2[position];
        holder.discountedPrice.setText(str2);

        String str3 = s3[position];
        holder.originalPrice.setText(Html.fromHtml("<strike>" + str3 + "</strike>"));

        String str4 = s4[position];
        holder.mrp.setText(str4);

        int i1 = i[position];
        holder.productImage.setImageResource(i1);

    }

    @Override
    public int getItemCount() {
        return s1.length;
    }

    public static class SkuListingViewHolder extends RecyclerView.ViewHolder {
        TextView productName, originalPrice, discountedPrice, mrp, addThisProduct, buyAt, extra, allDeals;
        ImageView productImage, close;
        AppCompatButton btnShare, btnAddToCart, cardBtnAddToCart;
        RelativeLayout rlContainer;

        public SkuListingViewHolder(@NonNull View itemView, OnItemClick listener) {
            super(itemView);
            id();

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (listener != null) {
                        int pos = getAbsoluteAdapterPosition();
                        if (pos != RecyclerView.NO_POSITION)
                            listener.onItemClick(pos);
                    }
                }
            });

            btnAddToCart.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    showBottomSheet();
                }
            });

            addThisProduct.setText(Html.fromHtml(
                            "<b>" + "Add this product " + "</b>" +
                                    "and get up to 2% extra off on all H&K items. " +
                                    "<font color='#0066FF'" + "<b>" + "Know more..." + "</font>" + "</b>"
                    )
            );

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

        private void showBottomSheet() {
            BottomSheetDialog sheetDialog = new BottomSheetDialog(
                    btnAddToCart.getContext(),
                    R.style.BottomSheetDialogTheme
            );

            View bottomSheetView = LayoutInflater
                    .from(sheetDialog.getContext())
                    .inflate(R.layout.card_sku_details_bottom, rlContainer, false);

            close = bottomSheetView.findViewById(R.id.close);
            close.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    sheetDialog.dismiss();
                }
            });

            RecyclerView rv = bottomSheetView.findViewById(R.id.cardCouponRV);
            CouponAdaptor ca = new CouponAdaptor();
            rv.setLayoutManager(new LinearLayoutManager(
                    rv.getContext(),
                    LinearLayoutManager.HORIZONTAL,
                    false));
            rv.setAdapter(ca);

            cardBtnAddToCart = bottomSheetView.findViewById(R.id.cardBtnAddToCart);
            cardBtnAddToCart.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(
                                    cardBtnAddToCart.getContext(),
                                    "Cart item added successfully",
                                    Toast.LENGTH_SHORT)
                            .show();
                }
            });

            sheetDialog.setContentView(bottomSheetView);
            sheetDialog.show();
        }

        private void id() {
            productName = itemView.findViewById(R.id.skuName);
            originalPrice = itemView.findViewById(R.id.skuOriginalPrice);
            discountedPrice = itemView.findViewById(R.id.skuDiscountedPrice);
            mrp = itemView.findViewById(R.id.skuMrp);
            productImage = itemView.findViewById(R.id.skuImage);
            addThisProduct = itemView.findViewById(R.id.tvAddThisProduct);
            buyAt = itemView.findViewById(R.id.tvBuyAt);
            extra = itemView.findViewById(R.id.tvExtra);
            allDeals = itemView.findViewById(R.id.tvAllDeals);
            btnShare = itemView.findViewById(R.id.btnShare);
            btnAddToCart = itemView.findViewById(R.id.btnAddToCart);
            rlContainer = itemView.findViewById(R.id.container);
        }
    }
}
