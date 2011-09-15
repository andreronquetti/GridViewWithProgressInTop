package com.gridview;

import java.util.Arrays;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;

import com.gridview.adapter.GridAdapter;
import com.gridview.widget.GridViewProgress;

public class GridWithProgressInTopActivity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        GridViewProgress list = (GridViewProgress) findViewById(android.R.id.list);
        list.setAdapter(new GridAdapter(this, R.layout.row, android.R.id.text1, buildList()));
    }
    
    private List<String> buildList() {
    	String[] array = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"};
    	return Arrays.asList(array);
    }
}