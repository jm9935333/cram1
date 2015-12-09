//�ҵ{��T
package com.example.f;

import java.util.List;

import org.json.JSONException;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.TextureView;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

public class ClassInfo extends Fragment {
	private View v;
	String[] Grade = new String[]{"�@�~��", "�G�~��", "�T�~��"};
	String[] Lesson = new String[]{"���", "�ƾ�", "�^��", "���|", "�۵M"};
	Spinner spnGrade;
	Spinner spnLesson;
	TextView textView2;
	String grd;
	String sel;
	Button btn;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
							 Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		v = inflater.inflate(R.layout.classinfo, container, false);
		textView2 = (TextView) v.findViewById(R.id.textView2);
		btn = (Button) v.findViewById(R.id.btn);
		grd = "null";
		sel = "null";
		spnGrade = (Spinner) v.findViewById(R.id.spnGrade);
		spnLesson = (Spinner) v.findViewById(R.id.spnLesson);
		ArrayAdapter<String> adapterGrade = new ArrayAdapter<String>(
				getActivity(), android.R.layout.simple_spinner_item, Grade);
		adapterGrade.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		spnGrade.setAdapter(adapterGrade);


		ArrayAdapter<String> adapterLesson = new ArrayAdapter<String>(
				getActivity(), android.R.layout.simple_spinner_item, Lesson);
		adapterLesson.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		spnLesson.setAdapter(adapterLesson);
		spnLesson.setOnItemSelectedListener(spnLessonListener);
		spnGrade.setOnItemSelectedListener(spnGradeListener);

		btn.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {

			}
		});

		Spinner.OnItemSelectedListener spnGradeListener = new Spinner.OnItemSelectedListener() {

			@Override
			public void onItemSelected(AdapterView<?> parent, View view,
									   int position, long id) {
				// TODO Auto-generated method stub


				grd = parent.getSelectedItem().toString();

			}

			@Override
			public void onNothingSelected(AdapterView<?> parent) {
				// TODO Auto-generated method stub

			}
		};
		Spinner.OnItemSelectedListener spnLessonListener = new Spinner.OnItemSelectedListener() {

			@Override
			public void onItemSelected(AdapterView<?> parent, View view,
									   int position, long id) {
				// TODO Auto-generated method stub


				sel = parent.getSelectedItem().toString();

			}

			@Override
			public void onNothingSelected(AdapterView<?> parent) {
				// TODO Auto-generated method stub

			}
		};

	}
}


