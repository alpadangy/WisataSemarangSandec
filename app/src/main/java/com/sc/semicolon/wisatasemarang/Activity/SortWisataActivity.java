package com.sc.semicolon.wisatasemarang.Activity;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.sc.semicolon.wisatasemarang.Adapter.SpinnerAdapter;
import com.sc.semicolon.wisatasemarang.R;

import java.util.ArrayList;

public class SortWisataActivity extends AppCompatActivity {
    private Spinner spnKota;
    private RecyclerView recyclerview;
    private SwipeRefreshLayout swipe;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sort_wisata);
        initView();

        ArrayList<String> listKota = new ArrayList<>();
        listKota.add("Semua");
        listKota.add("Semarang");
        listKota.add("Yogyakarta");
        SpinnerAdapter adapter = new SpinnerAdapter(this,listKota);
        spnKota.setAdapter(adapter);
    }

    private void initView() {
        spnKota = findViewById(R.id.spn_kota);
        recyclerview = findViewById(R.id.recyclerview);
        swipe = findViewById(R.id.swipe);
    }
}
