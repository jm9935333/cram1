package com.example.cram;

import com.parse.Parse;

import android.app.Fragment;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.view.Menu;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.graphics.Color;

public class MainActivity extends FragmentActivity {
	private TextView test, NewMessage, ClassInfo, Login;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		Parse.enableLocalDatastore(MainActivity.this);

		Parse.initialize(MainActivity.this,
				"mZ2wYUMn2tJ18nNOEg1jLGfDCg2Y03qg73IdHsIe",
				"ghNaTQIVYsuy5flEQoKwYlKUjw7kVNsgsEVCCfCl");

		setContentView(R.layout.activity_main);
		test = (TextView) findViewById(R.id.test);
		NewMessage = (TextView) findViewById(R.id.NewMessage);
		ClassInfo = (TextView) findViewById(R.id.ClassInfo);
		Login = (TextView) findViewById(R.id.Login);
		
		// 進入test
		test.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				FragmentTransaction transaction = getSupportFragmentManager()
						.beginTransaction();
				Test Test = new Test();
				transaction.replace(R.id.fragment_container, Test);
				transaction.addToBackStack(null);
				transaction.commitAllowingStateLoss();
			}

		});

		// 做出按下去的效果
		test.setOnTouchListener(new OnTouchListener() {
			@Override
			public boolean onTouch(View v, MotionEvent event) {

				switch (event.getAction()) {

				case MotionEvent.ACTION_DOWN:
					v.setBackgroundColor(Color.argb(120, 0, 0, 0));
					break;
				case MotionEvent.ACTION_CANCEL:

				case MotionEvent.ACTION_UP:
					v.setBackgroundColor(Color.argb(0, 0, 0, 0));
					break;

				}
				return false;
			}

		});

		// 進入最新消息
		NewMessage.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				FragmentTransaction transaction = getSupportFragmentManager()
						.beginTransaction();
				NewMessage NewMessage = new NewMessage();
				transaction.replace(R.id.fragment_container, NewMessage);
				transaction.addToBackStack(null);
				transaction.commitAllowingStateLoss();
			}

		});

		// 做出按下去的效果
		NewMessage.setOnTouchListener(new OnTouchListener() {
			@Override
			public boolean onTouch(View v, MotionEvent event) {

				switch (event.getAction()) {

				case MotionEvent.ACTION_DOWN:
					v.setBackgroundColor(Color.argb(120, 0, 0, 0));
					break;
				case MotionEvent.ACTION_CANCEL:

				case MotionEvent.ACTION_UP:
					v.setBackgroundColor(Color.argb(0, 0, 0, 0));
					break;

				}
				return false;
			}

		});

		// 進入開課資訊
		ClassInfo.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				FragmentTransaction transaction = getSupportFragmentManager()
						.beginTransaction();
				ClassInfo ClassInfo = new ClassInfo();
				transaction.replace(R.id.fragment_container, ClassInfo);
				transaction.addToBackStack(null);
				transaction.commitAllowingStateLoss();
			}

		});

		// 做出按下去的效果
		ClassInfo.setOnTouchListener(new OnTouchListener() {
			@Override
			public boolean onTouch(View v, MotionEvent event) {

				switch (event.getAction()) {

				case MotionEvent.ACTION_DOWN:
					v.setBackgroundColor(Color.argb(120, 0, 0, 0));
					break;
				case MotionEvent.ACTION_CANCEL:

				case MotionEvent.ACTION_UP:
					v.setBackgroundColor(Color.argb(0, 0, 0, 0));
					break;

				}
				return false;
			}

		});

		// 進入登入/註冊
		Login.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				FragmentTransaction transaction = getSupportFragmentManager()
						.beginTransaction();
				Personal Login = new Personal();
				transaction.replace(R.id.fragment_container, Login);
				transaction.addToBackStack(null);
				transaction.commitAllowingStateLoss();
			}

		});

		// 做出按下去的效果
		Login.setOnTouchListener(new OnTouchListener() {
			@Override
			public boolean onTouch(View v, MotionEvent event) {

				switch (event.getAction()) {

				case MotionEvent.ACTION_DOWN:
					v.setBackgroundColor(Color.argb(120, 0, 0, 0));
					break;
				case MotionEvent.ACTION_CANCEL:

				case MotionEvent.ACTION_UP:
					v.setBackgroundColor(Color.argb(0, 0, 0, 0));
					break;

				}
				return false;
			}

		});

	}

}
