package com.example.bookyourcab;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class CustomAdapter extends ArrayAdapter {

    ArrayList iconList = new ArrayList<>();

    public CustomAdapter(Context context, int textViewResourceId, ArrayList objects){
        super(context, textViewResourceId, objects);
        iconList = objects;
    }

    @Override
    public int getCount() {
        return super.getCount();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View v = convertView;
        LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        v = inflater.inflate(R.layout.gridview, null);
        ImageView imageView = v.findViewById(R.id.grid_image);
        imageView.setImageResource((int)iconList.get(position));
        return v;

    }

}
