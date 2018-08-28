package com.tencent.mm.ak;

import com.tencent.mm.ab.f;

class k$1 implements Runnable {
    final /* synthetic */ f dVv;
    final /* synthetic */ int dVw;
    final /* synthetic */ int dVx;
    final /* synthetic */ k dVy;

    k$1(k kVar, f fVar, int i, int i2) {
        this.dVy = kVar;
        this.dVv = fVar;
        this.dVw = i;
        this.dVx = i2;
    }

    public final void run() {
        this.dVv.a(this.dVw, this.dVx, this.dVy);
    }
}
