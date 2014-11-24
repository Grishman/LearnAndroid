package com.sm.fragtest;

import android.support.v7.app.ActionBarActivity;
import android.app.FragmentManager;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends ActionBarActivity implements
		OnSelectedButtonListener {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	@Override
	public void onButtonSelected(int buttonIndex) {
		// TODO Auto-generated method stub
		// подключаем FragmentManager
		FragmentManager fragmentManager = getFragmentManager();

		// Получаем ссылку на второй фрагмент по ID
		ResultFrag fragment2 = (ResultFrag) fragmentManager
				.findFragmentById(R.id.resultfragment);

		// Выводим нужную информацию
		if (fragment2 == null || !fragment2.isVisible()) {
			// запускаем активность
			Intent intent = new Intent(this, SecondActivity.class);
			intent.putExtra("buttonIndex", buttonIndex);
			startActivity(intent);

		} else {
			fragment2.setDescription(buttonIndex);
		}
	}

	@Override
	public void doURLMagic(String str) {
		FragmentManager fragmentManager = getFragmentManager();

		// Получаем ссылку на второй фрагмент по ID
		ResultFrag fragment2 = (ResultFrag) fragmentManager
				.findFragmentById(R.id.resultfragment);

		// Выводим нужную информацию
		if (fragment2 == null || !fragment2.isVisible()) {
			// запускаем активность
			Intent intent = new Intent(this, SecondActivity.class);
			intent.putExtra("str", str);
			startActivity(intent);

		} else {
			fragment2.setDescriptionURL(str);
		}
		
	}
}
