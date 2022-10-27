package com.unlisted.basiccrud;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void createMahasiswa(View view) {
        Intent intentku = new Intent(this, AddMahasiswa.class);
        startActivity(intentku);
    }

    public void selectMahasiswa(View view) {
        Intent intentku = new Intent(this, ReadMahasiswa.class);
        intentku.setFlags(intentku.getFlags() | Intent.FLAG_ACTIVITY_NO_HISTORY);
        startActivity(intentku);
    }


    public void deleteMahasiswa(View view) {
        Intent intentku = new Intent(this, DeleteMahasiswa.class);
        startActivity(intentku);
    }

    public void updateMahasiswa(View view) {
        Intent intentku = new Intent(this, UpdateMahasiswa.class);
        startActivity(intentku);
    }
}
