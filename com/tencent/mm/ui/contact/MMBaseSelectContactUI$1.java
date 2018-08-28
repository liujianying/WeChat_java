package com.tencent.mm.ui.contact;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

class MMBaseSelectContactUI$1 implements OnTouchListener {
    final /* synthetic */ MMBaseSelectContactUI ukl;

    MMBaseSelectContactUI$1(MMBaseSelectContactUI mMBaseSelectContactUI) {
        this.ukl = mMBaseSelectContactUI;
    }

    public final boolean onTouch(View view, MotionEvent motionEvent) {
        MMBaseSelectContactUI.a(this.ukl);
        this.ukl.cyv();
        this.ukl.cyw();
        return false;
    }
}
