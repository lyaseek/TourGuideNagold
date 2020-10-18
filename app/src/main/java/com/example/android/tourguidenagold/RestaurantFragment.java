package com.example.android.tourguidenagold;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class RestaurantFragment extends Fragment {
    final static String RESTAURANT_TITlES = "restaurants_names";
    final static String RESTAURANT_DESCRIPTIONS = "restaurants_descriptions";
    final static String RESTAURANT_IMAGE = "restaurant_image";
    private String mTitle;
    private String mDescription;
    private int mImageRestaurant;

    public RestaurantFragment() {
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
                startActivity(MainActivity.intentRestaurant);
            }
        });
        if (getArguments() != null) {
            mTitle = getArguments().getString(RESTAURANT_TITlES);
            mDescription = getArguments().getString(RESTAURANT_DESCRIPTIONS);
            mImageRestaurant = getArguments().getInt(RESTAURANT_IMAGE);
        }
        TextView restaurantsTitlesTextView = (TextView) view.findViewById(R.id.titles);
        TextView restaurantsDescriptionsTextView = (TextView) view.findViewById(R.id.descriptions);
        ImageView restaurantsImagesImageView = (ImageView) view.findViewById(R.id.images);
        restaurantsDescriptionsTextView.setText(mDescription);
        restaurantsTitlesTextView.setText(mTitle);
        restaurantsImagesImageView.setImageResource(mImageRestaurant);
        return view;
    }
}
