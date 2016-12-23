package com.example.jory.learningproject;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabItem;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.jory.learningproject.fragments.MyBlankFragment;
import com.orhanobut.logger.Logger;

import java.util.ArrayList;

public class FragmentManageActivity extends AppCompatActivity {

    private ViewPager viewPager;
    private ArrayList<Fragment> fragmentArrayList;

    private MyPageAdapter myPageAdapter;
    private FragmentManager fragmentManager;
    private TabLayout tabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment_manage);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "First Fragment Changed", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
                if (null != fragmentArrayList && fragmentArrayList.size() > 0) {
                    MyBlankFragment myBlankFragment = new MyBlankFragment();
                    myBlankFragment.setTextStr("New Fragment");
                    fragmentArrayList.remove(0);
                    fragmentArrayList.add(0, myBlankFragment);
                    myPageAdapter.notifyDataSetChanged();
                    Logger.e("First Fragment Changed 22");
                }
            }
        });
        initView();
    }

    private void initView() {
        fragmentArrayList = new ArrayList<>();

        viewPager = (ViewPager) findViewById(R.id.fragment_view_pager);

        tabLayout = (TabLayout) findViewById(R.id.tab_layout);


        for (int i = 0; i < 4; i++) {
            MyBlankFragment myBlankFragment = new MyBlankFragment();
            fragmentArrayList.add(myBlankFragment);
        }

        fragmentManager = getSupportFragmentManager();
        myPageAdapter = new MyPageAdapter(fragmentManager);
        viewPager.setAdapter(myPageAdapter);
        viewPager.setOffscreenPageLimit(2);
        tabLayout.setupWithViewPager(viewPager, true);
    }

    class MyPageAdapter extends FragmentStatePagerAdapter {


        public MyPageAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            return super.instantiateItem(container, position);
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            super.destroyItem(container, position, object);
        }

        @Override
        public Fragment getItem(int position) {
            Logger.e("getItem position " + position);
            Fragment fragment = fragmentArrayList.get(position);
            if (null == fragment) {
                Logger.e("null == fragment " + position);
                fragment = new MyBlankFragment();
            }
            return fragment;
        }

        @Override
        public int getCount() {
            return fragmentArrayList.size();
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return "" + (position + 1);
        }
    }

}
