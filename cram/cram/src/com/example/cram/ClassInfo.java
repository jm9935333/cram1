//課程資訊
package com.example.cram;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

public class ClassInfo extends Fragment {
	private View v;
	String[] Grade= new String[] {"一年級","二年級","三年級"};
	String[] Lesson= new String[] {"國文","數學","英文","社會","自然"};
	String string1;
	String string2;
	String finalString;
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		v = inflater.inflate(R.layout.classinfo, container, false);
		Spinner spnGrade;
		Spinner spnLesson;
		TextView myTextView = (TextView)v.findViewById(R.id.textView4);
		
		spnGrade=(Spinner) v.findViewById(R.id.spnGrade);
		ArrayAdapter<String> adapterGrade= new ArrayAdapter<String>(getActivity(),android.R.layout.simple_spinner_item,Grade);
		adapterGrade.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		spnGrade.setAdapter(adapterGrade);
		string1 = spnGrade.getSelectedItem().toString();
		
		spnLesson=(Spinner) v.findViewById(R.id.spnLesson);
		ArrayAdapter<String> adapterLesson= new ArrayAdapter<String>(getActivity(),android.R.layout.simple_spinner_item,Lesson);
		adapterLesson.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		spnLesson.setAdapter(adapterLesson);
		string2 = spnLesson.getSelectedItem().toString();
		
		finalString = string1+string2;
		 myTextView.setText(finalString);
		
		return v;
	}

}
