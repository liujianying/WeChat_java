package com.tencent.mm.ui.base;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

class MMListPopupWindow$e implements OnTouchListener {
    final /* synthetic */ MMListPopupWindow tvV;

    private MMListPopupWindow$e(MMListPopupWindow mMListPopupWindow) {
        this.tvV = mMListPopupWindow;
    }

    /* synthetic */ MMListPopupWindow$e(MMListPopupWindow mMListPopupWindow, byte b) {
        this(mMListPopupWindow);
    }

    public final boolean onTouch(View view, MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        int x = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        if (action == 0 && MMListPopupWindow.b(this.tvV) != null && MMListPopupWindow.b(this.tvV).isShowing() && x >= 0 && x < MMListPopupWindow.b(this.tvV).getWidth() && y >= 0 && y < MMListPopupWindow.b(this.tvV).getHeight()) {
            MMListPopupWindow.d(this.tvV).postDelayed(MMListPopupWindow.c(this.tvV), 250);
        } else if (action == 1) {
            MMListPopupWindow.d(this.tvV).removeCallbacks(MMListPopupWindow.c(this.tvV));
        }
        return false;
    }
}
