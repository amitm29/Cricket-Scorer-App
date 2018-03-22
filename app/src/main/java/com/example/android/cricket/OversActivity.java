package com.example.android.cricket;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import static com.example.android.cricket.MainActivity.ba;
import static com.example.android.cricket.MainActivity.balls;
import static com.example.android.cricket.MainActivity.bb;
import static com.example.android.cricket.MainActivity.mBalls;
import static com.example.android.cricket.MainActivity.overs;

public class OversActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_overs);
        displayo(overs);
    }

    public void bincreament(View view) {
        balls = balls + 1;
        mBalls++;
        ba=balls/6;
        bb=balls%6;
        overs = ba + bb / 10;
        displayo(overs);
    }
    public void bdecreament(View view) {
        balls = balls - 1;
        mBalls--;
        if(balls==-1)
            balls=0;
        over();
        displayo(overs);
    }
    private void displayo(float number) {
        TextView quantityTextView = (TextView) findViewById(R.id.overs_tv);
        quantityTextView.setText("" + number);
    }
    public void over()
    {
        ba=balls/6;
        bb=balls%6;
        overs = ba + bb / 10;
    }
}
