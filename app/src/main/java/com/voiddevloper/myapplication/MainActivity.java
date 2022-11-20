package com.voiddevloper.myapplication;

import android.content.Context;
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
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.voiddevloper.myapplication.databinding.ActivityMainBinding;

import java.lang.reflect.Type;
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
        dataList.add(new CafeItem(R.drawable.cafe_image,"애월카페", "90", "4.8(45)", "애월", "애월너무좋아요."));
        dataList.add(new CafeItem(R.drawable.cafe_image1,"제카페", "99+", "5(15)", "제주시", "제주너무좋아요."));
        dataList.add(new CafeItem(R.drawable.cafe_image2,"애월카페", "90", "4.8(45)", "애월", "애월너무좋아요."));
        dataList.add(new CafeItem(R.drawable.cafe_image3,"애월카페", "90", "4.8(45)", "애월", "애월너무좋아요."));
        dataList.add(new CafeItem(R.drawable.cafe_image4,"애월카페", "90", "4.8(45)", "애월", "애월너무좋아요."));
        //        getHashKey();
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        // ArrayList에 데이터를 추가해주고 SharedPreference를 이용하여 데이터를 저장하는 코드
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        binding.rvCafes.setLayoutManager(layoutManager);
        cafesAdapter = new CafesAdapter();

        setArrayPref(getApplicationContext(), "cafes", dataList);
        ArrayList<CafeItem> cafeItems = getArrayPref(getApplicationContext(), "cafes");
        cafesAdapter.addItem(cafeItems);

        cafesAdapter.setOnItemClickListener((v, position) -> {
            Toast.makeText(getApplicationContext(), position+" 값입니다.", Toast.LENGTH_SHORT).show();
            Log.e("position: ", position+"");
            Intent intent = new Intent(this, CafesActivity.class);
            intent.putExtra("index", position);
            startActivity(intent);
        });

        binding.rvCafes.setAdapter(cafesAdapter);
        cafesAdapter.notifyDataSetChanged();

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

    private void setArrayPref(Context context, String key, ArrayList<CafeItem> values) {

        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor editor = prefs.edit();
        Gson gson = new Gson();
        String json = gson.toJson(values);
        editor.putString(key, json); // "items", "datalist"
        editor.apply();
    }

    private ArrayList getArrayPref(Context context, String key) {

        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(context);
        Gson gson = new Gson();
        String json = prefs.getString(key, null);
        Type type = new TypeToken<ArrayList<CafeItem>>() {
        }.getType();
        ArrayList<CafeItem> arrayList = gson.fromJson(json, type);
        return arrayList;
    }

}