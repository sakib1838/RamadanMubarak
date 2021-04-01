package com.example.ramadanmubarak.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ramadanmubarak.BackendClass.Ramadan;
import com.example.ramadanmubarak.R;

import java.util.ArrayList;

public class RecyclerViewRamadanList extends RecyclerView.Adapter<RecyclerViewRamadanList.ViewHolder> {

    private ArrayList<Ramadan>ramadanArrayList;
    private Context context;
    public RecyclerViewRamadanList(ArrayList<Ramadan>ramadanArrayList,Context context){
        this.ramadanArrayList=ramadanArrayList;
        this.context=context;
    }

    @NonNull
    @Override
    public RecyclerViewRamadanList.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_item,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewRamadanList.ViewHolder holder, int position) {
        holder.dayOfRamadan.setText(ramadanArrayList.get(position).getRamadanDay());
        holder.dateOfRamadanDay.setText(ramadanArrayList.get(position).getDate());
        holder.nameOfDay.setText(ramadanArrayList.get(position).getDay());
        holder.sehriTime.setText(ramadanArrayList.get(position).getSehar());
        holder.iftarTime.setText(ramadanArrayList.get(position).getIftar());
    }

    @Override
    public int getItemCount() {
        return ramadanArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView dayOfRamadan,dateOfRamadanDay,nameOfDay,sehriTime,iftarTime;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            dayOfRamadan=itemView.findViewById(R.id.dayOfRamadan);
            dateOfRamadanDay=itemView.findViewById(R.id.dateOfRamadanDay);
            nameOfDay=itemView.findViewById(R.id.nameOfDay);
            sehriTime=itemView.findViewById(R.id.sehriTime);
            iftarTime=itemView.findViewById(R.id.iftarTime);
        }
    }
}
