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
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;

import com.sm.econom.R;


public class MainActivity extends Activity {

	private static final String DEBUG_TAG = "Naim Activity";
	private AutoCompleteTextView countryName;
	private EditText country;
	private EditText source;
	private EditText params;
	TextView textView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		countryName = (AutoCompleteTextView) findViewById(R.id.countryText);

		// Create an ArrayAdapter containing country names
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
				R.layout.list_item, COUNTRIES);
		countryName.setAdapter(adapter);
		countryName.setOnItemClickListener(new OnItemClickListener() {

			// Display a Toast Message when the user clicks on an item in the
			// AutoCompleteTextView
			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				Toast.makeText(getApplicationContext(),
						"Your choose: " + arg0.getAdapter().getItem(arg2),
						Toast.LENGTH_SHORT).show();

			}
		});
		
		country = (EditText) findViewById(R.id.countryText);
		source = (EditText) findViewById(R.id.sourceText);
		params = (EditText) findViewById(R.id.paramsText);
		textView = (TextView)findViewById(R.id.resultText);
		 
		


	}
	private class DownloadWebpageTask extends AsyncTask<String, Void, String> {
		@Override
		protected String doInBackground(String... urls) {
			// params comes from the execute() call: params[0] is the url.
			try {
				return downloadUrl(urls[0]);
			} catch (IOException e) {
				return "Unable to retrieve web page. URL may be invalid.";
			}
		}

		// onPostExecute displays the results of the AsyncTask.
		@Override
		protected void onPostExecute(String result) {
			textView.setText(result);
		}
	}
	private String downloadUrl(String myurl) throws IOException {
		InputStream is = null;
		// Only display the first 500 characters of the retrieved
		// web page content.
		int len = 500;

		try {
			URL url = new URL(myurl);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setReadTimeout(10000 /* milliseconds */);
			conn.setConnectTimeout(15000 /* milliseconds */);
			conn.setRequestMethod("GET");
			conn.setDoInput(true);
			// Starts the query
			conn.connect();
			int response = conn.getResponseCode();
			Log.d(DEBUG_TAG, "The response is: " + response);
			is = conn.getInputStream();

			// Convert the InputStream into a string
			String contentAsString = readIt(is, len);
			return contentAsString;

			// Makes sure that the InputStream is closed after the app is
			// finished using it.
		} finally {
			if (is != null) {
				is.close();
			}
		}
	}

	public String readIt(InputStream stream, int len) throws IOException,
			UnsupportedEncodingException {
		Reader reader = null;
		reader = new InputStreamReader(stream, "UTF-8");
		char[] buffer = new char[len];
		reader.read(buffer);
		return new String(buffer);
	}

	public void startClick(View view) {

//		EditText srcName = (EditText) findViewById(R.id.sourceText);
//		EditText paramsName = (EditText) findViewById(R.id.paramsText);
//
//		Intent intent = new Intent(MainActivity.this, ResultActivity.class);
//
//		intent.putExtra("countryName", countryName.getText().toString());
//		intent.putExtra("srcName", srcName.getText().toString());
//		intent.putExtra("paramsName", paramsName.getText().toString());
//		startActivity(intent);
		String stringUrl = "http://www.quandl.com/api/v1/datasets/"+source+
	    		"/"+country+"_"+params;
	    // test asynkTester
	    ConnectivityManager connMgr = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
		NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();
		if (networkInfo != null && networkInfo.isConnected()) {
			new DownloadWebpageTask().execute(stringUrl);
		} else {
			textView.setText("No network connection available.");
		}
	}

	static final String[] COUNTRIES = new String[] { "AFG", "AGO", "ALB",
			"ARE", "ARG", "ARM", "ATG", "AUS", "AUT", "AZE", "BDI", "BEL",
			"BEN", "BFA", "BGD", "BGR", "BHR", "BHS", "BIH", "BLR", "BLZ",
			"BOL", "BRA", "BRB", "BRN", "BTN", "BWA", "CAF", "CAN", "CHE",
			"CHL", "CHN", "CIV", "CMR", "COD", "COG", "COL", "COM", "CPV",
			"CRI", "CUB", "CYP", "CZE", "DEU", "DJI", "DMA", "DNK", "DOM",
			"DZA", "ECU", "EGY", "ERI", "ESP", "EST", "ETH", "FIN", "FJI",
			"FRA", "GAB", "GBR", "GEO", "GHA", "GIN", "GMB", "GNB", "GNQ",
			"GRC", "GRD", "GTM", "GUY", "HKG", "HND", "HRV", "HTI", "HUN",
			"IDN", "IND", "IRL", "IRN", "IRQ", "ISL", "ISR", "ITA", "JAM",
			"JOR", "JPN", "KAZ", "KEN", "KGZ", "KHM", "KIR", "KNA", "KOR",
			"KSV", "KWT", "LAO", "LBN", "LBR", "LBY", "LCA", "LKA", "LSO",
			"LTU", "LUX", "LVA", "MAR", "MDA", "MDG", "MDV", "MEX", "MKD",
			"MLI", "MLT", "MMR", "MNE", "MNG", "MOZ", "MRT", "MUS", "MWI",
			"MYS", "NAM", "NER", "NGA", "NIC", "NLD", "NOR", "NPL", "NZL",
			"OMN", "PAK", "PAN", "PER", "PHL", "PNG", "POL", "PRK", "PRT",
			"PRY", "QAT", "ROU", "RUS", "RWA", "SAU", "SDN", "SEN", "SGP",
			"SLB", "SLE", "SLV", "SMR", "SOM", "SRB", "SSD", "STP", "SUR",
			"SVK", "SVN", "SWE", "SWZ", "SYC", "SYR", "TCD", "TGO", "THA",
			"TJK", "TKM", "TLS", "TON", "TTO", "TUN", "TUR", "TUV", "TZA",
			"UGA", "UKR", "URY", "USA", "UZB", "VCT", "VEN", "VNM", "VUT",
			"WSM", "WSM", "ZAF", "ZMB", "ZWE" };
}
