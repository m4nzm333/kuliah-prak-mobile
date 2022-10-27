package com.unlisted.basiccrud;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.strictmode.SqliteObjectLeakedViolation;
import android.util.Log;

public class MahasiswaDBHelper extends SQLiteOpenHelper {

    // Pendefenisian Nama Database dan Versi
    public static final String DATABASE_NAME = "db_mhs";
    public static final int DATABASE_VERSION = 1;

    // Constructor
    MahasiswaDBHelper(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        Log.d("Database Operation", "Database Connected");
    }

    //Buat Tabel
    static final String CREATE_TABLE = "CREATE TABLE " +
            MahasiswaContract.MahasiswaEntry.TABLE_NAME + "(" +
            MahasiswaContract.MahasiswaEntry.ID_MHS + " INTEGER PRIMARY KEY AUTOINCREMENT," +
            MahasiswaContract.MahasiswaEntry.NAMA + " TEXT," +
            MahasiswaContract.MahasiswaEntry.NIM + " TEXT," +
            MahasiswaContract.MahasiswaEntry.ALAMAT +  " TEXT;)";
    static final String DROP_TABLE = "DROP TABLE IF EXISTS " + DATABASE_NAME;

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE);
        Log.d("Database Operation", "Tabel Mahasiswa Created");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(DROP_TABLE);
        Log.d("Database Operation", "Tabel Mahasiswa Dropped");
    }

    // E: Koneksi DB Keselurahan


    // Menambah Data
    public void addDataMahasiswa(String nama, String nim, String alamat, SQLiteDatabase database){
        ContentValues contentValues = new ContentValues();
        // Isi Tabel
        contentValues.put(MahasiswaContract.MahasiswaEntry.NAMA, nama);
        contentValues.put(MahasiswaContract.MahasiswaEntry.NIM, nim);
        contentValues.put(MahasiswaContract.MahasiswaEntry.ALAMAT, alamat);
        // Eksekusi Insert Data
        database.insert(MahasiswaContract.MahasiswaEntry.TABLE_NAME, null, contentValues);
        Log.d("Database Operation", "1 Row Inserted");
    }
    // Membaca Data
    public Cursor readMahasiswa(SQLiteDatabase database){
        // Defenisikan Field Yang mau diambil
        String[] projection = {
                MahasiswaContract.MahasiswaEntry.ID_MHS,
                MahasiswaContract.MahasiswaEntry.NAMA,
                MahasiswaContract.MahasiswaEntry.NIM,
                MahasiswaContract.MahasiswaEntry.ALAMAT
        };
        // Eksekusi Query Ambil Data
        Cursor cursor = database.query(MahasiswaContract.MahasiswaEntry.TABLE_NAME, projection, null, null, null, null, null);
        return cursor;
    }

    public Cursor readMahasiswabyNama(String nama, SQLiteDatabase database){
        String[] projection = {
                MahasiswaContract.MahasiswaEntry.ID_MHS,
                MahasiswaContract.MahasiswaEntry.NAMA,
                MahasiswaContract.MahasiswaEntry.NIM,
                MahasiswaContract.MahasiswaEntry.ALAMAT
        };
        String[] whereArgs = new String[] {nama};
        Cursor cursor = database.query(MahasiswaContract.MahasiswaEntry.TABLE_NAME, projection, "nama = ?", whereArgs, null, null, null);
        return cursor;
    }


    public void deleteMahasiswabyNama(String nama, SQLiteDatabase database){
        String[] whereArgs = new String[] {nama};
        database.delete(MahasiswaContract.MahasiswaEntry.TABLE_NAME, "nama = ?", whereArgs);
        Log.d("Database Operation", "1 Row Deleted");
    }

    public void updateMahasiswabyNama(String namaasal, String nama, String nim, String alamat, SQLiteDatabase database){
        String[] whereArgs = new String[] {namaasal};
        ContentValues contentValues = new ContentValues();
        contentValues.put(MahasiswaContract.MahasiswaEntry.NAMA, nama);
        contentValues.put(MahasiswaContract.MahasiswaEntry.NIM, nim);
        contentValues.put(MahasiswaContract.MahasiswaEntry.ALAMAT, alamat);

        database.update(MahasiswaContract.MahasiswaEntry.TABLE_NAME, contentValues, "nama = ?", whereArgs);
        Log.d("Database Operation", "1 Row Updated");
    }
}
