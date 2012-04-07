package me.tick.android.client;

import android.os.Bundle;
import android.preference.PreferenceActivity;

public class TickPreferencesXML extends PreferenceActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		addPreferencesFromResource(R.xml.preference);
	}
}
