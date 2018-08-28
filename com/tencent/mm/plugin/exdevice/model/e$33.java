package com.tencent.mm.plugin.exdevice.model;

import com.tencent.mm.g.a.eb;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

class e$33 extends c<eb> {
    final /* synthetic */ e iup;

    e$33(e eVar) {
        this.iup = eVar;
        this.sFo = eb.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        eb ebVar = (eb) bVar;
        e eVar = this.iup;
        ebVar = ebVar;
        x.i("MicroMsg.exdevice.ExdeviceEventManager", "ExDeviceSendDataToLanDeviceEvent: brandName=%s, deviceId=%s", new Object[]{ebVar.bLQ.bKC, ebVar.bLQ.byN});
        if (!e.zU(ebVar.bLQ.bKC) || bi.oW(ebVar.bLQ.data)) {
            ebVar.bLR.bKE = false;
            return false;
        } else if (ad.aHe().Al(ebVar.bLQ.byN) == null) {
            x.e("MicroMsg.exdevice.ExdeviceEventManager", "hdInfo error");
            ebVar.bLR.bKE = false;
            return false;
        } else {
            ebVar.bLR.bKE = eVar.iul.cy(ebVar.bLQ.byN, ebVar.bLQ.data);
            return true;
        }
    }
}
