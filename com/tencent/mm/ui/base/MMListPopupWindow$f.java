package com.tencent.mm.ui.base;

class MMListPopupWindow$f implements Runnable {
    final /* synthetic */ MMListPopupWindow tvV;

    private MMListPopupWindow$f(MMListPopupWindow mMListPopupWindow) {
        this.tvV = mMListPopupWindow;
    }

    /* synthetic */ MMListPopupWindow$f(MMListPopupWindow mMListPopupWindow, byte b) {
        this(mMListPopupWindow);
    }

    public final void run() {
        if (MMListPopupWindow.a(this.tvV) != null && MMListPopupWindow.a(this.tvV).getCount() > MMListPopupWindow.a(this.tvV).getChildCount() && MMListPopupWindow.a(this.tvV).getChildCount() <= this.tvV.PT) {
            MMListPopupWindow.b(this.tvV).setInputMethodMode(2);
            this.tvV.show();
        }
    }
}
