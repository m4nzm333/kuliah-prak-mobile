package com.unlisted.multiactivity;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText EditTextUntukIrman;
    TextView TampilPesanDariIrman;
    private static final int REQUEST_CODE = 0x9988;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EditTextUntukIrman = findViewById(R.id.EditText2Irman);
        TampilPesanDariIrman = findViewById(R.id.IsiPesanIrman);
    }

    public void bukaSecondActiviy (View view) {
        String Pesanku = EditTextUntukIrman.getText().toString();
        Intent intentmove = new Intent(this, SecondActivity.class);
        intentmove.putExtra("EXTRA_SEND", Pesanku);
        startActivityForResult(intentmove, REQUEST_CODE);

    }
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == REQUEST_CODE) {
            if(resultCode == Activity.RESULT_OK) {
                String result = data.getStringExtra(SecondActivity.EXTRA_DATA);
                TampilPesanDariIrman.setText(result);
            }
        }
    }
}
