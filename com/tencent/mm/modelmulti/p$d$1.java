package com.tencent.mm.modelmulti;

import com.tencent.mm.booter.f;
import com.tencent.mm.kernel.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelmulti.p.b;
import com.tencent.mm.modelmulti.p.d;
import com.tencent.mm.sdk.platformtools.x;

class p$d$1 implements b {
    final /* synthetic */ int eaH;
    final /* synthetic */ d eaI;

    p$d$1(d dVar, int i) {
        this.eaI = dVar;
        this.eaH = i;
    }

    public final boolean ie(int i) {
        x.i("MicroMsg.SyncService", "%s onFinishCmd index:%s ", new Object[]{this.eaI, Integer.valueOf(this.eaH)});
        int i2 = this.eaH;
        g.Ek();
        g.Eg();
        f.aO(i2, a.Df());
        p.a(this.eaI.eay, this.eaI);
        return true;
    }
}
