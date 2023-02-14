package com.example.bizztmdesign;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = findViewById(R.id.horizontalRV);

        String[] s1 = {
                "Cello Puro Trends 600 Printed Insulated Plastic",
                "Cello Swift Thermosteel Vacuum Insulated Water Bottle",
                "Dubblin Boom 900 Stainless Steel Vacuum Insulated Water",
                "Dubblin Kango 1000 Stainless Steel Vacuum",
                "Dubblin Dolphin 500 Stainless Steel Vacuum"
        };

        String[] s2 = {"₹1114.00", "₹1667.99", "₹853.00", "₹609.99", "₹698.99"};
        String[] s3 = {"₹1132.00", "₹1746.00", "₹953.00", "₹675.00", "₹723.00"};

        int[] i = {
                R.drawable.img_4,
                R.drawable.img_1,
                R.drawable.img_2,
                R.drawable.img_3,
                R.drawable.img_4
        };

        HorizontalRvAdapter adapter = new HorizontalRvAdapter(s1, s2, s3, i);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        recyclerView.setAdapter(adapter);


    }
}