package com.example.projet3;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class MyDatabaseHelper2 extends SQLiteOpenHelper {
    private Context context;
    public static final String DATABASE_NAME="data";
    public static final int DATABASE_VERSION= 1;
    private static final String TABLE_NAME = "inscription";

    private static final String COLUMN_TYPE = "type";
    private static final String COLUMN_EMAIL = "email";
    private static final String COLUMN_VILLE = "ville";
    private static final String COLUMN_MOTPASE = "mot_passe";


    MyDatabaseHelper2(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context = context;
    }



    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "CREATE TABLE " + TABLE_NAME +
                " (" + COLUMN_EMAIL + " TEXT PRIMARY KEY, " +
                COLUMN_VILLE + " TEXT, " +
                COLUMN_MOTPASE + " TEXT);";
        db.execSQL(query);


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);

        onCreate(db);
    }

    void add(String email, String ville, String mot_passe){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();


        cv.put(COLUMN_EMAIL, email);
        cv.put(COLUMN_VILLE, ville);
        cv.put(COLUMN_MOTPASE, mot_passe);
        long result = db.insert(TABLE_NAME,null, cv);
        if(result == -1){
            Toast.makeText(context, "failed!", Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(context, "Added Successfully!", Toast.LENGTH_SHORT).show();
        }
    }


    public boolean checkUser(String email, String password) {
        SQLiteDatabase db = this.getReadableDatabase();
        String[] columns = {COLUMN_EMAIL};
        String selection = COLUMN_EMAIL + " = ?" + " AND " + COLUMN_MOTPASE + " = ?";
        String[] selectionArgs = {email, password};
        Cursor cursor = db.query(TABLE_NAME, columns, selection, selectionArgs, null, null, null);
        int count = cursor.getCount();
        cursor.close();
        return count > 0;
    }


}
