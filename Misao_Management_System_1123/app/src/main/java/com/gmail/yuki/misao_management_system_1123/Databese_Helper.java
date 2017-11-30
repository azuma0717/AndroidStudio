package com.gmail.yuki.misao_management_system_1123;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by yuki on 2017/11/23.
 */

public class Databese_Helper extends SQLiteOpenHelper {

    Context context;
    SQLiteDatabase sqLiteDatabase;
    public static String Databesename = "MMS2";

    public Databese_Helper(Context context){

        super(context,Databesename,null,1);
        this.context = context;
    }


    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        sqLiteDatabase.execSQL("Create table userinfo5(_id integer primary key autoincrement,name varchar(50),phone varchar(50),email varchar(50),city varchar(50),dob varchar(50),doj varchar(50),doe varchar(50),course varchar(50),fee varchar(50),ved varchar(50))");
        this.sqLiteDatabase = sqLiteDatabase;

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

        this.onCreate(sqLiteDatabase);

    }

    /////////////////　↓Create function  /////////////////////////

    public void Insert(String name, String phone, String email, String city, String dob, String doj, String doe, String course, String fee, String ved) {

        sqLiteDatabase = this.getWritableDatabase();


        ContentValues cv = new ContentValues();


        cv.put("name",name);
        cv.put("phone",phone);
        cv.put("email",email);
        cv.put("city",city);
        cv.put("dob",dob);
        cv.put("doj",doj);
        cv.put("doe",doe);
        cv.put("course",course);
        cv.put("fee",fee);
        cv.put("ved",ved);


        sqLiteDatabase.insert("userinfo5", null, cv);

    }

    /////////////////　↓Create function  /////////////////////////


    public Cursor show(){

        sqLiteDatabase = this.getReadableDatabase();

        Cursor c = sqLiteDatabase.rawQuery("select * from userinfo5",null);
        return c;
    }




    /////////////////　↓Create function  /////////////////////////


    public Cursor show2(String id){

        sqLiteDatabase = this.getReadableDatabase();
        String yuki = id;

//        Cursor c = sqLiteDatabase.rawQuery("select * from userinfo5",null);
        Cursor c = sqLiteDatabase.rawQuery("select * from userinfo5 where _id = '"+yuki+"'", null);

        return c;
    }



}
