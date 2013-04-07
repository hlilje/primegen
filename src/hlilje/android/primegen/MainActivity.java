package hlilje.android.primegen;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

/**
 * The main activity for the PrimeGen application.
 * 
 * @author Hampus Liljekvist
 * @version 2013-04-07
 */
public class MainActivity extends Activity {
	// Key used to identify the user specified prime limit
	public final static String EXTRA_LIMIT = "hlilje.android.primegen.LIMIT";
	// Key used as warning message if the limit is too high
	public final static String WARNING_MESSAGE = "hlilje.android.primegen.WARNING";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * Create a menu.
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
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
    	
    	//TODO, this only works if you send a String?
    	if(numberBox != null) {
    		String boxInput = numberBox.getText().toString();
    		// Will crash at parseInt if no number is supplied otherwise
    		if(!boxInput.equals("")) {
    			// Safe since specified as a number in xml-file
    			int limit = Integer.parseInt(boxInput);
    			String warning = getString(R.string.number_warning);
    			
    			// Check for the limit size to avoid program freezes
    			if(!(limit > 1000))
    				// Limit ok, put the limit
    				intent.putExtra(EXTRA_LIMIT, limit);
    			else {
    				// Put a warning instead
    				intent.putExtra(WARNING_MESSAGE, warning);
    			}
    		}
    		
    	}
    	startActivity(intent);
    }
}
