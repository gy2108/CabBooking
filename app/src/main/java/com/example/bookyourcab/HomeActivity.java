package com.example.bookyourcab;

import android.app.Activity;
import android.os.Bundle;
import android.widget.GridView;

import java.util.ArrayList;

public class HomeActivity extends Activity {

    GridView gridView;
    ArrayList<Integer> iconList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home);

        gridView = findViewById(R.id.grid_view);
        iconList.add(R.drawable.profile);
        iconList.add(R.drawable.ride);
        iconList.add(R.drawable.history);
        iconList.add(R.drawable.offers);
        CustomAdapter adapter = new CustomAdapter(this, R.layout.gridview, iconList);

        gridView.setAdapter(adapter);
    }
}