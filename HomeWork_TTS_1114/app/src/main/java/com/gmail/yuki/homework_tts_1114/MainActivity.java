package com.gmail.yuki.homework_tts_1114;

import android.app.Activity;
import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.util.Locale;

public class MainActivity extends Activity implements TextToSpeech.OnInitListener {


    private int reslut = 0;
    private TextToSpeech tts;
    private Button button;
    private EditText ET1, ET2, ET3, ET4, ET5, ET6;
    private RadioButton RB1,RB2;
    private RadioGroup RG;

    String text7 = "";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tts = new TextToSpeech(this, this);
        button =findViewById(R.id.button);
        ET1 = findViewById(R.id.editText);
        ET2 = findViewById(R.id.editText2);
        ET3 = findViewById(R.id.editText3);
        ET4 = findViewById(R.id.editText4);
        ET5 = findViewById(R.id.editText5);
        ET6 = findViewById(R.id.editText6);

        RG = findViewById(R.id.radioGroup);
        RB1 = findViewById(R.id.radioButton);
        RB2 = findViewById(R.id.radioButton2);

        RG.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int checkedId) {

                if(checkedId != -1){

                    RadioButton radioButton = findViewById(checkedId);
                    text7 = radioButton.getText().toString();
                }

            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                for(int i=1; i<=7; i++){

                    speakOut(String.valueOf(i));

                }



            }
        });


    }

    @Override
    public void onDestroy() {

        if (tts != null) {

            tts.stop();
            tts.shutdown();

        }

        super.onDestroy();
    }


    @Override
    public void onInit(int status) {

        if (status == TextToSpeech.SUCCESS) {

            reslut = tts.setLanguage(Locale.US);

            if (reslut == TextToSpeech.LANG_MISSING_DATA || reslut == TextToSpeech.LANG_NOT_SUPPORTED) {

                Toast.makeText(this, "Missing data", Toast.LENGTH_LONG).show();

                button.setEnabled(false);

            } else {

                button.setEnabled(true);

            }
        } else {

            Log.e("TTS", "Initilization Failed");
        }
    }

    private void speakOut(String a) {

        String text1 = ET1.getText().toString();
        String text2 = ET2.getText().toString();
        String text3 = ET3.getText().toString();
        String text4 = ET4.getText().toString();
        String text5 = ET5.getText().toString();
        String text6 = ET6.getText().toString();

        String text = "";



         switch (a){
             case "1":
                        text  = "Hi,My name is" + text1;
                 break;

             case "2":
                        text  = "My Phone number is" + text2;
                 break;

             case "3":
                 text  = "My Email is" + text3;
                 break;

             case "4":

                 text  = "My Gender is" +text7;
                 break;

             case "5":
                 text  = "My Birthday is" + text4;
                 break;

             case "6":
                 text  = "I live in" + text5;
                 break;


             case "7":
                 text  = "My favorite song is" + text6;
                 break;

         }




//        tts.setSpeechRate(1);
//        tts.setPitch(5);

        if (reslut != tts.setLanguage(Locale.US)) {

            Toast.makeText(getApplicationContext(), "Enter the right words..", Toast.LENGTH_LONG).show();

        } else {

//            tts.speak(text, TextToSpeech.QUEUE_FLUSH, null);
            tts.speak(text, TextToSpeech.QUEUE_ADD, null);

        }


    }
}
