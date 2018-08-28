package com.tencent.mm.plugin.brandservice.ui;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

class BizSearchDetailPageUI$4 implements OnTouchListener {
    final /* synthetic */ BizSearchDetailPageUI hos;

    BizSearchDetailPageUI$4(BizSearchDetailPageUI bizSearchDetailPageUI) {
        this.hos = bizSearchDetailPageUI;
    }

    public final boolean onTouch(View view, MotionEvent motionEvent) {
        if (BizSearchDetailPageUI.f(this.hos) != null) {
            BizSearchDetailPageUI.f(this.hos).clearFocus();
        }
        this.hos.YC();
        return false;
    }
}
