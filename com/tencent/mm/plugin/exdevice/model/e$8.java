package com.tencent.mm.plugin.exdevice.model;

import com.tencent.mm.g.a.dr;
import com.tencent.mm.plugin.exdevice.model.d.11;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.x;

class e$8 extends c<dr> {
    final /* synthetic */ e iup;

    e$8(e eVar) {
        this.iup = eVar;
        this.sFo = dr.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        x.i("MicroMsg.exdevice.ExdeviceEventManager", "handleDeviceOPFromJSAPIEvent: %d", new Object[]{Integer.valueOf(((dr) bVar).bLB.op)});
        if (((dr) bVar).bLB.op == 1) {
            d aHl = ad.aHl();
            if (aHl.itd == null) {
                aHl.itd = new com.tencent.mm.plugin.exdevice.service.c();
                aHl.itd.iyE = new 11(aHl);
                aHl.itd.dd(ad.getContext());
            }
        }
        return true;
    }
}
