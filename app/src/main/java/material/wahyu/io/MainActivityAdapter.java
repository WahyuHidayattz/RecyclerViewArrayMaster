package material.wahyu.io;

import android.content.*;
import android.graphics.drawable.*;
import android.support.v7.widget.*;
import android.view.*;
import android.widget.*;
import java.util.*;
import android.content.res.*;

public class MainActivityAdapter extends RecyclerView.Adapter<MainActivityAdapter.ViewHolder>
{
	// Main variable
	String[] title;
	String[] subtitle;
	Drawable[] thumbnail;
	private int LENGTH = 20;
	ArrayAdapter<String> adapter;

	@Override
	public MainActivityAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
	{
		View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_list, parent, false);
		ViewHolder vh = new ViewHolder(v);
		return vh;
	}

	// Main adapter
	public MainActivityAdapter(Context context){
		Resources resources = context.getResources();
		title = context.getResources().getStringArray(R.array.item_title);
		subtitle = context.getResources().getStringArray(R.array.item_subtitle);
		TypedArray a = resources.obtainTypedArray(R.array.item_thumbnail);
		thumbnail = new Drawable[a.length()];
		for (int i = 0; i < thumbnail.length; i++){
			thumbnail[i] = a.getDrawable(i);
		}
	}

	// View Holder
	public class ViewHolder extends RecyclerView.ViewHolder {
		public TextView mTitle;
		public TextView mSubtitle;
		public ImageView mThumbnail;

		public ViewHolder(View v){
			super(v);
			mTitle = (TextView)v.findViewById(R.id.title);
			mSubtitle = (TextView)v.findViewById(R.id.subtitle);
			mThumbnail = (ImageView)v.findViewById(R.id.thumbnail);
			v.setOnClickListener(new View.OnClickListener(){
					@Override
					public void onClick(View vi){
						Context context = vi.getContext();
						Intent intent = new Intent(context, DetailActivity.class);
						intent.putExtra(DetailActivity.EXTRA_POSITION, getAdapterPosition());
						context.startActivity(intent);
					}
				});
		}
	}

	// content holder 
	@Override
	public void onBindViewHolder(ViewHolder holder, int position)
	{
		holder.mTitle.setText(title[position % title.length]);
		holder.mSubtitle.setText(subtitle[position % subtitle.length]);
		holder.mThumbnail.setImageDrawable(thumbnail[position % thumbnail.length]);
	}

	// length / panjangnya recyclerView
	@Override
	public int getItemCount()
	{
		return LENGTH;
	}

}

