package com.sc.semicolon.wisatasemarang.Activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.sc.semicolon.wisatasemarang.Model.WisataModel;
import com.sc.semicolon.wisatasemarang.R;

import java.util.ArrayList;

public class DetailActivity extends AppCompatActivity {

    private TextView tvNama;
    private TextView tvDeskripsi;
    private TextView tvAlamat;
    private ImageView imgWisata;

    ArrayList<WisataModel> list;
    int position;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        initView();

        list = getIntent().getParcelableArrayListExtra("list");
        position = getIntent().getIntExtra("position",-1);

        //Pada bagian ini kita akan menampilkan detail tempat wisata yang tadi dipilih
        tvNama.setText(list.get(position).getNamaWisata());
        tvDeskripsi.setText(list.get(position).getDeskripsiWisata());
        Glide.with(this)
                .load("http://seputarwisatasemarang.000webhostapp.com/api/wisata/img/"+list.get(position).getGambarWisata())
                .error(R.drawable.ic_launcher_background)
                .into(imgWisata);

    }

    private void initView() {
        tvNama = (TextView) findViewById(R.id.tv_nama);
        tvDeskripsi = (TextView) findViewById(R.id.tv_deskripsi);
        tvAlamat = (TextView) findViewById(R.id.tv_alamat);
        imgWisata = (ImageView) findViewById(R.id.img_wisata);
    }
}
