package com.sc.semicolon.wisatasemarang.Activity;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.sc.semicolon.wisatasemarang.Adapter.WisataAdapter;
import com.sc.semicolon.wisatasemarang.Model.WisataModel;
import com.sc.semicolon.wisatasemarang.R;
import com.sc.semicolon.wisatasemarang.Retrofit.ApiService;
import com.sc.semicolon.wisatasemarang.Retrofit.Client;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    SwipeRefreshLayout swipe;
    LinearLayout cardBudaya;
    LinearLayout cardAlam;
    FloatingActionButton fabTambah;

    RecyclerView.Adapter mAdapter;
    RecyclerView.LayoutManager layoutManager;
    ArrayList<WisataModel> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.rv);
        swipe = findViewById(R.id.swipe);
        cardAlam = findViewById(R.id.card_alam);
        cardBudaya = findViewById(R.id.card_budaya);
        fabTambah = findViewById(R.id.fab_tambah);

        layoutManager = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);
        getWisata();

        //Ini akan bekerja ketika menarik dan terjadi refresh
        swipe.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                getWisata();
            }
        });

        //digunakan untuk handler ketika "Budaya" ditekan
        cardBudaya.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, SortWisataActivity.class);
                startActivity(intent);
                Toast.makeText(MainActivity.this, "Maaf Belum Tersedia", Toast.LENGTH_SHORT).show();
            }
        });

        //digunakan untuk handler ketika "Alam" ditekan
        cardAlam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Maaf Belum Tersedia", Toast.LENGTH_SHORT).show();
            }
        });

        //digunakan untuk handler ketika "+" ditekan
        fabTambah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Maaf Belum Tersedia", Toast.LENGTH_SHORT).show();
            }
        });
    }

    /*Method ini digunakan untuk mendapatkan daftar wisata dari server
    *
    * */
    private void getWisata(){
        swipe.setRefreshing(true);
        ApiService apiService = Client.getInstanceRetrofit();
        apiService.getWisata().enqueue(new Callback<ArrayList<WisataModel>>() {
            @Override
            public void onResponse(Call<ArrayList<WisataModel>> call, Response<ArrayList<WisataModel>> response) {
                if (response.isSuccessful()){
                    swipe.setRefreshing(false);
                    list = response.body();
                    mAdapter = new WisataAdapter(list,MainActivity.this);
                    recyclerView.setAdapter(mAdapter);
                    mAdapter.notifyDataSetChanged();
                    swipe.setRefreshing(false);
                }
            }

            @Override
            public void onFailure(Call<ArrayList<WisataModel>> call, Throwable t) {
                swipe.setRefreshing(false);
                Toast.makeText(MainActivity.this, ""+t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
