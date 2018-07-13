package com.sc.semicolon.wisatasemarang.Adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.sc.semicolon.wisatasemarang.Activity.DetailActivity;
import com.sc.semicolon.wisatasemarang.Model.WisataModel;
import com.sc.semicolon.wisatasemarang.R;

import java.util.ArrayList;

/**
 * Created by cis on 01/06/2018.
 */

public class WisataAdapter extends RecyclerView.Adapter<WisataAdapter.WisataHolder> {

    ArrayList<WisataModel> list;
    Context context;

    public WisataAdapter(ArrayList<WisataModel> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public WisataHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_wisata, parent, false);
        WisataHolder holder = new WisataHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(WisataHolder holder, int position) {
        holder.tvWisata.setText(list.get(position).getNamaWisata());
        Glide.with(context)
                .load("http://seputarwisatasemarang.000webhostapp.com/api/wisata/img/"+list.get(position).getGambarWisata())
                .error(R.drawable.ic_launcher_background)
                .into(holder.imgWisata);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class WisataHolder extends RecyclerView.ViewHolder{

        ImageView imgWisata;
        TextView tvWisata;
        WisataModel wm;
        public WisataHolder(View itemView) {
            super(itemView);

            imgWisata = itemView.findViewById(R.id.img_wisata);
            tvWisata = itemView.findViewById(R.id.tv_wisata);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(context, DetailActivity.class);
                    intent.putParcelableArrayListExtra("list",list);
                    intent.putExtra("position",getAdapterPosition());
                    context.startActivity(intent);
                }
            });
        }
    }
}
