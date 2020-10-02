package com.learnr.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.learnr.R;
import com.learnr.adapter.ViewPagerAdapter;
import com.learnr.model.Leader_model;

import java.util.ArrayList;

import me.relex.circleindicator.CircleIndicator;

public class Deatils_view extends AppCompatActivity {
    TextView title_top, sub_titile,chapter,chapter_title;
    private  ViewPager mPager;
    CircleIndicator indicator;
    public ArrayList<Leader_model> itemList = new ArrayList<Leader_model>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deatils_view);
        itemList.add(new Leader_model("1",getString(R.string.demo_text),R.drawable.c3,""));
        itemList.add(new Leader_model("2",getString(R.string.demo_text),R.drawable.c1,""));
        itemList.add(new Leader_model("3",getString(R.string.demo_text),R.drawable.c2,""));
        itemList.add(new Leader_model("4",getString(R.string.demo_text),R.drawable.c4,""));
        itemList.add(new Leader_model("5",getString(R.string.demo_text),R.drawable.c5,""));
        itemList.add(new Leader_model("6",getString(R.string.demo_text),R.drawable.c6,""));
        //set text of tilte
        try {
            title_top = findViewById(R.id.title_top);
            title_top.setText(getIntent().getStringExtra("title"));
            sub_titile = findViewById(R.id.sub_titile);
            sub_titile.setText(getIntent().getStringExtra("sub_title"));
        } catch (NullPointerException e) {

        }
        mPager = (ViewPager) findViewById(R.id.view_pager);
        chapter= (TextView) findViewById(R.id.chapter);
        chapter_title= (TextView) findViewById(R.id.chapter_title);
        final float scaleFactor = 0.85f;
        mPager.setPageMargin(-35);
        mPager.setOffscreenPageLimit(2);
        mPager.setPageTransformer(false, new ViewPager.PageTransformer() {
            @Override
            public void transformPage(@NonNull View page, float position) {
                page.setScaleY((1 - Math.abs(position) * (1 - scaleFactor)));
                page.setScaleX(scaleFactor + Math.abs(position) * (1 - scaleFactor));
            }
        });
        indicator = (CircleIndicator)  findViewById(R.id.indicator);
        mPager.setAdapter(new ViewPagerAdapter(Deatils_view.this, itemList));
        indicator.setViewPager(mPager);
        mPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                Log.e("asdas", String.valueOf(position));
                chapter.setText("Chapter "+String.valueOf(position+1)+"/6");
                chapter_title.setText("Title page "+String.valueOf(position+1)+"");
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
       Log.e("asfsf", String.valueOf(mPager.getCurrentItem()));
    }

}