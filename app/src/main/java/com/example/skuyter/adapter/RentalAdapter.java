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

import com.example.skuyter.LihatRental;
import com.example.skuyter.R;
import com.example.skuyter.UpdateRental;
import com.example.skuyter.db.Rental;
import com.example.skuyter.db.database;

import java.util.ArrayList;
import java.util.HashMap;

public class RentalAdapter extends RecyclerView.Adapter<RentalAdapter.RentalViewHolder> {

    private ArrayList<Rental> listData;
    private Context control;

    public RentalAdapter(ArrayList<Rental> listData) {

        this.listData = listData;
    }

    @Override
    public RentalAdapter.RentalViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInf = LayoutInflater.from(parent.getContext());
        View view = layoutInf.inflate(R.layout.row_data_rental, parent,false);
        control = parent.getContext();
        return new RentalViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RentalAdapter.RentalViewHolder holder, int position) {
        String id, nama, tanggal, durasi, waktu;

        id = listData.get(position).getId();
        nama = listData.get(position).getNama();
        tanggal = listData.get(position).getTanggal();
        durasi = listData.get(position).getDurasi();
        waktu = listData.get(position).getWaktu();
        database db = new database(control);

        holder.namaTxt.setTextColor(Color.BLUE);
        holder.namaTxt.setTextSize(20);
        holder.idTxt.setText(id);
        holder.namaTxt.setText(nama);
        holder.tanggalTxt.setText(tanggal);
        holder.durasiTxt.setText(durasi);
        holder.waktuTxt.setText(waktu);

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
                                Intent i = new Intent(control, UpdateRental.class);
                                i.putExtra("id", id);
                                i.putExtra("nama", nama);
                                i.putExtra("tanggal", tanggal);
                                i.putExtra("durasi", durasi);
                                i.putExtra("waktu", waktu);
                                control.startActivity(i);
                                break;
                            case R.id.mnHapus:
                                HashMap<String, String> values = new HashMap<>();
                                values.put("id", id);
                                db.DeleteData(values);
                                Intent j = new Intent(control, LihatRental.class);
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

    public class RentalViewHolder extends RecyclerView.ViewHolder {
        private CardView cardku;
        private TextView idTxt, namaTxt, tanggalTxt, durasiTxt, waktuTxt;
        public RentalViewHolder(View view) {
            super(view);
            cardku = (CardView) view.findViewById(R.id.kartuku);
            idTxt = (TextView) view.findViewById(R.id.textId);
            namaTxt = (TextView) view.findViewById(R.id.textNama);
            tanggalTxt = (TextView) view.findViewById(R.id.textTanggal);
            durasiTxt = (TextView) view.findViewById(R.id.textDurasi);
            waktuTxt = (TextView) view.findViewById(R.id.textWaktu);
        }
    }
}
