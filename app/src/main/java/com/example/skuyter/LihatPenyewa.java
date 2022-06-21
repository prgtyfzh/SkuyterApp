package com.example.skuyter;

import android.content.Intent;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.skuyter.adapter.PenyewaAdapter;
import com.example.skuyter.db.Penyewa;
import com.example.skuyter.db.database;

import java.util.ArrayList;
import java.util.HashMap;

public class LihatPenyewa extends AppCompatActivity {

    private RecyclerView recyclerView;
    private PenyewaAdapter adapter;
    private ArrayList<Penyewa> penyewaArrayList;
    database controller = new database(this);
    String id_penyewa,nik, nama, alamat, telepon;
    Button btTambah;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lihat_penyewa);

        recyclerView = findViewById(R.id.recyclerView1);
        btTambah = findViewById(R.id.btnAdd);
        BacaData();
        adapter = new PenyewaAdapter(penyewaArrayList);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(LihatPenyewa.this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
        btTambah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LihatPenyewa.this, TambahPenyewa.class);
                startActivity(intent);
            }
        });
    }

    public void BacaData() {
        ArrayList<HashMap<String, String>> daftarpenyewa = controller.getAllPenyewa();
        penyewaArrayList =  new ArrayList<>();
        for (int i = 0; i < daftarpenyewa.size(); i++) {
            Penyewa penyewa = new Penyewa();
            penyewa.setId_penyewa(daftarpenyewa.get(i).get("id_penyewa").toString());
            penyewa.setNik(daftarpenyewa.get(i).get("nik").toString());
            penyewa.setNama(daftarpenyewa.get(i).get("nama").toString());
            penyewa.setAlamat(daftarpenyewa.get(i).get("alamat").toString());
            penyewa.setTelepon(daftarpenyewa.get(i).get("telepon").toString());
            penyewaArrayList.add(penyewa);
        }
    }
}