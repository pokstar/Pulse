package me.tick.android.client;

import me.tick.android.client.util.DialogHelper;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;


public class TickActivity extends Activity {

	private static String TAG = "TickActivity";

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
		setDefaultKeyMode(DEFAULT_KEYS_SHORTCUT);

		/*Intent intent = getIntent();
		if (intent.getData() == null) {

		}

		getListView().setOnCreateContextMenuListener(this);*/
	}

	/**
     * 
     */
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		MenuInflater inflater = getMenuInflater();
		inflater.inflate(R.layout.menu_main, menu);
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
	
	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event)
	{
	    if ((keyCode == KeyEvent.KEYCODE_BACK))
	    {
	    	DialogHelper.promptOnBackKey(this, "", "");
	    	//finish();
	    }
	    return super.onKeyDown(keyCode, event);
	}

	/**
     * 
     */
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case R.id.menu_channel_add:
			DialogHelper.notSupportedYet(this);
			return true;
		case R.id.menu_preferences:
			Intent i = new Intent(this, TickPreferencesActivity.class);
			startActivity(i);
			return true;
		case R.id.menu_quit:
			DialogHelper.quit(this);
			return true;
		}

		return false;
	}
	
	/**
	 * 
	 */
	@Override
    public void onCreateContextMenu(ContextMenu menu, View view, ContextMenuInfo menuInfo) {
        AdapterView.AdapterContextMenuInfo info;
        try {
             info = (AdapterView.AdapterContextMenuInfo) menuInfo;
        } catch (ClassCastException e) {
            Log.e(TAG, "bad menuInfo", e);
            return;
        }

        MenuInflater inflater = getMenuInflater();
        //inflater.inflate(R.menu.list_context_menu, menu);
        
        // Set the context menu header
        /*menu.setHeaderTitle(cursor.getString(COLUMN_INDEX_TITLE));
        
        // Append to the
        // menu items for any other activities that can do stuff with it
        // as well.  This does a query on the system for any activities that
        // implement the ALTERNATIVE_ACTION for our data, adding a menu item
        // for each one that is found.
        Intent intent = new Intent(null, Uri.withAppendedPath(getIntent().getData(), 
                                        Integer.toString((int) info.id) ));
        intent.addCategory(Intent.CATEGORY_ALTERNATIVE);
        menu.addIntentOptions(Menu.CATEGORY_ALTERNATIVE, 0, 0,
                new ComponentName(this, NotesList.class), null, intent, 0, null);*/
    }
}
