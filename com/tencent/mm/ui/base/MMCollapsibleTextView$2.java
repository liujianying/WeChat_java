package com.tencent.mm.ui.base;

class MMCollapsibleTextView$2 implements Runnable {
    final /* synthetic */ MMCollapsibleTextView ttX;

    MMCollapsibleTextView$2(MMCollapsibleTextView mMCollapsibleTextView) {
        this.ttX = mMCollapsibleTextView;
    }

    public final void run() {
        MMCollapsibleTextView.d(this.ttX).setMaxLines(10);
        MMCollapsibleTextView.e(this.ttX).setVisibility(0);
        MMCollapsibleTextView.e(this.ttX).setText(MMCollapsibleTextView.f(this.ttX));
    }
}
