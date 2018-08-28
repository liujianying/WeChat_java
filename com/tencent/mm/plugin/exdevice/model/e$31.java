package com.tencent.mm.plugin.exdevice.model;

import com.tencent.mm.g.a.eo;
import com.tencent.mm.plugin.exdevice.jni.Java2CExDevice;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.x;

class e$31 extends c<eo> {
    final /* synthetic */ e iup;

    e$31(e eVar) {
        this.iup = eVar;
        this.sFo = eo.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        if (((eo) bVar).bMs.bKD) {
            x.i("MicroMsg.exdevice.ExdeviceWCLanSDKUtil", "startScanWCLanDevice...");
            Java2CExDevice.startScanWCLanDevice(new byte[0], 1000);
        } else {
            x.i("MicroMsg.exdevice.ExdeviceWCLanSDKUtil", "stopScanWCLanDevice...");
            Java2CExDevice.stopScanWCLanDevice();
        }
        return true;
    }
}
