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
		
		// �i�Jtest
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

		// ���X���U�h���ĪG
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

		// �i�J�̷s����
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

		// ���X���U�h���ĪG
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

		// �i�J�}�Ҹ�T
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

		// ���X���U�h���ĪG
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

		// �i�J�n�J/���U
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

		// ���X���U�h���ĪG
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
