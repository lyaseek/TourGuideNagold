package com.example.android.tourguidenagold;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class RestaurantsPagerAdapter extends FragmentStateAdapter {
    private int mPosition = 0;
    private String[] mTitles;
    private String[] mDescriptions;

    public RestaurantsPagerAdapter(@NonNull FragmentManager fragmentManager, @NonNull Lifecycle lifecycle, Context context) {
        super(fragmentManager, lifecycle);
        Resources resources = context.getResources();
        mTitles = resources.getStringArray(R.array.restaurantsTitles);
        mDescriptions = resources.getStringArray(R.array.restaurantsDescriptions);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        Bundle arguments = new Bundle();
        RestaurantFragment restaurantsFragment = new RestaurantFragment();
        arguments.putString(RestaurantFragment.RESTAURANT_TITlES, mTitles[mPosition]);
        arguments.putString(RestaurantFragment.RESTAURANT_DESCRIPTIONS, mDescriptions[mPosition]);
        arguments.putInt(RestaurantFragment.RESTAURANT_IMAGE, MainActivity.imageRestaurants[mPosition]);
        restaurantsFragment.setArguments(arguments);
        if (mPosition >= mTitles.length - 1) {
            mPosition = 0;
        } else {
            mPosition++;
        }
        return restaurantsFragment;
    }
    @Override
    public int getItemCount() {
        return Integer.MAX_VALUE;
    }


}

