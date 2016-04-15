package com.example.activitylifecycle;


import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class Activity_A extends Activity{
	
	final Context context = this;
	int i=0;
	Handler mHandler = new Handler();
    TextView tv2;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_activity_);
		
				
		Button startB=(Button)findViewById(R.id.startb);
		startB.setOnClickListener(new OnClickListener(){
		
			public void onClick(View v)
			{
				Intent intent = new Intent(v.getContext(),Activity_B.class);
				startActivityForResult(intent,0);
				
			}
		});
		
		Button startDialog=(Button)findViewById(R.id.dialog);
		startDialog.setOnClickListener(new OnClickListener(){
		
			public void onClick(View v)
			{
				
				AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
						context);
		 
											 
					
					alertDialogBuilder
						.setMessage("Simple dialog!")
						.setInverseBackgroundForced(true)
						.setCancelable(false)
						.setNegativeButton("Close",new DialogInterface.OnClickListener() {
							public void onClick(DialogInterface dialog,int id) {
								
								dialog.cancel();
							}
						});
		 
						// create alert dialog
						AlertDialog alertDialog = alertDialogBuilder.create();
		 
						// show it
						alertDialog.show();
			}
		});
		
		
		
		Button closeapp=(Button)findViewById(R.id.close);
		closeapp.setOnClickListener(new OnClickListener(){
		
			public void onClick(View v)
			{
				finish();
				System.exit(0);
			}
		});
	}

	 @Override
	    protected void onStart() {
	       super.onStart();
	    }

	    @Override
	   protected void onRestart() {
	       super.onRestart();
	    }

	    @Override
	    protected void onResume() {
	    	

	      super.onResume();
	      	      
	      
	       Runnable runnable = new Runnable() {
	            @Override
	            public void run()                
	                {   
	                	tv2=(TextView)findViewById(R.id.tv2);
	                    tv2.setText(String.valueOf(i)+" ");
	                    i++;
	                  
	                   if (i<500)
	                    {
	                        mHandler.postDelayed(this, 1000);
	                    }
	                }
	            
	        };        
	        mHandler.post(runnable);
	    }

	    @Override
	    protected void onPause() {
	       super.onPause();

	    }

	    @Override
	    protected void onStop() {
	       super.onStop();

	    }

	    @Override
	    protected void onDestroy() {
	        super.onDestroy();

	    }

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
	
	
}


