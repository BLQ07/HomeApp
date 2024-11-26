package com.example.home.Settings;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.home.R;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;

import java.util.ArrayList;
import java.util.List;

public class EditBird extends AppCompatActivity {
    TableAdapter tableAdapter;

    @SuppressLint("NotifyDataSetChanged")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_bird);
        RecyclerView recyclerView = new RecyclerView(this);
        GridLayoutManager layoutManager = new GridLayoutManager(this, 6);
        recyclerView.setLayoutManager(layoutManager);
        List<String> data = new ArrayList<>();
data ((incubators, e) -> {
    if (e == null) {
        for (ParseObject object : incubators) {
            data.add(object.getString("name"));
            data.add(object.getObjectId());
            data.add(object.getInt("maxTemp")+"");
            data.add(object.getInt("humidity")+"");
            data.add(object.getString("day"));
            tableAdapter.notifyDataSetChanged();

        }}});


        tableAdapter = new TableAdapter(data);
        recyclerView.setAdapter(tableAdapter);
        setContentView(recyclerView);

    }
    void data (ReadCallback callback) {

        ParseQuery<ParseObject> query = ParseQuery.getQuery("Bird");
        query.findInBackground(callback::onComplete);

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here.
        int id = item.getItemId();

        if (id == R.id.undo) {
           tableAdapter.undo();
            return true;
        } else if (id == R.id.save) {
           save();
            return true;
        }



        return super.onOptionsItemSelected(item);
    }

    private void save() {
        List<String> data = tableAdapter.getData();
        List<ArrayList<String>> dividedLists = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            dividedLists.add(new ArrayList<>());
        }
        for (int i = 0; i < data.size(); i++) {
            dividedLists.get(i % 6).add(data.get(i));
        }
        for (int i = 0; i < 6; i++) {
           ParseQuery<ParseObject> query = ParseQuery.getQuery("Bird");
            int finalI = i;
            query.getInBackground(dividedLists.get(i).get(1), (parseObject, e) -> {
                if (e == null) {
                    parseObject.put("name", dividedLists.get(finalI).get(0));
                    parseObject.put("maxTemp",Integer.parseInt( dividedLists.get(finalI).get(2)));
                    parseObject.put("humidity",Integer.parseInt( dividedLists.get(finalI).get(3)));
                    parseObject.put("day", Integer.parseInt(dividedLists.get(finalI).get(4)));
                    parseObject.saveInBackground((e1) -> {
                        if (e1 == null) {
                            tableAdapter.visible();

                        }
                    });
                }
            });

        }


    }


}interface ReadCallback {
    void onComplete(List<ParseObject> incubators, ParseException e);
}