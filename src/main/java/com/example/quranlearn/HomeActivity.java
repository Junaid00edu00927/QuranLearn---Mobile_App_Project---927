package com.example.quranlearn;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class HomeActivity extends AppCompatActivity {
    @Override protected void onCreate(Bundle b) {
        super.onCreate(b);
        setContentView(R.layout.activity_home);
        ((TextView) findViewById(R.id.tvWelcome)).setText(getString(R.string.welcome, getIntent().getStringExtra("name")));
        findViewById(R.id.btnProfile).setOnClickListener(v -> startActivity(new Intent(this, ProfileActivity.class)));

        GridLayout grid = findViewById(R.id.grid);
        String[] names = getResources().getStringArray(R.array.modules);
        int[] icons = {android.R.drawable.ic_menu_agenda, android.R.drawable.ic_menu_sort_alphabetically,
                android.R.drawable.ic_menu_edit, android.R.drawable.btn_star_big_on,
                android.R.drawable.ic_media_play, android.R.drawable.ic_menu_preferences};
        for (int i = 0; i < names.length; i++) {
            View card = getLayoutInflater().inflate(R.layout.item_module, grid, false);
            ((ImageView) card.findViewById(R.id.imgIcon)).setImageResource(icons[i]);
            ((TextView) card.findViewById(R.id.tvTitle)).setText(names[i]);
            String n = names[i];
            card.setOnClickListener(v -> Toast.makeText(this, getString(R.string.opening, n), Toast.LENGTH_SHORT).show());
            grid.addView(card);
        }
    }
}
