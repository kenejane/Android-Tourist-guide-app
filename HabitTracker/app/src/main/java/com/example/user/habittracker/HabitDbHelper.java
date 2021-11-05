package com.example.user.habittracker;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by USER on 3/29/2018.
 */

public class HabitDbHelper extends SQLiteOpenHelper {
    public static final String LOG_TAG = HabitDbHelper.class.getSimpleName();

    /**
     * Name of the database file
     */
    private static final String DATABASE_NAME = "habittracker.db";

    private static final int DATABASE_VERSION = 1;

    public HabitDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // Create a String that contains the SQL statement to create the pets table
        String SQL_CREATE_HABITS_TABLE = "CREATE TABLE " + HabitContract.HabitEntry.TABLE_NAME + " ("
                + HabitContract.HabitEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + HabitContract.HabitEntry.COLUMN_HABITS + " INTEGER NOT NULL, "
                + HabitContract.HabitEntry.COLUMN_NUMBER_OF_TIMES_PER_WEEK + " INTEGER, "
                + HabitContract.HabitEntry.COLUMN_TIME_TAKEN + " INTEGER NOT NULL, "
                + HabitContract.HabitEntry.COLUMN_COMMENT + "STRING";

        // Execute the SQL statement
        db.execSQL(SQL_CREATE_HABITS_TABLE);
    }

    /**
     * This is called when the database needs to be upgraded.
     */
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // The database is still at version 1, so there's nothing to do be done here.
    }

    public void insertHabit(int habit, int number_of_times, int time, String comment) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(HabitContract.HabitEntry.COLUMN_HABITS, habit);
        values.put(HabitContract.HabitEntry.COLUMN_NUMBER_OF_TIMES_PER_WEEK, number_of_times);
        values.put(HabitContract.HabitEntry.COLUMN_TIME_TAKEN, time);
        values.put(HabitContract.HabitEntry.COLUMN_COMMENT, comment);

        db.insert(HabitContract.HabitEntry.TABLE_NAME, null, values);
    }

    public Cursor readHabit() {
        SQLiteDatabase db = getReadableDatabase();
        String[] projection = {
                HabitContract.HabitEntry._ID,
                HabitContract.HabitEntry.COLUMN_HABITS,
                HabitContract.HabitEntry.COLUMN_NUMBER_OF_TIMES_PER_WEEK,
                HabitContract.HabitEntry.COLUMN_TIME_TAKEN,
                HabitContract.HabitEntry.COLUMN_COMMENT
        };
        Cursor cursor = db.query(
                HabitContract.HabitEntry.TABLE_NAME,
                projection,
                null,
                null,
                null,
                null,
                null);
        return cursor;
    }
}
