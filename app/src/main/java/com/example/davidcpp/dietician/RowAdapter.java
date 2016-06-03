package com.example.davidcpp.dietician;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;


/**
 * Created by davidcpp on 2016-05-14.
 */
public class RowAdapter extends ArrayAdapter<MainRow> {

    Context context;
    int layoutResourceId;
    MainRow data[] = null;

    public RowAdapter(Context context, int layoutResourceId, MainRow[] data) {
        super(context, layoutResourceId, data);
        this.layoutResourceId = layoutResourceId;
        this.context = context;
        this.data = data;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row = convertView;
        MainRowHolder holder = null;

        if (row == null) {
            // Creating row View object from given xml layout
            LayoutInflater layoutInflater = ((Activity) context).getLayoutInflater();
            row = layoutInflater.inflate(layoutResourceId, parent, false);

            // Getting views objects of elements in row to later setting its title and image
            holder = new MainRowHolder();

            holder.rowObject = data[position];
            holder.textView = (TextView) row.findViewById(com.example.davidcpp.dietician.R.id.txtTitle);
            holder.textView.setTag(holder.rowObject);
            // Setting tag of whole row - ( single listItem view object )
            row.setTag(holder);
        } else {
            // Getting View objects of row View object to holder
            holder = (MainRowHolder) row.getTag();
        }
        // Setting txtTitle and imageResource id for elements on indicated position in listView

        holder.textView.setText(holder.rowObject.title);
        return row;
    }

    static class MainRowHolder {
        MainRow rowObject;
        TextView textView;

    }

}
