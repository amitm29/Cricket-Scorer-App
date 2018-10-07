package com.example.android.cricket.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.android.cricket.R;
import com.example.android.cricket.database.myDbHandler;
import com.example.android.cricket.model.Innings;

import static com.example.android.cricket.ui.MainActivity.balls;
import static com.example.android.cricket.ui.MainActivity.fours;
import static com.example.android.cricket.ui.MainActivity.pBalls;
import static com.example.android.cricket.ui.MainActivity.runs;
import static com.example.android.cricket.ui.MainActivity.sixes;
import static com.example.android.cricket.ui.MainActivity.tsixes;
import static com.example.android.cricket.ui.MainActivity.wickets;

public class UserActivity extends AppCompatActivity {

    myDbHandler dbHandler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);
        dbHandler = new myDbHandler(this);
    }

    public void done(View v)
    {
        EditText tSix = (EditText) findViewById(R.id.tsixes_tv);
        String value = tSix.getText().toString();
        if(!value.matches("")) {
            tsixes = Integer.parseInt(value);
            Toast toast = Toast.makeText(this, "Tap Save T Sixes to SAVE changes!", Toast.LENGTH_SHORT);
            toast.setGravity(Gravity.CENTER, 0, -100);
            toast.show();
        }

        EditText pO = (EditText) findViewById(R.id.pOvers_tv);
        String val1 = pO.getText().toString();
        if(!val1.matches("")) {
            pBalls = Integer.parseInt(val1) * 6;
            Toast toast = Toast.makeText(this, "Overs in an innings UPDATED!", Toast.LENGTH_SHORT);
            toast.setGravity(Gravity.CENTER, 0, -100);
            toast.show();
        }
        Intent i = new Intent(UserActivity.this, MainActivity.class);
        startActivity(i);

    }
    public  void saveDb(View view)
    {
        Innings innings = new Innings(runs, wickets, balls, fours, sixes);
        dbHandler.addInnings(innings);
//        dbHandler.addInnings();
        Toast toast = Toast.makeText(this, "Database UPDATED!!", Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.CENTER, 0, -100);
        toast.show();
    }

    public void showDb(View view)
    {
        String c = dbHandler.databaseShow();
        TextView tv = (TextView) findViewById(R.id.db_tv);
        tv.setText(c);


    }

    public void delDb(View view)
    {
        EditText dId = (EditText) findViewById(R.id.delId_tv);
        String delId = dId.getText().toString();
        if(!delId.matches("")) {
            int id = Integer.parseInt(delId);
            dbHandler.deleteInnings(id);
            Toast toast = Toast.makeText(this, "DELETED!", Toast.LENGTH_SHORT);
            toast.setGravity(Gravity.CENTER, 0, -100);
            toast.show();
        }
        else {
            Toast toast = Toast.makeText(this, "Specify the ID!", Toast.LENGTH_SHORT);
            toast.setGravity(Gravity.CENTER, 0, -100);
            toast.show();
        }

    }


}
