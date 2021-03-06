package com.sm.fragtest;

import android.app.FragmentManager;
import android.support.v7.app.ActionBarActivity;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class SecondActivity extends ActionBarActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_second);
		
		if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {
		    finish();
		    return;
		}
		
		Intent intent = getIntent();
		String buttonIndex = intent.getStringExtra("str");
		//if (buttonIndex != -1) {
			FragmentManager fm = getFragmentManager();
			ResultFrag fragment2 = (ResultFrag) fm
					.findFragmentById(R.id.resultfragment);
			fragment2.setDescriptionURL(buttonIndex);
		//}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.second, menu);
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
}
