package com.gmail.yuki.homework_db2_1116;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

/**
 * Created by yuki on 2017/11/16.
 */

public class Database_Helper extends SQLiteOpenHelper {

    Context context;
    SQLiteDatabase sqLiteDatabase;

    public static String dbname = "yuki3";

    public Database_Helper(Context context) {

        super(context, dbname, null, 1);
        this.context = context;

    }


    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        sqLiteDatabase.execSQL("create table userinfo(_id integer primary key autoincrement,name varchar(50),phone varchar(50),salary varchar(50),city varchar(50),dob varchar(50),email varchar(50))");
        this.sqLiteDatabase = sqLiteDatabase;

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

        this.onCreate(sqLiteDatabase);

    }

    public void Insert(String name, String phone, String salary, String city, String dob, String email) {


        sqLiteDatabase = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put("name", name);
        cv.put("phone", phone);
        cv.put("salary", salary);
        cv.put("city", city);
        cv.put("dob", dob);
        cv.put("email", email);

        sqLiteDatabase.insert("userinfo", null, cv);

    }

    public Cursor show() {

        sqLiteDatabase = this.getReadableDatabase();

        Cursor c = sqLiteDatabase.rawQuery("select * from userinfo",null);
        return c;

    }


}
