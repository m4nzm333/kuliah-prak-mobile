package com.unlisted.belajaroperasiaritmatika;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    void goToPenjumlahan(View view){
        String keyOperasi  = "1";
        Intent i = new Intent(this, OperasiActivity.class);
        i.putExtra("jenisoperasi", keyOperasi);
        startActivity(i);

    }
    void goToPengurangan(View view){
        String keyOperasi  = "2";
        Intent i = new Intent(this, OperasiActivity.class);
        i.putExtra("jenisoperasi", keyOperasi);
        startActivity(i);
    }
    void goToExit(View view){
        System.exit(0);
    }
}
