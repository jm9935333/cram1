//登入/註冊  子頁_登入
package com.example.cram;

import java.util.List;

import com.parse.FindCallback;
import com.parse.Parse;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class PersonalLogin extends Fragment {

	View v;
	EditText email, password, name;
	Button btn;

	public PersonalLogin() {
		v = null;
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		v = inflater.inflate(R.layout.personal_login, container, false);

		updateUI();

		return v;
	}

	private void updateUI() {
		// TODO Auto-generated method stub
		email = (EditText) v.findViewById(R.id.email);
		password = (EditText) v.findViewById(R.id.password);
		name = (EditText) v.findViewById(R.id.name);
		btn = (Button) v.findViewById(R.id.btn);

		// Enable Local Datastore
//		Parse.enableLocalDatastore(((MainActivity) getActivity()));
//
//		Parse.initialize(((MainActivity) getActivity()),
//				"mZ2wYUMn2tJ18nNOEg1jLGfDCg2Y03qg73IdHsIe",
//				"ghNaTQIVYsuy5flEQoKwYlKUjw7kVNsgsEVCCfCl");

		btn.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub

				if (!email.getText().toString().equals("")
						&& !password.getText().toString().equals("")
						&& !name.getText().toString().equals("")) {

					ParseQuery<ParseObject> query = ParseQuery
							.getQuery("Member");
					query.whereEqualTo("Name", name.getText().toString());

					query.findInBackground(new FindCallback<ParseObject>() {
						public void done(List<ParseObject> nameList,
								ParseException e) {
							if (e == null) {
								if (checkEmailFormat(email.getText().toString())) {

									if (nameList.size() == 0) {
										ParseObject member = new ParseObject(
												"Member");
										member.put("Email",
												"" + email.getText());
										member.put("Password",
												"" + password.getText());
										member.put("Name", "" + name.getText());
										member.saveInBackground();
										Toast.makeText(((MainActivity) getActivity()), "註冊成功",
												Toast.LENGTH_LONG).show();
									} else {
										Toast.makeText(((MainActivity) getActivity()), "此帳號已存在",
												Toast.LENGTH_LONG).show();
									}

								} else {
									Toast.makeText(((MainActivity) getActivity()), "Email格式錯誤",
											Toast.LENGTH_LONG).show();
								}

							} else {
								Log.d("name", "Error: " + e.getMessage());
							}
						}
					});

				} else {
					Toast.makeText(((MainActivity) getActivity()), "欄位不能為空", Toast.LENGTH_LONG)
							.show();
				}

			}
		});
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
