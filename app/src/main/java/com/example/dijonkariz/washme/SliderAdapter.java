package com.example.dijonkariz.washme;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class SliderAdapter extends PagerAdapter {

     Context context;
     LayoutInflater inflater;

    //constructor
    public SliderAdapter( Context context) {

        this.context = context;
    }

    //stores values for slider
    public int[] sliderImages = {
            R.drawable.locations,
            R.drawable.book_icon,
            R.drawable.carcleaning_icon,
            R.drawable.cleancar_icon

    };

    public String[] sliderHeadings = {
          "Find Location",
          "Book a service",
          "Car washed by expert",
            "Drive your clean car away"
    };

    @Override
    public int getCount() {
        return sliderHeadings.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == (RelativeLayout) object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {

        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        assert inflater != null;
        View view = inflater.inflate(R.layout.slide_layout, container,false);

        ImageView slideImageView = (ImageView)view.findViewById(R.id.slide_image);
        TextView slideHeading = (TextView) view.findViewById(R.id.slide_heading);

        slideImageView.setImageResource(sliderImages[position]);
        slideHeading.setText(sliderHeadings[position]);

        container.addView(view);

        return view;
    };

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {

        container.removeView((RelativeLayout)object);
    }
}
