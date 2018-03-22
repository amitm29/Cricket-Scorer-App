package com.example.android.cricket;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import static com.example.android.cricket.MainActivity.balls;
import static com.example.android.cricket.MainActivity.flag;
import static com.example.android.cricket.MainActivity.oType;
import static com.example.android.cricket.MainActivity.pace;
import static com.example.android.cricket.MainActivity.projected;
import static com.example.android.cricket.MainActivity.runs;
import static com.example.android.cricket.MainActivity.spin;

public class InitialActivity extends AppCompatActivity {
    static boolean temp = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_initial);
        if(temp)
        {
            displayPro();
        }
        temp = true;
    }


    private  void displayPro()
    {
        String scr;
        TextView textView = (TextView) findViewById(R.id.textView5);
        scr = "Projected Score : " + projected;
        textView.setText(scr);
    }

    public void sincreament(View v)
    {
        oType="Spin";
        spin+=1;
        Intent i = new Intent(InitialActivity.this, MainActivity.class);
        startActivity(i);
    }

    public void pincreament(View v)
    {
        oType="Pace";
        pace+=1;
        Intent i = new Intent(InitialActivity.this, MainActivity.class);
        startActivity(i);
    }

}
