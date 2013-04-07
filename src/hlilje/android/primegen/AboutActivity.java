package hlilje.android.primegen;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

/**
 * The activity used to display the about information
 * for the user.
 * 
 * @author Hampus Liljekvist
 * @version 2013-04-07
 */
public class AboutActivity extends Activity {

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	    setContentView(R.layout.activity_about);
	}
}
