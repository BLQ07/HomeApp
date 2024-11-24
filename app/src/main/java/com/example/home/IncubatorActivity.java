package com.example.home;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class IncubatorActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_incubator);
        Intent intent=getIntent();
        String id = intent.getStringExtra("id");
        IncubatorManager repository = new IncubatorManager();
        repository.readIncubator(id, (incubator, e) -> {
            if (e == null) {
                TextView textView=new TextView(this);
                textView.setText(incubator.getName());
                setContentView(textView);
            }
        });
    }
}
