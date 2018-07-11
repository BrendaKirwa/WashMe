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

import com.bumptech.glide.Glide;
import com.example.dijonkariz.washme.Model.Package;

import java.util.List;

public class PackageViewAdapter extends RecyclerView.Adapter<PackageViewAdapter.PackageViewHolder>
{
    private Context mContext;
    private List<Package> itemList;

    public class PackageViewHolder extends RecyclerView.ViewHolder
    {
        public TextView package_name, price, time_period, details,id;
        CardView cardView;

        public PackageViewHolder(View view)
        {
            super(view);
            cardView = (CardView) view.findViewById(R.id.cardview_package);
            package_name = (TextView) view.findViewById(R.id.package_name);
            price = (TextView) view.findViewById(R.id.package_price);
            time_period = (TextView) view.findViewById(R.id.package_time);
            details = (TextView) view.findViewById(R.id.package_details);
            id = (TextView) view.findViewById(R.id.package_id);

        }
    }
    public PackageViewAdapter(Context mContext, List<Package> itemList)
    {
        this.mContext = mContext;
        this.itemList = itemList;
    }

    @NonNull
    @Override
    public PackageViewAdapter.PackageViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.packages, parent, false);
        return new PackageViewAdapter.PackageViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull PackageViewAdapter.PackageViewHolder holder, final int position) {
        Package item = itemList.get(position);
        holder.id.setText(item.getId());
        holder.package_name.setText(item.getPackage_name());
        holder.price.setText(item.getPrice());
        holder.time_period.setText(item.getTimePeriod());
        holder.details.setText(item.getDetails());
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, finishBooking.class);
                intent.putExtra("Vehicle_id", itemList.get(position).getId());
                mContext.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }
}
