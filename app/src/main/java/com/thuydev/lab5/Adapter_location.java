package com.thuydev.lab5;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class Adapter_location extends BaseAdapter {
    private Activity activity;
    private ArrayList<modle_location> List;

    public Adapter_location(Activity activity, ArrayList<modle_location> List) {
        this.activity = activity;
        this.List = List;
    }


    @Override
    public int getCount() {
        return List.size();
    }

    @Override
    public Object getItem(int position) {
        return List.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater =activity.getLayoutInflater();
        convertView = inflater.inflate(R.layout.modle_tinhthnah,parent,false);
        ImageView imageView = convertView.findViewById(R.id.ivAvatar);
        TextView textView = convertView.findViewById(R.id.txtName);

        modle_location modleLocation =List.get(position);
        imageView.setImageResource(modleLocation.getIcon());
        textView.setText(modleLocation.getName());

        return convertView;
    }
}
