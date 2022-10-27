package com.unlisted.basiccrud;

import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AddMahasiswa extends AppCompatActivity {
    EditText namaMhs, nimMhs, alamatMhs;
    Button btnTambahDataku, btnResetDataku;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_mahasiswa);

        namaMhs = findViewById(R.id.inputNama);
        nimMhs = findViewById(R.id.inputNIM);
        alamatMhs = findViewById(R.id.inputAlamat);

        btnTambahDataku = findViewById(R.id.BtnTambahData);

        btnTambahDataku.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Masukkan Semua Data ke dalam Database
                String namaku = namaMhs.getText().toString();
                String nim = nimMhs.getText().toString();
                String alamat = alamatMhs.getText().toString();

                //Koneksi Database
                MahasiswaDBHelper mahasiswaDBHelper = new MahasiswaDBHelper(getApplicationContext());

                //Definisikan Objek Aktivitas Database
                SQLiteDatabase sqLiteDatabase = mahasiswaDBHelper.getReadableDatabase();

                mahasiswaDBHelper.addDataMahasiswa(namaku, nim, alamat, sqLiteDatabase);

                //Menutup Koneksi Database
                mahasiswaDBHelper.close();

                // Inputan Di Reset
                namaMhs.setText("");
                alamatMhs.setText("");
                nimMhs.setText("");

                //Notifikasi
                Toast.makeText(getApplicationContext(), "1 Row Data Inserted", Toast.LENGTH_SHORT).show();
                finish();
            }
        });




    }
}
