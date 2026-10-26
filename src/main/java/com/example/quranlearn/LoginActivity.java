package com.example.quranlearn;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.material.textfield.TextInputLayout;

public class LoginActivity extends AppCompatActivity {
    @Override protected void onCreate(Bundle b) {
        super.onCreate(b);
        setContentView(R.layout.activity_login);
        TextInputLayout user = findViewById(R.id.tilUser), pass = findViewById(R.id.tilPass);
        findViewById(R.id.btnLogin).setOnClickListener(v -> {
            UserStore.clear(user, pass);
            String u = UserStore.t(user), p = UserStore.t(pass);
            if (u.isEmpty()) { user.setError(getString(R.string.err_required)); return; }
            if (p.isEmpty()) { pass.setError(getString(R.string.err_required)); return; }
            if (!UserStore.login(u, p)) { pass.setError(getString(R.string.err_invalid_login)); return; }
            Intent i = new Intent(this, HomeActivity.class);
            i.putExtra("name", UserStore.name);
            startActivity(i);
            finish();
        });
        findViewById(R.id.tvRegister).setOnClickListener(v -> startActivity(new Intent(this, RegisterActivity.class)));
        findViewById(R.id.tvForgot).setOnClickListener(v -> startActivity(new Intent(this, ForgotPasswordActivity.class)));
    }
}
