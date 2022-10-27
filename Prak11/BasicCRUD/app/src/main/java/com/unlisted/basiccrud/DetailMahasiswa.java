package com.unlisted.basiccrud;

import android.content.DialogInterface;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class DetailMahasiswa extends AppCompatActivity {
    String NamaDariSebelah;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_mahasiswa);
        NamaDariSebelah = getIntent().getStringExtra("NamaMahasiswaKu");

        MahasiswaDBHelper mahasiswaDBHelper = new MahasiswaDBHelper(getApplicationContext());
        SQLiteDatabase sqLiteDatabase = mahasiswaDBHelper.getReadableDatabase();
        Cursor cursor = mahasiswaDBHelper.readMahasiswabyNama(NamaDariSebelah, sqLiteDatabase);
        while (cursor.moveToNext()){
            String idnya = String.valueOf(cursor.getInt(cursor.getColumnIndex(MahasiswaContract.MahasiswaEntry.ID_MHS)));
            String nimnya = cursor.getString(cursor.getColumnIndex(MahasiswaContract.MahasiswaEntry.NIM));
            String alamatnya = cursor.getString(cursor.getColumnIndex(MahasiswaContract.MahasiswaEntry.ALAMAT));

            TextView tvID = findViewById(R.id.tvIdMahasiswaDetail);
            tvID.setText(idnya);
            TextView tvNama = findViewById(R.id.etNamaMahasiswaDetail);
            tvNama.setText(NamaDariSebelah);
            TextView tvNim = findViewById(R.id.etNimMahasiswaDetail);
            tvNim.setText(nimnya);
            TextView tvAlamat = findViewById(R.id.etAlamatMahasiswaDetail);
            tvAlamat.setText(alamatnya);
        }
    }
    public void actionHapusDataDetail(View view) {
        AlertDialog.Builder builder = new AlertDialog.Builder(view.getContext());
        builder.setMessage("Anda yakin ingin menghpus data tersebut?")
                .setTitle("Konfirmasi Hapus");
        builder.setPositiveButton("Lanjutkan", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                // Kerjakan Hapus Data
                TextView tvNamaku = findViewById(R.id.etNamaMahasiswaDetail);
                String namahapus = tvNamaku.getText().toString();
                Toast.makeText(DetailMahasiswa.this, namahapus, Toast.LENGTH_SHORT).show();
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
    public void actionUpdateDataDetail(View view) {
        AlertDialog.Builder builder = new AlertDialog.Builder(view.getContext());
        builder.setMessage("Anda yakin ingin mengubah data itu?")
                .setTitle("Konfirmasi Update");
        builder.setPositiveButton("Lanjutkan", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                // Kerjakan Update Data
                EditText etElementNama, etElementNim, etElementAlamat;
                etElementNama = findViewById(R.id.etNamaMahasiswaDetail);
                etElementNim = findViewById(R.id.etNimMahasiswaDetail);
                etElementAlamat = findViewById(R.id.etAlamatMahasiswaDetail);

                String namaupdate = NamaDariSebelah;
                String namaku, nimku, alamatku;
                namaku = etElementNama.getText().toString();
                nimku = etElementNim.getText().toString();
                alamatku = etElementAlamat.getText().toString();

                MahasiswaDBHelper mahasiswaDBHelper = new MahasiswaDBHelper(getApplicationContext());
                SQLiteDatabase sqLiteDatabase = mahasiswaDBHelper.getReadableDatabase();
                mahasiswaDBHelper.updateMahasiswabyNama(namaupdate, namaku, nimku, alamatku, sqLiteDatabase);
                Toast.makeText(getApplicationContext(), "1 Row Updated", Toast.LENGTH_SHORT).show();
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

