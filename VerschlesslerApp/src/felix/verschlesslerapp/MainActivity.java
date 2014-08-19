package felix.verschlesslerapp;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends ActionBarActivity {

	private Uebersetzer u = new Uebersetzer();	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
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
	
	public void encode(View view) {
		setOutput(u.codiere(getEditText(R.id.codeword), getEditText(R.id.input)));
	}
	
	public void decode(View view) {
		setOutput(u.decodiere(getEditText(R.id.codeword), getEditText(R.id.input)));
	}

	private String getEditText(int id) {
		EditText editText = (EditText) findViewById(id);
		return editText.getText().toString();
	}

	private void setOutput(String output) {
		EditText editText = (EditText) findViewById(R.id.output);
		editText.setText(output);
	}
}
