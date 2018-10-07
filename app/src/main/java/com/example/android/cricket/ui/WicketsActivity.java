package com.example.android.cricket.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.android.cricket.R;

import static com.example.android.cricket.ui.MainActivity.mBalls;
import static com.example.android.cricket.ui.MainActivity.mRuns;
import static com.example.android.cricket.ui.MainActivity.tempBalls;
import static com.example.android.cricket.ui.MainActivity.tempRuns;
import static com.example.android.cricket.ui.MainActivity.wickets;

public class WicketsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wickets);
        displayw(wickets);

    }
    public void wincreament(View view) {
        wickets = wickets + 1;
        displayw(wickets);
    }
    public void wdecreament(View view) {
        mRuns = tempRuns;
        mBalls = tempBalls;
        wickets = wickets - 1;
        if(wickets==-1)
            wickets=0;
        displayw(wickets);
    }
    private void displayw(int number) {
        TextView quantityTextView = findViewById(R.id.wickets_tv);
        quantityTextView.setText(String.valueOf(number));
    }
}
