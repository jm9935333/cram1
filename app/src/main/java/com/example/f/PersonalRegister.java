package com.example.f;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import static com.example.f.DbConstants.EMAIL;
import static com.example.f.DbConstants.NAME;
import static com.example.f.DbConstants.TABLE_NAME1;
import static com.example.f.DbConstants.PASSWORD;

public class PersonalRegister extends Fragment {

    private View v;
    EditText edtEmail, edtPassword, edtName;
    Button btn;
    TextView gotonfc;
//    SharedPreferences sp;
    DBHelperPersonalInfo dbhelperpersonal;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        v = inflater.inflate(R.layout.personal_register, container, false);
//        sp = getActivity().getSharedPreferences("cram", 0);
        updateUI();
        return v;
    }

    @Override
    public void onResume() {
        // TODO Auto-generated method stub
        super.onResume();
        Log.v("PersonalonResume", "i am here");

    }

    private void updateUI() {
        // TODO Auto-generated method stub
        edtEmail = (EditText) v.findViewById(R.id.email);
        edtPassword = (EditText) v.findViewById(R.id.password);
        edtName = (EditText) v.findViewById(R.id.name);
        btn = (Button) v.findViewById(R.id.btn);
        gotonfc = (TextView) v.findViewById(R.id.gotonfc);

        //		gotonfc.setText(sp.getString("EasyCardTag", "�}��nfc"));
        gotonfc.setText("�}��nfc");
        //		gotonfc.setOnClickListener(new OnClickListener() {
        //			//Ū��y�C�dtag
        //			@Override
        //			public void onClick(View v) {
        //				// TODO Auto-generated method stub
        //				Intent intent = new Intent(getActivity(), NFC.class);
        //				startActivity(intent);
        //			}
        //
        //		});
        dbhelperpersonal = new DBHelperPersonalInfo(getActivity());

        btn.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub

                // �P�_�O�_���Ū����
                if (!edtEmail.getText().toString().equals("")
                        && !edtPassword.getText().toString().equals("")
                        && !edtName.getText().toString().equals("")) {


                    SQLiteDatabase db = dbhelperpersonal.getWritableDatabase();
                    ContentValues values = new ContentValues();
                    values.put(NAME, edtName.getText().toString());
                    values.put(PASSWORD, edtPassword.getText().toString());
                    values.put(EMAIL, edtEmail.getText().toString());
                    db.insert(TABLE_NAME1, null, values);

                    Toast.makeText(getActivity(), "儲存成功",
                                    Toast.LENGTH_LONG).show();

                    //					ParseQuery<ParseObject> query = ParseQuery
                    //							.getQuery("Member");
                    //					query.whereEqualTo("Email", edtEmail.getText().toString());
                    //					query.findInBackground(new FindCallback<ParseObject>() {
                    //
                    //						@Override
                    //						public void done(List<ParseObject> EmailList,
                    //								ParseException e) {
                    //							if (e == null) {
                    //								if (EmailList.size() == 0) {
                    //									// Email�S������
                    //
                    //									// parse�d�� EasyCardTag�O�_����
                    //									ParseQuery<ParseObject> query = ParseQuery
                    //											.getQuery("Member");
                    //									query.whereEqualTo("EasyCardTag", sp.getString("EasyCardTag", "�}��nfc"));
                    //									query.findInBackground(new FindCallback<ParseObject>() {
                    //
                    //										@Override
                    //										public void done(
                    //												List<ParseObject> EasyCardTagList,
                    //												ParseException e) {
                    //											if (e == null) {
                    //
                    //												if (EasyCardTagList.size() == 0) {
                    //													// EasyCardTag�S������
                    //													ParseObject member = new ParseObject(
                    //															"Member");
                    //													member.put("Email", ""+ edtEmail.getText().toString());
                    //													member.put("Password", ""+ edtPassword.getText().toString());
                    //													member.put("Name", ""+ edtName.getText().toString());
                    //													member.put("EasyCardTag",(gotonfc.getText().toString()).equals("�}��nfc") ? "null": sp.getString("EasyCardTag", null).toString());
                    //													member.saveInBackground();
                    //													sp.edit().putBoolean("isLogin", true).commit();
                    //													sp.edit().putString("Email", ""+edtEmail.getText().toString()).commit();
                    //													getActivity().onBackPressed();
                    //													Toast.makeText(getActivity(),"��U���\",Toast.LENGTH_LONG).show();
                    //
                    //												} else {
                    //													// ���y�C�d�w��U�L�F
                    //													Toast.makeText(getActivity(),"���y�C�d�w�s�b",Toast.LENGTH_LONG).show();
                    //												}
                    //
                    //											}
                    //										}
                    //									});
                    //								} else {
                    //									Toast.makeText(getActivity(), "���b���w�s�b",
                    //											Toast.LENGTH_LONG).show();
                    //								}
                    //							} else {
                    //								Log.d("Error", e.getMessage());
                    //							}
                    //						}
                    //
                    //					});

                    // } else {
                    // Toast.makeText(getActivity(), "Email�榡��~",
                    // Toast.LENGTH_LONG).show();
                    // }

                } else {
                    Toast.makeText(getActivity(), "��줣�ର��", Toast.LENGTH_LONG)
                            .show();
                }

            }
        });
    }

    @Override
    public void onDetach() {
        // TODO Auto-generated method stub
        super.onDetach();
        Log.v("PersonalonDetach", "i am here");
        dbhelperpersonal.close();
//        sp.edit().putString("EasyCardTag", "�}��nfc").commit();
    }

    private boolean checkEmailFormat(String email) {
        if (email
                .matches("^[_a-z0-9-]+([.][_a-z0-9-]+)*@[a-z0-9-]+([.][a-z0-9-]+)*$")) {
            return true;
        } else {
            return false;
        }

    }

    /** ���Ѫ���ܩI�s */
    // private int Query(int todo) {
    //
    // // TODO Auto-generated method stub
    // ParseQuery<ParseObject> query = ParseQuery.getQuery("Member");
    //
    // switch (todo) {
    // case 1:// check email
    // query.whereEqualTo("Email", email.getText().toString());
    // query.findInBackground(new FindCallback<ParseObject>() {
    //
    // @Override
    // public void done(List<ParseObject> EmailList, ParseException e) {
    // if (e == null) {
    // Query(2);
    // Log.v("EmailList", "" + EmailList.size());
    // listsize = EmailList.size();
    // } else {
    // Log.d("Error", e.getMessage());
    // }
    // }
    //
    // });
    // break;
    // case 3:// save token
    // query.whereEqualTo("Email", email.getText().toString());
    // query.findInBackground(new FindCallback<ParseObject>() {
    //
    // @Override
    // public void done(List<ParseObject> EmailList, ParseException e) {
    // if (e == null) {
    // if (EmailList.size() == 0) {
    // // TODO Auto-generated method stub
    // ParseObject member = EmailList.get(0);
    // Log.v("id", member.getObjectId());
    // sp.edit()
    // .putString("Token", "member.getObjectId()");
    // } else {
    // Toast.makeText(getActivity(), "���b���w�s�b",
    // Toast.LENGTH_LONG).show();
    // }
    // } else {
    // Log.d("Error", e.getMessage());
    // }
    //
    // }
    // });
    // break;
    //
    // case 2:// check EasyCardTag
    // query.whereEqualTo("EasyCardTag", gotonfc.getText().toString());
    // query.findInBackground(new FindCallback<ParseObject>() {
    //
    // @Override
    // public void done(List<ParseObject> EasyCardTagList,
    // ParseException e) {
    // if (e == null) {
    // listsize = EasyCardTagList.size();
    // if (EasyCardTagList.size() == 0) {
    // // parse�d��EasyCardTag�S����U�L
    // ParseObject member = new ParseObject("Member");
    // member.put("Email", "" + email.getText().toString());
    // member.put("Password", ""
    // + password.getText().toString());
    // member.put("Name", "" + name.getText().toString());
    // // member.put("EasyCardTag", (gotonfc.getText()
    // // .toString()).equals("�}��nfc") ? "null"
    // // : gotonfc.getText().toString());
    // member.put("EasyCardTag", gotonfc.getText()
    // .toString());
    // member.saveInBackground();
    //
    // Query(3);// �stoken
    // Toast.makeText(getActivity(), "��U���\",
    // Toast.LENGTH_LONG).show();
    //
    // sp.edit().putString("EasyCardTag", "�}��nfc")
    // .commit();
    // sp.edit().putBoolean("isLogin", true).commit();
    // getActivity().onBackPressed();
    // } else if (EasyCardTagList.size() >= 2) {
    // // ���y�C�d�w��U�L�F
    // Toast.makeText(getActivity(), "���y�C�d�w�s�b",
    // Toast.LENGTH_LONG).show();
    // }
    //
    // } else {
    // Log.d("Error", e.getMessage());
    // }
    //
    // }
    // });
    // break;
    // }
    // Log.v("listsize", listsize + "");
    // return listsize;
    //
    // }

}
