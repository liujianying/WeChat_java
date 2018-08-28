package com.tencent.mm.plugin.exdevice.model;

import com.tencent.mm.g.a.cv;
import com.tencent.mm.model.au;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.x;

class e$34 extends c<cv> {
    final /* synthetic */ e iup;

    e$34(e eVar) {
        this.iup = eVar;
        this.sFo = cv.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        cv cvVar = (cv) bVar;
        x.i("MicroMsg.exdevice.ExdeviceEventManager", "receive ExDeviceBindHardDeviceEvent");
        cvVar = cvVar;
        int i = cvVar.bKm.opType;
        x.i("MicroMsg.exdevice.ExdeviceEventManager", "now optype is %d, subscribeFlag is %d", new Object[]{Integer.valueOf(i), Integer.valueOf(cvVar.bKm.bKp)});
        if (i == 1) {
            l lVar = new l(cvVar.bKm.bKo, r1);
            au.DF().a(lVar, 0);
            cvVar.bKn.bKq = lVar;
        } else if (i == 2 && cvVar.bKm.bKq != null) {
            au.DF().c((l) cvVar.bKm.bKq);
        }
        return true;
    }
}
