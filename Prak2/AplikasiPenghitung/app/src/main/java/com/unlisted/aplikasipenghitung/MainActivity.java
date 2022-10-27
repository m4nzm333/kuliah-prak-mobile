package com.unlisted.aplikasipenghitung;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity{
    int counter = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button BtnToast = (Button) findViewById(R.id.BtnToast);
        Button BtnCount = (Button) findViewById(R.id.BtnCount);
        Button BtnSub = (Button) findViewById(R.id.BtnSub);
        final TextView TextCounter = (TextView) findViewById(R.id.TxtCounter);
        BtnToast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Jumlah Sekarang : " + Integer.toString(counter), Toast.LENGTH_SHORT).show();
            }
        });
        BtnCount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                counter++;
                TextCounter.setText(Integer.toString(counter));
            }
        });
        BtnSub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                counter--;
                TextCounter.setText(Integer.toString(counter));
            }
        });
    }
}
