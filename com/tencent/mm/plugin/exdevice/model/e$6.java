package com.tencent.mm.plugin.exdevice.model;

import com.tencent.mm.g.a.dc;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.x;

class e$6 extends c<dc> {
    final /* synthetic */ e iup;

    e$6(e eVar) {
        this.iup = eVar;
        this.sFo = dc.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        dc dcVar = (dc) bVar;
        com.tencent.mm.plugin.exdevice.h.b cA = ad.aHe().cA(dcVar.bKH.bKJ, dcVar.bKH.byN);
        if (cA == null || (cA.field_connStrategy & 16) != 0) {
            dcVar.bKI.bKE = false;
        } else {
            x.i("MicroMsg.exdevice.ExdeviceEventManager", "CONNECT_STRATEGY_IGNORE_ON_CHAT disable, (%s) do not disconnect ble device(%s)", new Object[]{dcVar.bKH.bKJ, dcVar.bKH.byN});
            dcVar.bKI.bKE = true;
        }
        return true;
    }
}
