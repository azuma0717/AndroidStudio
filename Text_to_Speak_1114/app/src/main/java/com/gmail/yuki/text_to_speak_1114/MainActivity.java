//大まかに/////////////////////////////////////////////////////
//
//        ①TestTo Speech インスタンス生成
//        　TestTo Speech tts = new TextToSpeech(this, this)
//        ②onInit() で初期化の結果ステータスを取得
//        ③speak() メソッドで読み上げ開始
//        　tts.speak(string, TextToSpeech.QUEUE_FLUSH, null)
//////////////////////////////////////////////////////////////

package com.gmail.yuki.text_to_speak_1114;

import android.app.Activity;
import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Locale;

public class MainActivity extends Activity implements TextToSpeech.OnInitListener {

//    OnInitListener は、TextToSpeechエンジンの準備ができたことを知らせるコールバック。引数にエンジンの初期化が成功したかどうかが渡される
//    TextToSpeech#speak エンジンにテキストを読み上げさせる.

    private int reslut = 0;
    private TextToSpeech tts;
    private Button btnSpeak;
    private EditText txtEdtit;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // TTS インスタンス生成
        tts = new TextToSpeech(this, this);

        btnSpeak = (Button) findViewById(R.id.bt);
        txtEdtit = (EditText) findViewById(R.id.ed);

        btnSpeak.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                speakOut();

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


    // TTS初期化
    @Override
    public void onInit(int status) {

        if (status == TextToSpeech.SUCCESS) {

            reslut = tts.setLanguage(Locale.US);

            if (reslut == TextToSpeech.LANG_MISSING_DATA || reslut == TextToSpeech.LANG_NOT_SUPPORTED) {

                Toast.makeText(this, "Missing data", Toast.LENGTH_LONG).show();

                btnSpeak.setEnabled(false);

            } else {

                btnSpeak.setEnabled(true);

            }
        } else {

            Log.e("TTS", "Initilization Failed");
        }

    }

    private void speakOut() {

        String text = txtEdtit.getText().toString();
        tts.setSpeechRate(1);
        tts.setPitch(5);

        if (reslut != tts.setLanguage(Locale.US)) {

            Toast.makeText(getApplicationContext(), "Enter the right words..", Toast.LENGTH_LONG).show();

        } else {

            tts.speak(text, TextToSpeech.QUEUE_FLUSH, null);

        }


    }


}


