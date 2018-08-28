package com.tencent.mm.plugin.exdevice.model;

import com.tencent.mm.g.a.rd;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.x;

class e$44 extends c<rd> {
    final /* synthetic */ e iup;

    e$44(e eVar) {
        this.iup = eVar;
        this.sFo = rd.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        rd rdVar = (rd) bVar;
        x.i("MicroMsg.exdevice.ExdeviceEventManager", "receive StopAllChannelWithParamsEvent");
        rdVar = rdVar;
        ad.aHl();
        d.ev(rdVar.cbU.cbV);
        return true;
    }
}
