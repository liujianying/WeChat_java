package com.tencent.mm.plugin.exdevice.model;

import com.tencent.mm.plugin.exdevice.service.c$a;
import com.tencent.mm.plugin.exdevice.service.k;
import com.tencent.mm.plugin.exdevice.service.u;
import com.tencent.mm.sdk.platformtools.x;

class d$3 extends c$a {
    final /* synthetic */ long hgw;
    final /* synthetic */ d itl;
    final /* synthetic */ k itn;

    d$3(d dVar, long j, k kVar) {
        this.itl = dVar;
        this.hgw = j;
        this.itn = kVar;
        super(0);
    }

    public final void onServiceConnected() {
        if (!u.aHG().isY.a(this.hgw, this.itn)) {
            x.e("MicroMsg.exdevice.ExdeviceConnectManager", "connect failed!!!");
        }
    }
}
