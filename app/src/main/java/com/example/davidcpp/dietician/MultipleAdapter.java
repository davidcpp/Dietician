package com.example.davidcpp.dietician;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.TreeSet;


/**
 * Created by davidcpp on 02.06.2016.
 */

public class MultipleAdapter extends BaseAdapter {

    private static final int TYPE_ITEM = 0;
    private static final int TYPE_SEPARATOR = 1;
    private static final int TYPE_MAX_COUNT = TYPE_SEPARATOR + 1;

    private ArrayList mData = new ArrayList();
    private LayoutInflater mInflater;

    private TreeSet mSeparatorsSet = new TreeSet();

    public MultipleAdapter(Context context) {
        mInflater = (LayoutInflater) ((Activity) context).getSystemService(Context.LAYOUT_INFLATER_SERVICE);

    }

    public void addItem(final String item) {
        mData.add(item);
        notifyDataSetChanged();
    }

    public void addSeparatorItem(final String item) {
        mData.add(item);
        // save separator position
        mSeparatorsSet.add(mData.size() - 1);
        notifyDataSetChanged();
    }

    @Override
    public int getItemViewType(int position) {
        return mSeparatorsSet.contains(position) ? TYPE_SEPARATOR : TYPE_ITEM;
    }

    @Override
    public int getViewTypeCount() {
        return TYPE_MAX_COUNT;
    }

    @Override
    public int getCount() {
        return mData.size();
    }

    @Override
    public String getItem(int position) {
        return (String) mData.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;
        int type = getItemViewType(position);
        System.out.println("getView " + position + " " + convertView + " type = " + type);
        if (convertView == null) {
            holder = new ViewHolder();
            switch (type) {
                case TYPE_ITEM:
//                    convertView = mInflater.inflate(R.layout.item1, null);
//                    holder.textView = (TextView) convertView.findViewById(R.id.text);
                    break;
                case TYPE_SEPARATOR:
//                    convertView = mInflater.inflate(R.layout.item2, null);
//                    holder.textView = (TextView) convertView.findViewById(R.id.textSeparator);
                    break;
            }
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        holder.textView.setText((String) mData.get(position));
        return convertView;
    }

    public static class ViewHolder {
        public TextView textView;
    }

}