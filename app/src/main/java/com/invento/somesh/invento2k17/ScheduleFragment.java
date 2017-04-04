package com.invento.somesh.invento2k17;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public class ScheduleFragment extends Fragment {

    public static TabLayout tabLayout_sch;
    public static ViewPager viewPager_sch;
    public static int int_items = 3 ;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View y =  inflater.inflate(R.layout.fragment_schedule,null);
        tabLayout_sch = (TabLayout) y.findViewById(R.id.tabs_sch);
        viewPager_sch = (ViewPager) y.findViewById(R.id.viewpager_sch);


        viewPager_sch.setAdapter(new MyAdapter(getChildFragmentManager()));


        tabLayout_sch.post(new Runnable() {
            @Override
            public void run() {
                tabLayout_sch.setupWithViewPager(viewPager_sch);
            }
        });

        return y;

    }

    class MyAdapter extends FragmentPagerAdapter {

        public MyAdapter(FragmentManager fm) {
            super(fm);
        }



        @Override
        public Fragment getItem(int position)
        {
            switch (position){
                case 0 : return new First_fragment();
                case 1 : return new Second_fragment();
                case 2 : return new Third_fragment();
            }
            return null;
        }

        @Override
        public int getCount() {

            return int_items;

        }



        @Override
        public CharSequence getPageTitle(int position) {

            switch (position){
                case 0 :
                    return "26 <sup>rd</sup>" +
                            "\n" +
                            "April";
                case 1 :
                    return "27th" +
                            "\n" +
                            "April";
                case 2 :
                    return "28th" +
                            "\n" +
                            "April";
            }
            return null;
        }
    }

}
