package com.example.btth4trongnghia;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.List;

import me.relex.circleindicator.CircleIndicator;

public class MainActivity5 extends AppCompatActivity {
    private ViewPager mViewPager;
    private CircleIndicator mCircleIndicate;
    private List<Image> mListImage;

    private Handler mHandler =new Handler();
    private Runnable mRunnable =new Runnable() {
        @Override
        public void run() {
            if(mViewPager.getCurrentItem()==mListImage.size() -1) {
                mViewPager.setCurrentItem(0);
            } else {
                mViewPager.setCurrentItem(mViewPager.getCurrentItem()+1);
            }
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);
        BottomNavigationView navigationView = findViewById(R.id.bottom_nav);
        navigationView.setSelectedItemId(R.id.action_home);
        navigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.action_home:
                        Toast.makeText(MainActivity5.this, "Home", Toast.LENGTH_SHORT).show();
                        overridePendingTransition(0,0);
                        break;

                    case R.id.action_list:
                        Toast.makeText(MainActivity5.this, "List", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(MainActivity5.this, MainActivity6.class);
                        startActivity(intent);
                        overridePendingTransition(0,0);
                        break;

                    case R.id.action_profile:
                        Toast.makeText(MainActivity5.this, "Profile", Toast.LENGTH_SHORT).show();
                        Intent intent1 = new Intent(MainActivity5.this, MainActivity2.class);
                        startActivity(intent1);
                        overridePendingTransition(0,0);
                        break;
                }
                return true;
            }
        });
        mViewPager =findViewById(R.id.view_pager);
        mCircleIndicate =findViewById(R.id.circle_indicator);
        mListImage=getListImage();
        ImageViewPagerAdapter adapter = new ImageViewPagerAdapter(mListImage);
        mViewPager.setAdapter(adapter);
        mCircleIndicate.setViewPager(mViewPager);
        mHandler.postDelayed(mRunnable,2000);
        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                mHandler.removeCallbacks(mRunnable);
                mHandler.postDelayed(mRunnable,2000);

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }
    List<Image> getListImage(){
        List<Image> list =new ArrayList<>();
        list.add(new Image(R.drawable.oto1));
        list.add(new Image(R.drawable.oto2));
        list.add(new Image(R.drawable.oto3));
        list.add(new Image(R.drawable.oto4));
        return list;
    }
}