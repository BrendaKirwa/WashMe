package com.example.dijonkariz.washme;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

public class VehicleViewAdapter extends RecyclerView.Adapter<VehicleViewAdapter.VehicleViewHolder>
{
    private Context mContext;
    private List<Item> itemList;

    public class VehicleViewHolder extends RecyclerView.ViewHolder
    {
        public TextView vehicle_name;
        public ImageView vehicle_pic;

        public VehicleViewHolder(View view)
        {
            super(view);
            vehicle_name = (TextView) view.findViewById(R.id.vehicle_name);
            vehicle_pic = (ImageView) view.findViewById(R.id.vehicle_pic);
        }
    }
    public VehicleViewAdapter(Context mContext, List<Item> itemList)
    {
        this.mContext = mContext;
        this.itemList = itemList;
    }

    @NonNull
    @Override
    public VehicleViewAdapter.VehicleViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.vehicles, parent, false);
        return new VehicleViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull VehicleViewAdapter.VehicleViewHolder holder, int position) {
        Item item = itemList.get(position);
        holder.vehicle_name.setText(item.getName());
        Glide.with(mContext).load(item.getPic()).into(holder.vehicle_pic);
    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }
}
