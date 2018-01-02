package com.gmail.yuki.swipe_cards_1215;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

/**
 * Created by yuki on 2017/12/21.
 */


//<cards>ってやることで、cardsクラスを好きに使っていいってことなのかな

public class arrayAdapter extends ArrayAdapter<cards> {

    Context context;

    //ArrayAdapterをextendsすると、こいつをつくる決まりなのかな？
    public arrayAdapter(Context context, int resourceId, List<cards> items){
        super(context,resourceId,items);

    }

    //getViewは絶対必要。
    public View getView(int position,  View convertView,  ViewGroup parent) {

        cards card_item = getItem(position);


        if(convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item, parent, false);
        }

        TextView name = convertView.findViewById(R.id.name);
        ImageView image = convertView.findViewById(R.id.image);


        name.setText(card_item.getName());
        image.setImageResource(R.mipmap.ic_launcher);


        //arrayAdapterを呼び出したら、リターンでconvetViewが返る。
        return convertView;


    }



}
