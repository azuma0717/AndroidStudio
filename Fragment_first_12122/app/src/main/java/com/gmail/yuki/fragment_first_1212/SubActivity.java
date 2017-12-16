package com.gmail.yuki.fragment_first_1212;

import android.content.res.Configuration;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class SubActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub);

        if(getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE){

            finish();
            return;

        }



        //DetailFragmentで部品化した、Viewを表示させる
        //インテントしてもらってきたpositionをDetailFragmentインスタンス作りがてら、newInstanceメソッドで受け取る。
        int position = getIntent().getIntExtra(TitleFragment.EXTRA_POSITION,0);

        //まずはDetailFragmentで作ったメソッドを呼び出してやる。
        DetailFragment detailFragment = DetailFragment.newInstance(position);
        //そのあとに、動的にフラグメントを操作したいので、フラグメントマネージャーを呼び出して、トランザクションを開始
        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.detailFrame,detailFragment)
                .commit();


    }
}
