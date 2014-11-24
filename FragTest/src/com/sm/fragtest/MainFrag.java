package com.sm.fragtest;


import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainFrag extends Fragment implements OnClickListener {
	private static final String DEBUG_TAG = "MainFrag Activity";
	private AutoCompleteTextView countryName;
	private EditText country;
	private EditText source;
	private EditText params;
	private StringBuilder strBuild;
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		// return super.onCreateView(inflater, container, savedInstanceState);
		View view = inflater.inflate(R.layout.main_frag, container, false);
		Button doURL = (Button) view.findViewById(R.id.doURL);
		doURL.setOnClickListener(this);

		countryName = (AutoCompleteTextView) view.findViewById(R.id.countryText);

		// Create an ArrayAdapter containing country names
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this.getActivity(), R.layout.list_item, COUNTRIES);
		countryName.setAdapter(adapter);
		countryName.setOnItemClickListener(new OnItemClickListener() {

			// Display a Toast Message when the user clicks on an item in the
			// AutoCompleteTextView
			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
//				Toast.makeText(getApplicationContext(),
//						"Your choose: " + arg0.getAdapter().getItem(arg2),
//						Toast.LENGTH_SHORT).show();

			}
		});
		//country = (AutoCompleteTextView) view.findViewById(R.id.countryText);
		String count = countryName.getText().toString();
		source = (EditText) view.findViewById(R.id.sourceText);
		params = (EditText) view.findViewById(R.id.paramsText);
		strBuild = new StringBuilder();
		strBuild.append("http://www.quandl.com/api/v1/datasets/");
		strBuild.append(source.getText().toString());
		strBuild.append("/");
		strBuild.append(count);
		strBuild.append("_");
		strBuild.append(params.getText().toString());
		
		return view;

	}

	int translateIdToIndex(int id) {
		int index = -1;
		switch (id) {
		case R.id.doURL:
			index = 1;
			break;
//		case R.id.doURL2:
//			index = 2;
//			break;

		}
		return index;
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		int buttonIndex = translateIdToIndex(v.getId());
		String str = new String("URLURLURL");
		// Закоментируйте перед проверкой
		OnSelectedButtonListener listener = (OnSelectedButtonListener) getActivity();
		listener.doURLMagic(strBuild.toString());

		// Вспомогательный метод для получения индекса нажатой кнопки
		Toast.makeText(getActivity(), String.valueOf(buttonIndex),
				Toast.LENGTH_SHORT).show();
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
