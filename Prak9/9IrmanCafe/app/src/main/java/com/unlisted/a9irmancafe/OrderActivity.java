package com.unlisted.a9irmancafe;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.RadioButton;
import android.widget.Toast;

public class OrderActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    public void onRadioButtonClicked(View view) {
        boolean checked = ((RadioButton) view).isChecked();
        switch(view.getId()) {
            case R.id.someday:
                if (checked)
                    Toast.makeText(this, getString(R.string.order1), Toast.LENGTH_SHORT).show();
                finish();
                break;
            case R.id.nextday:
                if (checked)
                    Toast.makeText(this, getString(R.string.order2), Toast.LENGTH_SHORT).show();
                finish();
                break;
            case R.id.pickup:
                if (checked)
                    Toast.makeText(this, getString(R.string.order3), Toast.LENGTH_SHORT).show();
                finish();
                break;
            default:
                Log.d(String.valueOf(getApplicationContext()), "Nothing Clicked");
                break;
        }
    }


}
