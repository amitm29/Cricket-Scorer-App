package com.example.android.cricket;

import static com.example.android.cricket.MainActivity.oWiseScore;
import static com.example.android.cricket.MainActivity.overScore;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class ScoreActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);

        ArrayAdapter<String> scoreAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,oWiseScore);
        ListView listView = (ListView) findViewById(R.id.list);
        listView.setAdapter(scoreAdapter);

    }
}
