package com.example.id2013_03.startProject.Tabbed_Pages;

// Importing the required functions for the class/s

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;


import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.GestureDetectorCompat;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;



import com.example.id2013_03.mclaren.R;

import fr.castorflex.android.verticalviewpager.VerticalViewPager;


public class Tab_Vehicle_Spec extends Fragment{
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        // Placing the layout into the rootView variable
        // This is also what places and fills the container on the page
        View rootView = inflater.inflate(R.layout.test, container, false);

        final VerticalViewPager viewPager = (VerticalViewPager) rootView.findViewById(R.id.viewPagerVertTest);
        viewPager.setAdapter(new CustomAdapter(getActivity().getSupportFragmentManager(), getActivity()));




        TabLayout testTab = (TabLayout) rootView.findViewById(R.id.tabLayoutTest);


        testTab.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());

            }
        });

        return rootView;
    }


    private class CustomAdapter extends FragmentStatePagerAdapter {
        // Creating a private string that is only for this class
        // This string stores the names of each of the tabs that I have named.
        // These tab names are then stored within the variable fragments
        private String fragments[] = {"Yo", "Test"};


        public CustomAdapter(FragmentManager supportFragmentManager, Context applicationContext){
            super(supportFragmentManager);

        }

        @Override
        public Fragment getItem(int position){
            Fragment fragment = null;
            switch (position){
                case 0:
                    fragment = new Yo();
                    break;
                case 1:
                    fragment = new YoYo();
                    break;

            }
            return fragment;
        }

        @Override
        public int getCount(){
            return fragments.length;
        }

        @Override
        public CharSequence getPageTitle(int position){
            return fragments[position];
        }


    }
}