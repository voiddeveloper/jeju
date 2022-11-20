package com.voiddevloper.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class TestActivity extends AppCompatActivity {

    Button btn, btn2, btn3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

        Toast.makeText(getApplicationContext(), "TestActivity onCreate()", Toast.LENGTH_SHORT).show();
        Log.e("TestActivity ", "onCreate()");
        btn = (Button) findViewById(R.id.btn_to_map);
//        btn2 = (Button) findViewById(R.id.btn_to_near_map);
//        btn3 = (Button) findViewById(R.id.btn_to_);
//
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Toast.makeText(getApplicationContext(), "버튼이 클릭되었습니다.", Toast.LENGTH_LONG).show();
                Intent intent = new Intent(getApplicationContext(), Test2Activity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        Toast.makeText(getApplicationContext(), "TestActivity onStart()", Toast.LENGTH_SHORT).show();
        Log.e("TestActivity ", "onStart()");

    }

    @Override
    protected void onResume() {
        super.onResume();
        Toast.makeText(getApplicationContext(), "TestActivity onResume()", Toast.LENGTH_SHORT).show();
        Log.e("TestActivity ", "onResume()");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Toast.makeText(getApplicationContext(), "TestActivity onPause()", Toast.LENGTH_SHORT).show();
        Log.e("TestActivity ", "onPause()");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Toast.makeText(getApplicationContext(), "TestActivity onStop()", Toast.LENGTH_SHORT).show();
        Log.e("TestActivity ", "onStop()");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Toast.makeText(getApplicationContext(), "TestActivity onRestart()", Toast.LENGTH_SHORT).show();
        Log.e("TestActivity ", "onRestart()");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Toast.makeText(getApplicationContext(), "TestActivity onDestroy()", Toast.LENGTH_SHORT).show();
        Log.e("TestActivity ", "onDestroy()");
    }
}