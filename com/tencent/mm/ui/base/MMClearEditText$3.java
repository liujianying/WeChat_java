package com.tencent.mm.ui.base;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

class MMClearEditText$3 implements OnTouchListener {
    final /* synthetic */ MMClearEditText ttV;

    MMClearEditText$3(MMClearEditText mMClearEditText) {
        this.ttV = mMClearEditText;
    }

    public final boolean onTouch(View view, MotionEvent motionEvent) {
        MMClearEditText mMClearEditText = this.ttV;
        if (mMClearEditText.getCompoundDrawables()[2] != null && motionEvent.getAction() == 1 && motionEvent.getX() > ((float) ((mMClearEditText.getWidth() - mMClearEditText.getPaddingRight()) - this.ttV.qFN.getIntrinsicWidth()))) {
            mMClearEditText.setText("");
            MMClearEditText.c(this.ttV);
        }
        return false;
    }
}
