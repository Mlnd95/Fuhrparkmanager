package com.example.myapplication1;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class DBHelper extends SQLiteOpenHelper {

    public static final String DBName="logindata.db";

    public DBHelper( Context context) {
        super(context, "Logindata.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase MyDB) {
        MyDB.execSQL("create TABLE users(username TEXT primary key, password TEXT)"); // Erstellt Tabelle: Users, mit den Spalten "username" und "password"

    }

    @Override
    public void onUpgrade(SQLiteDatabase MyDB, int oldVersion, int newVersion) {
        MyDB.execSQL("drop Table if exists users");

    }

    public boolean insertData(String username, String password){
        SQLiteDatabase MyDB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("username", username);
        contentValues.put("password", password);
        long result = MyDB.insert("users", null,contentValues);

        if (result==-1) return false;
        else
            return true;
    }

    public boolean checkUsername(String username){ // Überprüfung ob User in Tabelle existiert
        SQLiteDatabase MyDB = this.getWritableDatabase();
        Cursor cursor =  MyDB.rawQuery("SELECT * FROM users WHERE username=?", new String[] {username});
        if (cursor.getCount()>0)
            return true;
        else return false;
    }
    public boolean checkUsernamePassword(String username, String password){
        SQLiteDatabase MyDB = this.getWritableDatabase();
        Cursor cursor =  MyDB.rawQuery("SELECT * FROM users WHERE username=? and password=?", new String[] {username,password});
        if (cursor.getCount()>0)
            return true;
        else return false;
    }
}
