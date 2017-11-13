package com.yukigmail.anyshape_1107;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView tv;
    EditText ed1,ed2,ed3;
    Button bt;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

            tv =findViewById(R.id.rr);
            ed1 = findViewById(R.id.no1);
            ed2 = findViewById(R.id.no2);
            ed3 = findViewById(R.id.etshape);
            bt = findViewById(R.id.bt1);


    }
       public void clicks(View v) {

           String x = ed1.getText().toString();
           int num1 = Integer.parseInt(x);
           String y = ed2.getText().toString();
           int num2 = Integer.parseInt(y);
           String z = ed3.getText().toString();
           String num = "";

           if (z.equals("RT")) {

               for(int e=0; e<num2; e++) {

                   for (int a = num1; a > 0; a--) {

                       for (int c = a; c > 1; c--) {

                           num = num + "  ";

                       }

                       for (int b = 0; b < ((num1+1) - a); b++) {

                           num = num + "*";

                       }
                       num = num + "\n";
                   }
                   num = num + "\n\n";
               }

               tv.setText(num);

           } else if (z.equals("LT")) {

               for(int e=0; e<num2; e++) {

                   for (int i = 1; i <= num1; i++) {

                       for (int l = 0; l < i; l++) {

                           num = num + "*";
                       }
                       num = num + "\n";
                   }
                   num = num + "\n\n";
               }

               tv.setText(num);



           } else if (z.equals("RDT")) {

               for(int e=0; e<num2; e++) {

                   for (int a = num1; a > 0; a--) {

                       for (int c = 0; c < (num1 - a); c++) {

                           num = num + "  ";

                       }

                       for (int b = a; b > 0; b--) {

                           num = num + "*";

                       }

                       num = num + "\n";
                   }
                   num = num + "\n\n";
               }

               tv.setText(num);

           } else if (z.equals("LDT")) {

               for(int e=0; e<num2; e++) {

               for(int a = 0; a<num1; a++){

                   for(int b = num1; b>a; b--){

                       num = num + "*";
                   }

                   for(int c = 0; c<a; c++){

                       num = num + "  ";

                   }
                   num = num + "\n";

               }
                   num = num + "\n\n";
               }

               tv.setText(num);

           } else if (z.equals("UH")) {

               for(int e=0; e<num2; e++) {

               for(int a = num1; a>0; a--) {

                   for(int c =a; c>1; c--){

                       num = num + "  ";

                   }

                   for (int b = 0; b < ((num1+1)-a); b++){

                       num = num + "*";

                   }

                   for(int d =1; d<((num1+1)-a); d++){

                       num = num + "*";
                   }

                   num = num + "\n";
               }
                   num = num + "\n\n";
               }
               tv.setText(num);


           } else if (z.equals("DH")) {

               for(int e=0; e<num2; e++) {


               for(int a = num1; a>0; a--) {

                   for (int c = 0; c < (num1 - a); c++) {

                       num = num + "  ";

                   }

                   for (int b = a; b > 0; b--) {

                       num = num + "*";

                   }

                   for (int d = (a - 1); d > 0; d--) {

                       num = num + "*";
                   }

                   num = num + "\n";
               }
                   num = num + "\n\n";

               }
               tv.setText(num);

               } else if (z.equals("LH")) {

               for(int e=0; e<num2; e++) {


                       for(int f=0; f<num1; f++) {

                           for (int b = 0; b <= f; b++) {

                               num = num + "*";
                           }
                           num = num + "\n";
                       }

                       for(int g=num1; g>0; g--) {


                           for (int b = (g-1); b > 0; b--) {

                               num = num + "*";

                           }

                           num = num + "\n";
                       }

                   num = num + "\n\n";
               }
               tv.setText(num);

           } else if (z.equals("RH")) {

                   for(int e=0; e<num2; e++) {


                       for(int a = num1;  a >0; a--) {

                           for (int c = a; c > 1; c--) {

                               num = num + "  ";

                           }


                           for (int b = 0; b <= (num1 - a); b++) {

                               num = num + "*";

                           }

                           num = num + "\n";

                       }

                       for(int a = num1;  a >0; a--) {

                           for (int b = 0; b <= (num1 - a); b++) {

                               num = num + "  ";

                           }


                           for (int c = a; c > 1; c--) {

                               num = num + "*";

                           }
                           num = num + "\n";
                       }

                       num = num + "\n\n";
                   }


               tv.setText(num);

           } else if (z.equals("DIA")) {

               for(int e=0; e<num2; e++) {


                   for (int a = num1; a > 0; a--) {

                       for (int c = a; c > 1; c--) {

                           num = num + "  ";

                       }

                       for (int b = 0; b < ((num1 + 1) - a); b++) {

                           num = num + "*";

                       }

                       for (int d = 1; d < ((num1 + 1) - a); d++) {

                           num = num + "*";
                       }

                       num = num + "\n";

                   }


                   for (int a = num1; a > 0; a--) {

                       for (int c = 0; c < ((num1 + 1) - a); c++) {

                           num = num + "  ";

                       }

                       for (int b = (a - 1); b > 0; b--) {

                           num = num + "*";

                       }

                       for (int d = (a - 2); d > 0; d--) {

                           num = num + "*";
                       }

                       num = num + "\n";
                   }
                   num = num + "\n";
               }

                     tv.setText(num);
                   }

               }
}



