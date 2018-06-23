package com.example.spyboy.splashscreen;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

public class SplashScreenActivity extends AppCompatActivity {
    private int SLEEP_TIMER=2500;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE); //not having toolbar
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_splash_screen);
        getSupportActionBar().hide();
        LogoLauncher logoLauncher=new LogoLauncher();
        logoLauncher.start();
        TextView textView =(TextView)findViewById(R.id.id_title);
        Animation animation= AnimationUtils.loadAnimation(getApplicationContext(),R.anim.anim_bottom);
        textView.startAnimation(animation);
    }
    private class LogoLauncher extends Thread
    {
        public void run()
        {
            try
            {
               sleep(SLEEP_TIMER);
            }
            catch (InterruptedException e)
            {
                e.printStackTrace();
            }
           startActivity(new Intent(getApplicationContext(),sliderActivity.class));
            SplashScreenActivity.this.finish();

        }
    }
}
