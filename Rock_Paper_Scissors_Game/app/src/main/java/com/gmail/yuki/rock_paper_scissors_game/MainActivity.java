package com.gmail.yuki.rock_paper_scissors_game;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    int[] hands = {R.drawable.stone, R.drawable.scissors,R.drawable.paper};

    int result;
    int hand;


    boolean stop = false;

    ImageView imageView1, imageView2;
    Handler handler;
    Button bt1, bt2, bt3;
    TextView tv1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView1 = findViewById(R.id.cpu);
        imageView2 = findViewById(R.id.you);
        tv1 = findViewById(R.id.result);

        bt1 = findViewById(R.id.stone);
        bt2 = findViewById(R.id.scissors);
        bt3 = findViewById(R.id.paper);

        bt1.setOnClickListener(this);
        bt2.setOnClickListener(this);
        bt3.setOnClickListener(this);


        if (!stop) {
            handler = new Handler();
            Runnable runnable = new Runnable() {
                int i = 0;

                public void run() {

                    imageView1.setImageResource(hands[i]);
                    i++;
                    if (i > hands.length - 1) {
                        i = 0;
                    }

                    if (!stop) {
                        handler.postDelayed(this, 100);
                    }
                }
            };

            if (!stop) {
                handler.postDelayed(runnable, 100);
            }
        }


    }

    @Override
    public void onClick(View v) {

        Random random = new Random();
        int n = random.nextInt(3);

        switch (v.getId()) {

            case R.id.stone:

                hand = 0;
                handler.removeMessages(0);

                imageView1.setImageResource(hands[n]);
                imageView2.setImageResource(hands[hand]);
                result = (hand - n) + 3;

                break;

            case R.id.scissors:

                hand = 1;
                handler.removeMessages(0);

                imageView1.setImageResource(hands[n]);
                imageView2.setImageResource(hands[hand]);
                result = (hand - n) + 3;

                break;

            case R.id.paper:

                hand = 2;
                handler.removeMessages(0);

                imageView1.setImageResource(hands[n]);
                imageView2.setImageResource(hands[hand]);
                result = (hand - n) + 3;

                break;

        }

        if (result%3 == 0){
            tv1.setText("DRAW");

        }else if(result%3 == 1){
            tv1.setText("YOU LOSE");

        }else if(result%3 == 2){
            tv1.setText("YOU WIN");
            
        }


    }
}
