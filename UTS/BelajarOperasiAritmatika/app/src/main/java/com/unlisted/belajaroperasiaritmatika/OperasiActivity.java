package com.unlisted.belajaroperasiaritmatika;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class OperasiActivity extends AppCompatActivity {

    final int min = 0;
    final int max = 999;
    int nomorku1, nomorku2;
    int addcheckintr;
    TextView labelOperasiku, labelnomorku1, labelnomorku2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_operasi);

        labelOperasiku = findViewById(R.id.labeljenisOperasi);
        labelnomorku1 = findViewById(R.id.number1);
        labelnomorku2 = findViewById(R.id.number2);

        Intent intent = getIntent();
        String easyPuzzle = intent.getExtras().getString("jenisoperasi");
        int realoperasi = Integer.valueOf(easyPuzzle);

        if(realoperasi==1){
            labelOperasiku.setText("+");
            nomorku1 = dapatkanRandom();
            nomorku2 = dapatkanRandom();
            addcheckintr = nomorku1 + nomorku2;
            while (addcheckintr > 999){
                nomorku1 = dapatkanRandom();
                nomorku2 = dapatkanRandom();
                addcheckintr = nomorku1 + nomorku2;
            }
        } else if(realoperasi == 2){
            labelOperasiku.setText("-");
            nomorku1 = dapatkanRandom();
            nomorku2 = dapatkanRandom();
            while (nomorku2 >= nomorku1){
                nomorku1 = dapatkanRandom();
                nomorku2 = dapatkanRandom();
            }
        }

        labelnomorku1.setText(String.valueOf(nomorku1));
        labelnomorku2.setText(String.valueOf(nomorku2));
    }

    void testRandom(View view){
        final int randomku = new Random().nextInt((max - min) + 1) + min;
        Toast.makeText(this, String.valueOf(randomku), Toast.LENGTH_SHORT).show();
    }
    int dapatkanRandom(){
        final int randomku = new Random().nextInt((max - min) + 1) + min;
        return randomku;
    }
    void cekBenar(View view){
        Intent intent = getIntent();
        String cekeasyPuzzle = intent.getExtras().getString("jenisoperasi");
        int cekrealoperasi = Integer.valueOf(cekeasyPuzzle);
        EditText inputanhasil = findViewById(R.id.editTextHasil);

        TextView ceklabelnomorku1, ceklabelnomorku2;
        ceklabelnomorku1 = findViewById(R.id.number1);
        ceklabelnomorku2 = findViewById(R.id.number2);

        int nilainomor1 = Integer.parseInt(ceklabelnomorku1.getText().toString());
        int nilainomor2 = Integer.parseInt(ceklabelnomorku2.getText().toString());
        int nilaiinputhasil;

        String cekingnull = inputanhasil.getText().toString();
        if (cekingnull.matches("")) {
            Toast.makeText(this, "Inputan Kosong! Hasil akan di diatur sebagai 0.", Toast.LENGTH_SHORT).show();
            nilaiinputhasil = 0;
            inputanhasil.setText("0");
        } else {
            nilaiinputhasil = Integer.parseInt(inputanhasil.getText().toString());
        }

        int hasiloperasi;
        if(cekrealoperasi==1){
            hasiloperasi = nilainomor1 + nilainomor2;
            if (nilaiinputhasil == hasiloperasi){
                Toast.makeText(this, "Jawaban Benar. Coba soal ini lagi!", Toast.LENGTH_SHORT).show();
                finish();
                startActivity(getIntent());
            } else {
                Toast.makeText(this, "Jawaban Salah. Masukkan jawaban yang benar!", Toast.LENGTH_SHORT).show();
            }
        } else if(cekrealoperasi == 2){
            hasiloperasi = nilainomor1 - nilainomor2;
            if (nilaiinputhasil == hasiloperasi){
                Toast.makeText(this, "Jawaban Benar. Coba soal ini lagi!", Toast.LENGTH_SHORT).show();
                finish();
                startActivity(getIntent());
            } else {
                Toast.makeText(this, "Jawaban Salah. Masukkan jawaban yang benar!", Toast.LENGTH_SHORT).show();
            }
        }
    }

    public void kembalikemenuku(View view) {
        finish();
    }
}
