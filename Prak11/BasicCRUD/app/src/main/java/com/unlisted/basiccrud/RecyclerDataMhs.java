package com.unlisted.basiccrud;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.LinkedList;

import static android.support.v4.content.ContextCompat.startActivity;

class RecyclerDataMhs extends RecyclerView.Adapter<RecyclerDataMhs.MyViewHolder>{
    private final LinkedList<String> mNama;
    private final LinkedList<String> mNim;



    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView nama, nim;
        public CardView cardnyamereka;

        public MyViewHolder(View view) {
            super(view);
            nama = (TextView) view.findViewById(R.id.tvNamaMahasiswa);
            nim = (TextView) view.findViewById(R.id.tvNimMahasiswa);
            cardnyamereka = (CardView) view.findViewById(R.id.CardMahasiswa);
        }
    }
    public RecyclerDataMhs(LinkedList<String> mNama, LinkedList<String> mNim) {
        this.mNama = mNama;
        this.mNim = mNim;
    }
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.rv_data_mahasiswa, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder myViewHolder, int i) {
        final String namaTampil = mNama.get(i);
        myViewHolder.nama.setText(namaTampil);
        myViewHolder.cardnyamereka.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentku = new Intent(v.getContext(), DetailMahasiswa.class);
                intentku.putExtra("NamaMahasiswaKu", namaTampil);
                startActivity(v.getContext(), intentku, null);
            }
        });
        myViewHolder.nim.setText(mNim.get(i));
    }

    @Override
    public int getItemCount() {
        return mNama.size();
    }
}
