package com.tencent.mm.modelcdntran;

import com.tencent.mm.g.a.la;
import com.tencent.mm.modelvideo.t;
import com.tencent.mm.sdk.b.a;

class f$7 implements Runnable {
    final /* synthetic */ f dPC;
    final /* synthetic */ int dPF;
    final /* synthetic */ int dPG;
    final /* synthetic */ String sl;

    f$7(f fVar, String str, int i, int i2) {
        this.dPC = fVar;
        this.sl = str;
        this.dPF = i;
        this.dPG = i2;
    }

    public final void run() {
        j jVar = (j) this.dPC.dOW.get(this.sl);
        if (jVar != null) {
            la laVar = new la();
            laVar.bVm.bOh = 3;
            laVar.bVm.retCode = 0;
            laVar.bVm.mediaId = this.sl;
            laVar.bVm.offset = this.dPF;
            laVar.bVm.length = this.dPG;
            a.sFg.m(laVar);
            if (this.dPF == 0 && this.dPG >= jVar.dQl) {
                f.a(t.nW(jVar.filename), jVar.dQl, jVar.dQk);
            }
        }
    }
}
