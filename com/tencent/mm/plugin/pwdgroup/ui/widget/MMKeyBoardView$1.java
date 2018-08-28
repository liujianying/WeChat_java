package com.tencent.mm.plugin.pwdgroup.ui.widget;

class MMKeyBoardView$1 implements Runnable {
    final /* synthetic */ MMKeyBoardView mbg;

    MMKeyBoardView$1(MMKeyBoardView mMKeyBoardView) {
        this.mbg = mMKeyBoardView;
    }

    public final void run() {
        this.mbg.requestLayout();
    }
}
