package com.example.quranlearn;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class ProfileActivity extends AppCompatActivity {
    @Override protected void onCreate(Bundle b) {
        super.onCreate(b);
        setContentView(R.layout.activity_profile);
        ((TextView) findViewById(R.id.tvName)).setText(UserStore.name);
        ((TextView) findViewById(R.id.tvEmail)).setText(UserStore.email);
        findViewById(R.id.btnLogout).setOnClickListener(v -> {
            Toast.makeText(this, R.string.logged_out, Toast.LENGTH_SHORT).show();
            Intent i = new Intent(this, LoginActivity.class);
            i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(i);
        });
    }
}
