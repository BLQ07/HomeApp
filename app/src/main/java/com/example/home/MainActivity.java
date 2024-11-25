package com.example.home;


import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

import com.example.home.Settings.EditBird;
import com.example.home.Settings.SettingsActivity;
import com.example.home.Settings.TableAdapter;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity  {
    ViewPagerAdapter adapter;
    private final String[] tabTitles = new String[]{"Tab 1", "Tab 2"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        TabLayout tabLayout = findViewById(R.id.tab_layout);
        ViewPager2 viewPager = findViewById(R.id.view_pager);

       adapter  = new ViewPagerAdapter(this,this);
        viewPager.setAdapter(adapter);

        new TabLayoutMediator(tabLayout, viewPager,
                (tab, position) -> tab.setText(tabTitles[position])).attach();


    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.context_menu, menu);
        return true;



}

    @SuppressLint("NotifyDataSetChanged")
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.edit) {
            Intent intent = new Intent(this, SettingsActivity.class);
            startActivity(intent);
        }

        if (item.getItemId() == R.id.update) {
        adapter.notifyDataSetChanged();
        }
        if (item.getItemId() == R.id.search) {
            Intent intent = new Intent(this, EditBird.class);
            startActivity(intent);

        }
        return super.onContextItemSelected(item);

    }





}





