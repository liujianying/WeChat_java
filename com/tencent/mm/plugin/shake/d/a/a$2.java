package com.tencent.mm.plugin.shake.d.a;

import com.tencent.mm.protocal.c.bhp;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

class a$2 implements Runnable {
    final /* synthetic */ a mYA;
    final /* synthetic */ boolean mYB = false;
    final /* synthetic */ boolean mYC;

    a$2(a aVar, boolean z) {
        this.mYA = aVar;
        this.mYC = z;
    }

    public final void run() {
        if (this.mYB) {
            a.a(this.mYA, null, -1, this.mYC);
        } else if (!this.mYA.mYp) {
            x.w("MicroMsg.MusicFingerPrintRecorder", "tryCallBack netscen not return.");
        } else if (this.mYA.bDp != null) {
            x.w("MicroMsg.MusicFingerPrintRecorder", "tryCallBack device not ready!");
        } else if (this.mYA.mYq != null) {
            a aVar = this.mYA;
            bhp bvf = this.mYA.mYq.bvf();
            e eVar = this.mYA.mYq;
            long VF = bi.VF();
            if (eVar.mYG > 0 && eVar.mYG < VF) {
                VF = eVar.mYG;
            }
            a.a(aVar, bvf, VF, this.mYC);
        } else {
            a.a(this.mYA, null, -1, this.mYC);
        }
    }
}
