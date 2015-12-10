package com.example.f;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import static android.provider.BaseColumns._ID;
import static com.example.f.DbConstants.EMAIL;
import static com.example.f.DbConstants.NAME;
import static com.example.f.DbConstants.TABLE_NAME;
import static com.example.f.DbConstants.TEL;
import android.app.Activity;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends FragmentActivity {


    private TextView test, NewMessage, ClassInfo, Personal, Lo, Punch;

    private TextView[] myTextView = { test, NewMessage, ClassInfo, Personal,
            Lo, Punch };

    private int[] myId = { R.id.test, R.id.NewMessage, R.id.ClassInfo,
            R.id.Personal, R.id.Lo, R.id.Punch };

    SharedPreferences sp;

//    Test Test;
    static final String[] mDate = new String[100];
    static final String mTime[] = new String[100];
    int mlong;

    public static ProgressDialog pd;
    public static Timer connectionTimer = new Timer();
    public static int tsec = 0;
    static Context mContext;
    static FragmentActivity mActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        Test = new Test();
        sp = getSharedPreferences("cram", 0);
        sp.getBoolean("isLogin", false);
        setContentView(R.layout.activity_main);
        checkSharedPreferences();
        updateUI();
        myOnclick();
        myOntouch();

        mContext = this.getApplicationContext();
        mActivity = MainActivity.this;
    }


    private void checkSharedPreferences() {
        // TODO Auto-generated method stub
        Log.v("sp", "isLogin_" + sp.getBoolean("isLogin", false));
        Log.v("sp", "Token_" + sp.getString("Token", "null"));
        Log.v("sp", "Email_" + sp.getString("Email", "null"));
        // Log.v("sp", "Email"+sp.getString("Email_", "null"));
        // Log.v("sp", "Email"+sp.getString("Email_", "null"));
    }

    @Override
    public void onAttachFragment(android.support.v4.app.Fragment fragment) {
        // TODO Auto-generated method stub
        super.onAttachFragment(fragment);
        Log.v("onAttachFragment", "i am here");
    }

    @Override
    public FragmentManager getSupportFragmentManager() {
        // TODO Auto-generated method stub
        Log.v("FragmentManager", "i am here");
        if (sp.getString("Token", "").equals("")) {
            Log.v("if", "i am in the FragmentManager if");

        } else {
            Log.v("i am elseif", "");
        }
        return super.getSupportFragmentManager();

    }

    private void myOntouch() {
        for (int i = 0; i < myTextView.length; i++) {
            myTextView[i].setOnTouchListener(new View.OnTouchListener() {
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

    private void myOnclick() {

        // 進入登入/註冊
        Personal.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                FragmentTransaction transaction = getSupportFragmentManager()
                        .beginTransaction();
                Personal Personal = new Personal();
                transaction.replace(R.id.fragment_container, Personal);
                transaction.addToBackStack(null);
                transaction.commitAllowingStateLoss();
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
    }

    private void updateUI() {
        // TODO Auto-generated method stub

        test = (TextView) findViewById(R.id.test);
        NewMessage = (TextView) findViewById(R.id.NewMessage);
        ClassInfo = (TextView) findViewById(R.id.ClassInfo);
        Personal = (TextView) findViewById(R.id.Personal);
        Lo = (TextView) findViewById(R.id.Lo);
        Punch = (TextView) findViewById(R.id.Punch);

        if (sp.getBoolean("isLogin", false) == true) {
            // 已經登入
            Personal.setText("學生資訊");
        } else {
            // �٨S�n�J
            Personal.setText("登入/註冊");
        }

        for (int i = 0; i < myTextView.length; i++) {
            myTextView[i] = (TextView) findViewById(myId[i]);
        }
    }

    @Override
    public void onBackPressed() {
        // 偵測手機的返回鍵
        getSupportFragmentManager().popBackStack();

    }

    private Cursor getCursor(){
        DBHelper dbhelper = null;
        SQLiteDatabase db = dbhelper.getReadableDatabase();
        String[] columns = {_ID, NAME, TEL, EMAIL};

        Cursor cursor = db.query(TABLE_NAME , columns, null, null, null, null, null);
        //        Cursor cursor = db.rawQuery("SELECT * FROM "+ TABLE_NAME + " WHERE _ID = 5 ", null);
        startManagingCursor(cursor);
        Log.v("cursor", "" + cursor);
        return cursor;
    }
}

//public class MainActivity extends FragmentActivity implements OnClickListener  {
//
//    private DBHelper dbhelper = null;
//    private DBHelperPersonalInfo dbhelperpersonal = null;
//    private TextView result = null;
//    private ListView listData = null;
//    private EditText editName = null;
//    private EditText editTel = null;
//    private EditText editEmail = null;
//    private EditText editId = null;
//    private Button btnAdd = null;
//    private Button btnDel = null;
//    private Button btnUpdate = null;
//    private Button btnQur = null;
//    private Button btnNext = null;
//
//    static Context mContext;
//    static FragmentActivity mActivity;
//
//
//    @Override
//    public void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.main);
//
//        initView();
//
//        openDatabase();
//        show();
//        showInList();
//
//        mContext = this.getApplicationContext();
//        mActivity = MainActivity.this;
//    }
//
//    @Override
//    public FragmentManager getSupportFragmentManager() {
//        // TODO Auto-generated method stub
//        return super.getSupportFragmentManager();
//    }
//
//    @Override
//    public void onAttachFragment(android.support.v4.app.Fragment fragment) {
//        // TODO Auto-generated method stub
//        super.onAttachFragment(fragment);
//    }
//
//    @Override
//    protected void onDestroy() {
//        super.onDestroy();
//        closeDatabase();
//    }
//
//    private void openDatabase(){
//        dbhelper = new DBHelper(this);
//        dbhelperpersonal= new DBHelperPersonalInfo(this);
//    }
//
//    private void closeDatabase(){
//        dbhelper.close();
//        dbhelperpersonal.close();
//    }
//
//    private void initView(){
//        result = (TextView) findViewById(R.id.txtResult);
//        listData = (ListView) findViewById(R.id.listData);
//        editName = (EditText) findViewById(R.id.editName);
//        editTel = (EditText) findViewById(R.id.editTel);
//        editEmail = (EditText) findViewById(R.id.editEmail);
//        editId = (EditText) findViewById(R.id.editId);
//
//        btnAdd = (Button) findViewById(R.id.btnAdd);
//        btnDel = (Button) findViewById(R.id.btnDel);
//        btnUpdate = (Button) findViewById(R.id.btnUpdate);
//        btnQur = (Button) findViewById(R.id.btnQur);
//        btnNext = (Button) findViewById(R.id.btnNext);
//
//        btnAdd.setOnClickListener(this);
//        btnDel.setOnClickListener(this);
//        btnUpdate.setOnClickListener(this);
//        btnQur.setOnClickListener(this);
//        btnNext.setOnClickListener(this);
//    }
//
//    @Override
//    public void onClick(View v) {
//        switch (v.getId()) {
//            case R.id.btnAdd:
//                add();
//                break;
//
//            case R.id.btnDel:
//                del();
//                break;
//
//            case R.id.btnUpdate:
//                update();
//                break;
//
//            case R.id.btnQur:
//                Qur();
//                break;
//
//            case R.id.btnNext:
//                Next();
//                break;
//
//            default:
//                break;
//        }
//
//        show();
//        showInList();
//    }
//
//    private void Next() {
//        Log.v("onclick","next");
//        // TODO Auto-generated method stub
//        FragmentTransaction transaction = getSupportFragmentManager()
//                .beginTransaction();
//        PersonalRegister PersonalRegister = new PersonalRegister();
//        transaction.replace(R.id.fragment_container, PersonalRegister);
//        transaction.addToBackStack(null);
//        transaction.commitAllowingStateLoss();
//    }
//
//    @Override
//    public void onBackPressed() {
//        // ����������^��
//        getSupportFragmentManager().popBackStack();
//    }
//
//    private void Qur() {
//        SQLiteDatabase db = dbhelper.getReadableDatabase();
////        Cursor cursor = db.query(TABLE_NAME, new String[]{_ID}, null, null, null, null, null);
//        Cursor cursor = db.rawQuery("SELECT * FROM "+ TABLE_NAME + " WHERE _ID = 5 ", null);
//        startManagingCursor(cursor);
//        Log.v("cursor", "" + cursor);
//
//        while(cursor.moveToNext()){
//            int id = cursor.getInt(0);
//            Log.v("id", "" + id);
//
////            resultData.append(id).append(": ");
////            resultData.append(name).append(": ");
////            resultData.append(tel).append(": ");
////            resultData.append(email).append(": ");
////            resultData.append("\n");
//        }
//    }
//
//    private void add(){
//
//        SQLiteDatabase db = dbhelper.getWritableDatabase();
//        ContentValues values = new ContentValues();
//        values.put(NAME, editName.getText().toString());
//        values.put(TEL, editTel.getText().toString());
//        values.put(EMAIL, editEmail.getText().toString());
//        db.insert(TABLE_NAME, null, values);
//
//        cleanEditText();
//    }
//
//    private Cursor getCursor(){
//        SQLiteDatabase db = dbhelper.getReadableDatabase();
//        String[] columns = {_ID, NAME, TEL, EMAIL};
//
//        Cursor cursor = db.query(TABLE_NAME, columns, null, null, null, null, null);
//        startManagingCursor(cursor);
//        Log.v("cursor", "" + cursor);
//        return cursor;
//    }
//



//    private void show(){
//
//        Cursor cursor = getCursor();
//
//        StringBuilder resultData = new StringBuilder("RESULT: \n");
//
//        while(cursor.moveToNext()){
//            int id = cursor.getInt(0);
//            String name = cursor.getString(1);
//            String tel = cursor.getString(2);
//            String email = cursor.getString(3);
//
//            resultData.append(id).append(": ");
//            resultData.append(name).append(": ");
//            resultData.append(tel).append(": ");
//            resultData.append(email).append(": ");
//            resultData.append("\n");
//        }
//
//
//        result.setText(resultData);
//    }
//
//
//    private void showInList(){
//
//        Cursor cursor = getCursor();
//
//        String[] from = {_ID, NAME, TEL, EMAIL};
//        int[] to = {R.id.txtId, R.id.txtName, R.id.txtTel, R.id.txtEmail};
//
//        SimpleCursorAdapter adapter = new SimpleCursorAdapter(this, R.layout.data_item, cursor, from, to);
//        listData.setAdapter(adapter);
//    }
//
//    private void del(){
//        String id = editId.getText().toString();
//
//        SQLiteDatabase db = dbhelper.getWritableDatabase();
//        db.delete(TABLE_NAME, _ID + "=" + id, null);
//
//        cleanEditText();
//    }
//
//    private void update(){
//        String id = editId.getText().toString();
//
//        ContentValues values = new ContentValues();
//        values.put(NAME, editName.getText().toString());
//        values.put(TEL, editTel.getText().toString());
//        values.put(EMAIL, editEmail.getText().toString());
//
//        SQLiteDatabase db = dbhelper.getWritableDatabase();
//        db.update(TABLE_NAME, values, _ID + "=" + id, null);
//
//        cleanEditText();
//    }
//
//    private void cleanEditText(){
//        editName.setText("");
//        editTel.setText("");
//        editEmail.setText("");
//        editId.setText("");
//    }
//
//}