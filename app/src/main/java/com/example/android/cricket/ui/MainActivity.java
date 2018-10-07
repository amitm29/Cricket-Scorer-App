package com.example.android.cricket.ui;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

/**
 * Add your package below. Package name can be found in the project's AndroidManifest.xml file.
 * This is the package name our example uses:
 *
 * package com.example.android.justjava;
 */

import android.view.Gravity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.android.cricket.R;

import java.util.ArrayList;
import java.util.Random;


public class MainActivity extends AppCompatActivity {

    MediaPlayer player;

//    @Override
//    protected void onStop() {
//        super.onStop();
//        String key = "TSIXES";
//        int value = tsixes;
//        SharedPreferences sp = getSharedPreferences("TSIXES", Activity.MODE_PRIVATE);
////        sp = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
//        SharedPreferences.Editor editor = sp.edit();
//        editor.putInt(key, value);
//        editor.commit();
//    }

    static ArrayList<String> oWiseScore = new ArrayList<String>();

    static int sbat =0, sbowl =0;
    static int runs = 0;
    static int tsixes = 0;
    static int mRuns = 0;
    static int tempRuns = 0;
    static int tempBalls = 0;
    static int mBalls = 0;
    static int extras = 0;
    static int wickets = 0;
    static int balls=0;
    static int fours=0;
    static int sixes=0;
    static int pBalls=120;
    static int spin = 0, pace = 0;
    static float ba = 0, bb = 0;
    static float overs;
    static boolean flag = true, flag1 = true;
    static String overScore = "";
    static int mOvers = 0;
    static String oType = "";
    static int oRuns = 0;
    static int projected = 0;


    @Override
    protected void onResume() {
        super.onResume();
        displayp(pace);
        display(runs);
        displays(spin);
        displayo(overs);
        displayw(wickets);
        displayRB(mRuns,mBalls);
        displayE(extras);
        displayTS();
        calcPro();
        displayPro();
        displayPO();
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if(flag1) {
            SharedPreferences sp = getSharedPreferences("TSIXES", Activity.MODE_PRIVATE);
            tsixes = sp.getInt("TSIXES", 0);
            flag1 = false;
        }
        player = MediaPlayer.create(MainActivity.this,R.raw.gogo);
        if(flag) {
            Intent i = new Intent(MainActivity.this, TeamsActivity.class);
            startActivity(i);
            flag = false;
        }
        TextView run1 = (TextView) findViewById(R.id.runs_tv);
        run1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, RunsActivity.class);
                startActivity(i);
            }

        });

        TextView wicket1 = (TextView) findViewById(R.id.wickets_tv);
        wicket1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, WicketsActivity.class);
                startActivity(i);
            }

        });

        TextView over1 = (TextView) findViewById(R.id.overs_tv);
        over1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, OversActivity.class);
                startActivity(i);
            }

        });


        TextView run2 = (TextView) findViewById(R.id.runs2_tv);
        run2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, RunsActivity.class);
                startActivity(i);
            }

        });

        TextView wicket2 = (TextView) findViewById(R.id.wickets2_tv);
        wicket2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, WicketsActivity.class);
                startActivity(i);
            }

        });

        TextView over2 = (TextView) findViewById(R.id.overs2_tv);
        over2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, OversActivity.class);
                startActivity(i);
            }

        });

        TextView spinTV = (TextView) findViewById(R.id.spin_tv);
        spinTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, EndOverActivity.class);
                startActivity(i);
            }

        });

        TextView paceTV = (TextView) findViewById(R.id.pace_tv);
        paceTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, EndOverActivity.class);
                startActivity(i);
            }

        });


        TextView oDetails = (TextView) findViewById(R.id.odetails);
        oDetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, ScoreActivity.class);
                startActivity(i);
            }

        });

        TextView extras = (TextView) findViewById(R.id.extra_TV);
        extras.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                player.reset();
                player = MediaPlayer.create(MainActivity.this,R.raw.gogo);
            }

        });

        TextView SA = (TextView) findViewById(R.id.save);
        SA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String key = "TSIXES";
                int value = tsixes;
                SharedPreferences sp = getSharedPreferences("TSIXES", Activity.MODE_PRIVATE);
//        sp = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
                SharedPreferences.Editor editor = sp.edit();
                editor.putInt(key, value);
                editor.commit();
                Toast toast = Toast.makeText(MainActivity.this,"Changes Saved!", Toast.LENGTH_SHORT);
                toast.setGravity(Gravity.CENTER,0,-100);
                toast.show();
            }

        });

        TextView ED = (TextView) findViewById(R.id.edit);
        ED.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, UserActivity.class);
                startActivity(i);

            }

        });

        TextView pp = (TextView) findViewById(R.id.score_tv);
        pp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                player.reset();
                Random rand = new Random();
                int n = rand.nextInt(5);
                switch (n)
                {
                    case 0 : player = MediaPlayer.create(MainActivity.this,R.raw.rcb);
                        break;
                    case 1 : player = MediaPlayer.create(MainActivity.this,R.raw.shape);
                        break;
                    case 2 : player = MediaPlayer.create(MainActivity.this,R.raw.gogo);
                        break;
                    case 3 : player = MediaPlayer.create(MainActivity.this,R.raw.rock);
                        break;
                    case 4 : player = MediaPlayer.create(MainActivity.this,R.raw.rps);
                        break;

                }

                player.start();
            }

        });
    }

    public void endOver()
    {
        mOvers++;
        String oScore = "Over " + mOvers + " (" + oType + ") : " + overScore  + "        =" + oRuns;
        oWiseScore.add(oScore);
        oRuns = 0;
        player.reset();
        Intent i = new Intent(MainActivity.this, InitialActivity.class);
        startActivity(i);
    }

    public void over()
    {
        ba=balls/6;
        bb=balls%6;
        overs = ba + bb / 10;
    }

    public void dot(View view) {
        balls=balls+1;
        over();
        displayo(overs);
//        Toast toast = Toast.makeText(this,"DOT BALL!",Toast.LENGTH_SHORT);
//        toast.setGravity(Gravity.CENTER,0,-100);
//        toast.show();
        mBalls+= 1;
        displayRB(mRuns,mBalls);
        overScore = overScore + " . ";
        displayScore(overScore);
        projected = calcPro();
        displayPro();
        if(balls%6 == 0) {
            endOver();
            overScore="";
            displayScore(overScore);
        }

    }

    public void one(View view) {
        runs=runs+1;
        balls=balls+1;
        over();
        displayo(overs);
        display(runs);
//        Toast toast = Toast.makeText(this,"1 RUN",Toast.LENGTH_SHORT);
//        toast.setGravity(Gravity.CENTER,0,-100);
//        toast.show();
        mBalls+= 1;
        mRuns+= 1;
        oRuns+=1;
        displayRB(mRuns,mBalls);
        overScore = overScore + " 1 ";
        displayScore(overScore);
        projected = calcPro();
        displayPro();
        if(balls%6 == 0) {
            endOver();
            overScore="";
            displayScore(overScore);
        }

    }

    public void two(View view) {
        runs=runs+2;
        balls=balls+1;
        over();
        displayo(overs);
        display(runs);
        mBalls+= 1;
        mRuns+= 2;
        oRuns+=2;
        displayRB(mRuns,mBalls);
//        Toast toast = Toast.makeText(this,"2 RUNS",Toast.LENGTH_SHORT);
//        toast.setGravity(Gravity.CENTER,0,-100);
//        toast.show();
        overScore = overScore + " 2 ";
        displayScore(overScore);
        projected = calcPro();
        displayPro();
        if(balls%6 == 0) {
            endOver();
            overScore="";
            displayScore(overScore);
        }

    }

    public void four(View view) {
        player.reset();
        if(sbat==3)
        {
            player = MediaPlayer.create(MainActivity.this,R.raw.rcb);
        }
        else if(sbat==2)
        {
            player = MediaPlayer.create(MainActivity.this,R.raw.rps);

        }
        else
        {
            player = MediaPlayer.create(MainActivity.this,R.raw.gogo);
        }
        runs=runs+4;
        balls=balls+1;
        fours++;
        over();
        displayo(overs);
        display(runs);
        mBalls+= 1;
        mRuns+= 4;
        oRuns+=4;
        displayRB(mRuns,mBalls);
//        Toast toast = Toast.makeText(this,"BOUNDARY!",Toast.LENGTH_SHORT);
//        toast.setGravity(Gravity.CENTER,0,-100);
//        toast.show();
        overScore = overScore + " 4 ";
        displayScore(overScore);
        projected = calcPro();
        displayPro();
        if(balls%6 == 0) {
            endOver();
            overScore="";
            displayScore(overScore);
        }
        player.start();

    }

    public void six(View view) {
        player.reset();
        if(sbat==3)
        {
            player = MediaPlayer.create(MainActivity.this,R.raw.rcb);
        }
        else if(sbat==2)
        {
            player = MediaPlayer.create(MainActivity.this,R.raw.rps);

        }
        else
        {
            player = MediaPlayer.create(MainActivity.this,R.raw.gogo);
        }
        runs=runs+6;
        balls=balls+1;
        over();
        displayo(overs);
        display(runs);
        mBalls+= 1;
        mRuns+= 6;
        oRuns+=6;
        sixes++;
        tsixes++;
        displayRB(mRuns,mBalls);
//        Toast toast = Toast.makeText(this,"SIX!!!",Toast.LENGTH_SHORT);
//        toast.setGravity(Gravity.CENTER,0,-100);
//        toast.show();
        overScore = overScore + " 6 ";
        displayScore(overScore);
        projected = calcPro();
        displayPro();
        if(balls%6 == 0) {
            endOver();
            overScore="";
            displayScore(overScore);
        }
        displayTS();
        player.start();

    }

    public void wicket(View view) {
        player.reset();

        if(sbowl==3)
        {
            player = MediaPlayer.create(MainActivity.this,R.raw.rcb);
        }
        else if(sbowl==2)
        {
            player = MediaPlayer.create(MainActivity.this,R.raw.rps);

        }
        else
        {
            player = MediaPlayer.create(MainActivity.this,R.raw.gogo);
        }
        wickets=wickets+1;
        balls=balls+1;
        over();
        displayo(overs);
        displayw(wickets);
        mBalls++;
        tempBalls = mBalls;
        tempRuns = mRuns;
        displayRB(mRuns,mBalls);
        mRuns = 0;
        mBalls = 0;
//        Toast toast = Toast.makeText(this,"WICKET!!!",Toast.LENGTH_SHORT);
//        toast.setGravity(Gravity.CENTER,0,-100);
//        toast.show();
        overScore = overScore + " W ";
        displayScore(overScore);
        projected = calcPro();
        displayPro();
        if(balls%6 == 0) {
            endOver();
            overScore="";
            displayScore(overScore);
        }

        player.start();
    }

    public void wide(View view) {
        runs=runs+1;
        mRuns++;
        display(runs);
        extras++;
        displayE(extras);
//        Toast toast = Toast.makeText(this,"WIDE!",Toast.LENGTH_SHORT);
//        toast.setGravity(Gravity.CENTER,0,-100);
//        toast.show();
        oRuns+=1;
        overScore = overScore + " Wd ";

        projected = calcPro();
        displayPro();
        displayScore(overScore);
    }

    public void noBall(View view) {
        runs=runs+1;
        mRuns++;
        display(runs);
        extras++;
        displayE(extras);
//        Toast toast = Toast.makeText(this,"NO BALL!",Toast.LENGTH_SHORT);
//        toast.setGravity(Gravity.CENTER,0,-100);
//        toast.show();
        oRuns+=1;
        overScore = overScore + " Nb ";
        displayScore(overScore);
        projected = calcPro();
        displayPro();
    }


    public int calcPro()
    {
        int pro;
        if(balls!=0)
            pro = (runs * pBalls) / balls;
        else
            pro = 0;
        return (pro);
    }

    private void display(int number) {
        TextView quantityTextView = (TextView) findViewById(R.id.runs_tv);
        quantityTextView.setText("" + number);
    }

    private void displayw(int number) {
        TextView quantityTextView = (TextView) findViewById(R.id.wickets_tv);
        quantityTextView.setText("" + number);
    }


    private void displayo(float number) {
        TextView quantityTextView = (TextView) findViewById(R.id.overs_tv);
        quantityTextView.setText("" + number);
    }


    private  void displayPro()
    {
        String scr;
        TextView textView = (TextView) findViewById(R.id.ProScore);
        scr = "Projected Score : " + projected;
        textView.setText(scr);
    }
    private  void displayPO()
    {
        String scr;
        TextView textView = (TextView) findViewById(R.id.pOvers_tv);
        scr = (pBalls/6) + " Overs";
        textView.setText(scr);
    }

    private  void displayScore(String score)
    {
        TextView textView = (TextView) findViewById(R.id.score_tv);
        score = "This Over : " + score;
        textView.setText(score);
    }



    private void displays(int s)
    {
        TextView textView = (TextView) findViewById(R.id.spin_tv);
        if (oType=="Spin")
            textView.setText("" + s + "*");
        else
            textView.setText("" + s);


    }

    private void displayp(int p)
    {
        TextView textView = (TextView) findViewById(R.id.pace_tv);
        if (oType=="Pace")
            textView.setText("" + p + "*");
        else
            textView.setText("" + p);
    }

    private void displayRB(int mruns, int mballs)
    {
        String s;
        s = mruns + " (" +mballs + ")";
        TextView tView = (TextView) findViewById(R.id.runBall);
        tView.setText(s);
    }
    private void displayE(int extra)
    {
        String s;
        s = "Extras : " + extra;
        TextView tView = (TextView) findViewById(R.id.extra_TV);
        tView.setText(s);
    }

    private void displayTS()
    {
        String s;
        s = "T Sixes : " + tsixes;
        TextView tView = (TextView) findViewById(R.id.tsix_TV);
        tView.setText(s);
    }
}


