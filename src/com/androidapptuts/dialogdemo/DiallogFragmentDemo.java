package com.androidapptuts.dialogdemo;

import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentActivity;

public class DiallogFragmentDemo extends FragmentActivity {

	@Override
	protected void onCreate(Bundle arg0) {
		super.onCreate(arg0);
		
		//create dialog fragment
		final DialogFragment dialog = new DialogFragmentSimple();
		
		//show it, if you support earlier versions then should use getSupportFragmentManager()
		//instead of getFragmentManager()
		dialog.show(getSupportFragmentManager(), "DialogFragment");
	}
}
