package com.tencent.mm.plugin.exdevice.model;

import com.tencent.mm.g.a.eh;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.x;

class e$13 extends c<eh> {
    final /* synthetic */ e iup;

    e$13(e eVar) {
        this.iup = eVar;
        this.sFo = eh.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        eh ehVar = (eh) bVar;
        e eVar = this.iup;
        if (ehVar == null || !(ehVar instanceof eh)) {
            x.e("MicroMsg.exdevice.ExdeviceEventManager", "event is not instanceof ExDeviceSimpleBTConnectDeviceEvent");
            return false;
        }
        ehVar = ehVar;
        if (ehVar.bMh.bKD ? eVar.zW(ehVar.bMh.mac) : e.zV(ehVar.bMh.mac)) {
            ehVar.bMi.bKE = true;
            return true;
        }
        ehVar.bMi.bKE = false;
        return true;
    }
}
