package com.example.bookyourcab;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.logging.Logger;

public class MainActivity extends AppCompatActivity {

    ListView offers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*offers = (ListView) findViewById(R.id.offerList);
        offers.setOnItemClickListener(this);*/
    }

   /* public void onItemClick(AdapterView<?> parent, View view, int position, long id){
        String value = parent.getItemAtPosition(position).toString();
        Log.d("Item Clicked", value);
    }*/
}
