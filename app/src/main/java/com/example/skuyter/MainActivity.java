package com.example.skuyter;

import android.content.Intent;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {

    //deklarasi button, edittext, string
    Button btnlogin;
    EditText ednama, edpassword;
    String nama, password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnlogin=findViewById(R.id.btLogin);
        ednama=findViewById(R.id.edNama);
        edpassword=findViewById(R.id.edPassword);


        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nama = ednama.getText().toString();
                password = edpassword.getText().toString();

                if(nama.equals("skuyter")&& password.equals("skuy")){
                    Toast.makeText(MainActivity.this, "Login Sukses", Toast.LENGTH_SHORT).show();

                    Bundle bn = new Bundle();

                    bn.putString("a", nama.trim());
                    bn.putString("b", password.trim());

                    Intent i = new Intent(MainActivity.this,Menu.class);
                    i.putExtras(bn);
                    startActivity(i);

                } else if (nama.equals("skuyter")&& password.equals(password)){
                    Toast.makeText(MainActivity.this, "Password Salah", Toast.LENGTH_SHORT).show();
                } else if (nama.equals(nama)&& password.equals("skuy")){
                    Toast.makeText(MainActivity.this, "Username Salah", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MainActivity.this, "Username dan Password Salah", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}