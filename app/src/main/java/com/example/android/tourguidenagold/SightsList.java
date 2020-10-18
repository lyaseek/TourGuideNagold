package com.example.android.tourguidenagold;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;

import com.example.android.tourguidenagold.databinding.ActivityListBinding;

public class SightsList extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        if (MainActivity.arrayItems != null) {
            MainActivity.arrayItems.clear();
        }
        String[] titles = getResources().getStringArray(R.array.sightsTitles);
        String[] descriptions = getResources().getStringArray(R.array.sightsDescriptions);
        for (int i = 0; i < titles.length; i++) {
            MainActivity.arrayItems.add(new Items(titles[i], descriptions[i], MainActivity.imageSights[i]));
        }
        ActivityListBinding bindingActivityList = DataBindingUtil.setContentView(this, R.layout.activity_list);
        bindingActivityList.listView.setAdapter(MainActivity.adapter);
        bindingActivityList.listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                startActivity(new Intent(SightsList.this, ItemDetails.class).putExtra("position", position).putExtra("item", "sight"));
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = new MenuInflater(getApplicationContext());
        inflater.inflate(R.menu.menu_sights, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.hotels:
                startActivity(MainActivity.intentHotels);
                break;
            case R.id.main_menu:
                startActivity(MainActivity.mainMenu);
                break;
            case R.id.restaurants:
                startActivity(MainActivity.intentRestaurant);
                break;
            case R.id.groceries:
                startActivity(MainActivity.intentGrocery);
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
