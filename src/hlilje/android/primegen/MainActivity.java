package hlilje.android.primegen;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

/**
 * The main activity for the PrimeGen application.
 * 
 * @author Hampus Liljekvist
 * @version 2013-07-07
 */
public class MainActivity extends Activity {
	// Key used to identify the user specified prime limit
	public final static String EXTRA_LIMIT = "hlilje.android.primegen.LIMIT";
	// Key used as warning message if the limit is too high
	public final static String WARNING_MESSAGE = "hlilje.android.primegen.WARNING";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_activity_main);
    }

    /**
     * Create a menu.
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_activity_main, menu);
        return true;
    }
    
    /**
     * Handle menu click events.
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
    	switch(item.getItemId()) {
    	case R.id.menu_about:
    		Intent intent = new Intent(this, AboutActivity.class);
    		startActivity(intent);
    		return true;
    	}
    	return super.onOptionsItemSelected(item);
    }
    
    /**
     * Called when the user presses the button and wants
     * to start generating primes.
     */
    public void startCounting(View view) {
    	Intent intent = new Intent(this, PrimeActivity.class);
    	EditText numberBox = (EditText) findViewById(R.id.numberBox);
    	
    	// This only works if you send a String?
    	if(numberBox != null) {
    		String boxInput = numberBox.getText().toString();
    		// Would otherwise crash at parseInt if no number was supplied
    		if(!boxInput.equals("")) {
    			// Safe since specified as a number in the xml-file meaning
    			// the user can't enter negative numbers or random characters
    			int limit = Integer.parseInt(boxInput);
    			String warning = getString(R.string.number_warning);
    			
    			// Limit integer input to avoid unreasonable CPU stress
    			if(!(limit > 1000))
    				// Limit ok, add the limit
    				intent.putExtra(EXTRA_LIMIT, limit);
    			else {
    				// Add a warning instead
    				intent.putExtra(WARNING_MESSAGE, warning);
    			}
    		}
    		
    	}
    	startActivity(intent);
    }
}
