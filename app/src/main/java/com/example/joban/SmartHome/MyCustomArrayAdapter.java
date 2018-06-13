package com.example.joban.SmartHome;

/**
 * Created by joban on 03/03/2018.
 */

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import android.widget.ToggleButton;

import java.util.List;

public class MyCustomArrayAdapter extends ArrayAdapter<Model> {

    private final List<Model> list;
    private final Activity context;

    public MyCustomArrayAdapter(Activity context, List<Model> list) {
        super(context, R.layout.list_layout, list);
        this.context = context;
        this.list = list;
    }

    static class ViewHolder {
        protected TextView text;
        protected ToggleButton ToggleButton;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = null;
        if (convertView == null) {
            LayoutInflater inflator = context.getLayoutInflater();
            view = inflator.inflate(R.layout.list_layout, null);
            final ViewHolder viewHolder = new ViewHolder();
         //   viewHolder.text = view.findViewById(R.id.label);
           // viewHolder.text.setTextColor(Color.BLACK);
            viewHolder.ToggleButton =  view.findViewById(R.id.check);
            view.setTag(viewHolder);
            viewHolder.ToggleButton.setTag(list.get(position));
        } else {
            view = convertView;
            ((ViewHolder) view.getTag()).ToggleButton.setTag(list.get(position));
        }
        ViewHolder holder = (ViewHolder) view.getTag();
//      holder.text.setText(list.get(position).getName());
        holder.ToggleButton.setTextOn(list.get(position).getName());
        holder.ToggleButton.setTextOff(list.get(position).getName());
        holder.ToggleButton.setChecked(list.get(position).isSelected());
        return view;

    }
}