package com.tencent.mm.plugin.emoji.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ScrollView;

public class EmojiDetailScrollView extends ScrollView {
    private boolean imb;

    public EmojiDetailScrollView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public EmojiDetailScrollView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.imb = true;
        setFadingEdgeLength(0);
    }

    protected void onSizeChanged(int i, int i2, int i3, int i4) {
    }

    public void requestLayout() {
        this.imb = false;
        super.requestLayout();
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        this.imb = false;
        super.onLayout(z, i, i2, i3, i4);
    }

    public void scrollTo(int i, int i2) {
        this.imb = true;
    }

    public void scrollBy(int i, int i2) {
    }

    public void requestChildFocus(View view, View view2) {
    }

    public void setScrollEnable(boolean z) {
        this.imb = z;
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.imb) {
            return super.onInterceptTouchEvent(motionEvent);
        }
        return false;
    }
}
