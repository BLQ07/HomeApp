package com.example.home.First;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.home.R;

import java.util.List;

public class IncubatorAdapter extends RecyclerView.Adapter<IncubatorAdapter.IncubatorViewHolder> {

    private final List<Incubator> incubatorList;
    private final Context context;

    public IncubatorAdapter(List<Incubator> incubatorList, Context context) {
        this.incubatorList = incubatorList;
        this.context = context;
    }

    @NonNull
    @Override
    public IncubatorViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.simple_item_1, parent, false);
        return new IncubatorViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull IncubatorViewHolder holder, int position) {
        Incubator incubator = incubatorList.get(position);
        holder.nameTextView.setText(incubator.getName());
        holder.tempTextView.setText("Temp: " + incubator.getTemperature());
        holder.humTextView.setText("Hum: " + incubator.getHumidity());
        holder.sizeTextView.setText("Size: " + incubator.getSize());
        holder.itemView.setOnClickListener(v -> {
            Intent intent = new Intent(context, IncubatorActivity.class);
            intent.putExtra("id", incubator.getId());
            context.startActivity(intent);
        });




    }

    @Override
    public int getItemCount() {
        return incubatorList.size();
    }

    static class IncubatorViewHolder extends RecyclerView.ViewHolder {
        TextView nameTextView;
        TextView tempTextView;
        TextView humTextView;
        TextView sizeTextView;
        ImageView imageView;


        public IncubatorViewHolder(@NonNull View itemView) {
            super(itemView);
            nameTextView = itemView.findViewById(R.id.textView4);
            tempTextView = itemView.findViewById(R.id.textView5);
            humTextView = itemView.findViewById(R.id.textView6);
            sizeTextView = itemView.findViewById(R.id.textView7);
            imageView = itemView.findViewById(R.id.imageView);





        }
    }
}
