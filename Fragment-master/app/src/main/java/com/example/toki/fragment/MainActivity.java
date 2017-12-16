package com.example.toki.fragment;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    private SectionStatePagerAdapter sectionStatePagerAdapter;
    private ViewPager viewPager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sectionStatePagerAdapter=new SectionStatePagerAdapter(getSupportFragmentManager());
        viewPager=findViewById(R.id.container);

            setupViewPager(viewPager);
    }

    private void setupViewPager(ViewPager viewPager) {
        sectionStatePagerAdapter=new SectionStatePagerAdapter(getSupportFragmentManager());
        sectionStatePagerAdapter.addFragment(new Fragment1(),"Fragment1");
        sectionStatePagerAdapter.addFragment(new Fragment2(),"Fragment2");
        sectionStatePagerAdapter.addFragment(new Fragment3(),"Fragment3");

        viewPager.setAdapter(sectionStatePagerAdapter);

    }
    public void setViewPager(int fragmentNumber){
        viewPager.setCurrentItem(fragmentNumber);

    }

}
