package com.gmail.yuki.loginsystem2;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

/**
 * Created by yuki on 2017/11/23.
 */

public class Database_Helper extends SQLiteOpenHelper {

    Context context;
    SQLiteDatabase sqLiteDatabase;
    public static String Databesename = "LoginSystem2";

    public Database_Helper(Context context) {

        super(context, Databesename, null, 1);
        this.context = context;

    }


    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        sqLiteDatabase.execSQL("Create table userinfo(name varchar(50),phone varchar(50),email varchar(50),pass varchar(50),photo varchar(50),dob varchar(50),city varchar(50))");
        this.sqLiteDatabase = sqLiteDatabase;

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

        this.onCreate(sqLiteDatabase);

    }


/////////////////　↓Create function  /////////////////////////

    public void Insert(String name, String phone, String email, String pass, String photo, String dob, String city) {

        sqLiteDatabase = this.getWritableDatabase();


        ContentValues cv = new ContentValues();


        cv.put("name", name);
        cv.put("phone", phone);
        cv.put("email", email);
        cv.put("pass", pass);
        cv.put("photo", photo);
        cv.put("dob", dob);
        cv.put("city", city);

        sqLiteDatabase.insert("userinfo", null, cv);

    }

    /////////////////　↓Create function  /////////////////////////

    public Cursor login(String name, String pass) {

        sqLiteDatabase = this.getReadableDatabase();
        Cursor c = sqLiteDatabase.rawQuery("select * from userinfo where name = '" + name + "' AND pass = '" + pass + "'", null);


        if (c.getCount() > 0) {


            return c;

        } else {

            return null;

        }


    }



}