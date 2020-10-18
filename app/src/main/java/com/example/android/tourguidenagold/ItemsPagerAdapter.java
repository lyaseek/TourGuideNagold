package com.example.android.tourguidenagold;

import android.content.Context;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ItemsPagerAdapter extends RecyclerView.Adapter<PagerVH> {
    String[] mFullDescription;
    String[] mNumbers;
    String[] mWeb;
    int[] mImagesItems;
    int mPosition;

    public ItemsPagerAdapter(Context context, int position, String item) {
        switch (item) {
            case "hotel":
                mFullDescription = context.getResources().getStringArray(R.array.hotelsFullDescriptions);
                mNumbers = context.getResources().getStringArray(R.array.hotelsNumbers);
                mWeb = context.getResources().getStringArray(R.array.hotelsWeb);
                mImagesItems = MainActivity.imageHotels;
                break;
            case "restaurant":
                mFullDescription = context.getResources().getStringArray(R.array.restaurantsFullDescriptions);
                mImagesItems = MainActivity.imageRestaurants;
                mNumbers = context.getResources().getStringArray(R.array.restaurantsNumbers);
                mWeb = context.getResources().getStringArray(R.array.restaurantsWeb);
                break;
            case "sight":
                mFullDescription = context.getResources().getStringArray(R.array.sightsFullDescription);
                mImagesItems = MainActivity.imageSights;
                mNumbers = context.getResources().getStringArray(R.array.sightsNumbers);
                mWeb = context.getResources().getStringArray(R.array.sightsWeb);
                break;
            case "grocery":
                mFullDescription = context.getResources().getStringArray(R.array.groceriesFullDescriptions);
                mImagesItems = MainActivity.imageGrocery;
                mNumbers = context.getResources().getStringArray(R.array.groceriesNumbers);
                mWeb = context.getResources().getStringArray(R.array.groceriesWeb);
                break;
        }
        mPosition = position;
    }

    @NonNull
    @Override
    public PagerVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new PagerVH(LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_item_details, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull PagerVH holder, int position) {
        TextView fullDescription = (TextView) holder.itemView.findViewById(R.id.full_description);
        TextView number = (TextView) holder.itemView.findViewById(R.id.call);
        TextView web = (TextView) holder.itemView.findViewById(R.id.web);
        ImageView imageItem = (ImageView) holder.itemView.findViewById(R.id.main_image);
        web.setText(mWeb[mPosition]);
        web.setMovementMethod(LinkMovementMethod.getInstance());
        number.setText(mNumbers[mPosition]);
        fullDescription.setText(mFullDescription[mPosition]);
        imageItem.setImageResource(mImagesItems[mPosition]);
        if (mPosition >= mFullDescription.length - 1) {
            mPosition = 0;
        } else {
            mPosition++;
        }
    }

    @Override
    public int getItemCount() {
        return Integer.MAX_VALUE;
    }
}

class PagerVH extends RecyclerView.ViewHolder {
    public PagerVH(@NonNull View itemView) {
        super(itemView);
    }
}