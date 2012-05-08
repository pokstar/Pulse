package me.tick.android.client;

import me.tick.android.client.util.DialogHelper;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class TickAuthActivity extends Activity {

	private static String TAG = "TickAuthActivity";

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
		setContentView(R.layout.auth);
		setDefaultKeyMode(DEFAULT_KEYS_SHORTCUT);
		
		Button btnLogin = (Button) findViewById(R.id.LoginButton);
		btnLogin.setOnClickListener(new View.OnClickListener() {
			public void onClick(View arg0) {
				Intent i = new Intent(getApplicationContext(), TickActivity.class);
				i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
				startActivity(i);
				//finish();
			}
		});

		Button btnRegister = (Button) findViewById(R.id.RegisterButton);
		btnRegister.setOnClickListener(new View.OnClickListener() {
			public void onClick(View arg0) {
				DialogHelper.notSupportedYet(TickAuthActivity.this);
				//Intent i = new Intent(getApplicationContext(), TickActivity.class);
				//i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
				//startActivity(i);
				//finish();
			}
		});
	}

	/**
     * 
     */
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		MenuInflater inflater = getMenuInflater();
		inflater.inflate(R.layout.menu_auth, menu);
		return (super.onCreateOptionsMenu(menu));
	}
	
	/**
     * 
     */
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case R.id.menu_auth_about:
			DialogHelper.notSupportedYet(this);
			return true;
		}

		return false;
	}
}
