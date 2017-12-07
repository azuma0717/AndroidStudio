package com.gmail.yuki.session2_basic_1207;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class Get_Session_Data extends AppCompatActivity {


    //sessionのデータを受け取りたいときも、このクラスです。
    SharedPreferences sharedPreferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get__session__data);


        //渡した方と受け取りのキーとモードを合わせます。
        sharedPreferences = getSharedPreferences("key",MODE_PRIVATE);
        //１個目はカラム名、２個目は初期化する値。getStringだとStringで受け取れる。他にもintとかもあるよ。getIntとか。
        String name = sharedPreferences.getString("name",null);
        String city = sharedPreferences.getString("city",null);

        Toast.makeText(getApplicationContext(),name+"  "+city,Toast.LENGTH_SHORT).show();


    }
}
