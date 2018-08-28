package com.tencent.mm.plugin.exdevice.model;

import com.tencent.mm.g.a.cw;
import com.tencent.mm.plugin.exdevice.jni.Java2CExDevice;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.x;

class e$29 extends c<cw> {
    final /* synthetic */ e iup;

    e$29(e eVar) {
        this.iup = eVar;
        this.sFo = cw.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        cw cwVar = (cw) bVar;
        e eVar = this.iup;
        String str = cwVar.bKr.byN;
        g gVar = eVar.ium;
        gVar.iuF.remove(str);
        if (gVar.iuL.get(str) != null) {
            x.i("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "cancelWCLanDeviceTask cmdId: " + gVar.iuL.get(str));
            Java2CExDevice.cancelWCLanDeviceTask(((Integer) gVar.iuL.get(str)).intValue());
        }
        return true;
    }
}
