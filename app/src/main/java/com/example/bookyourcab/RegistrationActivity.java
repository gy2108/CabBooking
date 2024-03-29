package com.example.bookyourcab;

import android.app.Activity;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class RegistrationActivity extends Activity {

    TextView username, email, phone, password, confirmPassword;
    MyDBHelper db;
    SQLiteDatabase sqLiteDatabase;

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
        confirmPassword = findViewById(R.id.confirmPassword);
        final Button register = findViewById(R.id.btn_signup);

        db = new MyDBHelper(this);
        sqLiteDatabase = db.getWritableDatabase();

        register.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                if(view.getId()==R.id.btn_signup){
                    String name = username.getText().toString().trim();
                    String mail = email.getText().toString().trim();
                    String pwd = password.getText().toString();
                    String cnfPwd = confirmPassword.getText().toString();
                    String ph = phone.getText().toString();
                    if(TextUtils.isEmpty(name) || TextUtils.isEmpty(mail) ||
                            TextUtils.isEmpty(pwd) || TextUtils.isEmpty(ph) || TextUtils.isEmpty(cnfPwd)
                            || !cnfPwd.equals(pwd)){
                        Toast.makeText(getBaseContext(), "Please Provide Valid Data.", Toast.LENGTH_LONG).show();
                    } else{
                        String insertQuery = "insert into "+MyDBHelper.TABLE_NAME+" values(?,?,?,?)";
                        SQLiteStatement sqLiteStatement = sqLiteDatabase.compileStatement(insertQuery);
                        sqLiteStatement.bindString(1, name);
                        sqLiteStatement.bindString(2, mail);
                        sqLiteStatement.bindString(3, pwd);
                        sqLiteStatement.bindString(4, ph);
                        long rows = sqLiteStatement.executeInsert();
                        if(rows>0){
                            Toast.makeText(getApplicationContext(), "Success", Toast.LENGTH_SHORT).show();
                        }else{
                            Toast.makeText(getApplicationContext(), "Error", Toast.LENGTH_SHORT).show();
                        }
                        Intent intent = new Intent(RegistrationActivity.this, HomeActivity.class);
                        intent.putExtra("USERNAME", name);
                        intent.putExtra("EMAIL", mail);
                        startActivity(intent);
                    }

                }
                /*SharedPreferences.Editor editor = getSharedPreferences("userdata",MODE_PRIVATE).edit();
                editor.putString("username", username.getText().toString());
                editor.putString("email", email.getText().toString());
                editor.putLong("phone", Long.parseLong(phone.getText().toString()));
                editor.putString("password", password.getText().toString());
                editor.commit();*/
//                Toast.makeText(getApplicationContext(), "Welcome "+username.getText().toString(), Toast.LENGTH_SHORT).show();

            }
        });
    }
}
