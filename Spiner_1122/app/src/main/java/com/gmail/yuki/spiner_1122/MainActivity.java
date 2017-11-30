package com.gmail.yuki.spiner_1122;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends Activity implements AdapterView.OnItemSelectedListener {

    String myarray[] = {"Select one","January","February","March","April","May","June","July","August","September","October","November","December"};
    Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spinner =(Spinner)findViewById(R.id.spinner);
        ArrayAdapter<?> adapter= new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,myarray);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);

    }


    @Override
    public void onItemSelected(AdapterView<?> a, View v, int pos, long id) {

        Toast.makeText(getApplicationContext(),a.getItemAtPosition(pos)+"  selected",Toast.LENGTH_LONG).show();

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}
