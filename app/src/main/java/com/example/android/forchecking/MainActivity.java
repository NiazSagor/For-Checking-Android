package com.example.android.forchecking;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    ViewPager viewPager;
    LinearLayout linearLayout;

    SlideAdapter slideAdapter;

    TextView[] dots;

    SharedPreferences sharedPreferences;

    Button button;

    Boolean buttonClicked;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sharedPreferences = getSharedPreferences("started", MODE_PRIVATE);
        buttonClicked = false;

        if (sharedPreferences.getBoolean("started", false) && !buttonClicked) {
            Intent intent = new Intent(MainActivity.this, HomeActivity.class);
            startActivity(intent);
            finish();
            return;
        }


        viewPager = findViewById(R.id.viewpager);
        linearLayout = findViewById(R.id.dotslayout);

        button = findViewById(R.id.button);
        button.setVisibility(View.INVISIBLE);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                buttonClicked = true;
                sharedPreferences.edit().putBoolean("started", true).apply();
                Intent intent = new Intent(MainActivity.this, HomeActivity.class);
                startActivity(intent);
                finish();
            }
        });

        slideAdapter = new SlideAdapter(this);
        viewPager.setAdapter(slideAdapter);

        addDotIndicator(0);

        viewPager.addOnPageChangeListener(onPageChangeListener);

    }

    public void addDotIndicator(int position) {
        dots = new TextView[4];
        linearLayout.removeAllViews();
        button.setVisibility(View.INVISIBLE);

        for (int i = 0; i < dots.length; i++) {
            dots[i] = new TextView(this);
            dots[i].setText(Html.fromHtml("&#8226;"));
            dots[i].setTextSize(35);
            dots[i].setTextColor(getResources().getColor(R.color.transparentWhite));

            linearLayout.addView(dots[i]);
        }

        if (dots.length > 0) {
            dots[position].setTextColor(getResources().getColor(R.color.colorPrimary));
        }

        if (position == 3) {
            button.setVisibility(View.VISIBLE);
        }
    }

    ViewPager.OnPageChangeListener onPageChangeListener = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int i, float v, int i1) {

        }

        @Override
        public void onPageSelected(int i) {
            addDotIndicator(i);
        }

        @Override
        public void onPageScrollStateChanged(int i) {

        }
    };
}