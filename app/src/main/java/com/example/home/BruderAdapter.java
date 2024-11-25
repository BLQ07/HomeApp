package com.example.home;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;
public class BruderAdapter extends RecyclerView.Adapter<BruderAdapter.BruderViewHolder> {

    private final List<Bruder> BruderList;
    private final Context context;

    public BruderAdapter(List<Bruder> BruderList, Context context) {
        this.BruderList = BruderList;
        this.context = context;
    }


    @NonNull
    @Override
    public BruderViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.simple_item_1, parent, false);
        return new BruderViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BruderViewHolder holder, int position) {
        Bruder Bruder = BruderList.get(position);
        holder.nameTextView.setText(Bruder.getName());
        holder.tempTextView.setText("Temp: " + Bruder.getTemperature());
        holder.humTextView.setText("Hum: " + Bruder.getHumidity());
        holder.sizeTextView.setText("Size: " + Bruder.getSize());
        holder.itemView.setOnClickListener(v -> {
            Intent intent = new Intent(context, BruderActivity.class);
            intent.putExtra("id", Bruder.getId());
            context.startActivity(intent);
        });




    }

    @Override
    public int getItemCount() {
        return BruderList.size();
    }

    static class BruderViewHolder extends RecyclerView.ViewHolder {
        TextView nameTextView;
        TextView tempTextView;
        TextView humTextView;
        TextView sizeTextView;
        ImageView imageView;


        public BruderViewHolder(@NonNull View itemView) {
            super(itemView);
            nameTextView = itemView.findViewById(R.id.textView4);
            tempTextView = itemView.findViewById(R.id.textView5);
            humTextView = itemView.findViewById(R.id.textView6);
            sizeTextView = itemView.findViewById(R.id.textView7);
            imageView = itemView.findViewById(R.id.imageView);





        }
    }
}
