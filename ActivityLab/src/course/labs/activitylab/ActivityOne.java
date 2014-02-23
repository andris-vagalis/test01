package course.labs.activitylab;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class ActivityOne extends Activity {

	private static final String RESTART_KEY = "restart";
	private static final String RESUME_KEY = "resume";
	private static final String START_KEY = "start";
	private static final String CREATE_KEY = "create";
	
	private static final String PAUSE_KEY = "pause";
	private static final String STOP_KEY = "stop";
	private static final String DESTROY_KEY = "destroy";

	// String for LogCat documentation
	private final static String TAG = "Lab-ActivityOne";
	
	// Lifecycle counters

	// Create counter variables for onCreate(), onRestart(), onStart() and
	// onResume(), called mCreate, etc.
	// You will need to increment these variables' values when their
	// corresponding lifecycle methods get called

	private static int mCreate = 0;
	private static int mRestart = 0;
	private static int mStart = 0;
	private static int mResume = 0;
	
	private static int mPause = 0;
	private static int mStop = 0;
	private static int mDestroy = 0;


        // mTvCreate, etc. 
	private TextView mTvCreate;
	private TextView mTvRestart;
	private TextView mTvStart;
	private TextView mTvResume;
		
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_one);
		
		// Hint: Access the TextView by calling Activity's findViewById()
		// textView1 = (TextView) findViewById(R.id.textView1);

		mTvCreate = (TextView) findViewById(R.id.create);
		mTvRestart = (TextView) findViewById(R.id.restart);
		mTvStart = (TextView) findViewById(R.id.start);
		mTvResume = (TextView) findViewById(R.id.resume);
		
		Button launchActivityTwoButton = (Button) findViewById(R.id.bLaunchActivityTwo); 
		launchActivityTwoButton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// Launch Activity Two
				// Hint: use Context's startActivity() method

				// Create an intent stating which Activity you would like to start

				Intent intent = new Intent(ActivityOne.this, ActivityTwo.class);
				
				
				// Launch the Activity using the intent
				
				startActivity(intent);
			
			}
		});
		
		// Check for previously saved state
		if (savedInstanceState != null) {

			// Restore value of counters from saved state
			// Only need 4 lines of code, one for every count variable
			
	        mCreate = savedInstanceState.getInt(CREATE_KEY);
	        mRestart = savedInstanceState.getInt(RESTART_KEY);
	        mResume = savedInstanceState.getInt(RESUME_KEY);
	        mStart = savedInstanceState.getInt(START_KEY);
	        mPause = savedInstanceState.getInt(PAUSE_KEY);
	        mStop = savedInstanceState.getInt(STOP_KEY);
	        mDestroy = savedInstanceState.getInt(DESTROY_KEY);


		}


		Log.i(TAG,"The activity one is onCreate()");
		
		// Update the appropriate count variable
		mCreate++;
		// Update the user interface via the displayCounts() method

		displayCounts();

	}

	// Lifecycle callback overrides

	@Override
	public void onStart() {
		super.onStart();

		
		Log.i(TAG,"The activity one is onStart()");

		// Update the appropriate count variable
		mStart++;
		// Update the user interface
		displayCounts();

	}

	@Override
	public void onResume() {
		super.onResume();


		Log.i(TAG,"The activity one is onResume()");

		// Update the appropriate count variable
		mResume++;
		// Update the user interface
		displayCounts();

	}

	@Override
	public void onPause() {
		super.onPause();

		Log.i(TAG,"The activity one is onPause()");
		mPause++;
	}

	@Override
	public void onStop() {
		super.onStop();

		Log.i(TAG,"The activity one is onStop()");
		mStop++;
	}

	@Override
	public void onRestart() {
		super.onRestart();

		Log.i(TAG,"The activity one is onRestart()");

		// Update the appropriate count variable
		mRestart++;
		// Update the user interface

		displayCounts();

	}

	@Override
	public void onDestroy() {
		super.onDestroy();


		Log.i(TAG,"The activity one is onDestroy()");
		mDestroy++;
	}

	@Override
	public void onSaveInstanceState(Bundle savedInstanceState) {
		// Save state information with a collection of key-value pairs
		// 4 lines of code, one for every count variable
		
		savedInstanceState.putInt(CREATE_KEY, mCreate);
		savedInstanceState.putInt(RESTART_KEY, mRestart);
		savedInstanceState.putInt(START_KEY, mStart);
		savedInstanceState.putInt(RESUME_KEY, mResume);

		savedInstanceState.putInt(PAUSE_KEY, mPause);
		savedInstanceState.putInt(STOP_KEY, mStop);
		savedInstanceState.putInt(DESTROY_KEY, mDestroy);

		
	}
	
	// Updates the displayed counters
	public void displayCounts() {

		mTvCreate.setText("onCreate() calls: " + mCreate);
		mTvStart.setText("onStart() calls: " + mStart);
		mTvResume.setText("onResume() calls: " + mResume);
		mTvRestart.setText("onRestart() calls: " + mRestart);
	
	}
}
