package material.wahyu.io;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.content.*;
import android.os.*;
import android.view.*;
import android.support.v7.widget.*;
import android.widget.Toast;
import android.support.v4.view.*;

public class MainActivity extends AppCompatActivity
{
	
	private Toolbar toolbar;
	private RecyclerView recyclerView;
	private RecyclerView.Adapter adapter;
	private RecyclerView.LayoutManager layoutManager;
	public static final String THEME_UTILS = "current";
	
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
		ThemeUtils.createTheme(this);
        setContentView(R.layout.activity_main);
		toolbar=(Toolbar)findViewById(R.id.toolbar);
		setSupportActionBar(toolbar);
		
		// recycler view
		recyclerView = (RecyclerView)findViewById(R.id.recyclerView);
		recyclerView.setHasFixedSize(true);
		layoutManager = new LinearLayoutManager(this);
		recyclerView.setLayoutManager(layoutManager);
		adapter = new MainActivityAdapter(this);
		recyclerView.setAdapter(adapter);
    }
	
	// menu item
	@Override
	public boolean onCreateOptionsMenu(Menu menu)
	{
		getMenuInflater().inflate(R.menu.toolbar_menu, menu);
		
		// Search action == null ( belum paham cara search melalui arrays.xml )
		final MenuItem item = menu.findItem(R.id.search);
		final SearchView searchView=(SearchView)MenuItemCompat.getActionView(item);
		searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener(){
				@Override
				public boolean onQueryTextSubmit(String query)
				{
					return false;
				}

				@Override
				public boolean onQueryTextChange(String newText)
				{
					return false;
				}
			});
			
		// end
		return super.onCreateOptionsMenu(menu);
	}

	// item overflow action
	@Override
	public boolean onOptionsItemSelected(MenuItem item)
	{
		switch (item.getItemId()){
			case R.id.settings:
				Intent intent = new Intent(this, material.wahyu.io.SettingsActivity.class);
				startActivity(intent);
				break;
			case R.id.light:
				ThemeUtils.setTheme(this, 0);
				recreate();
				break;
			case R.id.dark:
				ThemeUtils.setTheme(this, 1);
				recreate();
				break;
		}
		return super.onOptionsItemSelected(item);
	}
}
