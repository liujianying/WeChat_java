package com.tencent.mm.plugin.soter.d;

import com.tencent.d.b.a.d;
import com.tencent.mm.plugin.soter.c.f;
import com.tencent.mm.plugin.soter.c.h;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.vending.g.b;
import com.tencent.mm.vending.g.g;
import com.tencent.mm.vending.j.c;

public final class a implements com.tencent.mm.vending.c.a<c<Boolean, Boolean>, c<Boolean, Boolean>> {
    private b eAc = null;

    public final /* synthetic */ Object call(Object obj) {
        c cVar = (c) obj;
        x.v("MicroMsg.SoterInitFunc", "alvinluo SoterInitFunc call");
        com.tencent.d.b.f.e.a aVar = new com.tencent.d.b.f.e.a();
        aVar.vmu.vmq = h.bFj();
        aVar.vmu.vmt = "WechatASK";
        aVar.vmu.vmr = new int[]{1, 2, 3};
        aVar.vmu.vmp = null;
        aVar.vmu.vms = new f();
        e eVar = new e(ad.getContext(), aVar.vmu);
        this.eAc = g.cBF();
        this.eAc.cBE();
        eVar.vmm = new 1(this);
        if (!com.tencent.d.b.f.f.cFZ().a(eVar, new d())) {
            x.e("MicroMsg.SoterInitFunc", "alvinluo: add soterTaskInitForWX failed.");
        }
        x.v("MicroMsg.SoterInitFunc", "alvinluo pending %d", new Object[]{Long.valueOf(System.currentTimeMillis())});
        return cVar;
    }
}
