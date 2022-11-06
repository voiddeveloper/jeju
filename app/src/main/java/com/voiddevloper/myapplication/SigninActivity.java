package com.voiddevloper.myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.voiddevloper.myapplication.databinding.ActivitySigninBinding;

public class SigninActivity extends AppCompatActivity {
    private ActivitySigninBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_signin);
        binding.tvSignup.setOnClickListener(this::btnClick);
    }

    public void btnClick(View view) {
        Toast.makeText(this, "btnClick", Toast.LENGTH_LONG).show();
    }
}