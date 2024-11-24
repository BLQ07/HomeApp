package com.example.home;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;

public class SettingsActivity extends AppCompatActivity
{

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LinearLayout layout = new LinearLayout(this);
        layout.setOrientation(LinearLayout.VERTICAL);
        LinearLayout layoutItems = new LinearLayout(this);
        layoutItems.setOrientation(LinearLayout.HORIZONTAL);
        layout.addView(layoutItems);
        LinearLayout layoutSettings = new LinearLayout(this);
        layoutSettings.setOrientation(LinearLayout.VERTICAL);
        layoutItems.addView(layoutSettings);
        Button button = new Button(this);
        button.setText("Add Incubator");
        layoutItems.addView(button);
        button.setOnClickListener(v -> {
            layoutSettings.removeAllViews();
            layoutSettings.addView(AddIncubator(layoutSettings));
        });

        setContentView(layout);

    }
    @SuppressLint("SetTextI18n")
    private LinearLayout AddIncubator (LinearLayout layoutSettings) {
        LinearLayout layout = new LinearLayout(this);
        layout.setOrientation(LinearLayout.VERTICAL);
        EditText editText = new EditText(this);
        layout.addView(editText);
        EditText editText2 = new EditText(this);
        editText2.setInputType(android.text.InputType.TYPE_CLASS_NUMBER);
        editText2.setHint("Size");
        layout.addView(editText2);
        EditText editText3 = new EditText(this);
        editText3.setInputType(android.text.InputType.TYPE_CLASS_NUMBER);
        editText3.setHint("Temperature");
        layout.addView(editText3);
        EditText editText4 = new EditText(this);
        editText4.setInputType(android.text.InputType.TYPE_CLASS_NUMBER);
        editText4.setHint("Humidity");
        layout.addView(editText4);
       IncubatorManager repository = new IncubatorManager();
       Button button = new Button(this);
       button.setText("Add");
       layout.addView(button);
       button.setOnClickListener(v -> {
           repository.createIncubator(editText.getText().toString(),Integer.parseInt(editText2.getText().toString()),Double.parseDouble(editText3.getText().toString()),Double.parseDouble(editText4.getText().toString()),"");
           layoutSettings.removeAllViews();
       });
        return layout;
    }



}