package com.example.android.tourguidenagold;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.viewpager2.widget.ViewPager2;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

import com.example.android.tourguidenagold.databinding.ActivityMainBinding;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    static Intent intentRestaurant;
    static Intent intentHotels;
    static Intent intentSights;
    static Intent intentGrocery;
    static Intent mainMenu;
    static ArrayAdapterItems adapter;
    static ArrayList<Items> arrayItems = new ArrayList<>();
    static int[] imageHotels = {R.drawable.ibis_hotel, R.drawable.pfrondorfer_muhle, R.drawable.adler_hotel};
    static int[] imageRestaurants = {R.drawable.burg_restaurant, R.drawable.eisembahn_restaurant, R.drawable.da_gino_restaurant};
    static int[] imageSights = {R.drawable.castle, R.drawable.church, R.drawable.park};
    static int[] imageGrocery = {R.drawable.metzgerei_widenmaier, R.drawable.edeka, R.drawable.bckerei_seeger};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ActivityMainBinding bindingActivityMain;
        adapter = new ArrayAdapterItems(this, R.layout.fragment_items_list, MainActivity.arrayItems);
        intentRestaurant = new Intent(this, RestaurantsList.class);
        intentHotels = new Intent(this, HotelsList.class);
        intentSights = new Intent(this, SightsList.class);
        intentGrocery = new Intent(this, GroceryList.class);
        mainMenu = new Intent(this, MainActivity.class);
        bindingActivityMain = DataBindingUtil.setContentView(this, R.layout.activity_main);
        bindingActivityMain.nagoldArticle.setMovementMethod(LinkMovementMethod.getInstance());
        bindingActivityMain.restaurants.setAdapter(new RestaurantsPagerAdapter(getSupportFragmentManager(), getLifecycle(), getApplicationContext()));
        bindingActivityMain.thingsToDo.setAdapter(new SightsPagerAdapter(getSupportFragmentManager(), getLifecycle(), getApplicationContext()));
        bindingActivityMain.restaurantsButton.setOnClickListener(this);
        bindingActivityMain.hotelsButton.setOnClickListener(this);
        bindingActivityMain.thingsToDoButton.setOnClickListener(this);
        bindingActivityMain.groceryButton.setOnClickListener(this);
        bindingActivityMain.tabLayoutRestaurant.addTab(bindingActivityMain.tabLayoutRestaurant.newTab().setText(getResources().getStringArray(R.array.restaurantsTabLayout)[0]));
        bindingActivityMain.tabLayoutRestaurant.addTab(bindingActivityMain.tabLayoutRestaurant.newTab().setText(getResources().getStringArray(R.array.restaurantsTabLayout)[1]));
        bindingActivityMain.tabLayoutRestaurant.addTab(bindingActivityMain.tabLayoutRestaurant.newTab().setText(getResources().getStringArray(R.array.restaurantsTabLayout)[2]));
        bindingActivityMain.tabLayoutSights.addTab(bindingActivityMain.tabLayoutSights.newTab().setText(getResources().getStringArray(R.array.sightsTabLayout)[0]));
        bindingActivityMain.tabLayoutSights.addTab(bindingActivityMain.tabLayoutSights.newTab().setText(getResources().getStringArray(R.array.sightsTabLayout)[1]));
        bindingActivityMain.tabLayoutSights.addTab(bindingActivityMain.tabLayoutSights.newTab().setText(getResources().getStringArray(R.array.sightsTabLayout)[2]));
        bindingActivityMain.tabLayoutRestaurant.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                bindingActivityMain.restaurants.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
            }
        });
        bindingActivityMain.tabLayoutSights.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                bindingActivityMain.thingsToDo.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
            }
        });

        bindingActivityMain.restaurants.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                if (position > bindingActivityMain.tabLayoutRestaurant.getTabCount() - 1) {
                    position = 0;
                }
                bindingActivityMain.tabLayoutRestaurant.selectTab(bindingActivityMain.tabLayoutRestaurant.getTabAt(position));
            }
        });

        bindingActivityMain.thingsToDo.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                if (position > bindingActivityMain.tabLayoutSights.getTabCount() - 1) {
                    position = 0;
                }
                bindingActivityMain.tabLayoutSights.selectTab(bindingActivityMain.tabLayoutSights.getTabAt(position));
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = new MenuInflater(getApplicationContext());
        inflater.inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.hotels:
                startActivity(intentHotels);
                break;
            case R.id.restaurants:
                startActivity(intentRestaurant);
                break;
            case R.id.sights:
                startActivity(intentSights);
                break;
            case R.id.groceries:
                startActivity(intentGrocery);
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.restaurants_button:
                startActivity(intentRestaurant);
                break;
            case R.id.hotels_button:
                startActivity(intentHotels);
                break;
            case R.id.things_to_do_button:
                startActivity(intentSights);
                break;
            case R.id.grocery_button:
                startActivity(intentGrocery);
                break;
            default:
                break;
        }
    }
}