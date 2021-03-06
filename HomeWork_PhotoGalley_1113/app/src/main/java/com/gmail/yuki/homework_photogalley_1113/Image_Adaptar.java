package com.gmail.yuki.homework_photogalley_1113;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListAdapter;

/**
 * Created by yuki on 2017/11/16.
 */

public class Image_Adaptar extends BaseAdapter {

    private Context mContext;

    public Image_Adaptar(Context mContext) {

        this.mContext = mContext;
    }


    @Override
    public int getCount() {

        return mThumbIds.length;
    }

    @Override
    public Object getItem(int position) {

        return null;


//        return mThumbIds[position];
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ImageView imageView;

        if (convertView == null) {

            imageView = new ImageView(mContext);
            imageView.setLayoutParams(new GridView.LayoutParams(150, 150));
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            imageView.setPadding(8, 8, 8, 8);

        } else {

            imageView = (ImageView) convertView;
        }


        imageView.setImageResource(mThumbIds[position]);
        return imageView;
    }

    public Integer[] mThumbIds = {

            R.drawable.b0,
            R.drawable.b1,
            R.drawable.b2,
            R.drawable.b3,
            R.drawable.b4,
            R.drawable.b5,
            R.drawable.b6,
            R.drawable.b7,
            R.drawable.b8,
            R.drawable.b9,
            R.drawable.b10,
            R.drawable.b12,
            R.drawable.b13,
            R.drawable.b14,


    };


}


