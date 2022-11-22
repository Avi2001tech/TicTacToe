package com.example.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

import com.airbnb.lottie.LottieAnimationView;

public class SplashScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        TextView AppName = findViewById(R.id.AppName);
        LottieAnimationView lottie = findViewById(R.id.lottie);


        Animation anim = AnimationUtils.loadAnimation(this,R.anim.text_animation);
        AppName.setAnimation(anim);
        //AppName.animate().alpha(1).getInterpolator();
        lottie.animate().setDuration(2700).setStartDelay(0);
        lottie.animate().getInterpolator();
        lottie.playAnimation();

        new Handler().postDelayed(new Runnable(){
            @Override
            public void run() {
                Intent i = new Intent(SplashScreen.this,MainActivity.class);
                startActivity(i);
                finish();
            }
        },3500);
    }
}