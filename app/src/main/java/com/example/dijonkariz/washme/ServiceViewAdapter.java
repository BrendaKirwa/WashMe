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

public class ServiceViewAdapter  extends RecyclerView.Adapter<ServiceViewAdapter.ServiceViewHolder>
{
    private Context mContext;
    private List<Item> itemList;

    public class ServiceViewHolder extends RecyclerView.ViewHolder
    {
        public TextView service_name;
//        public ImageView service_pic;

        public ServiceViewHolder(View view)
        {
            super(view);
            service_name = (TextView) view.findViewById(R.id.service_name);
//            service_pic = (ImageView) view.findViewById(R.id.service_pic);
        }
    }
    public ServiceViewAdapter(Context mContext, List<Item> itemList)
    {
        this.mContext = mContext;
        this.itemList = itemList;
    }

    @NonNull
    @Override
    public ServiceViewAdapter.ServiceViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.packages, parent, false);
        return new ServiceViewAdapter.ServiceViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ServiceViewAdapter.ServiceViewHolder holder, int position) {
        Item item = itemList.get(position);
        holder.service_name.setText(item.getName());
//        Glide.with(mContext).load(item.getPic()).into(holder.service_pic);
    }

    @Override
    public int getItemCount() {
        return 0;
    }
}
