package com.example.bookyourcab;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;

public class ProfileActivity extends Activity {

    TextView name, email, phone;
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profile);

        name = findViewById(R.id.username);
        email = findViewById(R.id.email);
        phone = findViewById(R.id.phone_number);

        sharedPreferences = getSharedPreferences("userdata", MODE_PRIVATE);

        String username = sharedPreferences.getString("username","");
        name.setText(username);
        String ph = String.valueOf(sharedPreferences.getLong("phone", 0L));
        phone.setText(ph);
        String mail = sharedPreferences.getString("email", "");
        email.setText(mail);

    }
}
