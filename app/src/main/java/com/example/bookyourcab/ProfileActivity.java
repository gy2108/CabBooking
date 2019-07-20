package com.example.bookyourcab;

import android.app.Activity;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class ProfileActivity extends Activity {

    TextView name, email, phone;
    SharedPreferences sharedPreferences;
    SQLiteDatabase  sqLiteDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profile);

        name = findViewById(R.id.username);
        email = findViewById(R.id.email);
        phone = findViewById(R.id.phone_number);

        Cursor cur = sqLiteDatabase.query(MyDBHelper.TABLE_NAME, new String[]{MyDBHelper.EMP_NAME, MyDBHelper.EMP_EMAIL,
                    MyDBHelper.EMP_PHONE}, MyDBHelper.EMP_NAME+"=?", new String[]{"Gopal"},
                null, null, null);
        cur.moveToFirst();

        /*name.setText(cur.getString(0));
        email.setText(cur.getString(1));
        phone.setText(cur.getString(2));*/

        while(!cur.isAfterLast()){
            Toast.makeText(this,"Name  is  "+cur.getString(0)+ "  and Email is  "+
                    cur.getString(1),Toast.LENGTH_LONG).show();
            cur.moveToNext();
        }
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
