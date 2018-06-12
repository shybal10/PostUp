package com.example.mawaqaamobile.myapplication;
import android.content.Context;
import android.content.Intent;
import android.graphics.Paint;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.jaeger.library.StatusBarUtil;

import org.json.JSONException;
import org.json.JSONObject;

public class LoginActivity extends AppCompatActivity {
    Button loginButton, forgotPasswordButton, registerButton,skip;
    EditText username, password;
    TextInputLayout userLayout,passLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        StatusBarUtil.setTransparent(LoginActivity.this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        skip = (Button) findViewById(R.id.skip_button);
        skip.setPaintFlags(skip.getPaintFlags() |   Paint.UNDERLINE_TEXT_FLAG);
        username = (EditText) findViewById(R.id.username_edit_text);
        password = (EditText) findViewById(R.id.password_edit_text);
        userLayout = (TextInputLayout) findViewById(R.id.input_layout_email);
        passLayout = (TextInputLayout) findViewById(R.id.input_layout_password);
        loginButton = (Button) findViewById(R.id.login_button);
        forgotPasswordButton = (Button) findViewById(R.id.forgot_password_button);
        registerButton = (Button) findViewById(R.id.new_user_register_button);


        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


               Intent i = new Intent(LoginActivity.this, MainActivity.class);
                i.putExtra("showPage", "main");
                startActivity(i);

                //checkValue();
            }
        });

        forgotPasswordButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(LoginActivity.this, MainActivity.class);
                i.putExtra("showPage", "forgotpassword");
                startActivity(i);
            }
        });

        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(LoginActivity.this, MainActivity.class);
                i.putExtra("showPage", "register");
                startActivity(i);
            }
        });
    }

    private void checkValue() {
        if (!validateEmail()) {
            return;
        }
        if (!validatePassword()) {
            return;
        }
        Login();
    }

    private boolean validateEmail() {
        String emailS = username.getText().toString().trim();
        if (emailS.isEmpty() || !isValidEmail(emailS)) {
            userLayout.setError("invalid username");
            requestFocus(username);
            return false;
        } else {
            userLayout.setErrorEnabled(false);
        }
        return true;
    }

    private boolean validatePassword() {
        if (password.getText().toString().trim().isEmpty()) {
            passLayout.setError("Invalid password");
            requestFocus(password);
            return false;
        } else {
            passLayout.setErrorEnabled(false);
        }

        return true;
    }


    public boolean isNetworkAvailable() {
        ConnectivityManager connectivityManager = (ConnectivityManager) LoginActivity.this
                .getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager
                .getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }

    private void requestFocus(View view) {
        if (view.requestFocus()) {
            getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_VISIBLE);
        }
    }

    private boolean isValidEmail(String emailS) {
        return !TextUtils.isEmpty(emailS) && android.util.Patterns.EMAIL_ADDRESS.matcher(emailS).matches();
    }

    private void Login() {
        String Email = username.getText().toString();
        String Password = password.getText().toString();

        if (isNetworkAvailable()) {
            Toast.makeText(LoginActivity.this, "Network available", Toast.LENGTH_LONG).show();

        } else {
            Toast.makeText(LoginActivity.this, "Please Check Your Internet Connection", Toast.LENGTH_LONG).show();
        }
    }
}
