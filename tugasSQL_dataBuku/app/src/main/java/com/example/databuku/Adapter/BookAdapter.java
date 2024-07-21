package com.example.databuku.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.databuku.R;

import java.util.ArrayList;

public class BookAdapter extends BaseAdapter {

    Context context;
    LayoutInflater inflater;
    ArrayList<GetData> model;
    public BookAdapter(Context context, ArrayList<GetData> model){
        inflater = LayoutInflater.from(context);
        this.context = context;
        this.model = model;
    }

    @Override
    public int getCount() {
        return model.size();
    }

    @Override
    public Object getItem(int position) {
        return model.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        TextView judul,penulis,tahun;
        View view1 = inflater.inflate(R.layout.list_buku, null);
        if(view1!=null){
            judul = view1.findViewById(R.id.OutJudul);
            penulis = view1.findViewById(R.id.OutPenulis);
            tahun = view1.findViewById(R.id.OutTahun);

            judul.setText(model.get(position).getJudul());
            penulis.setText(model.get(position).getPenulis());
            tahun.setText(model.get(position).getTahun());
        }
        return view1;
    }
}
