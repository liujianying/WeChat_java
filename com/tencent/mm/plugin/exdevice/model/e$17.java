package com.tencent.mm.plugin.exdevice.model;

import com.tencent.mm.g.a.cz;
import com.tencent.mm.g.a.cz$b;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.x;

class e$17 extends c<cz> {
    final /* synthetic */ e iup;

    e$17(e eVar) {
        this.iup = eVar;
        this.sFo = cz.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        cz$b cz_b;
        boolean z = false;
        cz czVar = (cz) bVar;
        x.i("MicroMsg.exdevice.ExdeviceEventManager", "handleExDeviceCheckDeviceIsBoundEvent: deviceType(%s), deviceId(%s)", new Object[]{czVar.bKx.bKv, czVar.bKx.byN});
        if (czVar.bKx.bKv == null || czVar.bKx.byN == null) {
            cz_b = czVar.bKy;
        } else {
            com.tencent.mm.plugin.exdevice.h.b cz = ad.aHe().cz(czVar.bKx.byN, czVar.bKx.bKv);
            cz_b = czVar.bKy;
            if (cz != null) {
                z = true;
            }
        }
        cz_b.bKz = z;
        return true;
    }
}
