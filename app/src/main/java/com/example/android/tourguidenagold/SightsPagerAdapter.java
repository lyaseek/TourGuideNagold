package com.example.android.tourguidenagold;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class SightsPagerAdapter extends FragmentStateAdapter {
    private int mPosition = 0;
    private String[] mTitles;
    private String[] mDescriptions;

    public SightsPagerAdapter(@NonNull FragmentManager fragmentManager, @NonNull Lifecycle lifecycle, Context context) {
        super(fragmentManager, lifecycle);
        Resources resources = context.getResources();
        mTitles = resources.getStringArray(R.array.sightsTitles);
        mDescriptions = resources.getStringArray(R.array.sightsDescriptions);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        Bundle arguments = new Bundle();
        SightsFragment sightsFragment = new SightsFragment();
        arguments.putString(SightsFragment.SIGHTS_TITlES, mTitles[mPosition]);
        arguments.putString(SightsFragment.SIGHTS_DESCRIPTIONS, mDescriptions[mPosition]);
        arguments.putInt(SightsFragment.SIGHTS_IMAGE, MainActivity.imageSights[mPosition]);
        sightsFragment.setArguments(arguments);
        if (mPosition >= mTitles.length - 1) {
            mPosition = 0;
        } else {
            mPosition++;
        }
        return sightsFragment;
    }

    @Override
    public int getItemCount() {
        return Integer.MAX_VALUE;
    }
}