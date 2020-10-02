package com.learnr.activity;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.content.Context;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Toast;

import com.eightbitlab.bottomnavigationbar.BottomBarItem;
import com.eightbitlab.bottomnavigationbar.BottomNavigationBar;
import com.learnr.R;
import com.learnr.fragment.Explore_Fragment;
import com.learnr.fragment.HomeFragment;
import com.learnr.fragment.LeaderBoard_Fragment;
import com.learnr.fragment.Profile_Fragment;

public class MainActivity extends AppCompatActivity {
    private FragmentTransaction transaction;
    private boolean single_backbutton;
    BottomNavigationBar bottomNavigationBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setupBottomBar();
        //home layout view
        transaction = getSupportFragmentManager().beginTransaction();
        HomeFragment contestFragment = new HomeFragment();
        transaction.replace(R.id.frame_layout, contestFragment, "MY Matches");
        transaction.commit();
    }

    @Nullable
    @Override
    public View onCreateView(@Nullable View parent, @NonNull String name, @NonNull Context context, @NonNull AttributeSet attrs) {
        return super.onCreateView(parent, name, context, attrs);
    }

    private void setupBottomBar() {

         bottomNavigationBar = (BottomNavigationBar) findViewById(R.id.bottom_navigation_view);
        BottomBarItem home = new BottomBarItem(R.drawable.nav_home_unchecked, R.string.home);
        BottomBarItem profile_bar = new BottomBarItem(R.drawable.nav_profile_unchecked, R.string.profile);
        BottomBarItem leaderboard_bar = new BottomBarItem(R.drawable.nav_leaderboard_unchecked, R.string.Leaderboard);
        BottomBarItem more = new BottomBarItem(R.drawable.nav_explore_unchecked, R.string.explore);

        bottomNavigationBar
                .addTab(home)
                .addTab(profile_bar)
                .addTab(leaderboard_bar)
                .addTab(more);


        bottomNavigationBar.setOnSelectListener(new BottomNavigationBar.OnSelectListener() {
            @Override
            public void onSelect(int position) {
                switch (position) {
                    case 0:
                        single_backbutton = false;
                        transaction = getSupportFragmentManager().beginTransaction();
                        HomeFragment contestFragment = new HomeFragment();
                        transaction.replace(R.id.frame_layout, contestFragment, "");
                        transaction.commit();
                        break;
                    case 1:
                        Toast.makeText(MainActivity.this, "Coming Soon", Toast.LENGTH_SHORT).show();

                        break;
                    case 2:
                        transaction = getSupportFragmentManager().beginTransaction();
                        LeaderBoard_Fragment leaderBoard_fragment = new LeaderBoard_Fragment();
                        transaction.replace(R.id.frame_layout, leaderBoard_fragment, "");
                        transaction.commit();
                        single_backbutton = true;
                        break;
                    case 3:
                        Toast.makeText(MainActivity.this, "Coming Soon", Toast.LENGTH_SHORT).show();

                        break;
                }
            }
        });
    }

    @Override
    public void onBackPressed() {
        if (single_backbutton) {
            single_backbutton = false;
            transaction = getSupportFragmentManager().beginTransaction();
            HomeFragment contestFragment = new HomeFragment();
            transaction.replace(R.id.frame_layout, contestFragment, "");
            transaction.commit();

            bottomNavigationBar.selectTab(2,false);
        } else {
            finish();
            super.onBackPressed();
        }

    }
}