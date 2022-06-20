package com.example.skuyter;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class Menu extends AppCompatActivity {

    ImageView dp, ir;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        dp = findViewById(R.id.datapenyewa);

        //memanggil bundle dari data penyewa
        dp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Menu.this, LihatPenyewa.class);
                startActivity(i);
            }
        });

        ir = findViewById(R.id.inforental);

        ir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Menu.this, LihatRental.class);
                startActivity(i);
            }
        });
    }
}