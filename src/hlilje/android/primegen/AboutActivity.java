package hlilje.android.primegen;

import android.app.Activity;
import android.os.Bundle;

/**
 * The activity used to display the 'About' information
 * for the user.
 * 
 * @author Hampus Liljekvist
 * @version 2013-04-09
 */
public class AboutActivity extends Activity {

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	    setContentView(R.layout.layout_activity_about);
	}
}
