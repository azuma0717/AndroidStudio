package com.gmail.yuki.firebase_third_db_1218;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Login extends AppCompatActivity {

    EditText ed1, ed2;
    Button bt1;
    FirebaseAuth mAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        ed1 = findViewById(R.id.email);
        ed2 = findViewById(R.id.pass);
        bt1 = findViewById(R.id.login);
        mAuth = FirebaseAuth.getInstance();


        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                loginUser();
            }
        });


    }


    private void loginUser() {

        String email = ed1.getText().toString().trim();
        String pass = ed2.getText().toString().trim();

        //バリデーションチェック/////////////
        if (email.isEmpty()) {
            ed1.setError("email required");
            ed1.requestFocus();
            return;
        }

        if (pass.isEmpty()) {
            ed2.setError("pass required");
            ed2.requestFocus();
            return;
        }
        ///////////////////////////////////

        mAuth.signInWithEmailAndPassword(email, pass)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {

                        if (task.isSuccessful()) {

                            Intent intent = new Intent(getApplicationContext(), Home.class);
                            //最初のActivityにもどる。それより後に起動したActivityは削除される
                            intent.addFlags(intent.FLAG_ACTIVITY_CLEAR_TOP);
                            startActivity(intent);

                        } else {

                            Toast.makeText(getApplicationContext(), task.getException().getMessage(), Toast.LENGTH_SHORT).show();

                        }

                    }
                });


    }


}
