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

public class PackageViewAdapter extends RecyclerView.Adapter<PackageViewAdapter.PackageViewHolder>
{
    private Context mContext;
    private List<Item> itemList;

    public class PackageViewHolder extends RecyclerView.ViewHolder
    {
        public TextView package_name;
//        public ImageView package_pic;

        public PackageViewHolder(View view)
        {
            super(view);
            package_name = (TextView) view.findViewById(R.id.package_name);
//            package_pic = (ImageView) view.findViewById(R.id.package_pic);
        }
    }
    public PackageViewAdapter(Context mContext, List<Item> itemList)
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
        Item item = itemList.get(position);
        holder.package_name.setText(item.getName());
//        Glide.with(mContext).load(item.getPic()).into(holder.package_pic);
    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }
}
