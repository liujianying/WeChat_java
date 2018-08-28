package com.tencent.mm.ui;

import com.tencent.mm.a.e;
import com.tencent.mm.ak.a.g.b;
import com.tencent.mm.g.a.bn;
import com.tencent.mm.model.au;
import com.tencent.mm.plugin.g.a;
import com.tencent.mm.plugin.p.c;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.x;

class ClearCacheUI$3 implements Runnable {
    final /* synthetic */ long thp;
    final /* synthetic */ ClearCacheUI thq;

    ClearCacheUI$3(ClearCacheUI clearCacheUI, long j) {
        this.thq = clearCacheUI;
        this.thp = j;
    }

    public final void run() {
        x.w("MicroMsg.ClearCacheUI", "doClearCache flag %d", new Object[]{Long.valueOf(this.thp)});
        if ((this.thp & 1) != 0) {
            e.co(c.aWE());
        }
        if ((this.thp & 2) != 0) {
            e.co(b.dYs);
        }
        if ((this.thp & 4) != 0) {
            e.co(com.tencent.mm.compatible.util.e.dgr);
        }
        if ((this.thp & 8) != 0) {
            au.HU();
            e.co(com.tencent.mm.model.c.Gl());
        }
        if ((this.thp & 16) != 0) {
            e.co(a.aqI());
        }
        if ((this.thp & 32) != 0) {
            au.HU();
            e.co(com.tencent.mm.model.c.Gf());
        }
        if ((this.thp & 64) != 0) {
            au.HU();
            e.co(com.tencent.mm.model.c.getAccSnsPath());
        }
        bn bnVar = new bn();
        bnVar.bIU.bIV = this.thp;
        com.tencent.mm.sdk.b.a.sFg.m(bnVar);
        ah.A(new 1(this));
    }
}
