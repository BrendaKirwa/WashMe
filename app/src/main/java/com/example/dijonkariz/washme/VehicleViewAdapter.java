package com.example.dijonkariz.washme;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.dijonkariz.washme.Model.Vehicle;

import java.util.List;

public class VehicleViewAdapter extends RecyclerView.Adapter<VehicleViewAdapter.VehicleViewHolder>
{
    private Context mContext;
    private List<Vehicle> itemList;

    public class VehicleViewHolder extends RecyclerView.ViewHolder
    {
        public TextView vehicle_name;
        public ImageView vehicle_pic;
        CardView cardView;

        public VehicleViewHolder(View view)
        {
            super(view);
            cardView = (CardView) view.findViewById(R.id.cardview_vehicles);
            vehicle_name = (TextView) view.findViewById(R.id.vehicle_name);
            vehicle_pic = (ImageView) view.findViewById(R.id.vehicle_image);

        }
    }
    public VehicleViewAdapter(Context mContext, List<Vehicle> itemList)
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
        Vehicle item = itemList.get(position);
        holder.vehicle_name.setText(item.getVehicleName());
        Glide.with(mContext).load(item.getVehicleImage()).into(holder.vehicle_pic);
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(mContext, R.string.toast_vehicle_type, Toast.LENGTH_SHORT).show();
//                Intent intent = new Intent(mContext, finishBooking.class);
//                intent.putExtra("Vehicle_id", itemList.get(position).getId());
//                mContext.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }
}
