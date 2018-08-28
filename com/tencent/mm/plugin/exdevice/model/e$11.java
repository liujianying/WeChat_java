package com.tencent.mm.plugin.exdevice.model;

import com.tencent.mm.g.a.el;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.x;

class e$11 extends c<el> {
    final /* synthetic */ e iup;

    e$11(e eVar) {
        this.iup = eVar;
        this.sFo = el.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        el elVar = (el) bVar;
        if (elVar == null || !(elVar instanceof el)) {
            x.e("MicroMsg.exdevice.ExdeviceEventManager", "event is not instanceof ExDeviceSimpleBTScanDeviceEvent");
            return false;
        }
        elVar = elVar;
        if (e.aGR()) {
            elVar.bMn.bKE = true;
            return true;
        }
        elVar.bMn.bKE = false;
        return true;
    }
}
