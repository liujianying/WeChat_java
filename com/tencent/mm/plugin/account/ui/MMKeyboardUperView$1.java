package com.tencent.mm.plugin.account.ui;

class MMKeyboardUperView$1 implements Runnable {
    final /* synthetic */ MMKeyboardUperView eSq;

    MMKeyboardUperView$1(MMKeyboardUperView mMKeyboardUperView) {
        this.eSq = mMKeyboardUperView;
    }

    public final void run() {
        this.eSq.fullScroll(130);
        MMKeyboardUperView.a(this.eSq).setVisibility(4);
    }
}
