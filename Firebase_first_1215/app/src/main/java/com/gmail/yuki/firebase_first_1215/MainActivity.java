package com.gmail.yuki.firebase_first_1215;

import android.app.ProgressDialog;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity implements OnClickListener{

    private String TAG = "SignUpActivity";
    EditText ed1,ed2;
    Button bt1;
    ProgressDialog progressDialog;
    FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ed1 = findViewById(R.id.email);
        ed2 = findViewById(R.id.password);
        bt1 = findViewById(R.id.bt1);
        bt1.setOnClickListener(this);

        progressDialog = new ProgressDialog(this);

        firebaseAuth = FirebaseAuth.getInstance();
    }

    private void registerUser(){

        String email = ed1.getText().toString().trim();
        String password = ed2.getText().toString().trim();

        if(TextUtils.isEmpty(email)){

            Toast.makeText(getApplicationContext(),"please enter Name",Toast.LENGTH_SHORT).show();
            return;

        }

        if(TextUtils.isEmpty(password)){

            Toast.makeText(getApplicationContext(),"please enter Email",Toast.LENGTH_SHORT).show();
            return;

        }

        progressDialog.setMessage("Registering.....");
        progressDialog.show();
        firebaseAuth.createUserWithEmailAndPassword(email,password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {

//                Log.d(TAG, "createUserWithEmail:onComplete:" + task.isSuccessful());
//                task.getException();

                if(task.isSuccessful()){

                    Toast.makeText(getApplicationContext(),"Register Successfully",Toast.LENGTH_SHORT).show();

                }else{

                    Toast.makeText(getApplicationContext(),"Failed...",Toast.LENGTH_SHORT).show();
                }

            }
        });
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){

            case R.id.bt1:

                registerUser();

                break;

        }

    }
}
