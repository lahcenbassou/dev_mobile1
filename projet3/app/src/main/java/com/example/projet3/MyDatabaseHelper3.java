package com.example.projet3;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class MyDatabaseHelper3 extends SQLiteOpenHelper {
    private Context context;
    public static final String DATABASE_NAME="data3";
    public static final int DATABASE_VERSION= 1;

    private static final String TABLE_NAME2 = "annonce";
    private static final String COLUMN_TITRE = "titre";
    private static final String COLUMN_CATEGORIE = "categorie";
    private static final String COLUMN_VILLE2 = "ville2";

    MyDatabaseHelper3(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context = context;
    }



    @Override
    public void onCreate(SQLiteDatabase db) {


        String query2 = "CREATE TABLE " + TABLE_NAME2 +
                " (" + COLUMN_TITRE + " TEXT PRIMARY KEY, " +
                COLUMN_CATEGORIE + " TEXT, " +
                COLUMN_VILLE2 + " TEXT);";
        db.execSQL(query2);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {

        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME2);
        onCreate(db);
    }




    void add2(String titree, String categoriee, String villee){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();


        cv.put(COLUMN_TITRE, titree);
        cv.put(COLUMN_CATEGORIE, categoriee);
        cv.put(COLUMN_VILLE2, villee);
        long result = db.insert(TABLE_NAME2,null, cv);
        if(result == -1){
            Toast.makeText(context, "Failed", Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(context, "Added Successfully!", Toast.LENGTH_SHORT).show();
        }
    }

    public int countAdsInCity(String city) {
        SQLiteDatabase db = this.getReadableDatabase();
        String query = "SELECT COUNT(*) FROM " + TABLE_NAME2 + " WHERE " + COLUMN_VILLE2 + " = ?";
        Cursor cursor = db.rawQuery(query, new String[]{city});

        int count = 0;
        if (cursor != null) {
            cursor.moveToFirst();
            count = cursor.getInt(0); // Récupération du nombre d'annonces
            cursor.close();
        }

        return count;
    }




}
