package com.androidapptuts.dialogdemo;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.util.Log;

public class DialogFragmentSimple extends DialogFragment {

	private static final String TAG = DialogFragmentSimple.class.getSimpleName();
	
	@Override
	public Dialog onCreateDialog(Bundle savedInstanceState) {
		
		//Instantiate an AlertDialog.Builder
		final AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
		
		//Chain together various setter methods to set the dialog characteristics
		builder.setMessage("Exit?")//set message in content area.
		.setCancelable(true);//when touch outside of dialog it will dismiss.
		
		//set action buttons, you can get button text from resources too.
		builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
			
			@Override
			public void onClick(DialogInterface dialog, int which) {
				Log.v(TAG, "OK");
				getActivity().finish();//close current activity
			}
		});
		
		builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
			
			@Override
			public void onClick(DialogInterface dialog, int which) {
				Log.v(TAG, "Cancel");
				dialog.cancel();
			}
		});
		
		//create AlertDialog
		final AlertDialog dialog = builder.create();
		//return AlertDialog
		return dialog;
	}
}
