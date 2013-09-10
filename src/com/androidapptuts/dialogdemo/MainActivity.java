package com.androidapptuts.dialogdemo;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {

	private static final String TAG = MainActivity.class.getSimpleName();
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
    	Log.v(TAG, "onCreate");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        //'Simple Alert Dialog Demo button' click implementation
        final Button btn1 = (Button) findViewById(R.id.button1);
        btn1.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Log.v(TAG, "Simple Alert Dialog Demo Click");
				
				//Instantiate an AlertDialog.Builder
	    		final Builder builder = new AlertDialog.Builder(MainActivity.this);
	    		
	    		//Chain together various setter methods to set the dialog characteristics
	    		builder.setMessage("Exit?")//set message in content area.
	    		.setCancelable(true);//when touch outside of dialog it will dismiss.
	    		
	    		//set action buttons, you can get button text from resources too.
	    		builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
					
					@Override
					public void onClick(DialogInterface dialog, int which) {
						Log.v(TAG, "OK");
						MainActivity.this.finish();//close current activity
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
	    		
	    		//show dialog
	    		dialog.show();
			}
		});
        
        //'Simple Alert Dialog Demo with Title' button click implementation
        final Button btn2 = (Button) findViewById(R.id.button2);
        btn2.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Log.v(TAG, "Simple Alert Dialog Demo with Title Click");
				
				//Instantiate an AlertDialog.Builder
	    		final Builder builder = new AlertDialog.Builder(MainActivity.this);
	    		
	    		//Chain together various setter methods to set the dialog characteristics
	    		builder.setTitle("Close Activity?")
	    		.setMessage("You will exit from app!")//set message in content area.
	    		.setCancelable(true);
	    		
	    		//set action buttons, you can get button text from resources too.
	    		builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
					
					@Override
					public void onClick(DialogInterface dialog, int which) {
						Log.v(TAG, "OK");
						MainActivity.this.finish();//close current activity
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
	    		
	    		//show dialog
	    		dialog.show();
			}
		});
        
        //'Alert Dialog with 3 Buttons' button click implementation
        final Button btn3 = (Button) findViewById(R.id.button3);
        btn3.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Log.v(TAG, "Simple Alert Dialog Demo with Title Click");
				
				//Instantiate an AlertDialog.Builder
	    		final AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
	    		
	    		//Chain together various setter methods to set the dialog characteristics
	    		builder.setTitle("Close Activity?")
	    		.setMessage("You will exit from app!")//set message in content area.
	    		.setCancelable(true);
	    		
	    		//set action buttons, you can get button text from resources too.
	    		builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
					
					@Override
					public void onClick(DialogInterface dialog, int which) {
						Log.v(TAG, "OK");
						MainActivity.this.finish();//close current activity
					}
				});
	    		
	    		builder.setNeutralButton("Save and exit", new DialogInterface.OnClickListener() {
					
					@Override
					public void onClick(DialogInterface dialog, int which) {
						Log.v(TAG, "Save and exit.");
						//save data
						//exit
						MainActivity.this.finish();//close current activity
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
	    		
	    		//show dialog
	    		dialog.show();
			}
		});
    
    
        //'Alert Dialog with custome layout' click implementation
        final Button btn4 = (Button) findViewById(R.id.button4);
        btn4.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Log.v(TAG, "Alert Dialog with custome layout Click");
				
				//Instantiate an AlertDialog.Builder
				final AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
				
				//get the layout inflator
				final LayoutInflater inflater = MainActivity.this.getLayoutInflater();
				
				//Inflate and set layout for dialog
				//This is going in dialog layout so parent view is null
				final View viewDialog = inflater.inflate(R.layout.dialog_custom_layout, null);
				builder.setView(viewDialog);
				
				//set action buttons, you can get button text from resources too.
	    		builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
					
					@Override
					public void onClick(DialogInterface dialog, int which) {
						Log.v(TAG, "OK");
						
						//get edit text reference from layout
						EditText et = (EditText) viewDialog.findViewById(R.id.editTextName);
						//get text show it
						Toast.makeText(getApplicationContext(), et.getText().toString(), Toast.LENGTH_LONG).show();
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
	    		
	    		//show dialog
	    		dialog.show();
			}
		});
    
        //charsequence array for list
        final CharSequence[] colors = {"Red", "Green", "Blue"};
        
        //'Alert Dialog with single-choice list' click implementation
        final Button btn5 = (Button) findViewById(R.id.button5);
        btn5.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Log.v(TAG, "Alert Dialog with single-choice list Click");
				
				//Instantiate an AlertDialog.Builder
				final AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
				
				builder.setTitle("Pick a color")
				.setItems(colors, new DialogInterface.OnClickListener() {
					
					@Override
					public void onClick(DialogInterface dialog, int which) {
						// which = index of selected item
						String selectedColor = colors[which].toString();
						Toast.makeText(getApplicationContext(), selectedColor, Toast.LENGTH_LONG).show();
					}
				});
				
				//create AlertDialog
	    		final AlertDialog dialog = builder.create();
	    		
	    		//show dialog
	    		dialog.show();
			}
		});
        
        //CharSequence array for list
        final CharSequence[] animals = {"Cat", "Dog", "Parrot"};
        //checked state of items
        final boolean[] chckedItems = {false, false, false};
        
        //'Alert Dialog with multiple-choice list' click implementation
        final Button btn6 = (Button) findViewById(R.id.button6);
        btn6.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Log.v(TAG, "Alert Dialog with multiple-choice list Click");
				
				//Instantiate an AlertDialog.Builder
				final AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
				
				builder.setTitle("Pick a color")
				.setMultiChoiceItems(animals, chckedItems, new DialogInterface.OnMultiChoiceClickListener() {
					//if null for checkeditems then no one will be checked when dialgo created
					
					@Override
					public void onClick(DialogInterface dialog, int which, boolean isChecked) {
						chckedItems[which] = isChecked;
					}
				});
				
				//create AlertDialog
	    		final AlertDialog dialog = builder.create();
	    		
	    		//show dialog
	    		dialog.show();
			}
		});
        
        //'Dialog by activity theme' button click
        final Button btn10 = (Button) findViewById(R.id.button10);
        btn10.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				Log.v(TAG, "Dialog by activity theme Click");
				
				//create intent and start activity.
				startActivity(new Intent(MainActivity.this, DialogByTheme.class));
			}
        	
        });
        
        //'Alert Dialog with Dialog Fragment' click implementation
        final Button btn11 = (Button) findViewById(R.id.button11);
        btn11.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Log.v(TAG, "Alert Dialog with Dialog Fragment");
				
				//create intent and start Dialog Fragment Activity
				startActivity(new Intent(MainActivity.this, DiallogFragmentDemo.class));
			}
        });
    }
    
}
