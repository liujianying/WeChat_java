package com.tencent.mm.plugin.appbrand.widget.input.autofill;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

class AutoFillListPopupWindowBase$e implements OnTouchListener {
    final /* synthetic */ AutoFillListPopupWindowBase gKu;

    private AutoFillListPopupWindowBase$e(AutoFillListPopupWindowBase autoFillListPopupWindowBase) {
        this.gKu = autoFillListPopupWindowBase;
    }

    /* synthetic */ AutoFillListPopupWindowBase$e(AutoFillListPopupWindowBase autoFillListPopupWindowBase, byte b) {
        this(autoFillListPopupWindowBase);
    }

    public final boolean onTouch(View view, MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        int x = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        if (action == 0 && AutoFillListPopupWindowBase.b(this.gKu) != null && AutoFillListPopupWindowBase.b(this.gKu).isShowing() && x >= 0 && x < AutoFillListPopupWindowBase.b(this.gKu).getWidth() && y >= 0 && y < AutoFillListPopupWindowBase.b(this.gKu).getHeight()) {
            AutoFillListPopupWindowBase.d(this.gKu).postDelayed(AutoFillListPopupWindowBase.c(this.gKu), 250);
        } else if (action == 1) {
            AutoFillListPopupWindowBase.d(this.gKu).removeCallbacks(AutoFillListPopupWindowBase.c(this.gKu));
        }
        return false;
    }
}
