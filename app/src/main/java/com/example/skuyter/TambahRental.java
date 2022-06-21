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

public class TambahRental extends AppCompatActivity {

    private EditText tId, tNama, tTanggal, tDurasi, tWaktu;
    private Button simpanBtn;
    String id, nama, tanggal, durasi, waktu;
    database controller = new database(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tambah_rental);

        tId = findViewById(R.id.edID);
        tNama = findViewById(R.id.edNama);
        tTanggal = findViewById(R.id.edTanggal);
        tDurasi = findViewById(R.id.edDurasi);
        tWaktu = findViewById(R.id.edWaktu);

        simpanBtn = findViewById(R.id.btnSimpan);
        simpanBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(tId.getText().toString().equals("")||tNama.getText().toString().equals("")||tTanggal.getText().toString().equals("")||tDurasi.getText().toString().equals("")||tWaktu.getText().toString().equals("")){
                    Toast.makeText(TambahRental.this, "Lengkapi Data", Toast.LENGTH_SHORT).show();
                }else {
                    id = tId.getText().toString();
                    nama = tNama.getText().toString();
                    tanggal = tTanggal.getText().toString();
                    durasi = tDurasi.getText().toString();
                    waktu = tWaktu.getText().toString();

                    HashMap<String, String> qvalues = new HashMap<>();
                    qvalues.put("id", id);
                    qvalues.put("nama", nama);
                    qvalues.put("tanggal", tanggal);
                    qvalues.put("durasi", durasi);
                    qvalues.put("waktu", waktu);

                    controller.InsertDataRental(qvalues);
                    callHome();
                }
            }
        });
    }

    public void callHome(){
        Intent intent = new Intent(TambahRental.this, LihatRental.class);
        startActivity(intent);
        finish();
    }
}