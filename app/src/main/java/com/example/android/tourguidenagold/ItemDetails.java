package com.example.android.tourguidenagold;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import java.util.Objects;

public class ItemDetails extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_details_view_pager);
        ViewPager2 viewPager2 = (ViewPager2) findViewById(R.id.items_details);
        viewPager2.setAdapter(new ItemsPagerAdapter(getApplicationContext(), getIntent().getIntExtra("position", 0), Objects.requireNonNull(getIntent().getStringExtra("item"))));
        viewPager2.setOrientation(ViewPager2.ORIENTATION_VERTICAL);
    }
}