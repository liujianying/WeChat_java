package com.tencent.mm.ui;

class MMTabView$1 implements Runnable {
    final /* synthetic */ String tnZ;
    final /* synthetic */ MMTabView toa;

    MMTabView$1(MMTabView mMTabView, String str) {
        this.toa = mMTabView;
        this.tnZ = str;
    }

    public final void run() {
        MMTabView.a(this.toa).setText(this.tnZ);
        this.toa.cqw();
    }
}
