package com.tencent.xweb.extension.video;

import android.content.Context;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;

public class ClickableFrameLayout extends FrameLayout {
    private GestureDetector gbw;
    private OnClickListener mOnClickListener;

    public void setOnClickListener(OnClickListener onClickListener) {
        super.setOnClickListener(onClickListener);
        this.mOnClickListener = onClickListener;
    }

    public void setGestureDetector(GestureDetector gestureDetector) {
        this.gbw = gestureDetector;
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return this.mOnClickListener != null;
    }

    public ClickableFrameLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public ClickableFrameLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }
}
