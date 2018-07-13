package com.sc.semicolon.wisatasemarang.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.sc.semicolon.wisatasemarang.R;

import java.util.ArrayList;

/**
 * Created by ASUS on 13/07/2018.
 */

public class SpinnerAdapter extends BaseAdapter {
    Context context;
    ArrayList<String> list;

    public SpinnerAdapter(Context context, ArrayList<String> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        view = LayoutInflater.from(context).inflate(R.layout.row_spinner,null);
        TextView textView = view.findViewById(R.id.textview);
        textView.setText(list.get(i));
        return view;
    }
}
