package com.gmail.yuki.rock_paper_scissors_game;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends Activity implements View.OnClickListener {

    int[] hands = {R.drawable.stone, R.drawable.scissors, R.drawable.paper};

    int result;
    int hand;

    ImageView imageView1, imageView2;
    Handler handler;
    Button bt1, bt2, bt3;
    TextView tv1,scoreView;
    Score score = new Score();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView1 = findViewById(R.id.cpu);
        imageView2 = findViewById(R.id.you);
        tv1 = findViewById(R.id.result);
        scoreView = findViewById(R.id.score);

        bt1 = findViewById(R.id.stone);
        bt2 = findViewById(R.id.scissors);
        bt3 = findViewById(R.id.paper);

        bt1.setOnClickListener(this);
        bt2.setOnClickListener(this);
        bt3.setOnClickListener(this);

        ///このハンドラーの意味ちゃんと理解してないな。
        //ハンドラーインスタンス作成後、画像がずっと変更され続ける動き。

        handler = new Handler();
        Runnable runnable = new Runnable() {
            int i = 0;

            public void run() {

                imageView1.setImageResource(hands[i]);
                i++;
                if (i > hands.length - 1) {
                    i = 0;
                }


                handler.postDelayed(this, 100);

            }
        };

        handler.postDelayed(runnable, 100);



    }


    @Override
    public void onClick(View v) {

        Random random = new Random();
        int n = random.nextInt(3);

        switch (v.getId()) {

            case R.id.stone:

                hand = 0;

                //ハンドラーの動きを止める。
                handler.removeMessages(0);

                imageView1.setImageResource(hands[n]);
                imageView2.setImageResource(hands[hand]);
                result = (hand - n) + 3;

                break;

            case R.id.scissors:

                hand = 1;
                //ハンドラーの動きを止める。
                handler.removeMessages(0);

                imageView1.setImageResource(hands[n]);
                imageView2.setImageResource(hands[hand]);
                result = (hand - n) + 3;

                break;

            case R.id.paper:

                hand = 2;
                //ハンドラーの動きを止める。
                handler.removeMessages(0);

                imageView1.setImageResource(hands[n]);
                imageView2.setImageResource(hands[hand]);
                result = (hand - n) + 3;

                break;

        }

        //（自分の出した数字ー相手の出した数字＋３）％３が、0ならあいこ、1なら負け、２なら勝ちという
        // 古くから伝わるじゃんけんロジック。

        if (result % 3 == 0) {
            tv1.setText("DRAW");
            int aa = score.getScore();
            scoreView.setText(""+aa);


        } else if (result % 3 == 1) {
            tv1.setText("YOU LOSE");
            tv1.setTextColor(Color.BLUE);
            score.resetScore();
            int aa = score.getScore();
            scoreView.setText(""+aa);


        } else if (result % 3 == 2) {
            tv1.setText("YOU WIN");
            tv1.setTextColor(Color.RED);
            int a = 1;
            score.setScore(a);
            int aa = score.getScore();
            scoreView.setText(""+aa);


        }


    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        Log.d("TouchEvent", "X:" + event.getX() + ",Y:" + event.getY());

        switch (event.getAction()) {

            ////タッチしたときのイベント。今回は勉強がてら記載しただけ。ログだけ出るよ。
            case MotionEvent.ACTION_DOWN:
                Log.d("TouchEvent", "getAction()" + "ACTION_DOWN");
                break;

            ///タッチから上げた時のイベント。今回はこれを使いたい。タップして指を離したら、作動。
            case MotionEvent.ACTION_UP:
                Log.d("TouchEvent", "getAction()" + "ACTION_UP");

//                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
//                startActivity(intent);

                handler = new Handler();
                Runnable runnable = new Runnable() {
                    int i = 0;

                    public void run() {

                        imageView1.setImageResource(hands[i]);
                        i++;
                        if (i > hands.length - 1) {
                            i = 0;
                        }


                        handler.postDelayed(this, 100);

                    }
                };

                handler.postDelayed(runnable, 100);

                tv1.setText("Ready?");
                tv1.setTextColor(Color.LTGRAY);


                break;

            ///タッチしてスライドした時の動き。今回は勉強がてら記載しただけ。ログだけ出るよ。
            case MotionEvent.ACTION_MOVE:
                Log.d("TouchEvent", "getAction()" + "ACTION_MOVE");

                break;

            //UP+DOWNの同時発生(＝キャンセル)の場合,短期間で押して話した場合は、ユーザーがキャンセルしたいと思っていると判断。
            //今回は勉強がてら記載しただけ。ログだけ出るよ。

            case MotionEvent.ACTION_CANCEL:
                Log.d("TouchEvent", "getAction()" + "ACTION_CANCEL");
                break;
        }
        return true;
    }
}
