package com.tencent.mm.plugin.exdevice.model;

import com.tencent.mm.g.a.em;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.x;

class e$14 extends c<em> {
    final /* synthetic */ e iup;

    e$14(e eVar) {
        this.iup = eVar;
        this.sFo = em.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        em emVar = (em) bVar;
        e eVar = this.iup;
        if (emVar == null || !(emVar instanceof em)) {
            x.e("MicroMsg.exdevice.ExdeviceEventManager", "event is not instanceof ExDeviceSimpleBTSendDataToDeviceEvent");
            return false;
        }
        emVar = emVar;
        if (eVar.o(emVar.bMo.mac, emVar.bMo.data)) {
            emVar.bMp.bKE = true;
            return true;
        }
        emVar.bMp.bKE = false;
        return true;
    }
}
