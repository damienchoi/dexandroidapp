package com.wego.dexandroidnative;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class SplashActivity extends AppCompatActivity {

    ImageView cplogo;
    Animation frombottom;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        cplogo = (ImageView) findViewById(R.id.splash_logo);
        frombottom = AnimationUtils.loadAnimation(this, R.anim.from_bottom);
//        frombottom.setInterpolator(this,R.anim.bounce_interpolator);
        cplogo.setAnimation(frombottom);
        startLoading();
    }


    private void startLoading() {
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
                finish();
            }
        }, 3000);
    }
}