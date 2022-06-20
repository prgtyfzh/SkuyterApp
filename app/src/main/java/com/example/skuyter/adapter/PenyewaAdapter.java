package com.example.skuyter.adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;

import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupMenu;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.skuyter.LihatPenyewa;
import com.example.skuyter.R;
import com.example.skuyter.UpdatePenyewa;
import com.example.skuyter.db.Penyewa;
import com.example.skuyter.db.database;

import java.util.ArrayList;
import java.util.HashMap;


public class PenyewaAdapter extends RecyclerView.Adapter<PenyewaAdapter.PenyewaViewHolder> {

    private ArrayList<Penyewa> listData;
    private Context control;

    public PenyewaAdapter(ArrayList<Penyewa> listData) {

        this.listData = listData;
    }

    @Override
    public PenyewaAdapter.PenyewaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInf = LayoutInflater.from(parent.getContext());
        View view = layoutInf.inflate(R.layout.row_data_penyewa, parent,false);
        control = parent.getContext();
        return new PenyewaViewHolder(view);
    }

    @Override
    public void onBindViewHolder(PenyewaAdapter.PenyewaViewHolder holder, int position) {
        String id_penyewa,nik, nama, alamat, telepon;

        id_penyewa = listData.get(position).getId_penyewa();
        nik = listData.get(position).getNik();
        nama = listData.get(position).getNama();
        alamat = listData.get(position).getAlamat();
        telepon = listData.get(position).getTelepon();
        database db = new database(control);

        holder.namaTxt.setTextColor(Color.BLUE);
        holder.namaTxt.setTextSize(20);
        holder.nikTxt.setText(nik);
        holder.namaTxt.setText(nama);
        holder.alamatTxt.setText(alamat);
        holder.teleponTxt.setText(telepon);

        holder.cardku.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                PopupMenu popupMenu = new PopupMenu(control, holder.cardku);
                popupMenu.inflate(R.menu.menu);
                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem Item) {
                        switch (Item.getItemId()) {
                            case R.id.mnEdit:
                                Intent i = new Intent(control, UpdatePenyewa.class);
                                i.putExtra("id_penyewa",id_penyewa);
                                i.putExtra("nik", nik);
                                i.putExtra("nama", nama);
                                i.putExtra("alamat", alamat);
                                i.putExtra("telpon", telepon);
                                control.startActivity(i);
                                break;
                            case R.id.mnHapus:
                                HashMap<String, String> values = new HashMap<>();
                                values.put("id_penyewa", id_penyewa);
                                db.DeleteData(values);
                                Intent j = new Intent(control, LihatPenyewa.class);
                                control.startActivity(j);
                                break;
                        }
                        return true;
                    }
                });
                popupMenu.show();
                return false;
            }
        });
    }

    @Override
    public int getItemCount() {
        return (listData != null)?listData.size() : 0;
    }

    public class PenyewaViewHolder extends RecyclerView.ViewHolder {
        private CardView cardku;
        private TextView nikTxt, namaTxt, alamatTxt, teleponTxt;
        public PenyewaViewHolder(View view) {
            super(view);
            cardku = (CardView) view.findViewById(R.id.kartuku);
            nikTxt = (TextView) view.findViewById(R.id.textNik);
            namaTxt = (TextView) view.findViewById(R.id.textNama);
            alamatTxt = (TextView) view.findViewById(R.id.textAlamat);
            teleponTxt = (TextView) view.findViewById(R.id.textTelepon);
        }
    }
}
