//�n�J/��U  �l��_�n�J
package com.example.f;

import java.util.List;



import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

public class PersonalLoginEasyCard extends Fragment {

	View v;
	TextView gotonfc;
	Button btn;

	public PersonalLoginEasyCard() {
		v = null;
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		v = inflater
				.inflate(R.layout.personal_login_easycard, container, false);
		updateUI();

		return v;
	}

	@Override
	public void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
		SharedPreferences sp = getActivity().getSharedPreferences("cram", 0);
		gotonfc.setText(sp.getString("EasyCardTag", "�}��nfc"));

	}

	private void updateUI() {
		// TODO Auto-generated method stub
		gotonfc = (TextView) v.findViewById(R.id.gotonfc);
		btn = (Button) v.findViewById(R.id.btn);
		gotonfc.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(getActivity(), NFC.class);
				startActivity(intent);
			}

		});
		btn.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
			}

		});

		// btn.setOnClickListener(new OnClickListener() {
		//
		// @Override
		// public void onClick(View v) {
		// // TODO Auto-generated method stub
		//
		// if (!edtEmail.getText().toString().equals("")
		// && !edtPassword.getText().toString().equals("")) {
		//
		// ParseQuery<ParseObject> query = ParseQuery
		// .getQuery("Member");
		// query.whereEqualTo("Email", edtEmail.getText().toString());
		// query.findInBackground(new FindCallback<ParseObject>() {
		// public void done(List<ParseObject> EmailList,
		// ParseException e) {
		// if (e == null) {
		// if (EmailList.size() == 0) {
		// //�d�L���b��
		// Toast.makeText(
		// ((MainActivity) getActivity()),
		// "�b����~", Toast.LENGTH_LONG).show();
		// } else {
		// //�b�����T
		// ParseObject object = EmailList.get(0);
		// if (object.getString("Password").equals(
		// edtPassword.getText().toString())) {
		// //�K�X���T
		// Toast.makeText(
		// ((MainActivity) getActivity()),
		// "���\�n�J", Toast.LENGTH_LONG)
		// .show();
		// SharedPreferences sp = getActivity().getSharedPreferences("cram", 0);
		// sp.edit().putBoolean("isLogin", true).commit();
		// getActivity().onBackPressed();
		// } else {
		// //�K�X��~
		// Toast.makeText(
		// ((MainActivity) getActivity()),
		// "�K�X��~", Toast.LENGTH_LONG)
		// .show();
		// }
		//
		// }
		//
		// // } else {
		// // Toast.makeText(
		// // ((MainActivity) getActivity()),
		// // "Email�榡��~", Toast.LENGTH_LONG)
		// // .show();
		// // }
		//
		// } else {
		// Log.d("name", "Error: " + e.getMessage());
		// }
		// }
		// });
		//
		// } else {
		// Toast.makeText(((MainActivity) getActivity()), "��줣�ର��",
		// Toast.LENGTH_LONG).show();
		// }
		//
		// }
		// });
	}

	private boolean checkEmailFormat(String email) {
		if (email
				.matches("^[_a-z0-9-]+([.][_a-z0-9-]+)*@[a-z0-9-]+([.][a-z0-9-]+)*$")) {
			return true;
		} else {
			return false;
		}

	}

}
