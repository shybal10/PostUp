package com.example.mawaqaamobile.myapplication;

import android.content.Intent;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import com.jaeger.library.StatusBarUtil;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Locale;

public class SplashActivity extends AppCompatActivity {
    Button englishButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        StatusBarUtil.setTransparent(SplashActivity.this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        Locale[] locale = Locale.getAvailableLocales();
        ArrayList<String> countries = new ArrayList<String>();
        englishButton = (Button) findViewById(R.id.english_button);
        englishButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SplashActivity.this,LoginActivity.class));
            }
        });
        String country;
/*        for( Locale loc : locale ){
            country = loc.getDisplayCountry();
            if( country.length() > 0 && !countries.contains(country) ){
                countries.add( country );
            }
        }*/
        countries.add(0,"CHOOSE COUNTRY");
        countries.add(1,"INDIA");
        countries.add(2,"KUWAIT");


        Spinner citizenship = (Spinner)findViewById(R.id.input_citizenship);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,R.layout.spinner_item_layout, countries);
        citizenship.setAdapter(adapter);
    }
}
