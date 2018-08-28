package com.tencent.mm.ui.base;

class WxImageView$1 implements Runnable {
    final /* synthetic */ float bCl;
    final /* synthetic */ float bCm;
    final /* synthetic */ long dUQ;
    final /* synthetic */ WxImageView tBw;
    final /* synthetic */ float tzI = 128.0f;
    final /* synthetic */ float tzJ;
    final /* synthetic */ float tzK;

    WxImageView$1(WxImageView wxImageView, long j, float f, float f2, float f3, float f4) {
        this.tBw = wxImageView;
        this.dUQ = j;
        this.tzJ = f;
        this.tzK = f2;
        this.bCl = f3;
        this.bCm = f4;
    }

    public final void run() {
        float min = Math.min(this.tzI, (float) (System.currentTimeMillis() - this.dUQ));
        this.tBw.h(this.tzJ + (this.tzK * min), this.bCl, this.bCm);
        if (min < this.tzI) {
            this.tBw.mHandler.post(this);
        }
    }
}
