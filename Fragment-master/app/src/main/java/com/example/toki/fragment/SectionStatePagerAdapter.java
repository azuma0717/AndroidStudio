package com.example.toki.fragment;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by toki on 2017/12/11.
 */

public class SectionStatePagerAdapter extends FragmentStatePagerAdapter{

    private final List<Fragment> fragmentList=new ArrayList<>();
    private final List<String>  fragentListTitleList=new ArrayList<>();

    public SectionStatePagerAdapter(FragmentManager fm){
        super(fm);

    }

    @Override
    public Fragment getItem(int position) {
        return fragmentList.get(position);
    }

    @Override
    public int getCount() {
        return fragmentList.size();
    }

    public void addFragment(Fragment fragment,String title){

        fragmentList.add(fragment);
        fragentListTitleList.add(title);

    }
}
