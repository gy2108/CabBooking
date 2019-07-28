package com.example.bookyourcab;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

public class ProfileActivity extends Activity {

    TextView name, email, phone;
//    SharedPreferences sharedPreferences;
    SQLiteDatabase  sqLiteDatabase;
    MyDBHelper myDBHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profile);

        name = findViewById(R.id.username);
        email = findViewById(R.id.email);
        phone = findViewById(R.id.phone_number);

        Intent intent = getIntent();
        String username = intent.getStringExtra("USERNAME");
        String mail = intent.getStringExtra("EMAIL");

        myDBHelper=new MyDBHelper(this);
        sqLiteDatabase=myDBHelper.getWritableDatabase();

        Cursor cur = sqLiteDatabase.query(MyDBHelper.TABLE_NAME, new String[]{MyDBHelper.EMP_NAME, MyDBHelper.EMP_EMAIL,
                    MyDBHelper.EMP_PHONE, MyDBHelper.EMP_PWD}, MyDBHelper.EMP_EMAIL+"=?", new String[]{mail},
                null, null, null);

        cur.moveToFirst();
//        while(!cur.isAfterLast()){
        Log.d("DEBUG", cur.getString(0));
        Log.d("DEBUG", cur.getString(1));
        Log.d("DEBUG", cur.getString(2));
        name.setText(cur.getString(0));
        email.setText(cur.getString(1));
        phone.setText(cur.getString(2));
//            cur.moveToNext();
//        }
        Toast.makeText(this,"Name  is  "+cur.getString(0)+ "  and Email is  "+
                cur.getString(1),Toast.LENGTH_LONG).show();
        cur.close();

        /*sharedPreferences = getSharedPreferences("userdata", MODE_PRIVATE);

        String username = sharedPreferences.getString("username","");
        name.setText(username);
        String ph = String.valueOf(sharedPreferences.getLong("phone", 0L));
        phone.setText(ph);
        String mail = sharedPreferences.getString("email", "");
        email.setText(mail);*/

    }
}
