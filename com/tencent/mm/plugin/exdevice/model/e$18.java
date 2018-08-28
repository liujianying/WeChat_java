package com.tencent.mm.plugin.exdevice.model;

import com.tencent.mm.g.a.cy;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.x;

class e$18 extends c<cy> {
    final /* synthetic */ e iup;

    e$18(e eVar) {
        this.iup = eVar;
        this.sFo = cy.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        cy cyVar = (cy) bVar;
        x.i("MicroMsg.exdevice.ExdeviceEventManager", "handleExDeviceCheckDeviceHasAbilityEvent: deviceType(%s), deviceId(%s)", new Object[]{cyVar.bKt.bKv, cyVar.bKt.byN});
        if (cyVar.bKt.bKv == null || cyVar.bKt.byN == null) {
            cyVar.bKu.bKw = false;
        } else {
            com.tencent.mm.plugin.exdevice.h.b cA = ad.aHe().cA(cyVar.bKt.bKv, cyVar.bKt.byN);
            if (cA != null) {
                String str = cA.cCX;
                cy.b bVar2 = cyVar.bKu;
                ad.aHe();
                bVar2.bKw = com.tencent.mm.plugin.exdevice.h.c.Am(str);
            } else {
                cyVar.bKu.bKw = false;
            }
        }
        return true;
    }
}
