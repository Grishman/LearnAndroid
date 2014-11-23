package com.sm.econom;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;

import android.app.Activity;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class ResultActivity extends Activity {
	private static final String DEBUG_TAG = null;
	TextView textView;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.result);
         textView = (TextView)findViewById(R.id.resultText);
	    
	    String country = "UKR";
	    String source = "SRC";
	    String	params = "PRM";
	    
	    

	    //txtResult.setText(stringUrl);
	}
	
}
