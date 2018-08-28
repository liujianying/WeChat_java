package com.tencent.mm.ui.base;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

class MMAutoCompleteTextView$1 implements OnTouchListener {
    final /* synthetic */ MMAutoCompleteTextView ttE;

    MMAutoCompleteTextView$1(MMAutoCompleteTextView mMAutoCompleteTextView) {
        this.ttE = mMAutoCompleteTextView;
    }

    public final boolean onTouch(View view, MotionEvent motionEvent) {
        MMAutoCompleteTextView mMAutoCompleteTextView = this.ttE;
        if (mMAutoCompleteTextView.getCompoundDrawables()[2] != null && motionEvent.getAction() == 1 && motionEvent.getX() > ((float) ((mMAutoCompleteTextView.getWidth() - mMAutoCompleteTextView.getPaddingRight()) - this.ttE.qFN.getIntrinsicWidth()))) {
            mMAutoCompleteTextView.setText("");
            MMAutoCompleteTextView.a(this.ttE);
        }
        return false;
    }
}
