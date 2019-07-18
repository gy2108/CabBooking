package com.example.bookyourcab;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class RegistrationActivity extends Activity {

    TextView username, email, phone, password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.registration);

        TextView linkToLogin = findViewById(R.id.link_to_login);
        linkToLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(RegistrationActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

        username = findViewById(R.id.username);
        email = findViewById(R.id.email);
        phone = findViewById(R.id.contact);
        password = findViewById(R.id.password);
        Button register = findViewById(R.id.btn_signup);
        register.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                SharedPreferences.Editor editor = getSharedPreferences("userdata",MODE_PRIVATE).edit();
                editor.putString("username", username.getText().toString());
                editor.putString("email", email.getText().toString());
                editor.putLong("phone", Long.parseLong(phone.getText().toString()));
                editor.putString("password", password.getText().toString());
                editor.commit();
                Toast.makeText(getApplicationContext(), "Welcome "+username.getText().toString(), Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(RegistrationActivity.this, HomeActivity.class);
                startActivity(intent);
            }
        });
    }
}
