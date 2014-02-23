package course.labs.activitylab;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class ActivityTwo extends Activity {

	private static final String RESTART_KEY = "restart";
	private static final String RESUME_KEY = "resume";
	private static final String START_KEY = "start";
	private static final String CREATE_KEY = "create";
	
	private static final String PAUSE_KEY = "pause";
	private static final String STOP_KEY = "stop";
	private static final String DESTROY_KEY = "destroy";

	// String for LogCat documentation
	private final static String TAG = "Lab-ActivityTwo";

	// Lifecycle counters

	// TODO:
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



	// TODO: Create variables for each of the TextViews, called
        // mTvCreate, etc. 
	private TextView mTvCreate;
	private TextView mTvRestart;
	private TextView mTvStart;
	private TextView mTvResume;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_two);

		// TODO: Assign the appropriate TextViews to the TextView variables
		// Hint: Access the TextView by calling Activity's findViewById()
		// textView1 = (TextView) findViewById(R.id.textView1);

		mTvCreate = (TextView) findViewById(R.id.create);
		mTvRestart = (TextView) findViewById(R.id.restart);
		mTvStart = (TextView) findViewById(R.id.start);
		mTvResume = (TextView) findViewById(R.id.resume);




		Button closeButton = (Button) findViewById(R.id.bClose); 
		closeButton.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {

				// TODO:
				// This function closes Activity Two
				// Hint: use Context's finish() method

				finish();
			
			}
		});

		// Check for previously saved state
		if (savedInstanceState != null) {

			// TODO:
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


		Log.i(TAG,"The activity two is onCreate()");

		// TODO:
		// Update the appropriate count variable
		mCreate++;
		// Update the user interface via the displayCounts() method
		
		displayCounts();

	}

	// Lifecycle callback methods overrides

	@Override
	public void onStart() {
		super.onStart();

		Log.i(TAG,"The activity two is onStart()");

		// TODO:
		// Update the appropriate count variable
		mStart = mStart +1;
		// Update the user interface
		displayCounts();
		
	}

	@Override
	public void onResume() {
		super.onResume();


		Log.i(TAG,"The activity two is onResume()");
		// TODO:
		// Update the appropriate count variable
		mResume++;
		// Update the user interface
		displayCounts();

	}

	@Override
	public void onPause() {
		super.onPause();


		Log.i(TAG,"The activity two is onPause()");
		mPause++;

	}

	@Override
	public void onStop() {
		super.onStop();


		Log.i(TAG,"The activity two is onStop()");
		mStop++;

	}

	@Override
	public void onRestart() {
		super.onRestart();

		Log.i(TAG,"The activity two is onRestart()");

		// TODO:
		// Update the appropriate count variable
		mRestart++;
		// Update the user interface

		displayCounts();

	}

	@Override
	public void onDestroy() {
		super.onDestroy();

		Log.i(TAG,"The activity two is onDestroy()");
		mDestroy++;
	}

	@Override
	public void onSaveInstanceState(Bundle savedInstanceState) {

		// TODO:
		// Save counter state information with a collection of key-value pairs
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
