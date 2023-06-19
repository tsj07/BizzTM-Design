package com.example.bizztmdesign.activity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.bizztmdesign.OnItemClick;
import com.example.bizztmdesign.R;
import com.example.bizztmdesign.adaptors.SkuListingAdaptor;
import com.example.bizztmdesign.databinding.ActivitySkuListingBinding;

import org.json.JSONException;
import org.json.JSONObject;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

public class SkuListingActivity extends AppCompatActivity implements OnItemClick {
    ActivitySkuListingBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySkuListingBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        counterTimer();

        binding.ivOpenCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SkuListingActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

        String[] s1 = {
                "Prestige Svachh Deluxe Alpha 2.0 Litre Stainless Steel Outer",
                "Prestige Svachh Deluxe Alpha 2.0 Litre Stainless Steel Outer",
                "Cello Swift Thermosteel Vacuum Insulated Water Bottle",
                "Dubblin Kango 1000 Stainless Steel Vacuum",
                "Dubblin Dolphin 500 Stainless Steel Vacuum"
        };

        String[] s2 = {"₹1114.00", "₹1667.99", "₹853.00", "₹609.99", "₹698.99"};
        String[] s3 = {"₹1132.00", "₹1746.00", "₹953.00", "₹675.00", "₹723.00"};
        String[] s4 = {"MRP ₹1500.00", "MRP ₹2000.00", "MRP ₹1000.00", "MRP 800.00", "MRP ₹800.00"};

        int[] i = {
                R.drawable.img_5,
                R.drawable.img_6,
                R.drawable.img_1,
                R.drawable.img_3,
                R.drawable.img_4
        };

        SkuListingAdaptor skuAdapter = new SkuListingAdaptor(s1, s2, s3, s4, i, this);
        binding.skuListingRecyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        binding.skuListingRecyclerView.setNestedScrollingEnabled(false);
        binding.skuListingRecyclerView.setAdapter(skuAdapter);
    }

    @Override
    public void onItemClick(int position) {
        Intent intent = new Intent(SkuListingActivity.this, SkuActivity.class);
        startActivity(intent);
    }

    private void counterTimer() {
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {

            JSONObject object = new JSONObject();
            try {
                object.put("startDate", "09:00:00");
                object.put("endDate", "23:45:00");
            } catch (JSONException e) {
                throw new RuntimeException(e);
            }

            long remainingTimeInMillis = getRemainingTime(object);
            new CountDownTimer(remainingTimeInMillis, 1000) {

                @SuppressLint("SetTextI18n")
                public void onTick(long millisUntilFinished) {
                    int seconds = (int) (millisUntilFinished / 1000) % 60;
                    int minutes = (int) ((millisUntilFinished / (1000 * 60)) % 60);
                    int hours = (int) ((millisUntilFinished / (1000 * 60 * 60)) % 24);

                    if (hours > 0) {
                        String time = String.format(Locale.getDefault(), "%02d:%02d:%02d", hours, minutes, seconds);
                        String[] str = time.split(":");
                        String hr = str[0];
                        String min = str[1];
                        String sec = str[2];
                        binding.tvHr1.setText(hr.charAt(0) + "");
                        binding.tvHr2.setText(hr.charAt(1) + "");
                        binding.tvMin1.setText(min.charAt(0) + "");
                        binding.tvMin2.setText(min.charAt(1) + "");
                        binding.tvSec1.setText(sec.charAt(0) + "");
                        binding.tvSec2.setText(sec.charAt(1) + "");
                    } else if (minutes > 0) {
                        String time = String.format(Locale.getDefault(), "%02d:%02d:%02d", hours, minutes, seconds);
                        String[] str = time.split(":");
                        String min = str[1];
                        String sec = str[2];
                        binding.tvMin1.setText(min.charAt(0) + "");
                        binding.tvMin2.setText(min.charAt(1) + "");
                        binding.tvSec1.setText(sec.charAt(0) + "");
                        binding.tvSec2.setText(sec.charAt(1) + "");
                    } else if (seconds > 0) {
                        String time = String.format(Locale.getDefault(), "%02d:%02d:%02d", hours, minutes, seconds);
                        String[] str = time.split(":");
                        String sec = str[2];
                        binding.tvSec1.setText(sec.charAt(0) + "");
                        binding.tvSec2.setText(sec.charAt(1) + "");
                    }
                }

                public void onFinish() {
                    binding.tvHr1.setText("0");
                    binding.tvHr2.setText("0");
                    binding.tvMin1.setText("0");
                    binding.tvMin2.setText("0");
                    binding.tvSec1.setText("0");
                    binding.tvSec2.setText("0");
                }
            }.start();
        }
    }

    private static long getRemainingTime(JSONObject object) {
        @SuppressLint("SimpleDateFormat")
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
        Date startD = null;
        Date endD = null;
        Date date = null;
        String startDate = null;
        String endDate = null;
        String current = sdf.format(new Date());

        try {
            startDate = object.getString("startDate");
            endDate = object.getString("endDate");
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }

        try {
            startD = sdf.parse(startDate);
            date = sdf.parse(current);
            endD = sdf.parse(endDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        long startTimeInMillis = startD.getTime();
        long currentTimeInMillis = date.getTime();
        long endTimeInMillis = endD.getTime();
        return endTimeInMillis - currentTimeInMillis;
    }

    private static boolean isDateMatching() {
        @SuppressLint("SimpleDateFormat")
        SimpleDateFormat dayFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date sDay = null;
        Date cDay = null;
        String startDay = "2023-04-1";
        String currentDay = dayFormat.format(new Date());

        try {
            sDay = dayFormat.parse(startDay);
            cDay = dayFormat.parse(currentDay);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }

        long startDayInMillis = sDay.getTime();
        long currentDayInMillis = cDay.getTime();
        long remainingDaysInMillis = currentDayInMillis - startDayInMillis;

        int days = (int) TimeUnit.DAYS.convert(remainingDaysInMillis, TimeUnit.MILLISECONDS);
        int frequency = 2;

        if (startDayInMillis < currentDayInMillis) {
            if (days % frequency == 1) {
                return false;
            }
        }
        return true;
    }

}