package com.example.dijonkariz.washme;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class StartSlider extends AppCompatActivity {

    private ViewPager mslideViewPager;
    private LinearLayout mdotLayout;

    private TextView[] mdots;

    private SliderAdapter sliderAdapter;

    private Button mNextBtn;
    private Button mBackBtn;
    private int mCurrentPage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_slider);

        if (!isfirsttime()){
            startHomeActivity();
            finish();
        }

        setContentView(R.layout.activity_start_slider);

        mslideViewPager = (ViewPager)findViewById(R.id.view_pager);
        mdotLayout = (LinearLayout)findViewById(R.id.dotLayout);

        mNextBtn = (Button)findViewById(R.id.btn_next);
        mBackBtn = (Button)findViewById(R.id.btn_skip);


        sliderAdapter = new SliderAdapter(this);
        mslideViewPager.setAdapter(sliderAdapter);

        addDotsIndicator(0);

        mslideViewPager.addOnPageChangeListener(viewListener);

        mNextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                mslideViewPager.setCurrentItem(mCurrentPage +1);
            }
        });

        mBackBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                mslideViewPager.setCurrentItem(mCurrentPage -1);
            }
        });

    }

    private boolean isfirsttime(){
        SharedPreferences ref = getApplicationContext().getSharedPreferences("introSlide", Context.MODE_PRIVATE);
        return ref.getBoolean("FirstTimeStartFlag",true);

    }

    private void setFirstTimeStartStstus(boolean stt){
        SharedPreferences ref = getApplicationContext().getSharedPreferences("introSlide", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = ref.edit();
        editor.putBoolean("FirstTimeStartFlag", stt);
        editor.apply();
    }

    public void addDotsIndicator(int position){

        mdots = new TextView[4];
        mdotLayout.removeAllViews();

        for (int i=0;  i< mdots.length; i++){

            mdots[i] = new TextView(this);
            mdots[i].setText(Html.fromHtml("&#8226;"));
            mdots[i].setTextSize(35);
            mdots[i].setTextColor(getResources().getColor(R.color.washwhite));
            mdotLayout.addView(mdots[i]);

        }

        if (mdots.length >0){
            mdots[position].setTextColor(getResources().getColor(R.color.white));
        }
    }

    public void startHomeActivity() {
        setFirstTimeStartStstus(false);
        Intent intent = new Intent(this, LogIn.class);
        startActivity(intent);
    }

    public void signInActivity() {
        setFirstTimeStartStstus(false);
        Intent intent = new Intent(this, SignInTwo.class);
        startActivity(intent);
    }

    ViewPager.OnPageChangeListener viewListener = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {

            addDotsIndicator(position);

            mCurrentPage = position;

            if (position ==0){

                mNextBtn.setEnabled(true);
                mBackBtn.setEnabled(false);
                mBackBtn.setVisibility(View.INVISIBLE);

                mNextBtn.setText(R.string.next);
                mBackBtn.setText("");

            }else if (position == mdots.length - 1){

                mNextBtn.setEnabled(true);
                mBackBtn.setEnabled(true);
                mBackBtn.setVisibility(View.VISIBLE);

                mNextBtn.setText(R.string.finish);
                mBackBtn.setText(R.string.back);

                mNextBtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        signInActivity();
                    }
                });

            }else{

                mNextBtn.setEnabled(true);
                mBackBtn.setEnabled(true);
                mBackBtn.setVisibility(View.VISIBLE);

                mNextBtn.setText(R.string.next);
                mBackBtn.setText(R.string.back);

            }
        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    };
}
