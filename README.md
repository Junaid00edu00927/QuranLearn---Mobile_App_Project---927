# Quran Learn – Common Screens (Android, Java + XML)

Android app with the common authentication and home screens. Authentication and password recovery are **simulated locally** (in-memory `UserStore`, no backend).

**Demo login:** `demo@quranlearn.com` (or username `Demo User`) / `Pass@123`

## Implemented screens
| Screen | Activity | Layout | Features |
|---|---|---|---|
| Splash | `SplashActivity` | ConstraintLayout | Logo, app name, tagline, **Get Started** → Login |
| Login | `LoginActivity` | LinearLayout | Email/username + password (toggle), Login, Register link, Forgot Password link |
| Register | `RegisterActivity` | LinearLayout | Name, email, password, confirm password; validation |
| Forgot Password | `ForgotPasswordActivity` | LinearLayout | Email validation, simulated recovery link |
| Reset Password | `ResetPasswordActivity` | LinearLayout | New + confirm password; validation |
| Home | `HomeActivity` | LinearLayout + GridLayout | 6 module cards (icon + text), Profile button |
| Profile | `ProfileActivity` | LinearLayout | Name, email, Logout |

## Navigation flow
```
Splash ─► Login ─► Home ─► Profile ─► (Logout) ─► Login
           │  │
           │  └─► Forgot Password ─► Reset Password ─► Login
           └────► Register ─► Login
```
All navigation uses **explicit Intents** (`new Intent(this, X.class)`); data is passed with extras (`name`, `email`). Logout and password reset clear the back stack.

## Technical requirements covered
- **Resources:** `strings.xml` (all text, plus string-array and formatted strings), `colors.xml` with `values-night/colors.xml` for dark mode, `themes.xml` styles, vector logo.
- **Layouts:** LinearLayout, GridLayout, ConstraintLayout.
- **Inputs:** `textEmailAddress`, `textPersonName`, `textPassword` (Material `TextInputLayout` with show/hide icon).
- **Validation:** required fields, email format, minimum 6-character password, password match, invalid-login and unknown-email errors.
- **Consistency:** one Material 3 theme, shared text styles, 24dp padding, 56dp buttons.

## Run
Open the folder in Android Studio (Hedgehog or newer), let Gradle sync, run on an emulator/device (minSdk 24).

## Push to GitHub
```
git init
git add .
git commit -m "Quran Learn: common screens"
git branch -M main
git remote add origin <YOUR_REPO_URL>
git push -u origin main
```
