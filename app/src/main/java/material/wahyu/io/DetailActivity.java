package material.wahyu.io;

import android.content.res.*;
import android.os.*;
import android.support.v7.app.*;
import android.support.v7.widget.*;
import android.view.*;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity
{
	public static final String EXTRA_POSITION = "position";
	Toolbar toolbar;
	ImageView imageView;
	TextView textView;
	@Override
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		ThemeUtils.createTheme(this);
		setContentView(R.layout.detail_activity);
		toolbar=(Toolbar)findViewById(R.id.toolbar);
		setSupportActionBar(toolbar);
		ActionBar actionBar=getSupportActionBar();
		actionBar.setDisplayHomeAsUpEnabled(true);

		int position = getIntent().getIntExtra(EXTRA_POSITION, 0);
		Resources resources = getResources();

		// Toolbar title
		String[] title = resources.getStringArray(R.array.item_title);
		actionBar.setTitle(title[position % title.length]);
		
		// Image 
		TypedArray itemLogos = resources.obtainTypedArray(R.array.item_thumbnail);
		ImageView itemLogo = (ImageView)findViewById(R.id.mThumbnail);
		itemLogo.setImageDrawable(itemLogos.getDrawable(position % itemLogos.length()));

		// title
		String[] itemTitles = resources.getStringArray(R.array.item_title);
		TextView itemTitle = (TextView)findViewById(R.id.mTitle);
		itemTitle.setText(itemTitles[position % itemTitles.length]);

		// subtitles 1-4
		String[] itemDescs = resources.getStringArray(R.array.item_subtitle);
		TextView itemDesc = (TextView)findViewById(R.id.mSubtitle);
		itemDesc.setText(itemDescs[position % itemDescs.length]);
		
		String[] itemDescs2 = resources.getStringArray(R.array.item_subtitle);
		TextView itemDesc2 = (TextView)findViewById(R.id.mSubtitle2);
		itemDesc2.setText(itemDescs2[position % itemDescs2.length]);
		
		String[] itemDescs3 = resources.getStringArray(R.array.item_subtitle);
		TextView itemDesc3 = (TextView)findViewById(R.id.mSubtitle3);
		itemDesc3.setText(itemDescs3[position % itemDescs3.length]);
		
		String[] itemDescs4 = resources.getStringArray(R.array.item_subtitle);
		TextView itemDesc4 = (TextView)findViewById(R.id.mSubtitle4);
		itemDesc4.setText(itemDescs4[position % itemDescs4.length]);
	}
	
	// back / home btn
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId())
		{
			case android.R.id.home:
				finish();
				return true;
		}
		return
			super.onOptionsItemSelected
		(item);
	}
}

