package com.example.f;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.os.AsyncTask;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

/**
  * ViewPager Adpater : ��oViewPager������Fragment
 *
 */
public class MyViewPagerAdapter extends FragmentPagerAdapter{

	
	private List<Fragment> fragments;
    public MyViewPagerAdapter(FragmentManager fragmentmanager, List<Fragment> fragments) {
        super(fragmentmanager);
        this.fragments = fragments;
    }
    
    
    @SuppressWarnings("deprecation")
	
	@Override
    public Fragment getItem(int position) {
        return this.fragments.get(position);
    }
    @Override
    public int getCount() {
        return this.fragments.size();
    }
	

}
