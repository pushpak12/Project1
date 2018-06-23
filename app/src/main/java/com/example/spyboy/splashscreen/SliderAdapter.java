package com.example.spyboy.splashscreen;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class SliderAdapter extends PagerAdapter
{
    Context context;
    LayoutInflater layoutInflater;

    public  SliderAdapter(Context context)
    {
        this.context = context;
    }

    public int[] slide_images = {

            R.drawable.attend,
            R.drawable.event,
            R.drawable.holiday,
            R.drawable.share

    };

    public String[] slide_headings = {

            "ATTENDANCE",
            "EVENTS",
            "HOLIDAYS",
            "SHARE THINGS"

    };

    public String[] slide_desc = {



    };

    @Override
    public int getCount()
    {
        return slide_headings.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object)
    {
        return view == (RelativeLayout) object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position)
    {
        layoutInflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.slide_layout,container,false);
        ImageView slideImageView = (ImageView) view.findViewById(R.id.slideimage);
        TextView slideHeading = (TextView) view.findViewById(R.id.slideheading);


        slideImageView.setImageResource(slide_images[position]);
        slideHeading.setText(slide_headings[position]);


        container.addView(view);


        return view;
    }

    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((RelativeLayout)object);

    }

}
