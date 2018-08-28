package com.tencent.mm.plugin.address.model;

import com.tencent.mm.g.a.mh;
import com.tencent.mm.model.au;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.x;

public final class j extends c<mh> {
    public j() {
        this.sFo = mh.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        mh mhVar = (mh) bVar;
        x.i("MicroMsg.RcptAddressEventListener", "revent " + mhVar.bWX.bWZ);
        au.HU();
        com.tencent.mm.sdk.platformtools.j.fN(mhVar.bWX.bWZ, com.tencent.mm.model.c.Gq() + "address");
        return false;
    }
}
