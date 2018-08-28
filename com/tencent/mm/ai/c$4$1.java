package com.tencent.mm.ai;

import com.tencent.mm.ai.c.4;
import com.tencent.mm.model.am.b.a;
import com.tencent.mm.sdk.platformtools.bi;

class c$4$1 implements Runnable {
    final /* synthetic */ String bAA;
    final /* synthetic */ String dSW;
    final /* synthetic */ boolean dSX;
    final /* synthetic */ 4 dSY;

    c$4$1(4 4, String str, String str2, boolean z) {
        this.dSY = 4;
        this.bAA = str;
        this.dSW = str2;
        this.dSX = z;
    }

    public final void run() {
        a aVar = (a) this.dSY.dST.dSL.remove(this.bAA);
        a aVar2 = bi.oW(this.dSW) ? null : (a) this.dSY.dST.dSL.remove(this.dSW);
        if (aVar != null) {
            aVar.x(this.bAA, this.dSX);
        }
        if (aVar2 != null && !bi.oW(this.dSW)) {
            aVar2.x(this.dSW, this.dSX);
        }
    }
}
