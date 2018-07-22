package com.example.mawaqaamobile.myapplication;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;

import com.jaeger.library.StatusBarUtil;

import java.util.ArrayList;
import java.util.Locale;

public class SplashActivity extends AppCompatActivity {
    Button englishButton,arabicButton;
    ImageButton spinnerButton;
    Typeface arabic;
    private static final String LOCALE_KEY = "localekey";
    private static final String KUWAITI_LOCALE = "ar";
    private static final String ENGLISH_LOCALE = "en_US";
    private static final String LOCALE_PREF_KEY = "localePref";
    private Locale locale;

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
                changeLanguage(ENGLISH_LOCALE);
                startActivity(new Intent(SplashActivity.this,LoginActivity.class));
            }
        });
        arabicButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeLanguage(KUWAITI_LOCALE);
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

    private void changeLanguage(String LOCALE) {
        if (Build.VERSION.SDK_INT <= 21){
            Locale locale = new Locale(LOCALE);
            Locale.setDefault(locale);
            Configuration config = new Configuration();
            config.locale = locale;
            getBaseContext().getResources().updateConfiguration(config, null);
        }else {
            Resources resources = getResources();
            SharedPreferences sharedPreferences = getSharedPreferences("localePref", MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedPreferences.edit();
            locale = new Locale(LOCALE);
            editor.putString(LOCALE_KEY, LOCALE);
            editor.apply();
            Configuration configuration = resources.getConfiguration();
            configuration.setLocale(locale);
            getBaseContext().getResources().updateConfiguration(configuration,
                    getBaseContext().getResources().getDisplayMetrics());
        }

    }
}
