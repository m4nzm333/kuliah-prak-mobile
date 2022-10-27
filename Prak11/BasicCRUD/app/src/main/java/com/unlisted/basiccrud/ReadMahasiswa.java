package com.unlisted.basiccrud;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.app.Activity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.LinkedList;

public class ReadMahasiswa extends Activity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_read_mahasiswa);

        RecyclerView mRecyclerView;
        RecyclerView.Adapter mAdapter;
        RecyclerView.LayoutManager mLayoutManager;

        LinkedList<String> listnama = new LinkedList<String>();
        LinkedList<String> listnim = new LinkedList<String>();

        MahasiswaDBHelper mahasiswaDBHelper = new MahasiswaDBHelper(getApplicationContext());
        SQLiteDatabase sqLiteDatabase = mahasiswaDBHelper.getReadableDatabase();
        Cursor cursor = mahasiswaDBHelper.readMahasiswa(sqLiteDatabase);
        ArrayList<String> listNamaMahasiswa = new ArrayList<String>();
        while (cursor.moveToNext()){
            String namanya = cursor.getString(cursor.getColumnIndex(MahasiswaContract.MahasiswaEntry.NAMA));
            String nimnya = cursor.getString(cursor.getColumnIndex(MahasiswaContract.MahasiswaEntry.NIM));
            listnama.add(namanya);
            listnim.add(nimnya);
        }



        mRecyclerView = (RecyclerView) findViewById(R.id.ListMahasiswaViewKu);
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);

        mAdapter = new RecyclerDataMhs(listnama, listnim);
        mRecyclerView.setAdapter(mAdapter);
    }

    public void kembali(View view) {
        finish();
    }
}
