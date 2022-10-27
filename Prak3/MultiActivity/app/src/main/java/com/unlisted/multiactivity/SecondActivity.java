package com.unlisted.multiactivity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {
    TextView TampilPesanDariBot;
    EditText EditTextUntukBot;
    public static final String EXTRA_DATA = "EXTRA_DATA";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        String IsiPesanDariBot = getIntent().getStringExtra("EXTRA_SEND");
        TampilPesanDariBot = findViewById(R.id.IsiPesanBot);
        TampilPesanDariBot.setText(IsiPesanDariBot);
        EditTextUntukBot = findViewById(R.id.EditText2Bot);
    }
    public void bukaMainActivity (View view){
        final Intent data = new Intent();
        String IsiPesanKeBot;
        IsiPesanKeBot = EditTextUntukBot.getText().toString();
        data.putExtra(EXTRA_DATA, IsiPesanKeBot);
        setResult(SecondActivity.RESULT_OK, data);
        finish();
    }
}
