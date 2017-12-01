package com.gmail.yuki.user_profile_1130;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.SimpleTimeZone;

public class MainActivity extends Activity implements View.OnClickListener, AdapterView.OnItemSelectedListener {

    EditText ed1, ed2, ed3;
    Button bt1, bt2, bt3, bt4;
    Spinner sp1;
    ImageView iv1;
    TextView tv1;
    String city1;
    String b, bbb, x,path;
    static final int Camera_Request = 1;
    String city[] = {"select city", "Tokyo", "Osaka", "Delhi", "Gurgaon", "Chandigarh", "Agra"};
    Database_Helper databese_helper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ed1 = findViewById(R.id.name);
        ed2 = findViewById(R.id.phone);
        ed3 = findViewById(R.id.email);
        bt1 = findViewById(R.id.checkdob);
        bt2 = findViewById(R.id.camera);
        bt3 = findViewById(R.id.ok);
        bt4 = findViewById(R.id.show);
        sp1 = findViewById(R.id.city);
        iv1 = findViewById(R.id.photo);
        tv1 = findViewById(R.id.dob);

        ArrayAdapter<?> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, city);
        sp1.setAdapter(adapter);
        sp1.setOnItemSelectedListener(this);

        bt1.setOnClickListener(this);
        bt2.setOnClickListener(this);
        bt3.setOnClickListener(this);
        bt4.setOnClickListener(this);

        databese_helper = new Database_Helper(MainActivity.this);

    }


    ///////////////////// on click Listener///////////////////////

    @Override
    public void onClick(View v) {

        switch (v.getId()) {

            case R.id.checkdob:

                Calendar calendar = Calendar.getInstance();
                DatePickerDialog datePickerDialog = new DatePickerDialog(MainActivity.this, new DatePickerDialog.OnDateSetListener() {

                    @Override
                    public void onDateSet(DatePicker datePicker, int year, int month, int day) {

                        Date date = new Date(year - 1900, month, day);

                        SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");

                        x = fmt.format(date);
                        tv1.setText(x);

                    }
                }, calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DATE)

                );

                datePickerDialog.show();

                break;

            case R.id.camera:

                String method = "yukicheck";

                databese_helper.execute(method);

                String dd = getIntent().getStringExtra("idnumber");
                Toast.makeText(getApplicationContext(),dd,Toast.LENGTH_SHORT).show();

//                if (rslt2 == null) {
//
                    b = databese_helper.show;
//                } else {

//                    b = rslt2.getString(rslt2.getColumnIndex("_id"));
//
//                }


//                Intent camera_intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
//                File file = getfile();
//                camera_intent.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(file));
//                startActivityForResult(camera_intent, Camera_Request);

        }
    }

    /////////////////// camera fuction   ///////////////////////////////////////

    private File getfile() {

        String c ="";
        int bb = Integer.parseInt(b) + 1;
        bbb = String.valueOf(bb);

        File folder = new File("sdcard/user_profile");

        if (!folder.exists()) {

            folder.mkdir();

        }
        File image_file = new File(folder, bbb + "user_image.jpg");

        return image_file;

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        path = "sdcard/user_profile/" + bbb + "user_image.jpg";
        Bitmap bmp1 = BitmapFactory.decodeFile(path);
        Bitmap rebmp1 = Bitmap.createScaledBitmap(bmp1, 200, 200, false);

        iv1.setImageBitmap(rebmp1);                //ビットマップをImageViewにセット


    }


    /////////////////// Item Select function //////////////////////////////////


    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

        city1 = sp1.getSelectedItem().toString();
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}
