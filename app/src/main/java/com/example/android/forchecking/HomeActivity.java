package com.example.android.forchecking;

import android.content.BroadcastReceiver;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

public class HomeActivity extends AppCompatActivity implements Petis.OnFragmentInteractionListener, Samusa.OnFragmentInteractionListener {

    private BroadcastReceiver MyReceiver = null;
    Button button;

    TabLayout tabLayout;

    ViewPager mPager;
    Adapter mPageAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        tabLayout = findViewById(R.id.tabs);

        List<Fragment> fragments = new ArrayList<Fragment>();

        String[] availableItemsList = {"Samusa", "Petis"};
        String[] fragmentsList = {"Samusa", "Petis"};
        ArrayList<String> names = new ArrayList<>();
        names.add("Samusa");
        names.add("Petis");

        Petis fragment1 = new Petis();

        for (int i = 0; i < 2; i++) {
            fragments.add(fragment1);
        }

        mPager = findViewById(R.id.viewpager);
        mPageAdapter = new Adapter(this, getSupportFragmentManager(), fragments, names);
        mPager.setAdapter(mPageAdapter);
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
