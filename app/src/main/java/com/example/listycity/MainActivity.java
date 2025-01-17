package com.example.listycity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class MainActivity extends AppCompatActivity {

    ListView cityList;
    ArrayAdapter<String> cityAdapter;
    ArrayList<String> dataList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //calling onCreate() of superclass
        //set layout to be the main
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cityList = findViewById(R.id.city_list);
        Button addButton = findViewById(R.id.add_city_button);
        Button delButton = findViewById(R.id.delete_city_button);
        EditText addCity = findViewById(R.id.add_city_input);


        String[] cities = {"Edmonton", "Vancouver"};

        dataList = new ArrayList<>();
        dataList.addAll(Arrays.asList(cities));

        //link content.xml to dataList
        cityAdapter = new ArrayAdapter<>(this, R.layout.content, dataList);
        //connect ListView to ArrayAdapter
        cityList.setAdapter(cityAdapter);


        cityList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                delButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dataList.remove(position);
                        updateList();
                    }
                });
            }
        });



        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getCity(v);
            }
        });


    }


    public void getCity(View v){
        TextView inputCity = findViewById(R.id.add_city_input);
        String cityName = inputCity.getText().toString();
        addCity(cityName);
    }

    public void addCity(String cityName){
        dataList.add(cityName);
        updateList();

    }

    public void updateList(){
        cityAdapter = new ArrayAdapter<>(this, R.layout.content, dataList);
        cityList.setAdapter(cityAdapter);
    }

}