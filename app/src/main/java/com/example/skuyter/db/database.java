package com.example.skuyter.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.HashMap;

public class database extends SQLiteOpenHelper {

    public database(Context context) {
        super(context, "Skuyterapp", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table penyewa (id_penyewa integer primary key, nik text, nama text, alamat text, telepon text)");
        db.execSQL("create table rental (id integer primary key, nama text, tanggal text, durasi text, waktu text)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("drop table if exists penyewa");
        db.execSQL("drop table if exists rental");
        onCreate(db);
    }

    public void InsertData(HashMap<String,String> queryValues) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues nilai = new ContentValues();
        nilai.put("nik", queryValues.get("nik"));
        nilai.put("nama", queryValues.get("nama"));
        nilai.put("alamat", queryValues.get("alamat"));
        nilai.put("telepon", queryValues.get("telepon"));
        db.insert("penyewa",null, nilai);
        nilai.put("nama", queryValues.get("nama"));
        nilai.put("tanggal", queryValues.get("tanggal"));
        nilai.put("durasi", queryValues.get("durasi"));
        nilai.put("waktu", queryValues.get("waktu"));
        db.insert("rental", null, nilai);
        db.close();
    }

    public void UpdateData(HashMap<String, String> queryValues) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues nilai = new ContentValues();
        nilai.put("nik", queryValues.get("nik"));
        nilai.put("nama", queryValues.get("nama"));
        nilai.put("alamat", queryValues.get("alamat"));
        nilai.put("telepon", queryValues.get("telepon"));
        db.update("penyewa", nilai, "id_penyewa=?", new String[]{queryValues.get("id_penyewa")});
        nilai.put("nama", queryValues.get("nama"));
        nilai.put("tanggal", queryValues.get("tanggal"));
        nilai.put("durasi", queryValues.get("durasi"));
        nilai.put("waktu", queryValues.get("waktu"));
        db.update("rental", nilai, "id=?", new String[]{queryValues.get("id")});
        db.close();
    }

    public void DeleteData(HashMap<String, String> queryValues) {
        SQLiteDatabase db = getWritableDatabase();
        db.delete("penyewa", "id_penyewa=?", new String[]{queryValues.get("id_penyewa")});
        db.delete("rental", "id=?", new String[]{queryValues.get("id")});
        db.close();
    }

    public ArrayList<HashMap<String,String>> getAllPenyewa() {
        ArrayList<HashMap<String,String>> daftarpenyewa;
        daftarpenyewa = new ArrayList<HashMap<String,String>>();
        String selectQuery = "Select * from penyewa";
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        if(cursor.moveToFirst()){
            do {
                HashMap<String,String> map = new HashMap<>();
                map.put("id_penyewa",cursor.getString(0));
                map.put("nik",cursor.getString(1));
                map.put("nama", cursor.getString(2));
                map.put("alamat", cursor.getString(3));
                map.put("telpon",cursor.getString(4));
                daftarpenyewa.add(map);
            } while (cursor.moveToNext());
        }
        db.close();
        return daftarpenyewa;
    }

    public ArrayList<HashMap<String,String>> getAllRental() {
        ArrayList<HashMap<String,String>> daftarrental;
        daftarrental = new ArrayList<HashMap<String, String>>();
        String selectQuery = "Select * from rental";
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        if(cursor.moveToFirst()){
            do {
                HashMap<String, String> map = new HashMap<>();
                map.put("id",cursor.getString(0));
                map.put("nama", cursor.getString(1));
                map.put("tanggal", cursor.getString(2));
                map.put("durasi",cursor.getString(3));
                map.put("waktu",cursor.getString(4));
                daftarrental.add(map);
            } while (cursor.moveToNext());
        }
        db.close();
        return daftarrental;
    }
}
