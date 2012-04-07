package me.tick.android.client;

import me.tick.android.client.util.DialogHelper;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

public class TickActivity extends Activity {

	private static String TAG = "tick";

	/**
	 * Called when the activity is first created.
	 * 
	 * @param savedInstanceState
	 *            If the activity is being re-initialized after previously being
	 *            shut down then this Bundle contains the data it most recently
	 *            supplied in onSaveInstanceState(Bundle). <b>Note: Otherwise it
	 *            is null.</b>
	 */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		Log.i(TAG, "onCreate");
		setContentView(R.layout.main);
	}

	/**
     * 
     */
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		MenuInflater inflater = getMenuInflater();
		inflater.inflate(R.layout.menu, menu);
		return (super.onCreateOptionsMenu(menu));
	}

	/**
     * 
     */
	@Override
	public void onBackPressed() {
		Log.d("CDA", "onBackPressed Called");
		Intent setIntent = new Intent(Intent.ACTION_MAIN);
		setIntent.addCategory(Intent.CATEGORY_HOME);
		setIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
		startActivity(setIntent);
		DialogHelper.promptOnBackKey(this, "", "");
	}

	/**
     * 
     */
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case R.id.menu_channel_add:
			Toast.makeText(this, "Not sypported yet", Toast.LENGTH_SHORT).show();
			return true;
		case R.id.menu_preferences:
			Intent i = new Intent(this, TickPreferencesXML.class);
			startActivity(i);
			return true;
		case R.id.menu_quit:
			DialogHelper.quit(this);
			return true;
		}

		return false;
	}
}
