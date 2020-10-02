package com.learnr.adapter;

import android.app.Activity;
import android.net.Uri;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.viewpager.widget.PagerAdapter;

import com.learnr.R;
import com.learnr.model.Leader_model;
import com.makeramen.roundedimageview.RoundedImageView;

import java.util.ArrayList;

public class ViewPagerAdapter extends PagerAdapter {


    public ArrayList<Leader_model> itemList = new ArrayList<Leader_model>();
    private LayoutInflater inflater;
    private Activity context;


    public ViewPagerAdapter(Activity context, ArrayList<Leader_model> data) {
        this.context = context;
        this.itemList = data;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }

    @Override
    public int getCount() {
        return itemList.size();
    }

    @Override
    public Object instantiateItem(ViewGroup view, int position) {
        View imageLayout = inflater.inflate(R.layout.layout_view_pager, view, false);

        assert imageLayout != null;
        RoundedImageView imageView = (RoundedImageView) imageLayout
                .findViewById(R.id.image_view);
        TextView title = imageLayout.findViewById(R.id.title);
        Leader_model leader_model = itemList.get(position);
        title.setText(leader_model.getName());
        imageView.setImageResource(leader_model.getImage());
        view.addView(imageLayout, 0);

        return imageLayout;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view.equals(object);
    }

    @Override
    public void restoreState(Parcelable state, ClassLoader loader) {
    }

    @Override
    public Parcelable saveState() {
        return null;
    }


}