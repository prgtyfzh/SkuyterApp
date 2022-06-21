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

public class TambahPenyewa extends AppCompatActivity {

    private EditText tNIK, tNama, tAlamat, tTelepon;
    private Button simpanBtn;
    String nik, nama, alamat, telepon;
    database controller = new database(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tambah_penyewa);

        tNIK = findViewById(R.id.edNIK);
        tNama = findViewById(R.id.edNama);
        tAlamat = findViewById(R.id.edAlamat);
        tTelepon = findViewById(R.id.edTelpon);

        simpanBtn = findViewById(R.id.btnSimpan);
        simpanBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(tNIK.getText().toString().equals("")||tNama.getText().toString().equals("")||tAlamat.getText().toString().equals("")||tTelepon.getText().toString().equals("")){
                    Toast.makeText(TambahPenyewa.this, "Lengkapi Data", Toast.LENGTH_SHORT).show();
                }else {
                    nik = tNIK.getText().toString();
                    nama = tNama.getText().toString();
                    alamat = tAlamat.getText().toString();
                    telepon = tTelepon.getText().toString();

                    HashMap<String, String> qvalues = new HashMap<>();
                    qvalues.put("nik", nik);
                    qvalues.put("nama", nama);
                    qvalues.put("alamat", alamat);
                    qvalues.put("telepon", telepon);

                    controller.InsertDataPenyewa(qvalues);
                    callHome();
                }
            }
        });
    }

    public void callHome(){
        Intent intent = new Intent(TambahPenyewa.this, LihatPenyewa.class);
        startActivity(intent);
        finish();
    }
}