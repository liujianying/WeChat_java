package com.tencent.mm.ui.widget;

import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;

class MMTextView$1 extends SimpleOnGestureListener {
    final /* synthetic */ MMTextView uHl;

    MMTextView$1(MMTextView mMTextView) {
        this.uHl = mMTextView;
    }

    public final boolean onDoubleTap(MotionEvent motionEvent) {
        if (MMTextView.a(this.uHl) == null) {
            return false;
        }
        return MMTextView.a(this.uHl).ds(this.uHl);
    }
}
