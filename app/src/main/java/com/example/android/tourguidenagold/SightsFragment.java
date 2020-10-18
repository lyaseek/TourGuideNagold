package com.example.android.tourguidenagold;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

public class SightsFragment extends Fragment {
    final static String SIGHTS_TITlES = "sights_names";
    final static String SIGHTS_DESCRIPTIONS = "sights_descriptions";
    final static String SIGHTS_IMAGE = "sights_image";
    private String mTitle;
    private String mDescription;
    private int mImageSight;

    public SightsFragment() {
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_items_list, container, false);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(MainActivity.intentSights);
            }
        });
        if (getArguments() != null) {
            mTitle = getArguments().getString(SIGHTS_TITlES);
            mDescription = getArguments().getString(SIGHTS_DESCRIPTIONS);
            mImageSight = getArguments().getInt(SIGHTS_IMAGE);
        }
        TextView restaurantsTitlesTextView = (TextView) view.findViewById(R.id.titles);
        TextView restaurantsDescriptionsTextView = (TextView) view.findViewById(R.id.descriptions);
        ImageView restaurantsImagesImageView = (ImageView) view.findViewById(R.id.images);
        restaurantsDescriptionsTextView.setText(mDescription);
        restaurantsTitlesTextView.setText(mTitle);
        restaurantsImagesImageView.setImageResource(mImageSight);
        return view;
    }
}
