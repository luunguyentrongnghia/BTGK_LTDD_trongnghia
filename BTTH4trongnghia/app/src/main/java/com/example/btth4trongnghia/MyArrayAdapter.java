package com.example.btth4trongnghia;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class MyArrayAdapter extends ArrayAdapter<Oto> {
    Activity context;
    int IdLayout;
    ArrayList<Oto> myList;

    public MyArrayAdapter(Activity context, int idLayout, ArrayList<Oto> myList) {
        super(context, idLayout,myList);
        this.context = context;
        IdLayout = idLayout;
        this.myList = myList;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater myflater = context.getLayoutInflater();
        convertView = myflater.inflate(IdLayout,null);
        Oto myoto =myList.get(position);
        ImageView img_oto = convertView.findViewById(R.id.img_oto);
        img_oto.setImageResource(myoto.getImage());
        TextView txt_oto=convertView.findViewById(R.id.txt_oto);
        txt_oto.setText(myoto.getName());
        return convertView;
    }
}
