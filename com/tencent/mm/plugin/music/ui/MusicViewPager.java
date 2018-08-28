package com.tencent.mm.plugin.music.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import com.tencent.mm.ui.base.CustomViewPager;

public class MusicViewPager extends CustomViewPager {
    private GestureDetector iEv = new GestureDetector(getContext(), new b(this, (byte) 0));

    public MusicViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setScroller(new a(this, getContext()));
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return super.onInterceptTouchEvent(motionEvent) && this.iEv.onTouchEvent(motionEvent);
    }
}
