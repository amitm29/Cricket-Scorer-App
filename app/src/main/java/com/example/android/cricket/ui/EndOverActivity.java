package com.example.android.cricket.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.android.cricket.R;

import static com.example.android.cricket.ui.MainActivity.oType;
import static com.example.android.cricket.ui.MainActivity.pace;
import static com.example.android.cricket.ui.MainActivity.spin;

public class EndOverActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_end_over);
        displayp(pace);
        displays(spin);
    }

    public void sdecreament(View v)
    {
        if(spin == 0)
            return;
        spin = spin - 1;
        displays(spin);
    }

    public void sincreament(View v)
    {
        oType="Spin";
        spin = spin + 1;
        displays(spin);
    }

    public void pincreament(View v)
    {
        oType="Pace";
        pace = pace + 1;
        displayp(pace);
    }

    public void pdecreament(View v)
    {
        if(pace == 0)
            return;
        pace = pace - 1;
        displayp(pace);
    }

    private void displays(int s)
    {
        TextView textView = findViewById(R.id.spin_tv);
        textView.setText(String.valueOf(s));
    }

    private void displayp(int p)
    {
        TextView textView = findViewById(R.id.pace_tv);
        textView.setText(String.valueOf(p));
    }
}
