package com.aademo.myapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class DBHelper extends SQLiteOpenHelper {

    public static final String DBName = "MYDATABASE.db";

    public static final String TableName = "MyData";
    public static final String NAME = "name";
    public static final String PHONE = "phone";
    public static final String EMAIL = "email";

    public DBHelper(Context context ) {
        super(context, DBName, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        sqLiteDatabase.execSQL("create table MyData"+
                "(id integer primary key, name text, phone text, email text)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {

        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS MyData");
        onCreate(sqLiteDatabase);

    }

    public boolean insertData (String name, String phone, String email){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("name",name);
        contentValues.put("phone",phone);
        contentValues.put("email",email);
        db.insert(TableName, null,contentValues);

        return true;
    }


    public ArrayList<DataModel> getData(){
        ArrayList<DataModel> arrayList = new ArrayList<>();

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res = db.rawQuery("select * from MyData",null);

        res.moveToFirst();

        while (res.isAfterLast() == false){
            DataModel model = new DataModel();
            model.setName(res.getString(res.getColumnIndex(NAME)));
            model.setPhone(res.getString(res.getColumnIndex(PHONE)));
            model.setEmail(res.getString(res.getColumnIndex(EMAIL)));

            arrayList.add(model);
            res.moveToNext();

        }

        return arrayList;
    }







}
