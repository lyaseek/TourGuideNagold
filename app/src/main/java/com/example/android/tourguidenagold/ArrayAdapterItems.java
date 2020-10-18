package com.example.android.tourguidenagold;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class ArrayAdapterItems extends ArrayAdapter<Items> {
    List<Items> items;

    public ArrayAdapterItems(@NonNull Context context, int resource, @NonNull List<Items> objects) {
        super(context, resource, objects);
        items = objects;
    }

    @Override
    public int getCount() {
        return super.getCount();
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.fragment_items_list, null);
        }
        TextView descriptions = (TextView) convertView.findViewById(R.id.descriptions);
        TextView titles = (TextView) convertView.findViewById(R.id.titles);
        ImageView images = (ImageView) convertView.findViewById(R.id.images);
        images.setImageResource(items.get(position).getImage());
        titles.setText(items.get(position).getTitle());
        descriptions.setText(items.get(position).getDescription());
        return convertView;
    }
}

