package com.tencent.mm.ui.base;

import android.view.View;

class MMListPopupWindow$1 implements Runnable {
    final /* synthetic */ MMListPopupWindow tvV;

    MMListPopupWindow$1(MMListPopupWindow mMListPopupWindow) {
        this.tvV = mMListPopupWindow;
    }

    public final void run() {
        View view = this.tvV.PW;
        if (view != null && view.getWindowToken() != null) {
            this.tvV.show();
        }
    }
}
