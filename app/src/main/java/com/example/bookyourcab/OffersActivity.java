package com.example.bookyourcab;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class OffersActivity extends Activity implements AdapterView.OnItemClickListener {

    ListView offers;
    List<String> listOfOffers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.offers);

//        offers = findViewById(R.id.offerList);
        listOfOffers = new ArrayList<>();
        listOfOffers.add("Upto 50% Cash-Back On first Ride");
        listOfOffers.add("Lucky Free Ride");
        listOfOffers.add("Long Distance Discount");
        listOfOffers.add("Get Rs50 cash-back");
        listOfOffers.add("Upto 50% Cash-Back On first Ride");
        listOfOffers.add("Lucky Free Ride");
        listOfOffers.add("Long Distance Discount");
        listOfOffers.add("Get Rs50 cash-back");
        listOfOffers.add("Upto 50% Cash-Back On first Ride");
        listOfOffers.add("Lucky Free Ride");
        listOfOffers.add("Long Distance Discount");
        listOfOffers.add("Get Rs50 cash-back");
        listOfOffers.add("Upto 50% Cash-Back On first Ride");
        listOfOffers.add("Lucky Free Ride");
        listOfOffers.add("Long Distance Discount");
        listOfOffers.add("Get Rs50 cash-back");
        listOfOffers.add("Upto 50% Cash-Back On first Ride");
        listOfOffers.add("Lucky Free Ride");
        listOfOffers.add("Long Distance Discount");
        listOfOffers.add("Get Rs50 cash-back");

        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        OfferAdapter offerAdapter = new OfferAdapter(OffersActivity.this, listOfOffers);
        recyclerView.setAdapter(offerAdapter);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, listOfOffers);
       /* offers.setAdapter(adapter);
        offers.setOnItemClickListener(this);*/
    }

    public void onItemClick(AdapterView<?> parent, View view, int position, long id){
        String value = parent.getItemAtPosition(position).toString();
        Log.d("Item Clicked", value);
    }
}
