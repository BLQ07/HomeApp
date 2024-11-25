package com.example.home.Settings;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.home.R;
import com.parse.ParseObject;
import com.parse.ParseQuery;

import java.util.ArrayList;
import java.util.List;

public class EditBird extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_bird);
        RecyclerView recyclerView = new RecyclerView(this);
        GridLayoutManager layoutManager = new GridLayoutManager(this, 5);
        recyclerView.setLayoutManager(layoutManager);
        List<String> data = new ArrayList<>();


        TableAdapter tableAdapter = new TableAdapter(data);
        recyclerView.setAdapter(tableAdapter);
        setContentView(recyclerView);

    }
    List<String> data (){
        ParseQuery query = ParseQuery.getQuery("Bird");
        query.findInBackground();

        return null;
    }
}