package com.example.bookyourcab;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class MainActivity extends AppCompatActivity{

    SQLiteDatabase sqLiteDatabase;
    TextView username;
    TextView password;
    MyDBHelper myDBHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = findViewById(R.id.login_button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                username = findViewById(R.id.username);
                password = findViewById(R.id.password);

                myDBHelper = new MyDBHelper(getBaseContext());
                sqLiteDatabase = myDBHelper.getWritableDatabase();

                Cursor cur = sqLiteDatabase.query(MyDBHelper.TABLE_NAME, new String[]{MyDBHelper.EMP_NAME,MyDBHelper.EMP_PWD},
                        null, null,
                        null, null, null);
//                cur.moveToFirst();
                boolean flag = false;
                while(cur.moveToNext()){
                    if(cur.getString(0).equalsIgnoreCase(username.getText().toString()) &&
                        cur.getString(1).equals(password.getText().toString())){
                        flag = true;
                        break;
                    }
                }
                if(flag){
                    String user = cur.getString(0);
                    Intent intent = new Intent(MainActivity.this, HomeActivity.class);
//                    intent.putExtra("USERNAME", user);
                    startActivity(intent);
                } else {
                    Toast.makeText(getBaseContext(), "Invalid UserName Or Password !!!!", Toast.LENGTH_LONG).show();
                }

            }
        });

        TextView linkToRegister = findViewById(R.id.link_to_register);

        linkToRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, RegistrationActivity.class);
                startActivity(intent);
            }
        });
    }

}
