package com.example.home;


import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private IncubatorAdapter adapter;
    private List<Incubator> incubatorList;

    private IncubatorManager repository;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        init();
        initIncubatorList();

    }
    @SuppressLint("SetTextI18n")
    public LinearLayout init() {
        LinearLayout layout =new LinearLayout(this);
        setContentView(layout);
        layout.setOrientation(LinearLayout.VERTICAL);
        LinearLayout layout2 =new LinearLayout(this);
        layout2.setOrientation(LinearLayout.HORIZONTAL);
        Button b1 = new Button(this);
        b1.setText("Incubator");
        b1.setOnClickListener(this);
        b1.setTag(1);
        layout2.addView(b1);
        Button b2 = new Button(this);
        b2.setText("Выводной");
        b2.setOnClickListener(this);
        b2.setTag(2);
        layout2.addView(b2);
        layout.addView(layout2);

        return layout2;
    }
    RecyclerView initIncubatorList() {
        RecyclerView recyclerView = new RecyclerView(this);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 2);
        recyclerView.setLayoutManager(gridLayoutManager);
        incubatorList = new ArrayList<>();
        adapter = new IncubatorAdapter(incubatorList, this);
        recyclerView.setAdapter(adapter);
        repository = new IncubatorManager();
        fetchIncubators();
        return recyclerView;
    }
    RecyclerView initBruderList() {
        RecyclerView recyclerView = new RecyclerView(this);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 2);
        recyclerView.setLayoutManager(gridLayoutManager);

        return recyclerView;
    }



    @SuppressLint("NotifyDataSetChanged")
    private void fetchIncubators() {
        repository.readIncubators((incubators, e) -> {
            if (e == null) {
                incubatorList.clear();
                incubatorList.addAll(incubators);
                adapter.notifyDataSetChanged();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.context_menu, menu);
        return true;



}

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.edit) {
            Intent intent = new Intent(this, SettingsActivity.class);
            startActivity(intent);
        }

        if (item.getItemId() == R.id.update) {
            fetchIncubators();
        }
        return super.onContextItemSelected(item);

    }



    @Override
    public void onClick(View v) {
        LinearLayout layout = init();
        layout.removeAllViews();
    switch (v.getTag().toString()) {
        case "1":
           layout.addView(initIncubatorList());
            break;
        case "2":

            break;
    }
    }
}






