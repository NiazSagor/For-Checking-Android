package com.example.android.forchecking;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class SlideAdapter extends PagerAdapter {

    Context context;
    LayoutInflater layoutInflater;

    public SlideAdapter(Context context) {
        this.context = context;
    }

    private int[] slideImges = {
            R.drawable.logo2,
            R.drawable.eat_icon,
            R.drawable.sleep_icon,
            R.drawable.code_icon
    };

    private String[] headings = {
            "", "EAT", "SLEEP", "CODE"
    };

    private String[] slide_desc = {
            "<b>Mr Pharmacy brings your medicine from your neighborhood store</b>",
            "Lorem ipsum nibh justo dui ultricies venenatis pharetra, rhoncus nulla lorem imperdiet nisi scelerisque ultrices aliquam, mollis suscipit lobortis sodales ultrices lacinia gravida imperdiet hendrerit conubia duis cras turpis scelerisque donec tincidunt torquent quisque est.",
            "Eu faucibus nunc facilisis pretium per quam rhoncus, hac mi fames ac scelerisque curabitur duis, aptent erat dui consectetur quis tempor proin augue felis in et fames ac imperdiet.",
            "Egestas est litora felis rhoncus facilisis interdum non inceptos urna integer, torquent"
    };


    @Override
    public int getCount() {
        return headings.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object o) {
        return view == (RelativeLayout) o;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.slide_layout, container, false);

        ImageView imageView = view.findViewById(R.id.image1);
        TextView textView = view.findViewById(R.id.text1);
        TextView textView1 = view.findViewById(R.id.text2);

        imageView.setImageResource(slideImges[position]);
        textView.setText(headings[position]);
        textView1.setText(slide_desc[position]);

        container.addView(view);

        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((RelativeLayout) object);
    }
}
