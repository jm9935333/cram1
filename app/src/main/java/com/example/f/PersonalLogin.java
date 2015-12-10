//�n�J/��U  �l��_�n�J
package com.example.f;

import java.util.List;



import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
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

import static com.example.f.DbConstants.TABLE_NAME1;
import static com.example.f.DbConstants._ID;

import android.widget.PopupMenu;
import android.widget.Toast;

public class PersonalLogin extends Fragment {

    View v;
    EditText edtEmail, edtPassword;
    Button btn;
    DBHelperPersonalInfo dbHelperPersonalInfo;

    public PersonalLogin() {
        v = null;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        v = inflater.inflate(R.layout.personal_login, container, false);
        dbHelperPersonalInfo = new DBHelperPersonalInfo(getActivity());
        updateUI();

        return v;
    }

    private void updateUI() {
        // TODO Auto-generated method stub
        edtEmail = (EditText) v.findViewById(R.id.email);
        edtPassword = (EditText) v.findViewById(R.id.password);
        btn = (Button) v.findViewById(R.id.btn);

        btn.setOnClickListener(new OnClickListener() {

                                   @Override
                                   public void onClick(View v) {
                                       // TODO Auto-generated method stub

                                       if (!edtEmail.getText().toString().equals("")
                                               && !edtPassword.getText().toString().equals("")) {

                                           SQLiteDatabase db = dbHelperPersonalInfo.getReadableDatabase();
                                           Log.v("db",""+db);
                                           Cursor cursor = db.rawQuery("SELECT * FROM " + TABLE_NAME1 + " WHERE EMAIL = "+"'"+edtEmail.getText().toString()+"'", null);
                                           Log.v("cursor", "" + cursor);


//                                           Cursor cursor = db.rawQuery("SELECT * FROM " + TABLE_NAME1 + " WHERE EMAIL = 'q'", null);
//                                                                                      Log.v("cursor", "" + cursor);

                                           while (cursor.moveToNext()) {
                                               int id = cursor.getInt(0);
                                               Log.v("id", "" + id);
                                           }
                                       } else {
                                           Toast.makeText(((MainActivity) getActivity()), "��줣�ର��",
                                                          Toast.LENGTH_LONG).show();
                                       }

                                   }
                               }

        );
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
