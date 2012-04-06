/**
 *   Licensed to the Apache Software Foundation (ASF) under one
 *   or more contributor license agreements.  See the NOTICE file
 *   distributed with this work for additional information
 *   regarding copyright ownership.  The ASF licenses this file
 *   to you under the Apache License, Version 2.0 (the
 *   "License"); you may not use this file except in compliance
 *   with the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *   Unless required by applicable law or agreed to in writing,
 *   software distributed under the License is distributed on an
 *   "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 *   KIND, either express or implied.  See the License for the
 *   specific language governing permissions and limitations
 *   under the License.
 */

package me.tick.android.client.util;

import me.tick.android.client.R;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class DialogHelper extends Activity {

	/**
	 * 
	 * @param context
	 */
	public static void terminateApplication(Context context) {
		AlertDialog.Builder builder = new AlertDialog.Builder(context);

		Dialog dialog_return = builder.create();
		dialog_return.show();
	}


	/**
	 * 
	 * @param context
	 */
	public static void resetApplicationPreferences(Context context) {

	}

	/**
	 * 
	 * @param context
	 */
	/*public static void help(Context context) {
		AlertDialog.Builder builder = new AlertDialog.Builder(context);
		builder.setTitle(R.string.prompt_help_title);
		builder.setMessage(R.string.prompt_help_question);
		builder.setIcon(R.drawable.icon);
		builder.setPositiveButton(R.string.prompt_ok, new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int whichButton) {
				// User clicked OK so do some stuff
				System.out.println("OK clicked.");
			}
		});
		builder.setNegativeButton(R.string.prompt_cancel, new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int whichButton) {
				// User clicked Cancel so do some stuff
				System.out.println("cancel clicked.");
			}
		});
		builder.create();
		builder.show();
	}*/

	/**
	 * 
	 * @param context
	 */
	public static void quit(Context context) {
		AlertDialog.Builder builder = new AlertDialog.Builder(context);
		builder.setTitle(R.string.prompt_quit_title);
		builder.setMessage(R.string.prompt_quit_question);
		builder.setIcon(R.drawable.icon);
		builder.setPositiveButton(R.string.dialog_ok, new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int whichButton) {
				// User clicked OK so do some stuff
				System.out.println("OK clicked.");
			}
		});
		builder.setNegativeButton(R.string.dialog_cancel, new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int whichButton) {
				// User clicked Cancel so do some stuff
				System.out.println("cancel clicked.");
			}
		});
		builder.create();
		builder.show();
		
	}

	/**
	 * 
	 */
	public static void promptOnBackKey(Context context, String message, String title) {

		AlertDialog ad = new AlertDialog.Builder(context).setMessage(message).setTitle(title).setCancelable(false).setPositiveButton(android.R.string.ok,
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int whichButton) {
						// User selects OK, save changes to db
					}
				}).setNeutralButton(android.R.string.cancel, new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int whichButton) {
				// User selects Cancel, discard all changes
			}
		}).show();
	}

}
