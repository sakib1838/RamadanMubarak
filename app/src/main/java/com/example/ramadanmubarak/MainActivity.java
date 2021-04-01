package com.example.ramadanmubarak;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.renderscript.ScriptGroup;

import com.example.ramadanmubarak.Adapter.PagerAdapter;
import com.example.ramadanmubarak.Adapter.RecyclerViewRamadanList;
import com.example.ramadanmubarak.BackendClass.Ramadan;
import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList<Ramadan> ramadanArrayList;
    RecyclerView recyclerView;
    RecyclerViewRamadanList recyclerViewRamadanList;
    TabItem rahmat,magrifat,najat;
    ViewPager viewPager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TabLayout tabLayout = findViewById(R.id.tabLayout);
        rahmat = findViewById(R.id.rahmat);
        magrifat = findViewById(R.id.magrifat);
        najat = findViewById(R.id.najat);
        viewPager = findViewById(R.id.viewPager);


        PagerAdapter pagerAdapter = new PagerAdapter(getSupportFragmentManager(),tabLayout.getTabCount());
        viewPager.setAdapter(pagerAdapter);

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        //recyclerView = findViewById(R.id.recyclerView);



       // recyclerViewRamadanList = new RecyclerViewRamadanList(ramadanArrayList, MainActivity.this);
       // recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));
       // recyclerView.setAdapter(recyclerViewRamadanList);


    }


}