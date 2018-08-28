package com.tencent.mm.plugin.exdevice.model;

import com.tencent.mm.g.a.dx;
import com.tencent.mm.model.au;
import com.tencent.mm.plugin.exdevice.jni.Java2CExDevice;
import com.tencent.mm.plugin.exdevice.model.ExdeviceWCLanSDKUtil.5;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.x;

class e$30 extends c<dx> {
    final /* synthetic */ e iup;

    e$30(e eVar) {
        this.iup = eVar;
        this.sFo = dx.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        dx dxVar = (dx) bVar;
        e eVar = this.iup;
        dxVar = dxVar;
        if (eVar.iul == null) {
            eVar.iul = new ExdeviceWCLanSDKUtil();
        }
        ExdeviceWCLanSDKUtil exdeviceWCLanSDKUtil = eVar.iul;
        if (dxVar.bLI.bKD) {
            x.i("MicroMsg.exdevice.ExdeviceWCLanSDKUtil", "initWCLanDeviceLib...");
            Java2CExDevice.initWCLanDeviceLib();
            j.aGV().a(14, exdeviceWCLanSDKUtil.iuN);
            j.aGV().a(10, exdeviceWCLanSDKUtil.ivf);
            j.aGV().a(13, exdeviceWCLanSDKUtil.iuP);
            j.aGV().a(16, exdeviceWCLanSDKUtil.ivg);
        } else {
            au.Em().H(new 5(exdeviceWCLanSDKUtil));
            x.d("MicroMsg.exdevice.ExdeviceWCLanSDKUtil", "unregisterReceiver...");
            if (exdeviceWCLanSDKUtil.hiJ != null) {
                exdeviceWCLanSDKUtil.mContext.unregisterReceiver(exdeviceWCLanSDKUtil.hiJ);
                exdeviceWCLanSDKUtil.hiJ = null;
            }
            j.aGV().b(14, exdeviceWCLanSDKUtil.iuN);
            j.aGV().b(10, exdeviceWCLanSDKUtil.ivf);
            j.aGV().b(13, exdeviceWCLanSDKUtil.iuP);
            j.aGV().b(16, exdeviceWCLanSDKUtil.ivg);
        }
        return true;
    }
}
