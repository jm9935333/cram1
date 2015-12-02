//最新消息
package com.example.cram;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.example.cram.NewMessageAdapter;
import com.example.cram.NewMessageListRow;


public class NewMessage extends Fragment{

	View v;

	// ------------------------------------------------------------------------------
	private Context context;
	private ListView lv;
	private LinearLayout ll_NoCommentParent;
	private List<NewMessageListRow> recordList = new ArrayList<NewMessageListRow>();
	private NewMessageAdapter listAdapter;
	private TextView Message;

	// ------------------------------------------------------------------------------

	public NewMessage() {
		v = null;
	}

	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		v = inflater.inflate(R.layout.newmessage, container, false);

		updateUI();

		return v;
	}

//	public void onDetach() {
		// super.onDetach();
		// try {
		// Field childFragmentManager = Fragment.class
		// .getDeclaredField("mChildFragmentManager");
		// childFragmentManager.setAccessible(true);
		// childFragmentManager.set(this, null);
		//
		// } catch (NoSuchFieldException e) {
		// throw new RuntimeException(e);
		// } catch (IllegalAccessException e) {
		// throw new RuntimeException(e);
		// }
//	}

	public void updateUI() {
		
		listAdapter = new NewMessageAdapter(recordList,getActivity());
		lv = (ListView) v.findViewById(R.id.listMain);
		lv.setAdapter(listAdapter);
		
		// Log.d("myDebug", "MainActivity.commentVisibleItem:"
		// + MainActivity.articleVisibleItem);
		// Log.d("myDebug", "MainActivity.articleVisibleItemTop:"
		// + MainActivity.articleVisibleItemTop);
		// lv.setSelectionFromTop(MainActivity.articleVisibleItem,
		// MainActivity.articleVisibleItemTop);
		
		recordList.clear();
		for(int i=1;i<20;i++)
		recordList.add(new NewMessageListRow("10/"+i,"消息  "+i));
		lv.setOnItemClickListener(OnItemClick);
//		SharedPreferences sp = getActivity().getSharedPreferences("EatMeData",
//				0);
//		JSONArray jsonCommentArray = null;
//		try {
//			jsonCommentArray = new JSONArray(sp.getString("store_info_comment",
//					""));
//			if (jsonCommentArray.length() != 0) {
//				lv.setVisibility(View.VISIBLE);
//				ll_NoCommentParent.setVisibility(View.GONE);
//				/* Add articles into view */
//				for (int i = 0; i < jsonCommentArray.length(); i++) {
//					recordList.add(new ShopInfoSubListRowComment(
//							jsonCommentArray.getJSONObject(i).getString(
//									"member_name"), jsonCommentArray
//									.getJSONObject(i).getString("comment"),
//							jsonCommentArray.getJSONObject(i).getString("like")
//					/*
//					 * ,jsonCommentArray.getJSONObject(i).getString("time" )
//					 */));
//				}
//			} else {
//				lv.setVisibility(View.GONE);
//				ll_NoCommentParent.setVisibility(View.VISIBLE);
//			}
//
//		} catch (JSONException e) {
//		}
		
	}
	
	public AdapterView.OnItemClickListener OnItemClick = new AdapterView.OnItemClickListener() {

		@Override
		public void onItemClick(AdapterView<?> parent, View view, int position,
				long id) {
			// TODO Auto-generated method stub
			FragmentTransaction transaction = getActivity().getSupportFragmentManager()
					.beginTransaction();
			Test Test = new Test();
			transaction.replace(R.id.fragment_container, Test);
			transaction.addToBackStack(null);
			transaction.commitAllowingStateLoss();
			
			
		}};
}
