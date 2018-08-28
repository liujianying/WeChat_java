package com.tencent.mm.modelmulti;

import com.tencent.mm.modelmulti.p.a;
import com.tencent.mm.modelmulti.p.c;
import com.tencent.mm.platformtools.af;
import com.tencent.mm.plugin.report.f;
import com.tencent.mm.protocal.c.awe;
import com.tencent.mm.protocal.s.b;
import com.tencent.mm.sdk.platformtools.x;
import java.util.Queue;

class p$f implements c {
    int dYV;
    awe eaC;
    long eaP;
    final /* synthetic */ p eay;

    public p$f(p pVar, b bVar, int i, long j) {
        this.eay = pVar;
        this.eaC = bVar == null ? null : bVar.qWX;
        this.eaP = j;
        this.dYV = i;
    }

    public final boolean c(Queue<c> queue) {
        if (this.eaC == null) {
            f.mDy.a(99, 40, 1, false);
            x.e("MicroMsg.SyncService", "%s run resp == null", new Object[]{this});
            return false;
        } else if (10018 == af.exm) {
            x.e("MicroMsg.SyncService", "%s Give up for test", new Object[]{this});
            return false;
        } else {
            a aVar = new a(this.eay, this, true, this.eaC, new 1(this), (byte) 0);
            f.mDy.a(99, 21, 1, false);
            return true;
        }
    }

    public final String toString() {
        return "NotifyData[" + hashCode() + "]";
    }
}
