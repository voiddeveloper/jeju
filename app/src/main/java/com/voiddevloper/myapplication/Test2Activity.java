package com.voiddevloper.myapplication;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Test2Activity extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test2);

        Toast.makeText(getApplicationContext(), "Test2Activity onCreate()", Toast.LENGTH_SHORT).show();
        Log.e("Test2Activity ", "onCreate()");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Toast.makeText(getApplicationContext(), "Test2Activity onStart()", Toast.LENGTH_SHORT).show();
        Log.e("Test2Activity ", "onStart()");

    }

    @Override
    protected void onResume() {
        super.onResume();
        Toast.makeText(getApplicationContext(), "Test2Activity onResume()", Toast.LENGTH_SHORT).show();
        Log.e("Test2Activity ", "onResume()");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Toast.makeText(getApplicationContext(), "Test2Activity onPause()", Toast.LENGTH_SHORT).show();
        Log.e("Test2Activity ", "onPause()");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Toast.makeText(getApplicationContext(), "Test2Activity onStop()", Toast.LENGTH_SHORT).show();
        Log.e("Test2Activity ", "onStop()");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Toast.makeText(getApplicationContext(), "Test2Activity onRestart()", Toast.LENGTH_SHORT).show();
        Log.e("Test2Activity ", "onRestart()");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Toast.makeText(getApplicationContext(), "Test2Activity onDestroy()", Toast.LENGTH_SHORT).show();
        Log.e("Test2Activity ", "onDestroy()");
    }
}