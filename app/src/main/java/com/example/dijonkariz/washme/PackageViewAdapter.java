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
import com.example.dijonkariz.washme.Model.Package;

import java.util.List;

public class PackageViewAdapter extends RecyclerView.Adapter<PackageViewAdapter.PackageViewHolder>
{
    private Context mContext;
    private List<Package> itemList;

    public class PackageViewHolder extends RecyclerView.ViewHolder
    {
        public TextView package_name, price, time_period, details;


        public PackageViewHolder(View view)
        {
            super(view);
            package_name = (TextView) view.findViewById(R.id.package_name);
            price = (TextView) view.findViewById(R.id.package_price);
            time_period = (TextView) view.findViewById(R.id.package_time);
            details = (TextView) view.findViewById(R.id.package_details);

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
    public void onBindViewHolder(@NonNull PackageViewAdapter.PackageViewHolder holder, int position) {
        Package item = itemList.get(position);
        holder.package_name.setText(item.getPackage_name());
        holder.price.setText(item.getPrice());
        holder.time_period.setText(item.getTimePeriod());
        holder.details.setText(item.getDetails());

    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }
}
