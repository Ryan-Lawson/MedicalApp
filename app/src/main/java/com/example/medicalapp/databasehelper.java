package com.example.medicalapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class databasehelper extends SQLiteOpenHelper {
    public static final String USER_TABLE = "USER_Table";
    public static final String COLUMN_USER_USERNAME = "USER_USERNAME";
    public static final String COLUMN_USER_PASSWORD = "USER_PASSWORD";
    public static final String COLUMN_USER_AGE = "USER_AGE";
    public static final String COLUMN_USER_PHONENUMBER = "USER_PHONENUMBER";
    public static final String COLUMN_USER_ADDRESS = "USER_ADDRESS";
    public static final String COLUMN_USER_SMSEMAIL = "USER_SMSEMAIL";

    public databasehelper(@Nullable Context context) {
        super(context, "user.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTableStatement = "Create Table " + USER_TABLE + " (ID INTEGER PRIMARY KEY AUTOINCREMENT, " + COLUMN_USER_USERNAME + " TEXT, " + COLUMN_USER_PASSWORD + " TEXT, " + COLUMN_USER_AGE + " INT, " + COLUMN_USER_PHONENUMBER + " INT, " + COLUMN_USER_ADDRESS + " TEXT, " + COLUMN_USER_SMSEMAIL + " BOOL)";

        db.execSQL(createTableStatement);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public boolean addOne(Usermodel usermodel) {

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(COLUMN_USER_USERNAME, usermodel.getUsername());
        cv.put(COLUMN_USER_PASSWORD, usermodel.getPassword());
        cv.put(COLUMN_USER_AGE, usermodel.getAge());
        cv.put(COLUMN_USER_PHONENUMBER, usermodel.getPhonenumber());
        cv.put(COLUMN_USER_ADDRESS, usermodel.getAddress());
        cv.put(COLUMN_USER_SMSEMAIL, usermodel.isSMSEMAIL());

        long insert = db.insert(USER_TABLE, null, cv);
        if (insert == -1) {
            return false;
        } else {
            return true;
        }

    }

    public boolean checkusernamepassword(String COLUMN_USER_USERNAME, String COLUMN_USER_PASSWORD) {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("Select * from USER_TABLE where USER_USERNAME = ? and USER_PASSWORD = ?", new String[]{COLUMN_USER_USERNAME, COLUMN_USER_PASSWORD});
        if (cursor.getCount() > 0)
            return true;
        else {
            return false;
        }

    }

    public boolean updateuserdata(String COLUMN_USER_USERNAME, String COLUMN_USER_PASSWORD, String COLUMN_USER_AGE, String COLUMN_USER_PHONENUMBER, String COLUMN_USER_ADDRESS) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("COLUMN_USER_USERNAME", COLUMN_USER_USERNAME);
        cv.put("COLUMN_USER_PASSWORD", COLUMN_USER_PASSWORD);
        cv.put("COLUMN_USER_AGE", COLUMN_USER_AGE);
        cv.put("COLUMN_USER_PHONENUMBER", COLUMN_USER_PHONENUMBER);
        cv.put("COLUMN_USER_ADDRESS", COLUMN_USER_ADDRESS);
        Cursor cursor = db.rawQuery("select * from USER_TABLE where COLUMN_USER_USERNAME = ?", new String[]{COLUMN_USER_USERNAME});

        if (cursor.getCount() > 0) {
            long result = db.update("USER_TABLE", cv, "COLUMN_USER_USERNAME=?", new String[]{COLUMN_USER_USERNAME});
            if (result == -1) {
                return false;
            } else {
                return true;
            }
        }else{
            return false;
        }


    }

}
