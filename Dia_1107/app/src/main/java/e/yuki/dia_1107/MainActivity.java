package e.yuki.dia_1107;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv = (TextView)findViewById(R.id.txt1);

        String num = "";
        for(int a = 10; a>0; a--) {

            if (a > 5) {

                for (int c = (a-5); c > 1; c--) {

                    num = num + "  ";

                }

                for (int b = 0; b < (11 - a); b++) {

                    num = num + "*";

                }

                for (int d = 1; d < (11 - a); d++) {

                    num = num + "*";
                }


                num = num + "\n";

            } else {

                for(int c = 0; c<(6-a); c++){

                    num = num + "  ";

                }

                for(int b = (a-1); b>0; b--){

                    num = num + "*";

                }

                for(int d = (a-2); d>0; d--){

                    num = num + "*";
                }

                num = num + "\n";



            }


        }
        tv.setText(num);

    }
}
