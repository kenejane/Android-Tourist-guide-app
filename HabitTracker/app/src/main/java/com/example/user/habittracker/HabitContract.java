package com.example.user.habittracker;

import android.provider.BaseColumns;

/**
 * Created by USER on 3/29/2018.
 */

public class HabitContract {

    private HabitContract() {
    }

    public static final class HabitEntry implements BaseColumns {

        public final static String TABLE_NAME = "habits";
        public final static String _ID = BaseColumns._ID;
        public final static String COLUMN_HABITS = "habit";
        public final static String COLUMN_NUMBER_OF_TIMES_PER_WEEK = "number_of_times";
        public final static String COLUMN_TIME_TAKEN = "time";
        public final static String COLUMN_COMMENT = "comment";


        public static final int HABIT_PROGRAMMING = 0;
        public static final int HABIT_TEACHING = 1;
        public static final int HABIT_HANGING_OUT = 2;
    }

}
