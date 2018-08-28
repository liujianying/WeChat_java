package com.tencent.mm.plugin.offline.ui;

import com.tencent.mm.g.a.ri;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.offline.i;
import com.tencent.mm.plugin.offline.k;

class d$1 implements Runnable {
    final /* synthetic */ ri lLg;
    final /* synthetic */ boolean lLh;
    final /* synthetic */ d lLi;

    d$1(d dVar, ri riVar, boolean z) {
        this.lLi = dVar;
        this.lLg = riVar;
        this.lLh = z;
    }

    public final void run() {
        if (!g.Eg().Dx()) {
            return;
        }
        if (this.lLg.ccb.ccd) {
            k.bkO();
            i bkR = k.bkR();
            int i = this.lLg.ccb.cce;
            bkR.df(i, i);
            return;
        }
        k.bkO();
        k.bkR().gW(this.lLh);
    }
}
