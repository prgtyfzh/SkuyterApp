package com.example.skuyter;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.skuyter.db.database;

import java.util.HashMap;

public class UpdateRental extends AppCompatActivity {

    EditText Id, Nama, Tanggal, Durasi, Waktu;
    Button Simpan, Batal;
    String id, nama, tanggal, durasi, waktu;
    database controller = new database(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_rental);

        Id = findViewById(R.id.edID);
        Nama = findViewById(R.id.edNama);
        Tanggal = findViewById(R.id.edTanggal);
        Durasi = findViewById(R.id.edDurasi);
        Waktu = findViewById(R.id.edWaktu);
        Simpan = findViewById(R.id.btnSimpan);
        Batal = findViewById(R.id.btnBatal);

        id = getIntent().getStringExtra("id");
        nama = getIntent().getStringExtra("nama");
        tanggal = getIntent().getStringExtra("tanggal");
        durasi = getIntent().getStringExtra("durasi");
        waktu = getIntent().getStringExtra("waktu");

        setTitle("Edit Data");
        Id.setText(id);
        Nama.setText(nama);
        Tanggal.setText(tanggal);
        Durasi.setText(durasi);
        Waktu.setText(waktu);

        Simpan.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                if(Id.getText().toString().equals("") || Nama.getText().toString().equals("") || Tanggal.getText().toString().equals("") || Durasi.getText().toString().equals("") || Waktu.getText().toString().equals("")){
                    Toast.makeText(getApplicationContext(), "Mohon isi data terlebih dahulu!", Toast.LENGTH_LONG).show();
                } else {
                    id = Id.getText().toString();
                    nama = Nama.getText().toString();
                    tanggal = Tanggal.getText().toString();
                    durasi = Durasi.getText().toString();
                    waktu = Waktu.getText().toString();
                    HashMap<String, String> values = new HashMap<>();
                    values.put("id", id);
                    values.put("nama", nama);
                    values.put("tanggal", tanggal);
                    values.put("durasi", durasi);
                    values.put("waktu", waktu);
                    controller.UpdateData(values);
                    callHome();
                }

                Batal.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(UpdateRental.this, LihatRental.class);
                    }
                });
            }
        });
    }

    public void callHome() {
        Intent i = new Intent(UpdateRental.this, LihatRental.class);
        startActivity(i);
        finish();
    }
}