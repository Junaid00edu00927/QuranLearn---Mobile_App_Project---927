package com.example.quranlearn;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.material.textfield.TextInputLayout;

public class RegisterActivity extends AppCompatActivity {
    @Override protected void onCreate(Bundle b) {
        super.onCreate(b);
        setContentView(R.layout.activity_register);
        TextInputLayout n = findViewById(R.id.tilName), e = findViewById(R.id.tilEmail),
                p = findViewById(R.id.tilPass), c = findViewById(R.id.tilConfirm);
        findViewById(R.id.btnRegister).setOnClickListener(v -> {
            UserStore.clear(n, e, p, c);
            String nm = UserStore.t(n), em = UserStore.t(e), pw = UserStore.t(p), cf = UserStore.t(c);
            boolean ok = true;
            if (nm.isEmpty()) { n.setError(getString(R.string.err_required)); ok = false; }
            if (!UserStore.isEmail(em)) { e.setError(getString(R.string.err_email)); ok = false; }
            if (!UserStore.isStrong(pw)) { p.setError(getString(R.string.err_short)); ok = false; }
            if (!pw.equals(cf)) { c.setError(getString(R.string.err_mismatch)); ok = false; }
            if (!ok) return;
            UserStore.name = nm; UserStore.email = em; UserStore.password = pw;
            Toast.makeText(this, R.string.registered, Toast.LENGTH_SHORT).show();
            startActivity(new Intent(this, LoginActivity.class));
            finish();
        });
        findViewById(R.id.tvLogin).setOnClickListener(v -> finish());
    }
}
