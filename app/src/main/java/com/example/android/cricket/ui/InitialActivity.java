package com.example.android.cricket.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.android.cricket.R;

import static com.example.android.cricket.ui.MainActivity.oType;
import static com.example.android.cricket.ui.MainActivity.pace;
import static com.example.android.cricket.ui.MainActivity.projected;
import static com.example.android.cricket.ui.MainActivity.spin;

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
        TextView textView = findViewById(R.id.textView5);
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
