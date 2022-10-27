package com.unlisted.a9irmancafe;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        switch (id){
            case R.id.action_contact:
                Toast.makeText(getApplicationContext(), "You Choose Contact!", Toast.LENGTH_SHORT).show();
                break;
            case R.id.action_favorites:
                Toast.makeText(getApplicationContext(), "You Choose Favorites", Toast.LENGTH_SHORT).show();
                break;
            case R.id.action_order:
                Toast.makeText(getApplicationContext(), "You Choose Order", Toast.LENGTH_SHORT).show();
                break;
            case R.id.action_settings:
                Toast.makeText(getApplicationContext(), "You Choose Settings", Toast.LENGTH_SHORT).show();
                break;
            case R.id.action_status:
                Toast.makeText(getApplicationContext(), "You Choose Status", Toast.LENGTH_SHORT).show();
                break;
        }

        return super.onOptionsItemSelected(item);
    }

    public void showPesananku(View view) {
        switch(view.getId()) {
            case R.id.imgDonuts:
                Toast.makeText(getApplicationContext(), "Anda memesan Donut!", Toast.LENGTH_SHORT).show();
                goToOrderActivity();
                break;
            case R.id.imgIcecream:
                Toast.makeText(getApplicationContext(), "Anda memesan Ice Cream!", Toast.LENGTH_SHORT).show();
                goToOrderActivity();
                break;
            case R.id.imgFroyo:
                Toast.makeText(getApplicationContext(), "Anda memesan Froyo!", Toast.LENGTH_SHORT).show();
                goToOrderActivity();
                break;
            default:
                Log.d(String.valueOf(getApplicationContext()), "Default");
                break;
        }
    }

    public void goToOrderActivity(){
        Intent intent = new Intent(this, OrderActivity.class);
        startActivity(intent);
    }


}
