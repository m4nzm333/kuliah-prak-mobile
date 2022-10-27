package com.unlisted.basiccrud;

import android.content.DialogInterface;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class DeleteMahasiswa extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete_mahasiswa);

        MahasiswaDBHelper mahasiswaDBHelper = new MahasiswaDBHelper(getApplicationContext());
        SQLiteDatabase sqLiteDatabase = mahasiswaDBHelper.getReadableDatabase();
        Cursor cursor = mahasiswaDBHelper.readMahasiswa(sqLiteDatabase);
        ArrayList<String> listNamaMahasiswa = new ArrayList<String>();
        while (cursor.moveToNext()){
            String namanya = cursor.getString(cursor.getColumnIndex(MahasiswaContract.MahasiswaEntry.NAMA));
            listNamaMahasiswa.add(namanya);
        }

        Spinner spinner = findViewById(R.id.spinnerPilihMahasiswa);
        ArrayAdapter<String> spinnerArrayAdapter = new ArrayAdapter<String>(this,   android.R.layout.simple_spinner_item, listNamaMahasiswa);
        spinnerArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item); // The drop down view
        spinner.setAdapter(spinnerArrayAdapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String getnama = parent.getItemAtPosition(position).toString();
                MahasiswaDBHelper mahasiswaDBHelper = new MahasiswaDBHelper(getApplicationContext());
                SQLiteDatabase sqLiteDatabase = mahasiswaDBHelper.getReadableDatabase();
                Cursor cursor = mahasiswaDBHelper.readMahasiswabyNama(getnama, sqLiteDatabase);
                while (cursor.moveToNext()){
                    String idnya = String.valueOf(cursor.getInt(cursor.getColumnIndex(MahasiswaContract.MahasiswaEntry.ID_MHS)));
                    String nimnya = cursor.getString(cursor.getColumnIndex(MahasiswaContract.MahasiswaEntry.NIM));
                    String alamatnya = cursor.getString(cursor.getColumnIndex(MahasiswaContract.MahasiswaEntry.ALAMAT));

                    TextView tvID = findViewById(R.id.tvIDMahasiswa);
                    tvID.setText(idnya);
                    TextView tvNim = findViewById(R.id.tvNimMahasiswa);
                    tvNim.setText(nimnya);
                    TextView tvAlamat = findViewById(R.id.tvAlamatMahasiswa);
                    tvAlamat.setText(alamatnya);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    public void actionHapusData(View view) {
        AlertDialog.Builder builder = new AlertDialog.Builder(DeleteMahasiswa.this);
        builder.setMessage("Anda yakin ingin menghpus data tersebut?")
                .setTitle("Konfirmasi Hapus");
        builder.setPositiveButton("Lanjutkan", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                // Kerjakan Hapus Data
                Spinner mySpinner = findViewById(R.id.spinnerPilihMahasiswa);
                String namahapus = mySpinner.getSelectedItem().toString();
                MahasiswaDBHelper mahasiswaDBHelper = new MahasiswaDBHelper(getApplicationContext());
                SQLiteDatabase sqLiteDatabase = mahasiswaDBHelper.getReadableDatabase();
                mahasiswaDBHelper.deleteMahasiswabyNama(namahapus, sqLiteDatabase);
                Toast.makeText(getApplicationContext(), "1 Row Deleted", Toast.LENGTH_SHORT).show();
                finish();
            }
        });
        builder.setNegativeButton("Kembali", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });
        AlertDialog dialog = builder.create();
        dialog.show();
    }
}
