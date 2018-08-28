package com.tencent.mm.ak;

import com.tencent.mm.ab.f;

class l$3 implements Runnable {
    final /* synthetic */ l dVN;
    final /* synthetic */ f dVv;
    final /* synthetic */ int dVw;
    final /* synthetic */ int dVx;

    l$3(l lVar, f fVar, int i, int i2) {
        this.dVN = lVar;
        this.dVv = fVar;
        this.dVw = i;
        this.dVx = i2;
    }

    public final void run() {
        this.dVv.a(this.dVw, this.dVx, this.dVN);
    }
}
