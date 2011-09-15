package com.gridview.widget;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.GridView;

public class GridViewProgress extends GridView {
	private Rect screen;

	public GridViewProgress(Context context, AttributeSet attrs) {
		super(context, attrs);
	}
	
	@Override
	public boolean dispatchTouchEvent(MotionEvent ev) {
		if (ev.getAction() == MotionEvent.ACTION_UP) {
			if (getFirstVisiblePosition() == 0) {
				getHitRect(screen);

				View progress = getChildAt(0);
				Rect rect = new Rect(progress.getLeft(), progress.getTop(),
						progress.getRight(), progress.getBottom());

				boolean contains = screen.contains(rect);

				if (contains) {
					Log.d("GridViewProgress", "Carregando....");
				}
			}
		}

		
		return super.dispatchTouchEvent(ev);
	}

	protected void onLayout(boolean changed, int l, int t, int r, int b) {
		super.onLayout(changed, l, t, r, b);
		if (screen == null) {
			screen = new Rect(l, t, r, b);
		}
	}

}