package com.example.davidcpp.dietician;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by davidcpp on 04.06.2016.
 */

public class RecycleViewAdapter extends RecyclerView.Adapter<RecycleViewAdapter.ViewHolder> {

    private String[] mDataset;


    // Provide a suitable constructor (depends on the kind of dataset)
    public RecycleViewAdapter(String[] myDataset) {
        mDataset = myDataset;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public RecycleViewAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                            int viewType) {
        // create a new view
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.row_activities, parent, false);
        // set the view's size, margins, paddings and layout parameters
//        ...
//        TextView textView= (TextView) v.findViewById(R.id.txtTitle);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
//        holder.txtTitleView.setText(mDataset[position]);  // Why does it work? (txtTitleView is private field)4
        holder.getTextView().setText(mDataset[position]);
        holder.getTextView().setText(mDataset[position]);

    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return mDataset.length;
    }

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public static class ViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        private final TextView txtTitleView;
        private final TextView txtKcalView;

        public ViewHolder(View v) {
            super(v);
            txtTitleView = (TextView) v.findViewById(R.id.txtTitle);
            txtKcalView = (TextView) v.findViewById(R.id.txtKcal);
        }

        public TextView getTextView() {
            return txtTitleView;
        }

    }
}