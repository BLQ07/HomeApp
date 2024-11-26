package com.example.home.Settings;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;

import com.example.home.First.CreateCallback;
import com.example.home.First.IncubatorManager;
import com.example.home.Second.BruderManager;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;
import com.parse.ParseObject;

import java.util.Objects;

@SuppressLint("SetTextI18n")
public class SettingsActivity extends AppCompatActivity
{ private final String[] tabTitles = new String[]{"Tab 1", "Tab 2","Tab 3"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LinearLayout linearLayout =new LinearLayout(this);
        TabLayout table =new TabLayout(this);
        ViewPager2 viewPager =new ViewPager2(this);
        linearLayout.setOrientation(LinearLayout.VERTICAL);
        setContentView(linearLayout);
        linearLayout.addView(table);
        linearLayout.addView(viewPager);
        PageAdapter pageAdapter = new PageAdapter(this);
        viewPager.setAdapter(pageAdapter);
        new TabLayoutMediator(table, viewPager,
                (tab, position) -> tab.setText(tabTitles[position])).attach();

    }

static class PageAdapter extends FragmentStateAdapter
{
    Context context;
    public PageAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
        context = fragmentActivity;
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position){
            case 1:
                return new AddBruder(context);

                case 2:return  new AddBird(context);
            case 0:
            default:return new AddIncubator(context);
        }
    }

    @Override
    public int getItemCount() {
        return 3;
    }
}

  public   static class AddIncubator extends Fragment
{Context context;
    public AddIncubator(Context context)
    {this.context = context;
    }
    public AddIncubator(){}

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return initAddIncubator();
    }

    private View initAddIncubator() {
        LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setOrientation(LinearLayout.VERTICAL);
        EditText editText = new EditText(context);
        editText.setHint("Enter incubator name");
        linearLayout.addView(editText);
        EditText editText1 = new EditText(context);
        editText1.setHint("Enter incubator size");
        linearLayout.addView(editText1);
        EditText editText2 = new EditText(context);
        editText2.setHint("Enter incubator temperature");
        linearLayout.addView(editText2);
        EditText editText3 = new EditText(context);
        editText3.setHint("Enter incubator humidity");
        linearLayout.addView(editText3);
        Button button = new Button(context);
        button.setText("Add");
        linearLayout.addView(button);
        button.setOnClickListener(v -> {
            IncubatorManager incubatorManager = new IncubatorManager();
            incubatorManager.createIncubator(editText.getText().toString(), Integer.parseInt(editText1.getText().toString()), Double.parseDouble(editText2.getText().toString()), Double.parseDouble(editText3.getText().toString()), "", e -> {
                if (e == null) {
                    Toast.makeText(context, "успешно добавлен", Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(context, e.getMessage(), Toast.LENGTH_SHORT).show();
                }
            });
        });
        return linearLayout;
    }
}
public  static class AddBruder extends Fragment
{Context context;
    public AddBruder(Context context)
    {this.context = context;
    }
    public AddBruder(){}

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return initAddBruder();
    }

    private View initAddBruder() {
        LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setOrientation(LinearLayout.VERTICAL);
        EditText editText = new EditText(context);
        editText.setHint("Enter Bruder name");
        linearLayout.addView(editText);
        EditText editText1 = new EditText(context);
        editText1.setHint("Enter Bruder size");
        linearLayout.addView(editText1);
        EditText editText2 = new EditText(context);
        editText2.setHint("Enter Bruder temperature");
        linearLayout.addView(editText2);
        EditText editText3 = new EditText(context);
        editText3.setHint("Enter Bruder humidity");
        linearLayout.addView(editText3);
        Button button = new Button(context);
        button.setText("Add");
        linearLayout.addView(button);
        button.setOnClickListener(v -> {
            BruderManager incubatorManager = new BruderManager();
            incubatorManager.createBruder(editText.getText().toString(), Integer.parseInt(editText1.getText().toString()), Double.parseDouble(editText2.getText().toString()), Double.parseDouble(editText3.getText().toString()), "", e -> {
                if (e == null) {
                    Toast.makeText(context, "успешно добавлен", Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(context, e.getMessage(), Toast.LENGTH_SHORT).show();
                }
            });
        });
        return linearLayout;
    }
}public   static class AddBird extends Fragment
{Context context;
    public AddBird(Context context)
    {this.context = context;
    }
    public AddBird(){}

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return initAddBird();
    }

    private View initAddBird() {
        LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setOrientation(LinearLayout.VERTICAL);
        EditText editText = new EditText(context);
        editText.setHint("Enter Bird name");
        linearLayout.addView(editText);
        EditText editText1 = new EditText(context);
        editText1.setHint("Enter max Temperature");
        linearLayout.addView(editText1);
        EditText editText2 = new EditText(context);
        editText2.setHint("Enter max Humidity");
        linearLayout.addView(editText2);
        EditText editText3 = new EditText(context);
        editText3.setHint("Enter day");
        linearLayout.addView(editText3);
        Button button = new Button(context);
        button.setText("Add");
        linearLayout.addView(button);
        button.setOnClickListener(v -> createBird(editText.getText().toString(), Double.parseDouble(editText1.getText().toString()), Double.parseDouble(editText2.getText().toString()), editText3.getText().toString(), e -> {
             if (e == null) {
                 Toast.makeText(context, "успешно добавлен", Toast.LENGTH_SHORT).show();
             }
             else {
                 Toast.makeText(context, e.getMessage(), Toast.LENGTH_SHORT).show();
             }
         }));
        return linearLayout;
    }
    void createBird(String name, Double maxTemp , Double maxHum, String day , CreateCallback callback) {
        ParseObject incubator = new ParseObject("Bird");
        incubator.put("name", name);
        incubator.put("maxTemp", maxTemp);
        incubator.put("humidity",maxHum);
        incubator.put("day", day);
        incubator.saveInBackground(e -> {
            if (e == null) {
                Log.i("CreateIncubator", "Incubator created");
                callback.onComplete(null);
            }
            else {Log.e("IncubatorCreate", Objects.requireNonNull(e.getMessage()));
                callback.onComplete(e);}
        });

    }
}
}