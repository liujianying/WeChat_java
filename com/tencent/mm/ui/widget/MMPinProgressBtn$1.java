package com.tencent.mm.ui.widget;

import com.tencent.mm.sdk.platformtools.x;

class MMPinProgressBtn$1 implements Runnable {
    final /* synthetic */ MMPinProgressBtn uGz;

    MMPinProgressBtn$1(MMPinProgressBtn mMPinProgressBtn) {
        this.uGz = mMPinProgressBtn;
    }

    public final void run() {
        if (this.uGz.getVisibility() != 0) {
            x.i("MicroMsg.MMPinProgressBtn", "cur progress bar not visiable, stop auto pregress");
            return;
        }
        MMPinProgressBtn.a(this.uGz, MMPinProgressBtn.a(this.uGz) + 1);
        if (MMPinProgressBtn.a(this.uGz) >= MMPinProgressBtn.b(this.uGz)) {
            MMPinProgressBtn.a(this.uGz, MMPinProgressBtn.a(this.uGz) - 1);
            x.i("MicroMsg.MMPinProgressBtn", "match auto progress max, return");
            return;
        }
        this.uGz.invalidate();
        this.uGz.postDelayed(MMPinProgressBtn.c(this.uGz), 200);
    }
}
