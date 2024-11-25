package com.example.home.Settings;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;

import com.example.home.First.IncubatorManager;
import com.example.home.Second.BruderManager;

@SuppressLint("SetTextI18n")
public class SettingsActivity extends AppCompatActivity
{


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

        Button button = new Button(this);
        button.setText("Add Incubator");
        layoutItems.addView(button);
        button.setOnClickListener(v -> {
            layoutSettings.removeAllViews();
            layoutSettings.addView(AddIncubator(layoutSettings));
        });
        Button button2 = new Button(this);
        button2.setText("Add Bruder");

        button2.setOnClickListener(v -> {
            layoutSettings.removeAllViews();
            layoutSettings.addView(AddBruder(layoutSettings));
        });
        layoutItems.addView(button2);
        layout.addView(layoutSettings);
        setContentView(layout);

    }

    private LinearLayout AddBruder(LinearLayout layoutSettings) {
        LinearLayout layout = new LinearLayout(this);
        layout.setOrientation(LinearLayout.VERTICAL);
        EditText editText = new EditText(this);
        editText.setHint("Name Bruder");
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
    private LinearLayout AddIncubator (LinearLayout layoutSettings) {
        LinearLayout layout = new LinearLayout(this);
        layout.setOrientation(LinearLayout.VERTICAL);
        EditText editText = new EditText(this);
        editText.setHint("Name Incubator");
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
      BruderManager repository = new BruderManager();
       Button button = new Button(this);
       button.setText("Add");
       layout.addView(button);
       button.setOnClickListener(v -> {
           repository.createBruder(editText.getText().toString(),Integer.parseInt(editText2.getText().toString()),Double.parseDouble(editText3.getText().toString()),Double.parseDouble(editText4.getText().toString()),"");
           layoutSettings.removeAllViews();
       });
        return layout;
    }



}