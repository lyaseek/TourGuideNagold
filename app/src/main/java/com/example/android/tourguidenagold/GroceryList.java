package com.example.android.tourguidenagold;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.example.android.tourguidenagold.databinding.ActivityListBinding;

import java.util.List;

public class GroceryList extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        if (MainActivity.arrayItems != null) {
            MainActivity.arrayItems.clear();
        }
        String[] titles = getResources().getStringArray(R.array.groceriesTitles);
        String[] descriptions = getResources().getStringArray(R.array.groceriesDescriptions);
        for (int i = 0; i < titles.length; i++) {
            MainActivity.arrayItems.add(new Items(titles[i], descriptions[i], MainActivity.imageGrocery[i]));
        }
        ActivityListBinding bindingActivityList = DataBindingUtil.setContentView(this, R.layout.activity_list);
        bindingActivityList.listView.setAdapter(MainActivity.adapter);
        bindingActivityList.listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                startActivity(new Intent(GroceryList.this, ItemDetails.class).putExtra("position", position).putExtra("item", "grocery"));
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = new MenuInflater(getApplicationContext());
        inflater.inflate(R.menu.menu_hotels, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.restaurants:
                startActivity(MainActivity.intentRestaurant);
                break;
            case R.id.main_menu:
                startActivity(MainActivity.mainMenu);
                break;
            case R.id.sights:
                startActivity(MainActivity.intentSights);
                break;
            case R.id.hotels:
                startActivity(MainActivity.intentHotels);
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}