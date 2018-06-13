package com.example.mawaqaamobile.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import com.jackpocket.scratchoff.ScratchoffController;
import com.jaeger.library.StatusBarUtil;

public class ScratchActivity extends AppCompatActivity {

    ScratchoffController controller;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        StatusBarUtil.setTransparent(ScratchActivity.this);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scratch);

        controller = new ScratchoffController(ScratchActivity.this)
                .setThresholdPercent(0.50d)
                .setTouchRadiusDip(ScratchActivity.this, 30)
                .setFadeOnClear(true)
                 .setCompletionCallback(new Runnable() {
                     @Override
                     public void run() {
                         startActivity(new Intent(ScratchActivity.this,SplashActivity.class));
                     }
                 })
                .setClearOnThresholdReached(true)
                .attach(findViewById(R.id.scratch_view), findViewById(R.id.scratch_view_behind));

    }
    @Override
    public void onPause(){
        controller.onPause();
        super.onPause();
    }

    @Override
    public void onResume(){
        super.onResume();
        controller.onResume();
    }

    @Override
    public void onDestroy(){
        controller.onDestroy();
        super.onDestroy();
    }
}
