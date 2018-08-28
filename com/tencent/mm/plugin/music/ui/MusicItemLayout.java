package com.tencent.mm.plugin.music.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.widget.LinearLayout;
import com.tencent.mm.plugin.music.ui.b.a;

public class MusicItemLayout extends LinearLayout {
    private GestureDetector iEv;

    public MusicItemLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        initView();
    }

    public MusicItemLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        initView();
    }

    private void initView() {
        this.iEv = new GestureDetector(getContext(), new a(this, (byte) 0));
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        a aVar = (a) getTag();
        if (!aVar.biE()) {
            Object obj;
            if (aVar.lAL.getX() <= motionEvent.getX() && motionEvent.getX() <= aVar.lAL.getX() + ((float) aVar.lAL.getMeasuredWidth()) && aVar.lAL.getY() <= motionEvent.getY()) {
                if (motionEvent.getY() <= ((float) aVar.lAL.getMeasuredHeight()) + aVar.lAL.getY()) {
                    obj = 1;
                    if (obj == null) {
                        return true;
                    }
                }
            }
            obj = null;
            if (obj == null) {
                return true;
            }
        }
        return false;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        this.iEv.onTouchEvent(motionEvent);
        return true;
    }
}
