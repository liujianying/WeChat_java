package com.tencent.mm.plugin.exdevice.model;

import com.tencent.mm.plugin.exdevice.service.c.a;
import com.tencent.mm.plugin.exdevice.service.u;
import com.tencent.mm.sdk.platformtools.x;

class d$12 extends a {
    final /* synthetic */ d itl;
    final /* synthetic */ int itv;

    d$12(d dVar, int i, int i2) {
        this.itl = dVar;
        this.itv = i2;
        super(i);
    }

    public final void onServiceConnected() {
        if (!u.aHG().isY.b(this.itv, d.f(this.itl))) {
            x.e("MicroMsg.exdevice.ExdeviceConnectManager", "scan failed!!!");
        }
    }
}
