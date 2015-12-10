//�n�J/��U
package com.example.f;


import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Vector;


import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.style.URLSpan;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TabHost;
import android.widget.TabWidget;
import android.widget.Toast;
import android.widget.TabHost.TabContentFactory;
import android.widget.TextView;

public class Personal extends Fragment implements
TabHost.OnTabChangeListener, ViewPager.OnPageChangeListener{
	
	private static Context mContext;
	private TabHost mTabHost;
	
	private MyViewPagerAdapter mAdapter;
	private ViewPager mPager;
	private HashMap<String, TabInfo> mHashMapTabInfo = new HashMap<String, TabInfo>();
	View v;
	
	public Personal() {
		v = null;
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		
		
		v = inflater.inflate(R.layout.personal, container, false);
		mContext = getActivity();
		
		this.initTabHost(savedInstanceState);
		if (savedInstanceState != null) {
			mTabHost.setCurrentTabByTag(savedInstanceState.getString("tab"));
		}
		this.initViewPager();
		
		
		updateUI();
		return v;
	}
	
	
	

	@Override
	public void onDetach() {
		super.onDetach();
		
		try {
	        Field childFragmentManager = Fragment.class.getDeclaredField("mChildFragmentManager");
	        childFragmentManager.setAccessible(true);
	        childFragmentManager.set(this, null);

	    } catch (NoSuchFieldException e) {
	        throw new RuntimeException(e);
	    } catch (IllegalAccessException e) {
	        throw new RuntimeException(e);
	    }
	}
	
	
	/* start of OnPageChangeListener */
	
	@Override
	public void onPageScrollStateChanged(int arg0) {
	}

	@Override
	public void onPageScrolled(int arg0, float arg1, int arg2) {
	}

	@Override
	public void onPageSelected(int position) {
		this.mTabHost.setCurrentTab(position);
	}
	
	/* end of OnPageChangeListener */
	
	/* start of OnTabChangeListener */
	
	@Override
	public void onTabChanged(String tabId) {
		int pos = this.mTabHost.getCurrentTab(); 
		
		this.mPager.setCurrentItem(pos);
	}
	
	/* end of OnTabChangeListener */
	
	private void initViewPager() {
		//Add Fragments into ViewPager
		List<Fragment> fragments = new Vector<Fragment>();
		fragments.add(Fragment.instantiate(getActivity(), PersonalLogin.class.getName())); //�[�J�n�J������Tabhost
		fragments.add(Fragment.instantiate(getActivity(), PersonalLoginEasyCard.class.getName())); //�[�J��U������Tabhost
		fragments.add(Fragment.instantiate(getActivity(), PersonalRegister.class.getName())); //�[�J��U������Tabhost
		
		this.mAdapter = new MyViewPagerAdapter(getChildFragmentManager(), fragments);
		
		this.mPager = (ViewPager) v.findViewById(R.id.my_viewpager);
		this.mPager.setAdapter(this.mAdapter);
		this.mAdapter.notifyDataSetChanged();
        
		//set OnPageChangeListener
		this.mPager.setOnPageChangeListener(this);
	}
	
	public void updateUI() {
		
}
	
	
	private void initTabHost(Bundle args) {
		mTabHost = (TabHost) v.findViewById(android.R.id.tabhost);
		mTabHost.setup();
		TabInfo tabInfo = null;
		
		
	    
		// Create Child Tab1
	    
		Personal.AddTab(this, this.mTabHost, this.mTabHost.newTabSpec("subtab1").setIndicator(createTabView(mContext, "登入")),
				(tabInfo = new TabInfo("Tab1", PersonalLogin.class, args)));
		this.mHashMapTabInfo.put(tabInfo.tag, tabInfo);
		
		
		// Create Child Tab2
		Personal.AddTab(this, this.mTabHost, this.mTabHost.newTabSpec("subtab2").setIndicator(createTabView(mContext, "nfc登入")),
						(tabInfo = new TabInfo("Tab2", PersonalLoginEasyCard.class, args)));
		this.mHashMapTabInfo.put(tabInfo.tag, tabInfo);
		mTabHost.setCurrentTab(0);
				
		// Create Child Tab3
		Personal.AddTab(this, this.mTabHost, this.mTabHost.newTabSpec("subtab3").setIndicator(createTabView(mContext, "註冊")),
				(tabInfo = new TabInfo("Tab3", PersonalRegister.class, args)));
		this.mHashMapTabInfo.put(tabInfo.tag, tabInfo);
		mTabHost.setCurrentTab(0);
		
		
		
		DisplayMetrics dm = new DisplayMetrics();
		getActivity().getWindowManager().getDefaultDisplay().getMetrics(dm);
		int screenWidth = dm.widthPixels;
		
		TabWidget tabWidget = mTabHost.getTabWidget(); 
		int count = tabWidget.getChildCount();
		if (count > 1) {
			for (int i = 0; i < count; i++) {
				tabWidget.getChildTabViewAt(i).setMinimumWidth((screenWidth) / 1);
			}
		}
		
		mTabHost.setOnTabChangedListener(this);
	}
	
	private static View createTabView(final Context context, final String text) {
	    View view = LayoutInflater.from(context).inflate(R.layout.custom_tab, null);
	    TextView tv = (TextView) view.findViewById(R.id.text);
	    tv.setText(text);
	    return view;
	}
	
	private static void AddTab(Personal activity, TabHost tabHost, TabHost.TabSpec tabSpec, TabInfo tabInfo) {
		
		tabSpec.setContent(activity.new TabFactory(mContext));
		tabHost.addTab(tabSpec);
	}
	
	private class TabInfo {
		private String tag;
		private Class<?> clss;
		private Bundle args;
		private Fragment fragment;

		TabInfo(String tag, Class<?> clazz, Bundle args) {
			this.tag = tag;
			this.clss = clazz;
			this.args = args;
		}
	}
	
	class TabFactory implements TabContentFactory {

		private final Context mContext;

		public TabFactory(Context context) {
			mContext = context;
		}

		public View createTabContent(String tag) {
			View v = new View(mContext);
			v.setMinimumWidth(0);
			v.setMinimumHeight(0);
			return v;
		}
	}
	
}
