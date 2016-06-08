package com.example.davidcpp.dietician;

import android.content.Intent;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;

import android.widget.ExpandableListView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;


public class ActivitiesActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    String[] activitiesNames;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(com.example.davidcpp.dietician.R.layout.activity_activities);

        mRecyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);

        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        mRecyclerView.setHasFixedSize(true);

        // use a linear layout manager
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);

        Resources resources = getResources();
        activitiesNames = resources.getStringArray(R.array.activity_names);


        // specify an adapter (see also next example)
        mAdapter = new RecycleViewAdapter(activitiesNames);
        mRecyclerView.setAdapter(mAdapter);

    }

    private void prepareListData() {


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
 //       getMenuInflater().inflate(com.example.davidcpp.dietician.R.menu.products_menu, menu);
        return super.onCreateOptionsMenu(menu);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent intent = null;
//        switch (item.getItemId()) {
//            case com.example.davidcpp.dietician.R.id.add_product_option:
//                intent = new Intent(this, AddProductActivity.class);
//                startActivity(intent);
//                break;
//            case com.example.davidcpp.dietician.R.id.remove_product_option:
//                break;
//            case com.example.davidcpp.dietician.R.id.view_categories_names_option:
//                break;
//            case com.example.davidcpp.dietician.R.id.view_products_names_option:
//                break;
//            case com.example.davidcpp.dietician.R.id.sort_alphabet_option:
//                break;
//            case com.example.davidcpp.dietician.R.id.sort_energy_value_option:
//                break;
//        }

        return super.onOptionsItemSelected(item);
    }

}
