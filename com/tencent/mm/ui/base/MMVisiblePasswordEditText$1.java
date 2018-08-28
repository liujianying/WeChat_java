package com.tencent.mm.ui.base;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

class MMVisiblePasswordEditText$1 implements OnTouchListener {
    final /* synthetic */ MMVisiblePasswordEditText tzf;

    MMVisiblePasswordEditText$1(MMVisiblePasswordEditText mMVisiblePasswordEditText) {
        this.tzf = mMVisiblePasswordEditText;
    }

    public final boolean onTouch(View view, MotionEvent motionEvent) {
        boolean z = true;
        MMVisiblePasswordEditText mMVisiblePasswordEditText = this.tzf;
        if (mMVisiblePasswordEditText.getCompoundDrawables()[2] != null && motionEvent.getAction() == 1 && motionEvent.getX() > ((float) ((mMVisiblePasswordEditText.getWidth() - mMVisiblePasswordEditText.getPaddingRight()) - this.tzf.tzc.getIntrinsicWidth()))) {
            mMVisiblePasswordEditText = this.tzf;
            if (MMVisiblePasswordEditText.a(this.tzf)) {
                z = false;
            }
            MMVisiblePasswordEditText.a(mMVisiblePasswordEditText, z);
            MMVisiblePasswordEditText.b(this.tzf);
        }
        return false;
    }
}
