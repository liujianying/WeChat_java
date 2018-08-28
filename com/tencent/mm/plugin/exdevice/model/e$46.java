package com.tencent.mm.plugin.exdevice.model;

import com.tencent.mm.g.a.dd;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.x;

class e$46 extends c<dd> {
    final /* synthetic */ e iup;

    e$46(e eVar) {
        this.iup = eVar;
        this.sFo = dd.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        boolean z = ((dd) bVar).bKK.bKL;
        x.i("MicroMsg.exdevice.ExdeviceEventManager", "------handleGetBoundDeviceEvent------ check if need to get bound device after auth");
        if (i.ivn.ex(z)) {
            x.i("MicroMsg.exdevice.ExdeviceEventManager", "do get bound device after auth");
            i.ivn.a(null, null);
        }
        return true;
    }
}
