package com.hazin.ivan.taskmanager;

import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by ivan on 19.12.17.
 */

public class PostDataBaseHelper extends SQLiteOpenHelper{
    //  Database
    private static final String _DBName = "Tasks" ;
    private static final int _Version = 1 ;

    //  Table
    private static final  String _TableName = "Tasks" ;

    //  Table colums
    private static final String _KEY_POST_ID = "id" ;
    private static final String _KEY_POST_Title = "Title" ;
    private static final String _KEY_POST_Description = "Description" ;
    private static final String _KEY_POST_Time = "Time" ;


    public PostDataBaseHelper(Context context) {
        super(context, _DBName, null, _Version);
    }

    @Override
    public void onConfigure(SQLiteDatabase db)
    {
        // Called when the database connection is being configured.
        // Configure database settings for things like foreign key support, write-ahead logging, etc.
        super.onConfigure(db);
        db.setForeignKeyConstraintsEnabled(true);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        // Called when the database is created for the FIRST time.
        // If a database already exists on disk with the same DATABASE_NAME, this method will NOT be called.
        String CreateTable ="CREATE TABLE " + _TableName +"("
                + _KEY_POST_ID + " INTEGER PRIMARY KEY, "
                + _KEY_POST_Title + " TEXT "
                + _KEY_POST_Description + " TEXT "
                + _KEY_POST_Time +" TIME "
                +")";
        sqLiteDatabase.execSQL(CreateTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
