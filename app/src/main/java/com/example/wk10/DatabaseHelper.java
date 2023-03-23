package com.example.wk10;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DatabaseHelper extends SQLiteOpenHelper {
    final static String DATABASE_NAME = "Information.db";
    final static int DATABASE_VERSION = 1;
    final static String TABLE_NAME  = "student_table";
    final static String T1COL1 = "id";
    final static String T1COL2 = "name";
    final static String T1COL3 = "Snumber";
    final static String T1COL4 = "Cell";
    final static String T1COL5 = "Cid";

// to add new commit

    //added newest commit

    public DatabaseHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String query = " CREATE TABLE " + TABLE_NAME +"("+T1COL1+" INTEGER PRIMARY KEY, "+ T1COL2+ " TEXT,"
                + T1COL3 + " TEXT," + T1COL4 + " TEXT," +T1COL5  + " TEXT)";
        sqLiteDatabase.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {
        sqLiteDatabase.execSQL(" DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(sqLiteDatabase);
    }

    public boolean addData(String name, String snum, String cell, String cid){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(T1COL2,name);
        values.put(T1COL3,snum);
        values.put(T1COL4,cell);
        values.put(T1COL5,cid);

        long l = sqLiteDatabase.insert(TABLE_NAME,null,values);
        if(l>0){
            return true;
        }else{
            return false;
        }
    }
    public Cursor viewData (){
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
        String query = " SELECT * FROM " + TABLE_NAME;
        Cursor  cursor = sqLiteDatabase.rawQuery(query,null);
        return cursor;
    }

    public boolean deleteData(int id){
        String [] input = {Integer.toString(id)};
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        int i = sqLiteDatabase.delete(TABLE_NAME, " id=? ", input);
        if(i > 0 ){
            return true;
        }else{
            return false;
        }
    }
}
