package com.example.bizztmdesign.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

import com.example.bizztmdesign.R;
import com.example.bizztmdesign.adaptors.CouponAdaptor;
import com.example.bizztmdesign.adaptors.ImageAdaptor;

public class SkuActivity extends AppCompatActivity {
    ImageView increase, decrease, openCart;
    TextView quantity;
    int count = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sku);

        increase = findViewById(R.id.counterIncrease);
        decrease = findViewById(R.id.counterDecrease);
        quantity = findViewById(R.id.tvOrderQuantity);
        openCart = findViewById(R.id.ivCart);

        openCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SkuActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

        increase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (count >= 0) {
                    count++;
                    quantity.setText(""+count);
                } else
                    quantity.setText("0");
            }
        });

        decrease.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (count <= 0)
                    quantity.setText("0");
                else {
                    count--;
                    quantity.setText(""+count);
                }
            }
        });

        int[] image = {
                R.drawable.img_6,
                R.drawable.img_5,
                R.drawable.img_4,
                R.drawable.img_3,
                R.drawable.img_2,
                R.drawable.img
        };

        ViewPager2 pager = findViewById(R.id.imgViewPager);
        ImageAdaptor iAdaptor = new ImageAdaptor(image);
        pager.setAdapter(iAdaptor);

        RecyclerView couponRV = findViewById(R.id.couponRV);
        CouponAdaptor cAdaptor = new CouponAdaptor();
        couponRV.setLayoutManager(new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false));
        couponRV.setAdapter(cAdaptor);


    }
}