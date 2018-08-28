package com.tencent.mm.modelcdntran;

import com.tencent.mm.g.a.la;
import com.tencent.mm.sdk.b.a;

class f$6 implements Runnable {
    final /* synthetic */ f dPC;
    final /* synthetic */ int dPF;
    final /* synthetic */ int dPG;
    final /* synthetic */ String sl;

    f$6(f fVar, String str, int i, int i2) {
        this.dPC = fVar;
        this.sl = str;
        this.dPF = i;
        this.dPG = i2;
    }

    public final void run() {
        j jVar = (j) this.dPC.dOW.get(this.sl);
        if (jVar != null) {
            if (jVar.dQt != null) {
                jVar.dQt.onDataAvailable(this.sl, this.dPF, this.dPG);
            }
            la laVar = new la();
            laVar.bVm.bOh = 2;
            laVar.bVm.retCode = 0;
            laVar.bVm.mediaId = this.sl;
            laVar.bVm.offset = this.dPF;
            laVar.bVm.length = this.dPG;
            a.sFg.m(laVar);
        }
    }
}
