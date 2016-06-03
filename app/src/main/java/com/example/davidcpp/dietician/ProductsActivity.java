package com.example.davidcpp.dietician;

import android.content.Intent;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ExpandableListView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class ProductsActivity extends AppCompatActivity {


    ExpandableListAdapter listAdapter;
    ExpandableListView expListView;
    List<String> listDataHeader;
    HashMap<String, List<String>> listDataChild;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(com.example.davidcpp.dietician.R.layout.activity_products);

        // get the listview
        expListView = (ExpandableListView) findViewById(com.example.davidcpp.dietician.R.id.products_list);

        // preparing list data
        prepareListData();

        listAdapter = new ExpandableListAdapter(this, listDataHeader, listDataChild);

        // setting list adapter
        expListView.setAdapter(listAdapter);
    }

    /*
     * Preparing the list data
     */
    private void prepareListData() {
        listDataHeader = new ArrayList<String>();
        listDataChild = new HashMap<String, List<String>>();

        Resources resources = getResources();
        // Getting Product Category Names
        listDataHeader = Arrays.asList(resources.getStringArray(com.example.davidcpp.dietician.R.array.products_categories_names));

        // Getting Product Name Arrays
        TypedArray arrayDataChild = resources.obtainTypedArray(com.example.davidcpp.dietician.R.array.all_products);
        int n = arrayDataChild.length();
        for (int i = 0; i < listDataHeader.size(); i++) {
            int id = arrayDataChild.getResourceId(i, 0);
            List<String> currentProducts = new ArrayList<String>();

            if (id > 0) {
                currentProducts = Arrays.asList(resources.getStringArray(id));
                listDataChild.put(listDataHeader.get(i), currentProducts);
            } else {
                listDataChild.put(listDataHeader.get(i), currentProducts);
            }

        }


        // Adding child data
//        listDataHeader.add("Top 250");
//        listDataHeader.add("Now Showing");
//        listDataHeader.add("Coming Soon..");

//        // Adding child data
//        List<String> top250 = new ArrayList<String>();
//        top250.add("The Shawshank Redemption");
//        top250.add("The Godfather");
//        top250.add("The Godfather: Part II");
//        top250.add("Pulp Fiction");
//        top250.add("The Good, the Bad and the Ugly");
//        top250.add("The Dark Knight");
//        top250.add("12 Angry Men");
//
//        List<String> nowShowing = new ArrayList<String>();
//        nowShowing.add("The Conjuring");
//        nowShowing.add("Despicable Me 2");
//        nowShowing.add("Turbo");
//        nowShowing.add("Grown Ups 2");
//        nowShowing.add("Red 2");
//        nowShowing.add("The Wolverine");
//
//        List<String> comingSoon = new ArrayList<String>();
//        comingSoon.add("2 Guns");
//        comingSoon.add("The Smurfs 2");
//        comingSoon.add("The Spectacular Now");
//        comingSoon.add("The Canyons");
//        comingSoon.add("Europa Report");
//
//        listDataChild.put(listDataHeader.get(0), top250); // Header, Child data
//        listDataChild.put(listDataHeader.get(1), nowShowing);
//        listDataChild.put(listDataHeader.get(2), comingSoon);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(com.example.davidcpp.dietician.R.menu.products_menu, menu);
        return super.onCreateOptionsMenu(menu);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent intent = null;
        switch (item.getItemId()) {
            case com.example.davidcpp.dietician.R.id.add_product_option:
                intent = new Intent(this, AddProductActivity.class);
                startActivity(intent);
                break;
            case com.example.davidcpp.dietician.R.id.remove_product_option:
                break;
            case com.example.davidcpp.dietician.R.id.view_categories_names_option:
                break;
            case com.example.davidcpp.dietician.R.id.view_products_names_option:
                break;
            case com.example.davidcpp.dietician.R.id.sort_alphabet_option:
                break;
            case com.example.davidcpp.dietician.R.id.sort_energy_value_option:
                break;
        }

        return super.onOptionsItemSelected(item);
    }
}
