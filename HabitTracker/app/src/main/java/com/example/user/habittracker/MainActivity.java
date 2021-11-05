package com.example.user.habittracker;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        HabitDbHelper habitDbHelper = new HabitDbHelper(this);

        habitDbHelper.insertHabit(HabitContract.HabitEntry.HABIT_PROGRAMMING, 3, 4, "Android");
        habitDbHelper.insertHabit(HabitContract.HabitEntry.HABIT_HANGING_OUT, 3, 5, "With friends");
        habitDbHelper.insertHabit(HabitContract.HabitEntry.HABIT_TEACHING, 5, 10, "Senior Secondary");
            }
}
