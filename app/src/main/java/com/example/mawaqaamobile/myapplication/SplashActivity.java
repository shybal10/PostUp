package com.example.mawaqaamobile.myapplication;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.mawaqaamobile.myapplication.UIUtils.LocaleHelper;
import com.jaeger.library.StatusBarUtil;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Locale;

public class SplashActivity extends AppCompatActivity {
    Button englishButton,arabicButton;
    ImageButton spinnerButton;
    Typeface arabic;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        StatusBarUtil.setTransparent(SplashActivity.this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        arabic = Typeface.createFromAsset(getAssets(),"fonts/GE_SS_TV_Bold.otf");
        final ArrayList<String> countries = new ArrayList<String>();
        arabicButton = (Button) findViewById(R.id.arabic_button);
        arabicButton.setTypeface(arabic);
        spinnerButton = (ImageButton) findViewById(R.id.spinner_click);
        englishButton = (Button) findViewById(R.id.english_button);
        englishButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LocaleHelper.setLocale(SplashActivity.this,"en");
                startActivity(new Intent(SplashActivity.this,LoginActivity.class));
            }
        });
        arabicButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LocaleHelper.setLocale(SplashActivity.this,"ar-rKW");
                startActivity(new Intent(SplashActivity.this,LoginActivity.class));
            }
        });
        String country;



        countries.add(0,"CHOOSE COUNTRY");
        countries.add(1,"INDIA");
        countries.add(2,"KUWAIT");



        final Spinner citizenship = (Spinner)findViewById(R.id.input_citizenship);

        ArrayAdapter adapter = new ArrayAdapter<String>(this, R.layout.spinner_item_layout, countries) {

            @Override
            public View getDropDownView(int position, View convertView, ViewGroup parent) {

                View v = null;

                if (position == 0) {
                    TextView tv = new TextView(getContext());
                    tv.setHeight(0);
                    tv.setVisibility(View.GONE);
                    v = tv;
                }
                else {

                    v = super.getDropDownView(position, null, parent);
                }

                parent.setVerticalScrollBarEnabled(false);
                return v;
            }

        };
        citizenship.setAdapter(adapter);

        spinnerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                citizenship.performClick();
            }
        });
    }


}
