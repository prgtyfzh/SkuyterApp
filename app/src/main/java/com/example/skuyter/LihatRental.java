package com.example.skuyter;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.skuyter.adapter.RentalAdapter;
import com.example.skuyter.db.Rental;
import com.example.skuyter.db.database;

import java.util.ArrayList;
import java.util.HashMap;

public class LihatRental extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RentalAdapter adapter;
    private ArrayList<Rental> rentalArrayList;
    database controller = new database(this);
    String id, nama, tanggal, durasi, waktu;
    Button btTambah;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lihat_rental);

        recyclerView = findViewById(R.id.recyclerView);
        BacaData();
        adapter = new RentalAdapter(rentalArrayList);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(LihatRental.this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
        btTambah = findViewById(R.id.btnAdd);
        btTambah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LihatRental.this, TambahRental.class);
                startActivity(intent);
            }
        });
    }

    public void BacaData() {
        ArrayList<HashMap<String, String>> daftarrental = controller.getAllRental();
        rentalArrayList =  new ArrayList<>();
        for (int i = 0; i < daftarrental.size(); i++) {
            Rental rental = new Rental();
            rental.setId(daftarrental.get(i).get("id").toString());
            rental.setNama(daftarrental.get(i).get("nama").toString());
            rental.setTanggal(daftarrental.get(i).get("tanggal").toString());
            rental.setDurasi(daftarrental.get(i).get("durasi").toString());
            rental.setWaktu(daftarrental.get(i).get("waktu").toString());
            rentalArrayList.add(rental);
        }
    }
}