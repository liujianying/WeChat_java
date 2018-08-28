package com.tencent.mm.plugin.multitalk.a;

import com.tencent.mm.g.a.mz;
import com.tencent.mm.sdk.b.a;

class g$1 implements Runnable {
    final /* synthetic */ String ltU;
    final /* synthetic */ g ltV;

    g$1(g gVar, String str) {
        this.ltV = gVar;
        this.ltU = str;
    }

    public final void run() {
        this.ltV.HK(this.ltU);
        mz mzVar = new mz();
        mzVar.bYb.type = 2;
        a.sFg.m(mzVar);
    }
}
