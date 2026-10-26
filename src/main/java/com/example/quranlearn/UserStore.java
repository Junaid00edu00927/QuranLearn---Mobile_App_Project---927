package com.example.quranlearn;

import android.util.Patterns;
import com.google.android.material.textfield.TextInputLayout;

/** Simulated, in-memory "database" (no backend). Demo user: demo@quranlearn.com / Pass@123 */
public class UserStore {
    public static String name = "Demo User";
    public static String email = "demo@quranlearn.com";
    public static String password = "Pass@123";

    public static boolean login(String id, String pw) {
        return (id.equalsIgnoreCase(email) || id.equalsIgnoreCase(name)) && pw.equals(password);
    }
    public static boolean isEmail(String s) { return Patterns.EMAIL_ADDRESS.matcher(s).matches(); }
    public static boolean isStrong(String p) { return p.length() >= 6; }
    public static String t(TextInputLayout l) {
        return l.getEditText() == null ? "" : l.getEditText().getText().toString().trim();
    }
    public static void clear(TextInputLayout... ls) { for (TextInputLayout l : ls) l.setError(null); }
}
