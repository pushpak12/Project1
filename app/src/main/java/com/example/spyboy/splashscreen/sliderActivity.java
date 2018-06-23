package com.example.spyboy.splashscreen;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class sliderActivity extends AppCompatActivity
{
    private ViewPager mSlideViewPager;
    private LinearLayout mDotLayout;
    private TextView[] mDots;

    private  SliderAdapter sliderAdapter;

    private Button mNextBtn;
    private Button mbackBtn;

    private int mCurrentPage;


    @SuppressLint("CutPasteId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_slider);

       mSlideViewPager = (ViewPager) findViewById(R.id.slideViewPager);
       mDotLayout = (LinearLayout) findViewById(R.id.dotsLayout);

       mNextBtn = (Button) findViewById(R.id.nextBtn);
       mbackBtn = (Button) findViewById(R.id.prevBtn);

       sliderAdapter = new SliderAdapter(this);
       mSlideViewPager.setAdapter(sliderAdapter);
       addDotsIndicator(0);
       mSlideViewPager.addOnPageChangeListener(viewListner);

       mNextBtn.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v)
           {
               mSlideViewPager.setCurrentItem(mCurrentPage + 1);
               if(mNextBtn.getText()=="FINISH"){
                   startActivity(new Intent(getApplicationContext(),LoginActivity.class));
               }
           }
       });

       mbackBtn.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v)
           {
               mSlideViewPager.setCurrentItem(mCurrentPage - 1);
           }
       });

    }

    public void addDotsIndicator(int position)
    {
        mDots = new TextView[4];
        mDotLayout.removeAllViews();
        for(int i=0;i<mDots.length;i++)
        {
            mDots[i] =  new TextView(this);
            mDots[i].setText(Html.fromHtml("&#8226"));
            mDots[i].setTextSize(35);
            mDots[i].setTextColor(getResources().getColor(R.color.colorTransparentWhite));

            mDotLayout.addView(mDots[i]);
        }
        if (mDots.length>0)
        {
            mDots[position].setTextColor(getResources().getColor(R.color.colorTransparentWhite));
        }
    }
    ViewPager.OnPageChangeListener viewListner = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels)
        {

        }

        @Override
        public void onPageSelected(int position){

            addDotsIndicator(position);
            mCurrentPage = position;
            if(position==0)
            {
               mNextBtn.setEnabled(true);
               mbackBtn.setEnabled(false);
               mbackBtn.setVisibility(View.INVISIBLE);

               mNextBtn.setText("NEXT");
               mbackBtn.setText("");
            }
            else if(position==mDots.length -1 )
            {
                mNextBtn.setEnabled(true);
                mbackBtn.setEnabled(true);
                mbackBtn.setVisibility(View.VISIBLE);

                mNextBtn.setText("FINISH");
                mbackBtn.setText("BACK");
            }
            else
            {

                mNextBtn.setEnabled(true);
                mbackBtn.setEnabled(true);
                mbackBtn.setVisibility(View.VISIBLE);

                mNextBtn.setText("NEXT");
                mbackBtn.setText("BACK");
            }
        }

        @Override
        public void onPageScrollStateChanged(int state)
        {

        }
    };
}
