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
import com.example.dijonkariz.washme.Model.Service;

import java.util.List;

public class ServiceViewAdapter  extends RecyclerView.Adapter<ServiceViewAdapter.ServiceViewHolder>
{
    private Context mContext;
    private List<Service> itemList;

    public class ServiceViewHolder extends RecyclerView.ViewHolder
    {
        public TextView service_name, price, duration, details;


        public ServiceViewHolder(View view)
        {
            super(view);
            service_name = (TextView) view.findViewById(R.id.service_name);
            price = (TextView) view.findViewById(R.id.service_price);
            duration = (TextView) view.findViewById(R.id.duration);
            details = (TextView) view.findViewById(R.id.service_details);
        }
    }
    public ServiceViewAdapter(Context mContext, List<Service> itemList)
    {
        this.mContext = mContext;
        this.itemList = itemList;
    }

    @NonNull
    @Override
    public ServiceViewAdapter.ServiceViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.services, parent, false);
        return new ServiceViewAdapter.ServiceViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ServiceViewAdapter.ServiceViewHolder holder, int position) {
        Service item = itemList.get(position);
        holder.service_name.setText(item.getServiceName());
        holder.price.setText(item.getPrice());
        holder.duration.setText(item.getDuration());
        holder.details.setText(item.getDetails());
    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }
}
