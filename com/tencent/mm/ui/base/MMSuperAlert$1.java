package com.tencent.mm.ui.base;

class MMSuperAlert$1 implements Runnable {
    final /* synthetic */ int txw;
    final /* synthetic */ int txx;
    final /* synthetic */ boolean txy;
    final /* synthetic */ MMSuperAlert txz;

    MMSuperAlert$1(MMSuperAlert mMSuperAlert, int i, int i2, boolean z) {
        this.txz = mMSuperAlert;
        this.txw = i;
        this.txx = i2;
        this.txy = z;
    }

    public final void run() {
        h.a(this.txz, this.txw == 0 ? "" : this.txz.getString(this.txw), this.txx == 0 ? "" : this.txz.getString(this.txx), this.txy, new 1(this), new 2(this));
    }
}
