package com.example.bookyourcab;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.view.View;

public class MyDBHelper extends SQLiteOpenHelper {

    Context ctx;
    public static String DB_NAME = "INFOSYS";
    public static String TABLE_NAME="Employee";
    public static String EMP_NAME="EMPLOYEE_NAME";
    public static String EMP_EMAIL="EMPLOYEE_EMAIL";
    public static String EMP_PWD="EMPLOYEE_PWD";
    public static String EMP_PHONE="EMPLOYEE_PHONE";
    public static int DB_VERSION=1;

    public MyDBHelper(Context ctx){
        super(ctx, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String query = "create table "+MyDBHelper.TABLE_NAME+" ("+MyDBHelper.EMP_NAME+" text,"+MyDBHelper.EMP_EMAIL+" text,"
                +MyDBHelper.EMP_PWD+" text,"+MyDBHelper.EMP_PHONE+" text);";
        sqLiteDatabase.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        if( i1 == i+1){

        }
    }
}
