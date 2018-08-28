package com.tencent.mm.plugin.exdevice.model;

import com.tencent.mm.g.a.eg;
import com.tencent.mm.model.au;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

class e$15 extends c<eg> {
    final /* synthetic */ e iup;

    e$15(e eVar) {
        this.iup = eVar;
        this.sFo = eg.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        eg egVar = (eg) bVar;
        if (egVar == null || !(egVar instanceof eg)) {
            x.e("MicroMsg.exdevice.ExdeviceEventManager", "event is not instanceof ExDeviceSimpleBTBindDeviceEvent");
            return false;
        }
        egVar = egVar;
        if (ad.aHe().cX(com.tencent.mm.plugin.exdevice.j.b.Az(egVar.bMd.mac)) != null) {
            x.d("MicroMsg.exdevice.ExdeviceEventManager", "device(" + egVar.bMd.mac + ") has been binded");
            egVar.bMe.bKE = true;
        } else {
            boolean z;
            String str = egVar.bMd.mac;
            String str2 = egVar.bMd.bMf;
            long j = egVar.bMd.bMg;
            if (bi.oW(str)) {
                x.e("MicroMsg.exdevice.ExdeviceEventManager", "mac is null or nil");
                z = false;
            } else {
                String str3 = "MicroMsg.exdevice.ExdeviceEventManager";
                String str4 = "handleExDeviceSimpleBTBindDevice. mac = %s, broadcastName = %s, profileType = %d";
                Object[] objArr = new Object[3];
                objArr[0] = str;
                objArr[1] = str2 == null ? "null" : str2;
                objArr[2] = Long.valueOf(j);
                x.d(str3, str4, objArr);
                int Lg = au.DF().Lg();
                if (Lg == 4 || Lg == 6) {
                    if (au.DF().a(new m(com.tencent.mm.plugin.exdevice.j.b.Az(str), str2, "3", j), 0)) {
                        z = true;
                    } else {
                        x.e("MicroMsg.exdevice.ExdeviceEventManager", "do NetSceneBindUnauthDevice fail");
                        z = false;
                    }
                } else {
                    x.e("MicroMsg.exdevice.ExdeviceEventManager", "net work state is not connected, current state is %d", new Object[]{Integer.valueOf(Lg)});
                    z = false;
                }
            }
            if (z) {
                egVar.bMe.bKE = true;
            } else {
                egVar.bMe.bKE = false;
            }
        }
        return true;
    }
}
