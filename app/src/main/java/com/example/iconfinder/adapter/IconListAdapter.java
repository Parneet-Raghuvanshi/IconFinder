package com.example.iconfinder.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Environment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.iconfinder.R;
import com.example.iconfinder.models.IconModel;

import java.io.File;
import java.io.FileOutputStream;
import java.util.List;
import java.util.concurrent.ExecutionException;

public class IconListAdapter extends RecyclerView.Adapter<IconListAdapter.MyViewHolder> {

    private Context context;
    private List<IconModel> list;

    public IconListAdapter(Context context, List<IconModel> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyViewHolder(LayoutInflater.from(context).inflate(R.layout.icon_layout,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        IconModel tempIcon = this.list.get(position);
        Glide.with(context).load(this.list.get(position).getPreviewUrl()).into(holder.iconImage);
        if(this.list.get(position).isPremium()){
            holder.isPrime.setVisibility(View.VISIBLE);
        }
        else {
            holder.isPrime.setVisibility(View.GONE);
        }
        holder.mainCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Runnable runnable = new Runnable() {
                    @Override
                    public void run() {
                        try {
                            Bitmap  bitmap = Glide.with(context).asBitmap().load(tempIcon.getPreviewUrl()).into(100,100).get();
                            SaveImage(bitmap,tempIcon.getName());
                        } catch (ExecutionException | InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                };
                Thread t = new Thread(runnable);
                t.start();
            }
        });
    }

    @Override
    public int getItemCount() {
        if (this.list != null){
            return  this.list.size();
        }
        return 0;
    }

    private static void SaveImage(Bitmap finalBitmap,String name) {

        File myDir= Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES);

        String fname = "Image-"+name+".png";
        File file = new File (myDir, fname);
        if (file.exists ()) file.delete ();
        try {
            FileOutputStream out = new FileOutputStream(file);
            finalBitmap.compress(Bitmap.CompressFormat.PNG, 90, out);
            out.flush();
            out.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public class MyViewHolder extends RecyclerView.ViewHolder {

        ImageView iconImage;
        ImageView isPrime;
        CardView mainCard;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            iconImage = itemView.findViewById(R.id.icon_image);
            isPrime = itemView.findViewById(R.id.prime_star);
            mainCard = itemView.findViewById(R.id.main_card);
        }
    }
}
