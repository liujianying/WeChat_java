package com.tencent.mm.plugin.exdevice.model;

import com.tencent.mm.plugin.exdevice.service.c$a;
import com.tencent.mm.plugin.exdevice.service.j;
import com.tencent.mm.plugin.exdevice.service.u;
import com.tencent.mm.sdk.platformtools.x;

class d$2 extends c$a {
    final /* synthetic */ d itl;
    final /* synthetic */ j itm;

    d$2(d dVar, j jVar) {
        this.itl = dVar;
        this.itm = jVar;
        super(0);
    }

    public final void onServiceConnected() {
        if (!u.aHG().isY.a(this.itm)) {
            x.e("MicroMsg.exdevice.ExdeviceConnectManager", "scan failed!!!");
        }
    }
}
