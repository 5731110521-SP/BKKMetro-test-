package com.example.calojy.ui2;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.content.Context;


public class myDBClass extends SQLiteOpenHelper {

    private static final String DB_NAME="Android";
    public static final String TABLE_NAME="members";
    public static final String COL_Email="Email";
    public static final String COL_Pass="Password";
    public static final String COL_Phone="Phone No";
    private static final int DB_VRESION=1;


    public myDBClass(Context context){
        super(context,DB_NAME,null,DB_VRESION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE members (Email TEXT PRIMARY KEY, Password TEXT, Phone TEXT);");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
