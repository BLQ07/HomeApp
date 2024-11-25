package com.example.home;

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

public class SecondFragment extends Fragment {
    public SecondFragment(Context context) {
this.context = context;
    }
    Context context;
    private List<Bruder> bruderList;
    private BruderAdapter bruderAdapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return initBruderList();
    } RecyclerView initBruderList() {
        RecyclerView recyclerView = new RecyclerView(context);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(context, 2);
        recyclerView.setLayoutManager(gridLayoutManager);
        bruderList = new ArrayList<>();
        bruderAdapter = new BruderAdapter(bruderList, context);

        return recyclerView;
    }
}
