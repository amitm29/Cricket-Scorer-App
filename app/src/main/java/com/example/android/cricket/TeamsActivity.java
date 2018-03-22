package com.example.android.cricket;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import static com.example.android.cricket.MainActivity.sbat;
import static com.example.android.cricket.MainActivity.sbowl;

public class TeamsActivity extends AppCompatActivity {

    private  RadioGroup bat, bowl;
    private RadioButton ANbat, ARbat, ANbowl, ARbowl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teams);

        bat = (RadioGroup) findViewById(R.id.batting);
        bowl = (RadioGroup) findViewById(R.id.bowling);
        ANbat = (RadioButton) findViewById(R.id.team2);
        ARbat = (RadioButton) findViewById(R.id.team3);
        ANbowl = (RadioButton) findViewById(R.id.team2b);
        ARbowl = (RadioButton) findViewById(R.id.team3b);
    }





    public void teamSelect(View v)
    {

        int selectedId1 = bat.getCheckedRadioButtonId();
        // find which radioButton is checked by id

        if(selectedId1 == ANbat.getId()) {

            sbat=2;

        } else if(selectedId1 == ARbat.getId()) {
            sbat=3;

        } else {
            sbat=1;

        }

        int selectedId2 = bowl.getCheckedRadioButtonId();
        // find which radioButton is checked by id

        if(selectedId2 == ANbowl.getId()) {

            sbowl=2;

        } else if(selectedId2 == ARbowl.getId()) {
            sbowl=3;

        } else {
            sbowl=1;

        }

        Intent i = new Intent(TeamsActivity.this, InitialActivity.class);
        startActivity(i);
    }
}
