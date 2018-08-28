package com.tencent.mm.pluginsdk.ui;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

class MMPhoneNumberEditText$1 implements OnTouchListener {
    final /* synthetic */ MMPhoneNumberEditText qFR;

    MMPhoneNumberEditText$1(MMPhoneNumberEditText mMPhoneNumberEditText) {
        this.qFR = mMPhoneNumberEditText;
    }

    public final boolean onTouch(View view, MotionEvent motionEvent) {
        MMPhoneNumberEditText mMPhoneNumberEditText = this.qFR;
        if (mMPhoneNumberEditText.getCompoundDrawables()[2] != null && motionEvent.getAction() == 1 && motionEvent.getX() > ((float) ((mMPhoneNumberEditText.getWidth() - mMPhoneNumberEditText.getPaddingRight()) - this.qFR.qFN.getIntrinsicWidth()))) {
            if (mMPhoneNumberEditText.isFocused()) {
                mMPhoneNumberEditText.setText("");
                MMPhoneNumberEditText.a(mMPhoneNumberEditText);
            } else if (MMPhoneNumberEditText.b(this.qFR) != null) {
                MMPhoneNumberEditText.b(this.qFR).f(mMPhoneNumberEditText);
            }
        }
        return false;
    }
}
