package com.gridview.adapter;

import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.gridview.R;

public class GridAdapter extends ArrayAdapter<String> {
	private int resource;

	public GridAdapter(Context context, int resource, int textViewResourceId,
			List<String> objects) {
		super(context, resource, textViewResourceId, objects);
		this.resource = resource;
	}

	@Override
	public int getItemViewType(int position) {
		if (position == 0)
			return 0;
		return 1;
	}
	
	@Override
	public int getCount() {
		return super.getCount()+1;
	}
	
	
	@Override
	public int getViewTypeCount() {
		return 2;
	}
	
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		LayoutInflater inflater = (LayoutInflater) getContext().getSystemService
	      (Context.LAYOUT_INFLATER_SERVICE);
		View view;
		if (position == 0) {
			view = inflater.inflate(R.layout.progress, parent, false);
		} else {
			String str = getItem(position - 1);
			view = inflater.inflate(resource, parent, false);
			
			((TextView) view.findViewById(android.R.id.text1)).setText(str);
		}
		
		return view;
	}
	
	

}
