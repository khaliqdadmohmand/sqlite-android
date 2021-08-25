package com.aademo.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class ListAdapter extends BaseAdapter {

    ArrayList<DataModel> list;
    Context context;

    public ListAdapter(ArrayList<DataModel> list, Context context) {
        this.list = list;
        this.context = context;
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
        LayoutInflater inflater = LayoutInflater.from(context);
        view = inflater.inflate(R.layout.data_layout, null);
        TextView name = view.findViewById(R.id.tv_name);
        TextView phone = view.findViewById(R.id.tv_phone);
        TextView email = view.findViewById(R.id.tv_email);

        name.setText(list.get(i).getName());
        phone.setText(list.get(i).getPhone());
        email.setText(list.get(i).getEmail());

        return view;
    }
}
