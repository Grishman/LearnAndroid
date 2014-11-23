package com.sm.fragtest;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

public class MainFrag extends Fragment implements OnClickListener  {

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		//return super.onCreateView(inflater, container, savedInstanceState);
		View view = 
				inflater.inflate(R.layout.main_frag, 
				container, false);
		
		Button doURL = (Button) view.findViewById(R.id.doURL);
Button doURL2 = (Button) view.findViewById(R.id.doURL2);
		doURL.setOnClickListener(this);
		doURL2.setOnClickListener(this);
		
				return view;
							
	}
	int translateIdToIndex(int id) {
		int index = -1;
		switch (id) {
		case R.id.doURL:
			index = 1;
			break;
		case R.id.doURL2:
			index = 2;
			break;
		
		}
		return index;
	}
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		int buttonIndex = translateIdToIndex(v.getId());

		// Закоментируйте перед проверкой
		OnSelectedButtonListener listener = (OnSelectedButtonListener) getActivity();
		listener.onButtonSelected(buttonIndex);

		// Вспомогательный метод для получения индекса нажатой кнопки
		Toast.makeText(getActivity(), String.valueOf(buttonIndex),
				Toast.LENGTH_SHORT).show();
	}

	

}
