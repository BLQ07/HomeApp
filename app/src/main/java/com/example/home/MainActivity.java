package com.example.home;


import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {
    private IncubatorAdapter adapter;
    private List<Incubator> incubatorList;
    private IncubatorManager repository;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        RecyclerView recyclerView = new RecyclerView(this);
        setContentView(recyclerView);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 2);
        recyclerView.setLayoutManager(gridLayoutManager);
        incubatorList = new ArrayList<>();
        adapter = new IncubatorAdapter(incubatorList, this);

        recyclerView.setAdapter(adapter);

        repository = new IncubatorManager();



        fetchIncubators();
    }

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

    private void updateIncubator(String id, int size, String newName, Double newTemperature, Double newHumidity, String newImage) {
        repository.updateIncubator(id, size, newName, newTemperature, newHumidity, newImage, e -> fetchIncubators());
    }


    private void deleteIncubator(String id) {
        repository.deleteIncubator(id, e -> fetchIncubators());
    }
}






