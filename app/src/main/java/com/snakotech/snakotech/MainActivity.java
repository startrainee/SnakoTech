package com.snakotech.snakotech;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.snakotech.snakotech.activity.base.BaseActivity;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends BaseActivity {

    private TextView mTextMessage;
    private List<View> views;
    private List<String> titles;
    private ViewPager viewPager;
    private PagerAdapter pagerAdapter;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    mTextMessage.setText(R.string.title_home);
                    if (viewPager != null) viewPager.setCurrentItem(0);
                    return true;
                case R.id.navigation_dashboard:
                    mTextMessage.setText(R.string.title_dashboard);
                    if (viewPager != null) viewPager.setCurrentItem(1);
                    return true;
                case R.id.navigation_notifications:
                    mTextMessage.setText(R.string.title_notifications);
                    if (viewPager != null) viewPager.setCurrentItem(2);
                    return true;
            }
            return false;
        }

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTextMessage = (TextView) findViewById(R.id.message);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        navigation.setSelectedItemId(R.id.navigation_dashboard);

        views = new ArrayList<>();
        LayoutInflater layoutInflater = getLayoutInflater();
        final View view = layoutInflater.inflate(R.layout.activity_1,null);
        View view1 = layoutInflater.inflate(R.layout.activity_2,null);
        View view2 = layoutInflater.inflate(R.layout.activity_3,null);
        View view3 = layoutInflater.inflate(R.layout.activity_4,null);
        views.add(view);
        views.add(view1);
        views.add(view2);
        views.add(view3);

        titles = new ArrayList<>();
        titles.add("Activity0");
        titles.add("Activity1");
        titles.add("Activity2");
        titles.add("Activity3");

        viewPager = (ViewPager) findViewById(R.id.view_pager);
        pagerAdapter = new PagerAdapter() {
            @Override
            public Object instantiateItem(ViewGroup container, int position) {
                Log.d("wcy","instantiateItem()");
                container.addView(views.get(position));
                return position;
            }

            @Override
            public void destroyItem(ViewGroup container, int position, Object object) {
                Log.d("wcy","destroyItem(): " + position);
                container.removeView(views.get(position));
            }

            @Override
            public int getCount() {
                Log.d("wcy","getCount()");
                return views.size();
            }

            @Override
            public boolean isViewFromObject(View view, Object object) {
                Log.d("wcy","isViewFromObject()");
                return view == views.get(Integer.parseInt(object.toString()));
            }

            @Override
            public CharSequence getPageTitle(int position) {
                return titles.get(position);
            }
        };
        viewPager.setAdapter(pagerAdapter);
        viewPager.setCurrentItem(2);

    }

}
