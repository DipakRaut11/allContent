package com.example.roomlibrarydb;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;


@Database(entities = Expense.class, exportSchema = false , version = 1)
public abstract class dbHelper extends RoomDatabase {

    private static final String DB_NAME = "expenseDB";
    private static dbHelper instance;

    public static synchronized dbHelper getDB(Context context){

        if (instance == null){
            instance = Room.databaseBuilder(context, dbHelper.class, DB_NAME)
                    .fallbackToDestructiveMigration()
                    .allowMainThreadQueries()
                    .build();
        }
        return instance;
    }

    public abstract DataAccessObject expenseDao();



}
