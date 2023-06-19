package com.example.bizztmdesign.activity;

import android.os.Bundle;
import android.text.Html;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bizztmdesign.R;
import com.example.bizztmdesign.adaptors.HorizontalRvAdapter;
import com.example.bizztmdesign.adaptors.VerticalRvAdapter;

public class MainActivity extends AppCompatActivity {
    TextView tvAddMore, tvDontMissOut, tvViewProducts, tvSavings, tvTotalAmount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvAddMore = findViewById(R.id.tvAddMore);
        tvDontMissOut = findViewById(R.id.tvDontMissOut);
        tvViewProducts = findViewById(R.id.tvViewProducts);
        tvSavings = findViewById(R.id.tvSavings);
        tvTotalAmount = findViewById(R.id.tvTotalAmount);


        RecyclerView hRecyclerView = findViewById(R.id.horizontalRV);
        RecyclerView vRecyclerView = findViewById(R.id.verticalRV);

        String[] s1 = {
                "Prestige Svachh Deluxe Alpha 2.0 Litre Stainless Steel Outer",
                "Prestige Svachh Deluxe Alpha 2.0 Litre Stainless Steel Outer",
                "Cello Swift Thermosteel Vacuum Insulated Water Bottle",
                "Dubblin Kango 1000 Stainless Steel Vacuum",
                "Dubblin Dolphin 500 Stainless Steel Vacuum"
        };

        String[] s2 = {"₹1114.00", "₹1667.99", "₹853.00", "₹609.99", "₹698.99"};
        String[] s3 = {"₹1132.00", "₹1746.00", "₹953.00", "₹675.00", "₹723.00"};
        String[] s4 = {"₹3332.00", "₹4432.00", "₹5332.00", "₹6732.00", "₹3232.00"};

        int[] i = {
                R.drawable.img_5,
                R.drawable.img_6,
                R.drawable.img_1,
                R.drawable.img_3,
                R.drawable.img_4
        };

        tvAddMore.setText(Html.fromHtml(
                        "Add more products in cart worth" +
                                "<font color='#1F9A29'" + "<b>" + " ₹2000.76 " + "</font>" + "</b>" + "to avail" +
                                "<font color='#1F9A29'" + "<b>" + " 10.00% " + "</font>" + "</b>" + "off."
                )
        );

        tvDontMissOut.setText(Html.fromHtml(
                        "⚠ " +
                                "<font color='#E80101'" + "<b>" + "Don't Miss Out. " + "</font>" + "</b>" +
                                "Add item worth" +
                                "<font color='#1F9A29'" + "<b>" + " ₹2000 " + "</font>" + "</b>" +
                                "to get extra" +
                                "<font color='#1F9A29'" + "<b>" + " 1% " + "</font>" + "</b>" +
                                "off on all H&K items."
                )
        );

        tvViewProducts.setText(Html.fromHtml(
                        "<font color='#FB413A'" + "<b>" + "<u>View Products</u>" + "</font>" + "</b>"
                )
        );

        tvSavings.setText(Html.fromHtml(
                        "<font color='#1F9A29'" + "<b>" + "<strong><big>₹510</strong></big>" + "</font>" + "</b>" +
                                "<font color='#1F9A29'" + "<b>" + "<strong> Savings </strong>" + "</font>" + "</b>" +
                                "<font color='#1F9A29'" + "<small>on this order</small>" + "</font>"
                )
        );

        tvTotalAmount.setText(Html.fromHtml(
                        "<small>₹</small>" + "4012.00"
                )
        );

        HorizontalRvAdapter hAdapter = new HorizontalRvAdapter(s1, s2, s3, i);
        hRecyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        hRecyclerView.setAdapter(hAdapter);

        VerticalRvAdapter vAdapter = new VerticalRvAdapter(s1, s2, s3, s4, i);
        vRecyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        vRecyclerView.setAdapter(vAdapter);

    }
}