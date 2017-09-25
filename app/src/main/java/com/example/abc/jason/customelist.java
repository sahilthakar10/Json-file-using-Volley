package com.example.abc.jason;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.android.volley.Response;

/**
 * Created by ABC on 08-08-2017.
 */

public class customelist extends ArrayAdapter<String> {

    private String[] name;
    private String[] Roll;
    private Activity context;

    public customelist(Activity context , String[] name , String[] Roll) {
        super(context, R.layout.list_layout , name);

            this.context = context;
            this.name = name;
            this.Roll = Roll;

    }
    @Override
    public View getView(int position , View convertView ,ViewGroup parent)
    {
        LayoutInflater inflater = context.getLayoutInflater();
        View listviewItem = inflater.inflate(R.layout.list_layout,null,true);

        TextView tname = (TextView)listviewItem.findViewById(R.id.t1);
        TextView troll = (TextView)listviewItem.findViewById(R.id.t2);

        tname.setText(name[position]+"");
        troll.setText(Roll[position]);

        return listviewItem;
    }
}
