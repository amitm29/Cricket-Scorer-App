package com.example.android.cricket.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.android.cricket.model.Innings;


/**
 * Created by AM on 16-11-2017.
 */

public class myDbHandler extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION=1;
    private static final String DATABASE_NAME="crk.db";
    private static final String TABLE_INNINGS="innings";
    private static final String COLUMN_ID="_id";
    private static final String COLUMN_RUNS="rRums";
    private static final String COLUMN_WICKETS="rWickets";
    private static final String COLUMN_BALLS="rBalls";
    private static final String COLUMN_FOURS="rFours";
    private static final String COLUMN_SIXES="rSixes";

    public myDbHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query="CREATE TABLE " + TABLE_INNINGS + " (" + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + COLUMN_RUNS
                + " INTEGER, " + COLUMN_WICKETS + " INTEGER, " + COLUMN_BALLS + " INTEGER, "
                + COLUMN_FOURS + " INTEGER, " + COLUMN_SIXES + " INTEGER);";
        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_INNINGS);
        onCreate(db);
    }

    public void addInnings()
    {
        SQLiteDatabase db= this.getWritableDatabase();
        ContentValues val = new ContentValues();
        val.put(COLUMN_RUNS, 10);
        val.put(COLUMN_WICKETS, 2);
        val.put(COLUMN_BALLS, 1);
        val.put(COLUMN_FOURS,1);
        val.put(COLUMN_SIXES, 1);
        db.insert(TABLE_INNINGS, null, val);
    }
    public void addInnings(Innings innings)
    {
        SQLiteDatabase db= this.getWritableDatabase();
        ContentValues values = new ContentValues();
        int iRuns = innings.getRuns();
        int iWickets = innings.getWickets();
        float iBalls = innings.getBalls();
        int iFours = innings.getFours();
        int iSixes = innings.getSixes();
        values.put(COLUMN_RUNS, iRuns);
        values.put(COLUMN_WICKETS, iWickets);
        values.put(COLUMN_BALLS, iBalls);
        values.put(COLUMN_FOURS, iFours);
        values.put(COLUMN_SIXES, iSixes);
        db.insert(TABLE_INNINGS,null, values);
        db.close();

    }
    public void deleteInnings(int id)
    {
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL("DELETE FROM " + TABLE_INNINGS + " WHERE " + COLUMN_ID + " = " + id + ";");
    }

    public String databaseShow() {
        SQLiteDatabase db = getWritableDatabase();
        String query = "SELECT * FROM " + TABLE_INNINGS + ";";
        Cursor c = db.rawQuery(query, null);
        int count = c.getCount();
        String str = "";
        str = "\nThere are total " + count + " Records...\n\n\n";
        c.moveToFirst();
        int id, runs, wickets, balls, fours, sixes, ba, bb;
        str += "ID  RUNS  WICKETS  OVERS  FOURS  SIXES\n\n";
        int i=1;
        while (!c.isAfterLast()) {
            id = c.getInt(c.getColumnIndex(COLUMN_ID));
            runs = c.getInt(c.getColumnIndex(COLUMN_RUNS));
            wickets = c.getInt(c.getColumnIndex(COLUMN_WICKETS));
            balls = c.getInt(c.getColumnIndex(COLUMN_BALLS));
            fours = c.getInt(c.getColumnIndex(COLUMN_FOURS));
            sixes = c.getInt(c.getColumnIndex(COLUMN_SIXES));
            ba = balls / 6;
            bb = balls % 6;
            str = str + id + "      " + runs + "           " + wickets + "             " + ba + "." + bb + "          " + fours + " " + "         " + sixes;
            str+="\n";
            if(i%2==0)
                str+="\n";
            c.moveToNext();
            i++;
        }
            db.close();
            return (str);


    }
//    public String databaseShow()
//    {
//        String dbString="";
//        SQLiteDatabase db = getWritableDatabase();
//        String query = "SELECT * FROM " + TABLE_INNINGS + " WHERE 1;";
//
//        Cursor c =db.rawQuery(query,null);
//        c.moveToFirst();
//        while (!c.isAfterLast())
//        {
//            if(c.getString(c.getColumnIndex("rRuns"))!=null)
//            {
//
//                dbString+= c.getString(c.getColumnIndex("_id"));
//                dbString+="   ";
//                dbString+= c.getString(c.getColumnIndex("rRuns"));
//                dbString+="   ";
//                dbString+= c.getString(c.getColumnIndex("rWickets"));
//                dbString+="   ";
//                dbString+= c.getString(c.getColumnIndex("rOvers"));
//                dbString+="   ";
//                dbString+= c.getString(c.getColumnIndex("rFours"));
//                dbString+="   ";
//                dbString+= c.getString(c.getColumnIndex("rSixes"));
//                dbString+="\n";
//            }
//            c.moveToNext();
//        }
//        db.close();
//        return dbString;

//    }
}

