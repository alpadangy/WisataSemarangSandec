package com.sc.semicolon.wisatasemarang;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class DetailActivity extends AppCompatActivity {

    private TextView tvNama;
    private TextView tvDeskripsi;
    private TextView tvAlamat;
    private ImageView imgWisata;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        initView();

        Awal();
    }

    private void Awal() {
        tvNama.setText(getIntent().getStringExtra("nama"));
        tvDeskripsi.setText(getIntent().getStringExtra("deskripsi"));
        tvAlamat.setText(getIntent().getStringExtra("alamat"));
        Glide.with(getApplicationContext())
                .load(getIntent().getStringExtra("gambar"))
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
