package com.tencent.mm.ui.base;

class MultiTouchImageView$1 implements Runnable {
    final /* synthetic */ float bCl;
    final /* synthetic */ float bCm;
    final /* synthetic */ long dUQ;
    final /* synthetic */ float tzI = 128.0f;
    final /* synthetic */ float tzJ;
    final /* synthetic */ float tzK;
    final /* synthetic */ MultiTouchImageView tzL;

    MultiTouchImageView$1(MultiTouchImageView multiTouchImageView, long j, float f, float f2, float f3, float f4) {
        this.tzL = multiTouchImageView;
        this.dUQ = j;
        this.tzJ = f;
        this.tzK = f2;
        this.bCl = f3;
        this.bCm = f4;
    }

    public final void run() {
        float min = Math.min(this.tzI, (float) (System.currentTimeMillis() - this.dUQ));
        this.tzL.h(this.tzJ + (this.tzK * min), this.bCl, this.bCm);
        if (min < this.tzI) {
            this.tzL.mHandler.post(this);
        }
    }
}
