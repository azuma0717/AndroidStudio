package com.gmail.yuki.homework_loginsystem_1119;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by yuki on 2017/11/20.
 */

public class Database_Helper extends SQLiteOpenHelper {


    Context context;
    SQLiteDatabase sqLiteDatabase;

    public static String Databasename = "Homework_login";

    public Database_Helper(Context context) {

        super(context, Databasename, null, 1);
        this.context = context;

    }


    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        sqLiteDatabase.execSQL("Create table userinfo(name varchar(50),phone varchar(50),email varchar(50),photo varchar(50),pass varchar(50),city varchar(50))");
        this.sqLiteDatabase = sqLiteDatabase;

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

        this.onCreate(sqLiteDatabase);

    }

    public void Insert(String name, String phone, String email, String photo, String pass, String city) {

        sqLiteDatabase = this.getWritableDatabase();


        ContentValues cv = new ContentValues();


        cv.put("name", name);
        cv.put("phone", phone);
        cv.put("email", email);
        cv.put("photo", photo);
        cv.put("pass", pass);
        cv.put("city", city);

        sqLiteDatabase.insert("userinfo", null, cv);

    }

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
