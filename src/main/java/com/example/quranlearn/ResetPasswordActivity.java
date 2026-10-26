package com.example.quranlearn;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.material.textfield.TextInputLayout;

public class ResetPasswordActivity extends AppCompatActivity {
    @Override protected void onCreate(Bundle b) {
        super.onCreate(b);
        setContentView(R.layout.activity_reset_password);
        ((TextView) findViewById(R.id.tvDesc)).setText(getString(R.string.reset_for, getIntent().getStringExtra("email")));
        TextInputLayout p = findViewById(R.id.tilPass), c = findViewById(R.id.tilConfirm);
        findViewById(R.id.btnReset).setOnClickListener(v -> {
            UserStore.clear(p, c);
            String pw = UserStore.t(p), cf = UserStore.t(c);
            boolean ok = true;
            if (!UserStore.isStrong(pw)) { p.setError(getString(R.string.err_short)); ok = false; }
            if (!pw.equals(cf)) { c.setError(getString(R.string.err_mismatch)); ok = false; }
            if (!ok) return;
            UserStore.password = pw;
            Toast.makeText(this, R.string.reset_done, Toast.LENGTH_SHORT).show();
            Intent i = new Intent(this, LoginActivity.class);
            i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(i);
        });
    }
}
