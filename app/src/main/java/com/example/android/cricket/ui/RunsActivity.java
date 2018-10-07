package com.example.android.cricket.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.android.cricket.R;

import static com.example.android.cricket.ui.MainActivity.mRuns;
import static com.example.android.cricket.ui.MainActivity.runs;

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
        TextView quantityTextView = findViewById(R.id.runs_tv);
        quantityTextView.setText(String.valueOf(number));
    }

}

