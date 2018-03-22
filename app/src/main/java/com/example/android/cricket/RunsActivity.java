package com.example.android.cricket;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import static com.example.android.cricket.MainActivity.mRuns;
import static com.example.android.cricket.MainActivity.runs;

public class RunsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_runs);
        display(runs);
    }

    public void rincreament(View view) {
        runs = runs + 1;
        mRuns++;
        display(runs);
    }
    public void rdecreament(View view) {
        runs = runs - 1;
        mRuns--;
        if(runs==-1)
            runs=0;
        display(runs);
    }
    private void display(int number) {
        TextView quantityTextView = (TextView) findViewById(R.id.runs_tv);
        quantityTextView.setText("" + number);
    }

}

