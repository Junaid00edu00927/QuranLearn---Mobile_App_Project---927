package com.example.quranlearn;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.material.textfield.TextInputLayout;

public class ForgotPasswordActivity extends AppCompatActivity {
    @Override protected void onCreate(Bundle b) {
        super.onCreate(b);
        setContentView(R.layout.activity_forgot_password);
        TextInputLayout e = findViewById(R.id.tilEmail);
        findViewById(R.id.btnSend).setOnClickListener(v -> {
            UserStore.clear(e);
            String em = UserStore.t(e);
            if (!UserStore.isEmail(em)) { e.setError(getString(R.string.err_email)); return; }
            if (!em.equalsIgnoreCase(UserStore.email)) { e.setError(getString(R.string.err_no_account)); return; }
            Toast.makeText(this, R.string.link_sent, Toast.LENGTH_SHORT).show();
            Intent i = new Intent(this, ResetPasswordActivity.class);
            i.putExtra("email", em);
            startActivity(i);
            finish();
        });
        findViewById(R.id.tvBack).setOnClickListener(v -> finish());
    }
}
