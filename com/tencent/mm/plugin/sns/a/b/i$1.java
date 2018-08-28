package com.tencent.mm.plugin.sns.a.b;

import com.tencent.mm.bk.b;
import com.tencent.mm.protocal.c.apz;
import com.tencent.mm.sdk.platformtools.x;

class i$1 implements Runnable {
    final /* synthetic */ int njH;
    final /* synthetic */ Object[] njI;
    final /* synthetic */ i njJ;

    i$1(i iVar, int i, Object[] objArr) {
        this.njJ = iVar;
        this.njH = i;
        this.njI = objArr;
    }

    public final void run() {
        apz apz = new apz();
        apz.rSt = this.njH;
        apz.rSB = (int) (System.currentTimeMillis() / 1000);
        apz.hbF = 1;
        String n = i.n(this.njI);
        apz.rSu = new b(n.getBytes());
        i.a(this.njJ).rbN.add(apz);
        x.i("MicroMsg.SnsLogMgr", "snsadlog " + this.njH + " " + n);
        if (i.b(this.njJ) == 0) {
            i.a(this.njJ, System.currentTimeMillis());
        }
    }
}
