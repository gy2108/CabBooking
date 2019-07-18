package com.example.bookyourcab;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
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

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = null;
                switch (i){
                    case 0:
                        intent = new Intent(HomeActivity.this, ProfileActivity.class);
                        break;
                    case 1:
                        intent = new Intent(HomeActivity.this, HistoryActivity.class);
                        break;
                    case 2:
                        intent = new Intent(HomeActivity.this, HistoryActivity.class);
                        break;
                    case 3:
                        intent = new Intent(HomeActivity.this, OffersActivity.class);
                        break;
                }
                startActivity(intent);
            }
        });
    }
}