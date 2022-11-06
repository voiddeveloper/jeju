package com.voiddevloper.myapplication;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Base64;
import android.util.Log;
import android.view.KeyEvent;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.voiddevloper.myapplication.databinding.ActivityMainBinding;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;
    private CafesAdapter cafesAdapter;
    private ArrayList<CafeItem> dataList = new ArrayList<>();
    private SharedPreferences preferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        getHashKey();
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        binding.rvCafes.setLayoutManager(layoutManager);
        cafesAdapter = new CafesAdapter();

        preferences = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor editor = preferences.edit();
        saveData(editor, dataList);
        cafesAdapter.addItem(dataList);
        binding.rvCafes.setAdapter(cafesAdapter);
        cafesAdapter.notifyDataSetChanged();

        /*
         * binding.etSearchCafe.setOnKeyListener(new View.OnKeyListener() {
         *    @Override
         *    public boolean onKey(View v, int keyCode, KeyEvent event) {
         *        switch (keyCode){
         *            case KeyEvent.KEYCODE_ENTER:
         *
         *        }
         *        return false;
         *    }
         * });
         */
        // 유저가 검색하면 검색어를 CafesActivity로 전달
        binding.etSearchCafe.setOnKeyListener((v, keyCode, event) -> {
            if (keyCode == KeyEvent.KEYCODE_ENTER) {
                Intent intent = new Intent(this, CafesActivity.class);
                intent.putExtra("searchText", binding.etSearchCafe.getText().toString());
                startActivity(intent);
//                Log.d( "searchText: " , binding.etSearchCafe.getText().toString());
            }
            return false;
        });
    }
    public void saveData(SharedPreferences.Editor editor, ArrayList<CafeItem> dataList) {

        dataList.add(new CafeItem(R.drawable.cafe_image,"애월카페", "90", "4.8(45)", "애월", "애월너무좋아요."));
//        dataList.add(new CafeItem(R.drawable.cafe_image1,"제카페", "99+", "5(15)", "제주시", "제주너무좋아요."));
//        dataList.add(new CafeItem(R.drawable.cafe_image2,"애월카페", "90", "4.8(45)", "애월", "애월너무좋아요."));
//        dataList.add(new CafeItem(R.drawable.cafe_image3,"애월카페", "90", "4.8(45)", "애월", "애월너무좋아요."));
//        dataList.add(new CafeItem(R.drawable.cafe_image4,"애월카페", "90", "4.8(45)", "애월", "애월너무좋아요."));
        editor.apply();
    }

    private void getHashKey(){
        PackageInfo packageInfo = null;
        try {
            packageInfo = getPackageManager().getPackageInfo(getPackageName(), PackageManager.GET_SIGNATURES);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        if (packageInfo == null)
            Log.e("KeyHash", "KeyHash:null");

        for (Signature signature : packageInfo.signatures) {
            try {
                MessageDigest md = MessageDigest.getInstance("SHA");
                md.update(signature.toByteArray());
                Log.d("KeyHash", Base64.encodeToString(md.digest(), Base64.DEFAULT));
            } catch (NoSuchAlgorithmException e) {
                Log.e("KeyHash", "Unable to get MessageDigest. signature=" + signature, e);
            }
        }
    }

}