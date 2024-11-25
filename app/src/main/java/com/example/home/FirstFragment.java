package com.example.home;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class FirstFragment extends Fragment {
    private List<Incubator> incubatorList;
    private IncubatorAdapter adapter;
    private IncubatorManager repository;
    Context context;
    public FirstFragment(Context context) {
       this.context = context;

    }
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return initIncubatorList();
    }
    RecyclerView initIncubatorList() {
        RecyclerView recyclerView = new RecyclerView(context);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(context, 2);
        recyclerView.setLayoutManager(gridLayoutManager);
        incubatorList = new ArrayList<>();
        adapter = new IncubatorAdapter(incubatorList, context);
        recyclerView.setAdapter(adapter);
        repository = new IncubatorManager();
        fetchIncubators();
        return recyclerView;
    } @SuppressLint("NotifyDataSetChanged")
    private void fetchIncubators() {
        repository.readIncubators((incubators, e) -> {
            if (e == null) {
                incubatorList.clear();
                incubatorList.addAll(incubators);
                adapter.notifyDataSetChanged();
            }
        });
    }
}
