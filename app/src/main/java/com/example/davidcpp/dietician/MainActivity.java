package com.example.davidcpp.dietician;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    String[] mainMenuTextArray;
    MainRow mainMenuRowArray[];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(com.example.davidcpp.dietician.R.layout.activity_main);
        ListView listView = (ListView) findViewById(com.example.davidcpp.dietician.R.id.listView1);

//        Resources resources;
        Resources resources = getResources();
        mainMenuTextArray = resources.getStringArray(com.example.davidcpp.dietician.R.array.main_menu);
        mainMenuRowArray = new MainRow[mainMenuTextArray.length];

        for (int i = 0; i < mainMenuTextArray.length; i++) {
            mainMenuRowArray[i] = new MainRow(mainMenuTextArray[i]);
        }

        RowAdapter adapter = new RowAdapter(this, com.example.davidcpp.dietician.R.layout.main_row, mainMenuRowArray);
        listView.setAdapter(adapter);
    }

    public void chooseMainMenuOption(View view) {
        MainRow clickedRow = (MainRow) view.getTag();
        Intent intent = null;
        switch (clickedRow.title) {
            case "Mój Plan":
                intent = new Intent(this, DietPlanActivity.class);
                break;
            case "Produkty":
                intent = new Intent(this, ProductsActivity.class);
                break;
            case "Jadłospis":
                intent = new Intent(this, MealPlanActivity.class);
                break;
            case "Moje dania":
                intent = new Intent(this, DishesActivity.class);
                break;
            case "Aktywności":
                intent = new Intent(this, ActivitiesActivity.class);
                break;
        }
        startActivity(intent);

    }
}
