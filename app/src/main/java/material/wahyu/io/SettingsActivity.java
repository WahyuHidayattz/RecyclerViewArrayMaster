package material.wahyu.io;

import android.support.v7.app.*;
import android.os.*;
import material.wahyu.io.*;
import android.view.*;
import android.support.v7.widget.*;
import android.content.*;

public class SettingsActivity extends AppCompatActivity
{
	private Toolbar toolbar;
	
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		ThemeUtils.createTheme(this);
		setContentView(R.layout.settings);

		toolbar=(Toolbar)findViewById(R.id.toolbar);
		setSupportActionBar(toolbar);
	}
	
}
