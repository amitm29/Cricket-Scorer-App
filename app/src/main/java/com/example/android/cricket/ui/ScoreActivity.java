package com.example.android.cricket.ui;

import static com.example.android.cricket.ui.MainActivity.oWiseScore;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.android.cricket.R;

public class ScoreActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);

        ArrayAdapter<String> scoreAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,oWiseScore);
        ListView listView = findViewById(R.id.list);
        listView.setAdapter(scoreAdapter);

    }
}
