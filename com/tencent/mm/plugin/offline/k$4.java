package com.tencent.mm.plugin.offline;

import com.tencent.mm.ab.d;
import com.tencent.mm.model.bv.a;
import com.tencent.mm.platformtools.ab;
import com.tencent.mm.sdk.platformtools.x;

class k$4 implements a {
    final /* synthetic */ k lJB;

    k$4(k kVar) {
        this.lJB = kVar;
    }

    public final void a(d.a aVar) {
        String a = ab.a(aVar.dIN.rcl);
        x.d("MicroMsg.SubCoreOffline", "OfflinePayMsg:" + a);
        k.a(this.lJB).post(new 1(this, a, aVar));
    }
}
