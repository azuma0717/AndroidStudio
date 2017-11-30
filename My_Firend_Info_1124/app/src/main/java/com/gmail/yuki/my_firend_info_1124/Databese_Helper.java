package com.gmail.yuki.my_firend_info_1124;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by yuki on 2017/11/25.
 */

public class Databese_Helper extends SQLiteOpenHelper {

    Context context;
    SQLiteDatabase sqLiteDatabase;
    public static String Databesename = "Friendinfo";

    public Databese_Helper(Context context) {

        super(context, Databesename, null, 2);
        this.context = context;

    }


    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        sqLiteDatabase.execSQL("Create table friendinfo2(_id integer primary key autoincrement,name varchar(50),phone varchar(50),email varchar(50),city varchar(50),dob varchar(50),photo varchar(50))");
        this.sqLiteDatabase = sqLiteDatabase;
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

        this.onCreate(sqLiteDatabase);

    }

    /////////////////////// create function////////////////////////////

    public void Insert(String name, String phone,String email,String city,String dob,String photo) {

        sqLiteDatabase = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put("name", name);
        cv.put("phone", phone);
        cv.put("email", email);
        cv.put("city", city);
        cv.put("dob", dob);
        cv.put("photo", photo);

        sqLiteDatabase.insert("friendinfo2", null, cv);

    }

    //////////////////////show all ////////////////////////////////////

    public Cursor showall(){

        sqLiteDatabase = this.getReadableDatabase();

        Cursor c = sqLiteDatabase.rawQuery("select ROWID, * from friendinfo2",null);
        return c;

    }

    //////////////////////show id ////////////////////////////////////

    public Cursor showid(String id){

        sqLiteDatabase = this.getReadableDatabase();

        Cursor c = sqLiteDatabase.rawQuery("select ROWID, * from friendinfo2 where _id = '" + id + "' or phone = '" + id + "'",null);
        return c;

    }

}
