package com.example.home;
import android.os.Bundle;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;
import com.example.home.First.Forms;
public class Table extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Forms forms = new Forms(this, 3, 3, ImageView.class);
        setContentView(forms.getLayout());

    }



}

