package com.gmail.yuki.my_firend_info_1124;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.database.Cursor;
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

public class Insert extends Activity implements View.OnClickListener, AdapterView.OnItemSelectedListener {

    Databese_Helper databese_helper;
    Spinner sp1;
    String city[] = {"Select City", "Gurgaon", "New delhi", "Old delhi", "Tokyo", "Osaka", "Fukuoka", "Jaipur", "Agra", "Haridwar", "Jodhpur", "Udaipur", "Gwalior"};
    String city1;
    Button bt1, bt2,bt3;
    TextView tv1, tv2;
    ImageView iv1;
    EditText ed1,ed2,ed3;
    String x;
    String path;
    static final int Camera_Request = 1;
    String b;
    String bbb;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert);

        sp1 = (Spinner)findViewById(R.id.city);
        ArrayAdapter<?> adapter1 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, city);
        sp1.setAdapter(adapter1);
        sp1.setOnItemSelectedListener(this);


        bt1 = (Button)findViewById(R.id.insert);
        bt1.setOnClickListener(this);
        bt2 = (Button)findViewById(R.id.dob);
        bt2.setOnClickListener(this);
        bt3 = (Button)findViewById(R.id.camera);
        bt3.setOnClickListener(this);

        iv1 = (ImageView)findViewById(R.id.image);
        tv1 = (TextView)findViewById(R.id.txt1);
        tv2 = (TextView)findViewById(R.id.tv2);
        ed1 = (EditText)findViewById(R.id.name);
        ed2 = (EditText)findViewById(R.id.phone);
        ed3 = (EditText)findViewById(R.id.email);


        databese_helper = new Databese_Helper(Insert.this);


    }


    /////////////////////////Method of Spinner/////////////////////////////////////


    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

        city1 = sp1.getSelectedItem().toString();

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }

    /////////////////////////On click listener//////////////////////////////////////

    @Override
    public void onClick(View v) {

        switch (v.getId()) {

            case R.id.insert:

                String name = ed1.getText().toString();
                String phone = ed2.getText().toString();
                String email = ed3.getText().toString();
                String city = city1;
                String dob = x;
                String photo = path;

                databese_helper.Insert(name,phone,email,city,dob,photo);
                Cursor rslt = databese_helper.showall();

                rslt.moveToFirst();

                String xx;
                String aa;
                String bb;
                String cc;
                String dd;
                String ee;
                String ff;


                do {
                    xx = rslt.getString(rslt.getColumnIndex("_id"));
                    aa = rslt.getString(rslt.getColumnIndex("name"));
                    bb = rslt.getString(rslt.getColumnIndex("phone"));
                    cc = rslt.getString(rslt.getColumnIndex("email"));
                    dd = rslt.getString(rslt.getColumnIndex("city"));
                    ee = rslt.getString(rslt.getColumnIndex("dob"));
                    ff = rslt.getString(rslt.getColumnIndex("photo"));

                } while (rslt.moveToNext());

                Toast.makeText(getApplicationContext(),"Insert Successfull",Toast.LENGTH_LONG).show();

                Intent back = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(back);
//
//
//                tv2.append(xx+aa+bb+cc+dd+ee+ff);

                break;

            case R.id.dob:

                Calendar calendar = Calendar.getInstance();

                DatePickerDialog datePickerDialog = new DatePickerDialog(Insert.this, new DatePickerDialog.OnDateSetListener() {
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


                Intent camera_intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                File file = getfile();
                camera_intent.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(file));
                startActivityForResult(camera_intent, Camera_Request);



                break;

        }


    }

    //////////////////////////////camera function//////////////////////////////////////

    private File getfile() {

        int bb = Integer.parseInt(b)+ 1;
        bbb = String.valueOf(bb);


        File folder = new File("sdcard/friends_pic");

        if (!folder.exists()) {

            folder.mkdir();

        }

        File image_file = new File(folder, bbb + "friends_image.jpg");

        return image_file;

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        path = "sdcard/friends_pic/" + bbb + "friends_image.jpg";
        iv1.setImageDrawable(Drawable.createFromPath(path));

    }
    ////////////////////////////////////////////////////////////////////////////////////


}
