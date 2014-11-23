package com.sm.fragtest;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class ResultFrag extends Fragment {

	private TextView tvInfo;
	private String[] mCatDescriptions;
	

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		//return super.onCreateView(inflater, container, savedInstanceState);
		View view = 
				inflater.inflate(R.layout.result_frag, 
				container, false);
		tvInfo = (TextView)view.findViewById(R.id.textView1);
		// загружаем массив из ресурсов
		mCatDescriptions = getResources().getStringArray(R.array.cats);
				return view;
	}
	public void setDescription(int buttonIndex) {
		String catDescription = mCatDescriptions[buttonIndex];
		tvInfo.setText(catDescription);
		
	}
}
