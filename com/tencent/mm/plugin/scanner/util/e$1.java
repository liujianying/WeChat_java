package com.tencent.mm.plugin.scanner.util;

import com.tencent.mm.g.a.lo;

class e$1 implements Runnable {
    final /* synthetic */ lo mMW;
    final /* synthetic */ e mMX;

    e$1(e eVar, lo loVar) {
        this.mMX = eVar;
        this.mMW = loVar;
    }

    public final void run() {
        if (this.mMX.getContext() != null && this.mMW.bVT != null) {
            if (this.mMW.bVT.ret == 1) {
                this.mMX.hk(true);
            } else if (this.mMW.bVT.ret == 2) {
                this.mMX.hk(false);
            }
        }
    }
}
