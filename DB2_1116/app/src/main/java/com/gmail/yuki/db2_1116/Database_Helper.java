package com.gmail.yuki.db2_1116;

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

  public static String dbname = "yuki2";

    public  Database_Helper(Context context) {

        super(context,dbname,null,1);
        this.context = context;
    }


    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        sqLiteDatabase.execSQL("create table userinfo(name varchar(50),phone varchar(50),email varchar(50),dob varchar(50))");
        this.sqLiteDatabase = sqLiteDatabase;

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

        this.onCreate(sqLiteDatabase);

    }

    public void Insertss(String name,String phone,String email,String dob){

        //Toast.makeText(this,"hhhhh",Toast.LENGTH_SHORT).show();


        sqLiteDatabase = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put("name",name);
        cv.put("phone",phone);
        cv.put("email",email);
        cv.put("dob",dob);

        sqLiteDatabase.insert("userinfo",null,cv);
    }

    public Cursor show(){

        sqLiteDatabase = this.getReadableDatabase();

        Cursor c = sqLiteDatabase.rawQuery("select * from userinfo",null);
        return c;


    }


}
