package com.example.sqliteimplementation;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class DataBaseHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME="Notes";
    private static final int VERSION=1;
    private static final String TABLE_NAME="Note";
    private static final String DATA="data";
    private static final String ID="id";

    public DataBaseHelper(Context context) {
        super(context, DATABASE_NAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE "+TABLE_NAME+" ( "+ID+" INTEGER PRIMARY KEY AUTOINCREMENT , "+DATA+" TEXT" +" )");

        add("");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);
        onCreate(sqLiteDatabase);
    }

    public void add(String data1){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues cv=new ContentValues();
        cv.put(DATA,data1);
        db.insert(TABLE_NAME,null,cv);
        db.close();
    }

    public String read(){
        SQLiteDatabase db=this.getReadableDatabase();
        Cursor cr=db.rawQuery("SELECT * FROM "+TABLE_NAME,null);
        db.close();
        return cr.getString(1);
    }

    public void update(String data1,int id){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues cv=new ContentValues();
        cv.put(DATA,data1);
        db.update(TABLE_NAME,cv,ID+"="+id,null);
        db.close();
    }

    public void delete(int id){
        SQLiteDatabase db=this.getWritableDatabase();
        db.delete(TABLE_NAME,ID+"="+id,null);
        db.close();
    }
}
