package com.tencent.mm.plugin.account.ui;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

class SimpleLoginUI$15 implements OnTouchListener {
    final /* synthetic */ SimpleLoginUI eXn;

    SimpleLoginUI$15(SimpleLoginUI simpleLoginUI) {
        this.eXn = simpleLoginUI;
    }

    public final boolean onTouch(View view, MotionEvent motionEvent) {
        SimpleLoginUI.d(this.eXn).setFocusableInTouchMode(true);
        SimpleLoginUI.c(this.eXn).setFocusableInTouchMode(false);
        return SimpleLoginUI.d(this.eXn).getDefaultOnTouchListener().onTouch(view, motionEvent);
    }
}
