package com.tencent.mm.plugin.account.ui;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

class SimpleLoginUI$14 implements OnTouchListener {
    final /* synthetic */ SimpleLoginUI eXn;

    SimpleLoginUI$14(SimpleLoginUI simpleLoginUI) {
        this.eXn = simpleLoginUI;
    }

    public final boolean onTouch(View view, MotionEvent motionEvent) {
        SimpleLoginUI.c(this.eXn).setFocusableInTouchMode(true);
        return SimpleLoginUI.c(this.eXn).getDefaultOnTouchListener().onTouch(view, motionEvent);
    }
}
