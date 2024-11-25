package com.example.home;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class ViewPagerAdapter extends FragmentStateAdapter {
Context context;
    public ViewPagerAdapter(Context context, @NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
        this.context = context;
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position) {
            case 1:
                return new SecondFragment(context);
            case 0:

            default:
                return new FirstFragment(context);
        }
    }

    @Override
    public int getItemCount() {
        return 2;
    }
}
