package com.gmail.yuki.session2_basic_1207;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button bt1;

    ///session使う時に、使うクラス。
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bt1 = findViewById(R.id.bt1);


        //キーの設定と、モードの設定だけする。このアプリにだけ使う時は、プライベートで。
        sharedPreferences = getSharedPreferences("key", MODE_PRIVATE);
        //専用のエディタに書き込むことで、別のクラスに流せる。
        SharedPreferences.Editor editor = sharedPreferences.edit();
        //1個目は、カラム名、２個目は入れたい変数。
        editor.putString("name", "yuki");
        editor.putString("city", "tokyo");
        //commitで完了。
        editor.commit();


    }


    public void push(View view) {

        Intent intent = new Intent(getApplicationContext(), Get_Session_Data.class);
        startActivity(intent);

    }

}
