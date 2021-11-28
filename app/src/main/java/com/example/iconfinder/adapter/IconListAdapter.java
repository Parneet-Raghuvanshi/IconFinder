package com.example.iconfinder.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.iconfinder.R;
import com.example.iconfinder.models.IconModel;

import java.util.List;

public class IconListAdapter extends RecyclerView.Adapter<IconListAdapter.MyViewHolder> {

    private Context context;
    private List<IconModel> list;

    public IconListAdapter(Context context, List<IconModel> list) {
        this.context = context;
        this.list = list;
    }

    public void setIconList(List<IconModel> list) {
        this.list = list;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyViewHolder(LayoutInflater.from(context).inflate(R.layout.icon_layout,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Glide.with(context).load(this.list.get(position).getPreviewUrl()).into(holder.iconImage);
        if(this.list.get(position).isPremium()){
            holder.isPrime.setVisibility(View.VISIBLE);
        }
        else {
            holder.isPrime.setVisibility(View.GONE);
        }
    }

    @Override
    public int getItemCount() {
        if (this.list != null){
            return  this.list.size();
        }
        return 0;
    }


    public class MyViewHolder extends RecyclerView.ViewHolder {

        ImageView iconImage;
        ImageView isPrime;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            iconImage = itemView.findViewById(R.id.icon_image);
            isPrime = itemView.findViewById(R.id.prime_star);
        }
    }
}
