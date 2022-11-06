package com.voiddevloper.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.voiddevloper.myapplication.databinding.ActivitySplashBinding;

public class SplashActivity extends AppCompatActivity {
    private ActivitySplashBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_splash);

        Handler hd = new Handler();
        hd.postDelayed(new SplashHandler(), 3000);
    }


    public class SplashHandler implements Runnable {
        @Override
        public void run() {
            Intent intent = new Intent(getApplication(), SigninActivity.class);
            startActivity(intent);
            finish();
        }
    }
}