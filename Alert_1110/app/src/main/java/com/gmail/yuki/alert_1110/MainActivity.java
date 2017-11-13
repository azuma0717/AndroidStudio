package com.gmail.yuki.alert_1110;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.sql.BatchUpdateException;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button bt1, bt2;
    TextView txt1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        bt1 = (Button) findViewById(R.id.bt1);
        bt2 = (Button) findViewById(R.id.bt2);

        bt1.setOnClickListener(this);
        bt2.setOnClickListener(this);

        txt1 = (TextView) findViewById(R.id.txt1);

    }

    @Override
    public void onClick(View v) {

        final AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("warning...");
        builder.setMessage("please choose anyone  'y' or 'n' ...");
//        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        switch (v.getId()) {

            case R.id.bt1:

                Toast.makeText(getApplicationContext(), "Hi Yuki.", Toast.LENGTH_LONG).show();
                break;

            case R.id.bt2: {


                builder.setNegativeButton("Yes", new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                        Toast.makeText(getApplicationContext(), "Continue your work", Toast.LENGTH_LONG).show();

                    }

                })

                .setPositiveButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                        Toast.makeText(getApplicationContext(), "Activity will be close", Toast.LENGTH_LONG).show();
                        AlertDialog dialog1 = builder.create();
                        dialog1.show();
                    }
                }).show();


//                builder.setTitle("title");
//                builder.setMessage("message");
//                builder.setPositiveButton("YES", new DialogInterface.OnClickListener() {
//                            @Override
//                            public void onClick(DialogInterface dialog, int which) {
//                                // YES button pressed
//                            }
//                        })
//                .setNeutralButton("Later", new DialogInterface.OnClickListener() {
//                            @Override
//                            public void onClick(DialogInterface dialog, int which) {
//                                // Later button pressed
//                            }
//                        })
//                        .setNegativeButton("No", null)
//                        .show();


            }
            break;

        }


    }
}
