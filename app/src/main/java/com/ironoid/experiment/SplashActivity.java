package com.ironoid.experiment;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.preference.PreferenceManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class SplashActivity extends Activity {

    // Splash screen timer
    private static int SPLASH_TIME_OUT = 2500;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        SharedPreferences pref2 = PreferenceManager
                .getDefaultSharedPreferences(this);
        String basetheme = pref2.getString("base_theme", "Light");
        if (basetheme.equals("Dark")) {
            SharedPreferences pref = PreferenceManager
                    .getDefaultSharedPreferences(this);
            String themeName = pref.getString("theme_select", "Blue");
            if (themeName.equals("Blue")) {
                setTheme(R.style.MyMaterialTheme2);
            } else if (themeName.equals("Green")) {
                setTheme(R.style.Green2);
            } else if (themeName.equals("Red")) {
                setTheme(R.style.Red2);
            } else if (themeName.equals("Orange")) {
                setTheme(R.style.Orange2);
            } else if (themeName.equals("Pink")) {
                setTheme(R.style.Pink2);
            } else if (themeName.equals("Purple")) {
                setTheme(R.style.Purple2);
            } else if (themeName.equals("Voilet")) {
                setTheme(R.style.Voilet2);
            } else if (themeName.equals("Yellow")) {
                setTheme(R.style.Yellow2);
            } else if (themeName.equals("Cyan")) {
                setTheme(R.style.Cyan2);
            } else if (themeName.equals("Teal")) {
                setTheme(R.style.Teal2);
            } else if (themeName.equals("Indigo")) {
                setTheme(R.style.Indigo2);
            }
        } else if(basetheme.equals("Light"))
        {
            SharedPreferences pref = PreferenceManager
                    .getDefaultSharedPreferences(this);
            String themeName = pref.getString("theme_select", "Blue");
            if (themeName.equals("Blue")) {
                setTheme(R.style.MyMaterialTheme);
            } else if (themeName.equals("Green")) {
                setTheme(R.style.Green);
            } else if (themeName.equals("Red")) {
                setTheme(R.style.Red);
            } else if (themeName.equals("Orange")) {
                setTheme(R.style.Orange);
            } else if (themeName.equals("Pink")) {
                setTheme(R.style.Pink);
            } else if (themeName.equals("Purple")) {
                setTheme(R.style.Purple);
            } else if (themeName.equals("Voilet")) {
                setTheme(R.style.Voilet);
            } else if (themeName.equals("Yellow")) {
                setTheme(R.style.Yellow);
            } else if (themeName.equals("Cyan")) {
                setTheme(R.style.Cyan);
            } else if (themeName.equals("Teal")) {
                setTheme(R.style.Teal);
            } else if (themeName.equals("Indigo")) {
                setTheme(R.style.Indigo);
            }
        }
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash);

        Animation rotate = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.trot);
        ImageView logo = (ImageView)findViewById(R.id.splash_logo);


        logo.startAnimation(rotate);



        new Handler().postDelayed(new Runnable() {

            /*
             * Showing splash screen with a timer. This will be useful when you
             * want to show case your app logo / company
             */

            @Override
            public void run() {
                // This method will be executed once the timer is over
                // Start your app main activity
                Intent i = new Intent(SplashActivity.this , HomeActivity.class);
                startActivity(i);

                // close this activity
                finish();
            }
        }, SPLASH_TIME_OUT);
    }


}
