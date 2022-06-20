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

public class UpdatePenyewa extends AppCompatActivity {

    EditText Nik, Nama, Alamat, Telepon;
    Button Simpan, Batal;
    String id_penyewa,nik, nama, alamat, telepon;
    database controller = new database(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_penyewa);

        Nik = findViewById(R.id.edNIK);
        Nama = findViewById(R.id.edNama);
        Alamat = findViewById(R.id.edAlamat);
        Telepon = findViewById(R.id.edTelpon);
        Simpan = findViewById(R.id.btnSimpan);

        id_penyewa = getIntent().getStringExtra("id_penyewa");
        nik = getIntent().getStringExtra("nik");
        nama = getIntent().getStringExtra("nama");
        alamat = getIntent().getStringExtra("alamat");
        telepon = getIntent().getStringExtra("telepon");

        setTitle("Edit Data");
        Nik.setText(nik);
        Nama.setText(nama);
        Alamat.setText(alamat);
        Telepon.setText(telepon);

        Simpan.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                if(Nik.getText().toString().equals("") || Nama.getText().toString().equals("") || Alamat.getText().toString().equals("") || Telepon.getText().toString().equals("")){
                    Toast.makeText(getApplicationContext(), "Mohon isi data terlebih dahulu!", Toast.LENGTH_LONG).show();
                } else {
                    nik = Nik.getText().toString();
                    nama = Nama.getText().toString();
                    alamat = Alamat.getText().toString();
                    telepon = Telepon.getText().toString();
                    HashMap<String, String> values = new HashMap<>();
                    values.put("id_penyewa",id_penyewa);
                    values.put("nik", nik);
                    values.put("nama", nama);
                    values.put("alamat", alamat);
                    values.put("telepon", telepon);
                    controller.UpdateData(values);
                    callHome();
                }
            }
        });
    }

    public void callHome() {
        Intent i = new Intent(UpdatePenyewa.this, LihatPenyewa.class);
        startActivity(i);
        finish();
    }
}