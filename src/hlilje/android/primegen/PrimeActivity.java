package hlilje.android.primegen;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

/**
 * The activity used to display the prime number generator.
 * 
 * @author Hampus Liljekvist
 * @version 2013-04-07
 */
public class PrimeActivity extends Activity {
	@Override
	public void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	    setContentView(R.layout.activity_prime);
	    
	    // Get the intent that brought you here
	    Intent intent = getIntent();
	    
	    if(intent != null) {
	    	// Returns the default value 0 if no value was found 
	    	int limit = intent.getIntExtra(MainActivity.EXTRA_LIMIT, 0);
	    	
	    	TextView view = (TextView) findViewById(R.id.prime_text);
	    	
	    	// Get the warning message which is null if the limit wasn't reached
	    	String warning = intent.getStringExtra(MainActivity.WARNING_MESSAGE);
	    	if(warning != null)
	    		view.setText(warning); // Set warning and don't do anything else
	    	else {
	    		// The output of the primeGenerator as a String meant to be printed
	    		String printPrimes = primeGenerator(limit);
	    		
	    		// Set the generated text and primes in the TextView
	    		view.setText(printPrimes);
	    		// Make the TextView scrollable
	    		view.setMovementMethod(new ScrollingMovementMethod());
	    	}
	    }
	}
	
	/**
	 * Method responsible for generating the prime numbers to
	 * display in the PrimeActivity.
	 * Will generate all prime numbers from 1 to the limit specified
	 * as a parameter (exclusive).
	 * This method is extremely inefficient and should be
	 * treated as such.
	 * 
	 * @param limit the limit to which all primes should be generated
	 * @return a string meant for displaying all generated primes
	 */
	private String primeGenerator(int limit) {
		StringBuilder sb = new StringBuilder();
		// Alter the user output if the limit is invalid
		// A limit of 0 may be a result of the user not supplying
		// any limit at all, as 0 is the default value
		if(limit == 0)
			sb.append("0 isn't allowed as limit, silly! Or perhaps you didn't enter anything at all!?\n");
		else if(limit < 3)
			sb.append("The first prime number is 2, you know.\n");
		else
			sb.append("Prime numbers between 1 and " + limit + ":\n");
		
		for(int i = 2; i < limit; i++) {
			// 1 is not a prime number, so begin with index 2
			boolean isPrime = true;
			
			/* 
			 * Check if the number is divisible by 2 or any other
			 * number smaller than the current number. If that is
			 * the case, break the loop since the number isn't a
			 * prime number.
			 */
			for(int j = 2; j < i; j++) {
				if (i % j == 0) {
					isPrime = false;
					break; 
				}
			}
			if(isPrime) {
				sb.append(i + "\n");
			}
		}
		return sb.toString();
	}
	
	/**
     * Create the menu.
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_prime, menu);
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
}
